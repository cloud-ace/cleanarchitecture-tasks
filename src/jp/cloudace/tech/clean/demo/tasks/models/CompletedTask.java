package jp.cloudace.tech.clean.demo.tasks.models;

public class CompletedTask extends Task {

    private CompletedTask() {
    }

    static class Factory {

        static CompletedTask createNewModel(Task task) {
            CompletedTask completedTask = new CompletedTask();
            completedTask.id = task.id;
            completedTask.name = task.name;
            completedTask.description = task.description;
            return completedTask;
        }

    }

}
