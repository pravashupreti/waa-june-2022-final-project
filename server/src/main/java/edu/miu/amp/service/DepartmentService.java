package edu.miu.amp.service;

import edu.miu.amp.dto.DepartmentDto;
import edu.miu.amp.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();

    DepartmentDto save(DepartmentDto departmentDto);

    DepartmentDto findById(Integer id);

    void remove(Integer id);

    DepartmentDto updateById(DepartmentDto departmentDto, Integer id);

}
