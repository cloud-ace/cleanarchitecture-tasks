package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseOutputPort;

public class ListCompletedTaskUseCase implements ListCompletedTaskUseCaseInputPort {

    private final ListCompletedTaskUseCaseOutputPort outputPort;
    private final CompletedTaskRepository repository;

    public ListCompletedTaskUseCase(
            ListCompletedTaskUseCaseOutputPort outputPort,
            CompletedTaskRepository repository
    ) {
        this.outputPort = outputPort;
        this.repository = repository;
    }

    @Override
    public void execute() {
        List<CompletedTask> tasks = repository.listCompletedTask();
        outputPort.emitCompletedTasks(tasks);
    }

}
