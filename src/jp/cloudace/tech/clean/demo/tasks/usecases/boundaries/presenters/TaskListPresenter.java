package jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.presenters;

import jp.cloudace.tech.clean.demo.tasks.models.Task;

import java.util.List;

public interface TaskListPresenter<T> {

    T present(List<? extends Task> list);

}
