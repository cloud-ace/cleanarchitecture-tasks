package jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;

public interface CompletedTaskRepository {

    List<CompletedTask> listCompletedTask();

    void create(CompletedTask task);

}
