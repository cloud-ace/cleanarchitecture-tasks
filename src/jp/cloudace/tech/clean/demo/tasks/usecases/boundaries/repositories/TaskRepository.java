package jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories;

import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;

import java.util.List;

public interface TaskRepository {
    List<Task> list();

    Task get(TaskId id);

    Task create(Task task);

    void delete(TaskId id);
}
