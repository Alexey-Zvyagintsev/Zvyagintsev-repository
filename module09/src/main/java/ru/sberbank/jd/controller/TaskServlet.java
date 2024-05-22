package ru.sberbank.jd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.CreateHtmlOutput;
import ru.sberbank.jd.repository.InMemoryTaskRepository;
import ru.sberbank.jd.service.TaskDeleteService;
import ru.sberbank.jd.service.TaskGetService;

/**
 * Сервлет TaskServlet.
 */
@WebServlet(name = "TaskServlet", value = "/task")
public class TaskServlet extends HttpServlet {

    private List<Task> tasks = new ArrayList<>();
    private ObjectMapper objectMapper;
    private ObjectWriter objectWriter;
    private InMemoryTaskRepository inMemoryTaskRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.objectMapper = new ObjectMapper();
        this.objectWriter = new ObjectMapper().writer(); //.withDefaultPrettyPrinter();
        inMemoryTaskRepository = new InMemoryTaskRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Task task = getTaskInputFrom(req);
        doFlush(task, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TaskGetService taskGetService = new TaskGetService(req, inMemoryTaskRepository);
        Task task = taskGetService.getTask();
        if (task != null) {
            doFlush(task, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String outputString = "Empty";
        TaskDeleteService taskDeleteService = new TaskDeleteService(req, inMemoryTaskRepository);
        Task task = taskDeleteService.deleteTask();
        if (task != null) {
            doFlush(task, resp);
        }
    }

    @SneakyThrows
    private Task getTaskInputFrom(HttpServletRequest req) {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        Task task = objectMapper.readValue(sb.toString(), Task.class);
        task = new Task(task.owner(), task.description());
        inMemoryTaskRepository.addTask(task);
        return task;
    }

    private void doFlush(Task task, HttpServletResponse resp) throws IOException {

        String htmlString = CreateHtmlOutput.createHtml(objectWriter.writeValueAsString(task));
        resp.getOutputStream().write(htmlString.getBytes());
        resp.getOutputStream().flush();
    }
}
