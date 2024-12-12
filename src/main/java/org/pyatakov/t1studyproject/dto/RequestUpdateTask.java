package org.pyatakov.t1studyproject.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.pyatakov.t1studyproject.enums.TaskStatus;

@Getter
@Setter
public class RequestUpdateTask {
    private TaskStatus status;
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String title;
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String description;
    @Positive
    private Long userId;
}
