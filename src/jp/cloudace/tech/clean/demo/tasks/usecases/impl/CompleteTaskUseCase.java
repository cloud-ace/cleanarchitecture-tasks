package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseInputPort;

public class CompleteTaskUseCase implements CompleteTaskUseCaseInputPort {
    private TaskRepository taskRepository;
    private CompletedTaskRepository completedTaskRepository;

    public CompleteTaskUseCase(TaskRepository taskRepository, CompletedTaskRepository completedTaskRepository) {
        this.taskRepository = taskRepository;
        this.completedTaskRepository = completedTaskRepository;
    }

    @Override
    public void execute(TaskId id) {
        Task task = taskRepository.get(id);
        if (task == null) {
            throw new IllegalArgumentException("taskId:" + id.getValue() + " is not found.");
        }
        CompletedTask completedTask = task.complete();
        taskRepository.delete(id);
        completedTaskRepository.create(completedTask);
    }
}
