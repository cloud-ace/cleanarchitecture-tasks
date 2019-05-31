package jp.cloudace.tech.clean.demo.tasks.models.valueobject;

import java.util.Objects;

public final class TaskDescription {

    private final String value;

    public TaskDescription(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDescription that = (TaskDescription) o;
        return Objects.equals(value, that.value);
    }

    /**
     * このオブジェクトが規則に従っているかどうかを確認する。
     *
     * @return 規則違反の場合は違反理由を返す。規則違反がない場合はnullを返す。
     */
    public String validate() {
        if (value == null) {
            return "タスクの説明がnullはだめです。";
        }
        if (value.length() > 10) {
            return "タスクの説明は10文字以下である必要があるです。";
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TaskDescription{" +
                "value='" + value + '\'' +
                '}';
    }
}
