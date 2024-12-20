package org.pyatakov.t1studyproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.pyatakov.t1studyproject.enums.TaskStatus;

@Getter
@Setter
@ToString
public class ResponseTask {
    private Long id;
    private TaskStatus status;
    private String title;
    private String description;
    private Long userId;
}
