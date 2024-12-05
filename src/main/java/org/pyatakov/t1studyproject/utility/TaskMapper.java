package org.pyatakov.t1studyproject.utility;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.pyatakov.t1studyproject.dto.RequestCreateTask;
import org.pyatakov.t1studyproject.dto.RequestUpdateTask;
import org.pyatakov.t1studyproject.dto.ResponseTask;
import org.pyatakov.t1studyproject.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task dtoToEntity(RequestCreateTask requestCreateTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(RequestUpdateTask requestUpdateTask, @MappingTarget Task task);

    ResponseTask entityToResponse(Task task);
}
