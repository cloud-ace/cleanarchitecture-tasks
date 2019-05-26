package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.presenters.TaskListPresenter;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseInputPort;

import java.util.List;

public class ListTasksUseCase<T> implements ListTasksUseCaseInputPort<T> {
    private TaskRepository repository;
    private TaskListPresenter<T> presenter;

    public ListTasksUseCase(TaskRepository repository, TaskListPresenter<T> presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public T execute() {
        List<Task> list = repository.list();
        return presenter.present(list);
    }
}
