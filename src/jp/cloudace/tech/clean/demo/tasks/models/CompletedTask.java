package jp.cloudace.tech.clean.demo.tasks.models;

public class CompletedTask extends Task {

    static class Factory {
        static CompletedTask createNewModel(Task task) {
            CompletedTask ct = new CompletedTask();
            ct.id = task.id;
            ct.name = task.name;
            ct.description = task.description;
            return ct;
        }
    }
}
