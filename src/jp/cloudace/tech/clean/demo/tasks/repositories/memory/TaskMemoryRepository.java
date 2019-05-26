package jp.cloudace.tech.clean.demo.tasks.repositories.memory;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;

import java.util.*;

public class TaskMemoryRepository implements TaskRepository, CompletedTaskRepository {
    private Map<TaskId, Task> tMap = new HashMap<>();
    private Map<TaskId, CompletedTask> ctMap = new HashMap<>();

    @Override
    public List<Task> list() {
        return new ArrayList<>(tMap.values());
    }

    @Override
    public List<CompletedTask> listCompletedTask() {
        return new ArrayList<>(ctMap.values());
    }

    @Override
    public void create(CompletedTask task) {
        ctMap.put(task.getId(), task);
    }

    @Override
    public Task get(TaskId id) {
        return tMap.get(id);
    }

    @Override
    public Task create(Task task) {
        String id = UUID.randomUUID().toString();
        TaskId taskId = new TaskId(id);
        task = Task.Factory.of(taskId, task.getName(), task.getDescription());
        tMap.put(taskId, task);
        return task;
    }

    @Override
    public void delete(TaskId id) {
        tMap.remove(id);
    }
}
