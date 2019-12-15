package by.ihorosho.api.services;

import by.ihorosho.api.services.dto.EmployeeDto;
import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;

import java.util.List;


public interface IEmployeeService {

    List<EmployeeDto> getAll(int offset, int limit);

    EmployeeDto getById(Long id);

    Long add(EmployeeDto dto);

    Long update(EmployeeDto dto);

    Boolean deleteById(Long id);

    Long addNewPhoneNumberToEmployee(Long employeeId, EmployeePhoneNumberDto phoneNumberDto);
}
