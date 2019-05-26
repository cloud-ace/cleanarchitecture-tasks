package jp.cloudace.tech.clean.demo.tasks.usecases.impl;

import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskDescription;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskName;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CreateTaskUseCaseInputPort;

public class CreateTaskUseCase implements CreateTaskUseCaseInputPort {
    private TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(TaskName name, TaskDescription description) {
        Task task = Task.Factory.createModelForRegister(name, description);
        String errors = task.validate();
        if (errors != null) {
            throw new IllegalArgumentException(errors);
        }
        repository.create(task);
    }
}
