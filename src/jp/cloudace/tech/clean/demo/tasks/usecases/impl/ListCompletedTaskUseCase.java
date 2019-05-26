package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.presenters.TaskListPresenter;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseInputPort;

import java.util.List;

public class ListCompletedTaskUseCase<T> implements ListCompletedTaskUseCaseInputPort<T> {
    private CompletedTaskRepository repository;
    private TaskListPresenter<T> presenter;

    public ListCompletedTaskUseCase(CompletedTaskRepository repository, TaskListPresenter<T> presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public T execute() {
        List<CompletedTask> list = repository.listCompletedTask();
        return presenter.present(list);
    }
}
