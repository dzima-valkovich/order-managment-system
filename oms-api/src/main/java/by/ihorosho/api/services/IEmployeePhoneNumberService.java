package by.ihorosho.api.services;

import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;

public interface IEmployeePhoneNumberService {

    Long update(EmployeePhoneNumberDto dto);

    Boolean deleteById(Long id);
}
