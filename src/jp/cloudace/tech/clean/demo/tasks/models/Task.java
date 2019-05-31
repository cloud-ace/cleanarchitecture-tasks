package jp.cloudace.tech.clean.demo.tasks.models;

import java.util.ArrayList;
import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskDescription;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskId;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskName;

public class Task {

    TaskId id;
    TaskName name;
    TaskDescription description;

    Task() {
    }

    public String[] validate() {
        List<String> errors = new ArrayList<>();
        if (name == null) {
            errors.add("タスク名は必須であります。");
        } else {
            String nameError = name.validate();
            if (nameError != null) {
                errors.add(nameError);
            }
        }
        if (description != null) {
            String descError = description.validate();
            if (descError != null) {
                errors.add(descError);
            }
        }
        if (errors.isEmpty()) {
            return null;
        }
        return errors.toArray(new String[0]);
    }

    public TaskId getId() {
        return id;
    }

    public TaskName getName() {
        return name;
    }

    public TaskDescription getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }

    public CompletedTask complete() {
        return CompletedTask.Factory.createNewModel(this);
    }

    public static class Factory {

        public static Task createModelForRegister(TaskName name, TaskDescription description) {
            Task task = new Task();
            task.name = name;
            task.description = description;
            return task;
        }

        public static Task of(TaskId id, TaskName name, TaskDescription description) {
            Task task = new Task();
            task.id = id;
            task.name = name;
            task.description = description;
            return task;
        }
    }

}
