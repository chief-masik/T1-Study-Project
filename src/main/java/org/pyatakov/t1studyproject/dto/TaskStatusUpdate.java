package org.pyatakov.t1studyproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.pyatakov.t1studyproject.enums.TaskStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatusUpdate {
    private Long id;
    private TaskStatus status;
}
