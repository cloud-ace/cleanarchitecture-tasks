package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import jp.cloudace.tech.clean.demo.tasks.models.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseOutputPort;

public class CompleteTaskUseCase implements CompleteTaskUseCaseInputPort {

    private final CompleteTaskUseCaseOutputPort outputPort;
    private final TaskRepository taskRepository;
    private final CompletedTaskRepository completedTaskRepository;

    public CompleteTaskUseCase(
            CompleteTaskUseCaseOutputPort outputPort,
            TaskRepository taskRepository,
            CompletedTaskRepository completedTaskRepository
    ) {
        this.outputPort = outputPort;
        this.taskRepository = taskRepository;
        this.completedTaskRepository = completedTaskRepository;
    }

    @Override
    public void execute(String id) {

        TaskId taskId = new TaskId(id);
        Task task = taskRepository.get(taskId);

        if (task == null) {
            outputPort.showErrors(new String[]{"taskId:" + id + " is not found."});
            return;
        }

        CompletedTask completedTask = task.complete();
        taskRepository.delete(taskId);
        completedTaskRepository.create(completedTask);
        outputPort.emitCompletedTaskId(completedTask.getId().getValue());

    }
}
