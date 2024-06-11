package ru.sberbank.jd.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.InMemoryTaskRepository;

/**
 * Получение информации по Task.
 */
public class TaskGetService {

    private HttpServletRequest request;
    private InMemoryTaskRepository inMemoryTaskRepository;

    public TaskGetService(HttpServletRequest req, InMemoryTaskRepository inMemoryTaskRepository) {
        this.request = req;
        this.inMemoryTaskRepository = inMemoryTaskRepository;
    }

    /**
     * Метод для получения Task.
     *
     * @return возвращает Task по id
     */
    public Task getTask() {

        Task task = null;
        String id = request.getParameter("id");
        if (id != null) {
            task = inMemoryTaskRepository.getTaskById(id);
        }
        return task;
    }
}
