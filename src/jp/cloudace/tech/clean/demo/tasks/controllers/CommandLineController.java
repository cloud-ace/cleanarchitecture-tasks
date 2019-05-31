package jp.cloudace.tech.clean.demo.tasks.controllers;

import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CreateTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseInputPort;

public class CommandLineController {

    private final ListTasksUseCaseInputPort listTasksUseCaseInputPort;
    private final CreateTaskUseCaseInputPort createTaskUseCaseInputPort;
    private final CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort;
    private final ListCompletedTaskUseCaseInputPort listCompletedTaskUseCaseInputPort;

    public CommandLineController(
            ListTasksUseCaseInputPort listTasksUseCaseInputPort,
            CreateTaskUseCaseInputPort createTaskUseCaseInputPort,
            CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort,
            ListCompletedTaskUseCaseInputPort listCompletedTaskUseCaseInputPort
    ) {
        this.listTasksUseCaseInputPort = listTasksUseCaseInputPort;
        this.createTaskUseCaseInputPort = createTaskUseCaseInputPort;
        this.completeTaskUseCaseInputPort = completeTaskUseCaseInputPort;
        this.listCompletedTaskUseCaseInputPort = listCompletedTaskUseCaseInputPort;
    }

    public void listCompleted() {
        listCompletedTaskUseCaseInputPort.execute();
    }

    public void listTasks() {
        listTasksUseCaseInputPort.execute();
    }

    public void createTask(String name, String description) {
        createTaskUseCaseInputPort.execute(name, description);
    }

    public void completeTask(String id) {
        completeTaskUseCaseInputPort.execute(id);
    }

}
