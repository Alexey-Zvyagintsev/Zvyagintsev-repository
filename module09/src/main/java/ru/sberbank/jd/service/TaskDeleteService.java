package ru.sberbank.jd.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.InMemoryTaskRepository;

/**
 * Удаление Task по его id и возврат удаленного Task.
 */
public class TaskDeleteService {

    private HttpServletRequest request;
    private InMemoryTaskRepository inMemoryTaskRepository;

    public TaskDeleteService(HttpServletRequest req, InMemoryTaskRepository inMemoryTaskRepository) {
        this.request = req;
        this.inMemoryTaskRepository = inMemoryTaskRepository;
    }

    /**
     * Метод для удаления Task.
     *
     * @return возвращает удаленный Task
     */
    public Task deleteTask() {
        Task task = null;
        String id = request.getParameter("id");
        if (id != null) {
            task = inMemoryTaskRepository.deleteTaskById(id);
        }
        return task;
    }
}
