package jp.cloudace.tech.clean.demo.tasks.models.valueobject;

import java.util.Objects;

public class TaskId {
    private String value;

    public TaskId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskId taskId = (TaskId) o;
        return Objects.equals(value, taskId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TaskId{" +
                "value='" + value + '\'' +
                '}';
    }
}
