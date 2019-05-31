package jp.cloudace.tech.clean.demo.tasks.repositories.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;

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
        String idValue = UUID.randomUUID().toString();
        TaskId id = new TaskId(idValue);
        Task registered = Task.Factory.of(id, task.getName(), task.getDescription());
        tMap.put(id, registered);
        return registered;
    }

    @Override
    public void delete(TaskId id) {
        tMap.remove(id);
    }

}
