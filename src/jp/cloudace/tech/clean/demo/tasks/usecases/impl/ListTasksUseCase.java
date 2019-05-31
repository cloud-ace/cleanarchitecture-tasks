package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseOutputPort;

public class ListTasksUseCase implements ListTasksUseCaseInputPort {

    private final TaskRepository repository;
    private final ListTasksUseCaseOutputPort outputPort;

    public ListTasksUseCase(TaskRepository repository, ListTasksUseCaseOutputPort outputPort) {
        this.repository = repository;
        this.outputPort = outputPort;
    }

    @Override
    public void execute() {
        List<Task> tasks = repository.list();
        outputPort.emitTasks(tasks);
    }

}
