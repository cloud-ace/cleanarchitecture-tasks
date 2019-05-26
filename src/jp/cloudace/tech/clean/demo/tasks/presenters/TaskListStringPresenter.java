package jp.cloudace.tech.clean.demo.tasks.presenters;

import jp.cloudace.tech.clean.demo.tasks.models.Task;
import jp.cloudace.tech.clean.demo.tasks.usecases.boundaries.presenters.TaskListPresenter;

import java.util.List;

public class TaskListStringPresenter implements TaskListPresenter<String> {
    @Override
    public String present(List<? extends Task> list) {
        String out = "";
        if (list.size() == 0) {
            return "no tasks.";
        }
        for (Task t : list) {
            out += t.toString() + System.lineSeparator();
        }
        return out;
    }

}
