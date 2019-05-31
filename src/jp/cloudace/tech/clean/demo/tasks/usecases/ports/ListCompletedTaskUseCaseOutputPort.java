package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;

public interface ListCompletedTaskUseCaseOutputPort {
    void emitCompletedTasks(List<CompletedTask> tasks);
}
