package jp.cloudace.tech.clean.demo.tasks;

import jp.cloudace.tech.clean.demo.tasks.controllers.CommandLineController;
import jp.cloudace.tech.clean.demo.tasks.presenters.TaskListStringPresenter;
import jp.cloudace.tech.clean.demo.tasks.repositories.memory.TaskMemoryRepository;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.presenters.TaskListPresenter;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        //TODO you can replace this code using DI container like Guice.
        TaskRepository taskRepository = new TaskMemoryRepository();
        CompletedTaskRepository completedTaskRepository = new TaskMemoryRepository();
        TaskListPresenter<String> presenter = new TaskListStringPresenter();
        ListTasksUseCaseInputPort<String> listTasksUseCaseInputPort = new ListTasksUseCase<>(taskRepository, presenter);
        CreateTaskUseCaseInputPort createTaskUseCaseInputPort = new CreateTaskUseCase(taskRepository);
        CompleteTaskUseCaseInputPort completeTaskUseCaseInputPort = new CompleteTaskUseCase(taskRepository, completedTaskRepository);
        ListCompletedTaskUseCaseInputPort<String> listCompletedTaskUseCaseInputPort = new ListCompletedTaskUseCase<>(completedTaskRepository, presenter);

        CommandLineController controller = new CommandLineController(listTasksUseCaseInputPort, createTaskUseCaseInputPort,
                completeTaskUseCaseInputPort, listCompletedTaskUseCaseInputPort);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("input > ");
            String str = br.readLine();
            while (!"exit".equals(str)) {
                String result = controller.invokeUseCase(str.split(" "));
                System.out.println(result);

                System.out.print("input > ");
                str = br.readLine();
            }
            System.out.println("Bye!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("入力エラー:" + e.getMessage());
            System.exit(-1);
        }
    }
}
