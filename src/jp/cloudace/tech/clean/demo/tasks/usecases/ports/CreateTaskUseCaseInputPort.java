package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

public interface CreateTaskUseCaseInputPort {
    void execute(String name, String description);
}
