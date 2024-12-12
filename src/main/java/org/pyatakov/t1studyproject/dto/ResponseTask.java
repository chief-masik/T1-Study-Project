package org.pyatakov.t1studyproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseTask {
    private Long id;
    private String title;
    private String description;
    private Long userId;
}
