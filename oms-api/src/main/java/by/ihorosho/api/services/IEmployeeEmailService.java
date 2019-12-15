package by.ihorosho.api.services;

import by.ihorosho.api.services.dto.EmployeeEmailDto;

public interface IEmployeeEmailService {

    Long update(EmployeeEmailDto dto);

    Boolean deleteById(Long id);
}
