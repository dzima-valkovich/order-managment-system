package by.ihorosho.services;

import by.ihorosho.api.services.IEmployeePhoneNumberService;
import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;
import by.ihorosho.api.storage.daos.IEmployeePhoneNumberDao;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.services.utils.DtoConverter;
import by.ihorosho.storage.adapters.domain.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("employeePhoneNumberService")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeePhoneNumberService implements IEmployeePhoneNumberService {
    private DtoConverter<EmployeePhoneNumberDto, IEmployeePhoneNumber> employeePhoneNumberDtoConverter =
            new DtoConverter<>("Id", "PhoneNumber", "EnableTelegramSending");

    private IEmployeePhoneNumberDao employeePhoneNumberDao;

    @Override
    @Transactional
    public Long update(EmployeePhoneNumberDto dto) {
        if (dto.getId() == null) {
        throw new IllegalArgumentException("Employee Phone Number id can not bu null!");
    }
        IEmployeePhoneNumber phoneNumber = employeePhoneNumberDao.getById(dto.getId());
        return employeePhoneNumberDao
                .update(employeePhoneNumberDtoConverter.convert(dto, phoneNumber))
                .getId();
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        return employeePhoneNumberDao.deleteById(id);
    }

    @Autowired
    public void setEmployeePhoneNumberDao(IEmployeePhoneNumberDao employeePhoneNumberDao) {
        this.employeePhoneNumberDao = employeePhoneNumberDao;
    }
}
