package jp.cloudace.tech.clean.demo.tasks.usecases.ports;

import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskDescription;
import jp.cloudace.tech.clean.demo.tasks.models.valueobject.TaskName;

public interface CreateTaskUseCaseInputPort {

    void execute(TaskName name, TaskDescription description);
}
