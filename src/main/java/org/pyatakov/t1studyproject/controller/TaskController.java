package org.pyatakov.t1studyproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pyatakov.t1studyproject.dto.RequestCreateTask;
import org.pyatakov.t1studyproject.dto.RequestUpdateTask;
import org.pyatakov.t1studyproject.dto.ResponseTask;
import org.pyatakov.t1studyproject.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<ResponseTask> createTask(@RequestBody @Valid RequestCreateTask requestCreateTask) {
        return ResponseEntity.ok(
                taskService.createTask(requestCreateTask)
        );
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<ResponseTask> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(
                taskService.getTaskById(id)
        );
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<ResponseTask> updateTask(@PathVariable Long id, @RequestBody @Valid RequestUpdateTask requestUpdateTask) {
        return ResponseEntity.ok(
                taskService.updateTask(id, requestUpdateTask)
        );
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<ResponseTask>> getAllTasks() {
        return ResponseEntity.ok(
                taskService.getAllTasks()
        );
    }
}
