package org.pyatakov.t1studyproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.pyatakov.t1studyproject.enums.TaskStatus;

@Getter
@Setter
public class RequestCreateTask {
    private TaskStatus status = TaskStatus.NEW;
    @NotNull
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String title;
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String description;
    @NotNull
    @Positive
    private Long userId;
}
