package jp.cloudace.tech.clean.demo.tasks.models.valueobject;

public class TaskDescription {

    private String value;

    public TaskDescription(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
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
        if (10 < value.length()) {
            return "タスクの説明は10文字以下である必要があるです。";
        }
        return null;
    }

    @Override
    public String toString() {
        return "TaskDescription{" +
                "value='" + value + '\'' +
                '}';
    }
}
