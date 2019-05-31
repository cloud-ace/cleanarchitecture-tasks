package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

public interface CompleteTaskUseCaseOutputPort extends ErrorOutputPort {
    void emitCompletedTaskId(String completedTaskId);
}
