package by.ihorosho.api.services;

import by.ihorosho.api.services.dto.EmployeeDto;

import java.util.List;


public interface IEmployeeService {

    List<EmployeeDto> getAll(int offset, int limit);

    EmployeeDto getById(Long id);

    void add(EmployeeDto dto);

    void update(EmployeeDto dto);

    void deleteById(Long id);
}
