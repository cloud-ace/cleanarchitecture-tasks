package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.Task;

public interface ListTasksUseCaseOutputPort {
    void emitTasks(List<Task> tasks);
}
