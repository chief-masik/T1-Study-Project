package org.pyatakov.t1studyproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pyatakov.t1studyproject.aspect.annotation.LogTracking;
import org.pyatakov.t1studyproject.dto.RequestCreateTask;
import org.pyatakov.t1studyproject.dto.RequestUpdateTask;
import org.pyatakov.t1studyproject.dto.ResponseTask;
import org.pyatakov.t1studyproject.entity.Task;
import org.pyatakov.t1studyproject.repository.TaskRepository;
import org.pyatakov.t1studyproject.utility.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @LogTracking
    @Transactional
    public ResponseTask createTask(RequestCreateTask requestCreateTask) {
        Task task = taskRepository.save(
                taskMapper.dtoToEntity(requestCreateTask)
        );
        return taskMapper.entityToResponse(task);
    }

    @LogTracking
    public ResponseTask getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Такой задачи не существует"));
        return taskMapper.entityToResponse(task);
    }

    @LogTracking
    @Transactional
    public ResponseTask updateTask(Long id, RequestUpdateTask requestUpdateTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        taskMapper.updateEntityFromDto(requestUpdateTask, task);
        return taskMapper.entityToResponse(task);
    }

    @LogTracking
    @Transactional
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @LogTracking
    public List<ResponseTask> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::entityToResponse)
                .collect(Collectors.toList());
    }
}