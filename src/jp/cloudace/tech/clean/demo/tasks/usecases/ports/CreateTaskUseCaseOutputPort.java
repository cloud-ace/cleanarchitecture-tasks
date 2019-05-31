package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

import jp.cloudace.tech.clean.demo.tasks.models.Task;

public interface CreateTaskUseCaseOutputPort extends ErrorOutputPort {
    void emitTask(Task task);
}
