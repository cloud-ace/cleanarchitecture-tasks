package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;

public interface CompleteTaskUseCaseInputPort {
    void execute(TaskId id);
}
