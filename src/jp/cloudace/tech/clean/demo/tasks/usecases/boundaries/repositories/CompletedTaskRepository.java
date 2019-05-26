package jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;

import java.util.List;

public interface CompletedTaskRepository {

    List<CompletedTask> listCompletedTask();

    void create(CompletedTask task);
}
