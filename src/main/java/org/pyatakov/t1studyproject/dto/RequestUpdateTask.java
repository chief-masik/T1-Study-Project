package org.pyatakov.t1studyproject.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdateTask {
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String title;
    @Pattern(regexp = "^\\S.{0,253}\\S$")
    private String description;
    @Positive
    private Long userId;
}
