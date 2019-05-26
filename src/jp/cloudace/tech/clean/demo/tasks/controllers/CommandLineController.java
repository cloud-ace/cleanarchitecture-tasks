package jp.cloudace.tech.clean.demo.tasks.controllers;

import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskDescription;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskName;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CreateTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseInputPort;

public class CommandLineController {

    private ListTasksUseCaseInputPort<String> listTasksUseCaseInputPort;
    private CreateTaskUseCaseInputPort taskCreateUseCaseInputPort;
    private CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort;
    private ListCompletedTaskUseCaseInputPort<String> listCompletedTaskUseCaseInputPort;

    public CommandLineController(ListTasksUseCaseInputPort<String> listTasksUseCaseInputPort, CreateTaskUseCaseInputPort
            taskCreateUseCaseInputPort, CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort,
                                 ListCompletedTaskUseCaseInputPort<String> listCompletedTaskUseCaseInputPort) {
        this.listTasksUseCaseInputPort = listTasksUseCaseInputPort;
        this.taskCreateUseCaseInputPort = taskCreateUseCaseInputPort;
        this.completeTaskUseCaseInputPort = completeTaskUseCaseInputPort;
        this.listCompletedTaskUseCaseInputPort = listCompletedTaskUseCaseInputPort;
    }

    public String invokeUseCase(String[] args) {
        if (args.length < 1) {
            return "1st argument is required.";
        }
        String resource = args[0];
        switch (resource) {
            case "help":
                return "sorry, this functions is not implemented.";
            case "tasks":
                if (args.length < 2) {
                    return "action is required";
                }
                String action = args[1];
                switch (action) {
                    case "list":
                        if (2 < args.length) {
                            String flag = args[2];
                            switch (flag) {
                                case "-c":
                                    return listCompletedTaskUseCaseInputPort.execute();
                            }
                        }
                        return listTasksUseCaseInputPort.execute();
                    case "create":
                        if (args.length < 4) {
                            return "id is required as 3rd argument.";
                        }
                        return taskCreate(args[2], args[3]);
                    case "complete":
                        if (args.length < 3) {
                            return "id is required as 3rd argument.";
                        }
                        return taskComplete(args[2]);
                    default:
                        return "action is required.";
                }
            default:
                return "nothing to do. :D";
        }
    }

    private String taskCreate(String name, String description) {
        taskCreateUseCaseInputPort.execute(new TaskName(name), new TaskDescription(description));
        return "task created!";
    }

    private String taskComplete(String idStr) {
        TaskId id = new TaskId(idStr);
        completeTaskUseCaseInputPort.execute(id);
        return "WELL DONE. task id: " + idStr + "changed to complete. :D";
    }
}
