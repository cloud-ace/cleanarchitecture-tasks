package jp.cloudace.tech.clean.demo.tasks.models.valueobject;

public class TaskName {

    private String value;

    public TaskName(String value) {
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
            return "タスク名がnullはだめです。";
        }
        if (value.equals("")) {
            return "空のタスク名はだめです。";
        }
        if (5 < value.length()) {
            return "タスク名は5文字以下である必要があるです。";
        }
        return null;
    }

    @Override
    public String toString() {
        return "TaskName{" +
                "value='" + value + '\'' +
                '}';
    }
}
