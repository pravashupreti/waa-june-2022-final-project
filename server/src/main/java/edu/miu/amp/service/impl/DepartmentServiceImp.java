package edu.miu.amp.service.impl;

import edu.miu.amp.domain.Department;
import edu.miu.amp.dto.DepartmentDto;
import edu.miu.amp.repository.DepartmentRepository;
import edu.miu.amp.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> department = departmentRepository.findAll();
        List<DepartmentDto> departmentDto = department.stream()
                .map(ja -> toDto(ja))
                .collect(Collectors.toList());
        return departmentDto;
    }



    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = toEntity(departmentDto);
        return toDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto findById(Integer id) {
        var department = departmentRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Department with id %s does not exists", id)));
        DepartmentDto departmentDto = toDto(department);
        return departmentDto;
    }

    @Override
    public void remove(Integer id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public DepartmentDto updateById(DepartmentDto departmentDto,Integer id) {
        Department department = toEntity(departmentDto);
        departmentRepository.findById(id).map(department1 -> {
            department1.setDepartmentName(department.getDepartmentName());
            return departmentRepository.save(department);
        });
        return toDto(department);
    }

    public DepartmentDto toDto(Department department){
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }

    public Department toEntity(DepartmentDto departmentDto){
        Department department = modelMapper.map(departmentDto, Department.class);
        return department;
    }
}
