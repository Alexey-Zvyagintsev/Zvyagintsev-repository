package ru.sberbank.jd.repository;

import java.util.HashMap;
import java.util.Map;
import ru.sberbank.jd.model.Task;

/**
 * Работа с данными в памяти.
 */

public class InMemoryTaskRepository {

    private Map<String, Task> storage = new HashMap<>();

    public void addTask(Task task) {
        storage.put(task.id().toString(), task);
    }

    public Task getTaskById(String id) {
        return storage.get(id);
    }

    /**
     * Удаление Task по его id.
     *
     * @param id UUID
     * @return удаленный Task
     */
    public Task deleteTaskById(String id) {
        Task task = getTaskById(id);
        storage.remove(id);
        System.out.println(storage.size());
        return task;
    }
}
