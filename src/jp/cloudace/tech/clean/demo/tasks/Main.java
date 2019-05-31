package jp.cloudace.tech.clean.demo.tasks;

import java.util.Scanner;

import jp.cloudace.tech.clean.demo.tasks.controllers.CommandLineController;
import jp.cloudace.tech.clean.demo.tasks.presenters.PrintPresenter;
import jp.cloudace.tech.clean.demo.tasks.presenters.views.PrintView;
import jp.cloudace.tech.clean.demo.tasks.repositories.memory.TaskMemoryRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.impl.CompleteTaskUseCase;
import jp.cloudace.tech.clean.demo.tasks.usecases.impl.CreateTaskUseCase;
import jp.cloudace.tech.clean.demo.tasks.usecases.impl.ListCompletedTaskUseCase;
import jp.cloudace.tech.clean.demo.tasks.usecases.impl.ListTasksUseCase;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CompleteTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.CreateTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListCompletedTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.usecases.ports.ListTasksUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.views.CommandLineView;

public class Main {

    public static void main(String[] args) {

        //TODO you can replace this code using DI container like Guice.
        TaskRepository taskRepository = new TaskMemoryRepository();
        CompletedTaskRepository completedTaskRepository = new TaskMemoryRepository();
        PrintView printView = new CommandLineView();
        PrintPresenter presenter = new PrintPresenter(printView);
        ListTasksUseCaseInputPort listTasksUseCaseInputPort = new ListTasksUseCase(taskRepository, presenter);
        CreateTaskUseCaseInputPort createTaskUseCaseInputPort = new CreateTaskUseCase(presenter, taskRepository);
        CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort = new CompleteTaskUseCase(presenter, taskRepository, completedTaskRepository);
        ListCompletedTaskUseCaseInputPort listCompletedTaskUseCaseInputPort = new ListCompletedTaskUseCase(presenter, completedTaskRepository);

        CommandLineController controller = new CommandLineController(
                listTasksUseCaseInputPort, createTaskUseCaseInputPort,
                completeTaskUseCaseInputPort, listCompletedTaskUseCaseInputPort);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("input > ");
            input = scanner.nextLine();

            if ("exit".equals(input)) {
                System.out.println("Bye!");
                break;
            }

            String[] inputs = input.split(" ");

            if (inputs.length < 1) {
                System.out.println("1st argument is required.");
                continue;
            }

            String resource = inputs[0];
            switch (resource) {
                case "help":
                    System.out.println("sorry, this functions is not implemented.");
                    continue;
                case "tasks":
                    if (inputs.length < 2) {
                        System.out.println("action is required");
                        break;
                    }
                    String action = inputs[1];
                    switch (action) {
                        case "list":
                            if (inputs.length > 2) {
                                String flag = inputs[2];
                                switch (flag) {
                                    case "-c":
                                        controller.listCompleted();
                                        continue;
                                }
                            }
                            controller.listTasks();
                            break;
                        case "create":
                            if (inputs.length < 4) {
                                System.out.println("id is required as 3rd argument.");
                                break;
                            }
                            controller.createTask(inputs[2], inputs[3]);
                            break;
                        case "complete":
                            if (inputs.length < 3) {
                                System.out.println("id is required as 3rd argument.");
                                break;
                            }
                            controller.completeTask(inputs[2]);
                            break;
                        default:
                            System.out.println("action is required.");
                            break;
                    }
                    break;
                default:
                    System.out.println("nothing to do. :D");
                    break;
            }
        }

    }

}
