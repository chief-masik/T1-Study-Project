package org.pyatakov.t1studyproject.service;

import org.pyatakov.t1studyproject.dto.RequestCreateTask;
import org.pyatakov.t1studyproject.dto.RequestUpdateTask;
import org.pyatakov.t1studyproject.dto.ResponseTask;

import java.util.List;

public interface TaskService {

    ResponseTask createTask(RequestCreateTask requestCreateTask);

    ResponseTask getTaskById(Long taskId);

    ResponseTask updateTask(Long id, RequestUpdateTask requestUpdateTask);

    void deleteTask(Long taskId);

    List<ResponseTask> getAllTasks();
}
