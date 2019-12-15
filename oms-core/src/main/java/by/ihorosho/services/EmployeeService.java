package by.ihorosho.services;

import by.ihorosho.api.services.IEmployeeService;
import by.ihorosho.api.services.dto.EmployeeDto;
import by.ihorosho.api.services.dto.EmployeeEmailDto;
import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;
import by.ihorosho.api.storage.daos.IEmployeeDao;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.services.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("employeeService")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeService implements IEmployeeService {
    private DtoConverter<IEmployee, EmployeeDto> employeeConverter =
            new DtoConverter<>("Id", "Login", "Name", "Surname", "Patronymic");
    private DtoConverter<IEmployeeEmail, EmployeeEmailDto> employeeEmailConverter =
            new DtoConverter<>("Id", "Email", "EnableSending");
    private DtoConverter<IEmployeePhoneNumber, EmployeePhoneNumberDto> employeePhoneNumberConverter =
            new DtoConverter<>("Id", "PhoneNumber", "EnableTelegramSending");

    private IEmployeeDao employeeDao;

    @Override
    public List<EmployeeDto> getAll(int offset, int limit) {
        return employeeDao.getAll(offset, limit).stream().map(e -> {
            EmployeeDto employeeDto = employeeConverter.convert(e, new EmployeeDto());
            employeeDto.setEmployeeEmails(employeeEmailConverter.convert(e.getEmployeeEmails(), EmployeeEmailDto.class));
            employeeDto.setEmployeePhoneNumbers(employeePhoneNumberConverter.convert(e.getEmployeePhoneNumbers(), EmployeePhoneNumberDto.class));
            return employeeDto;
        }).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Long id) {
        IEmployee e = employeeDao.getById(id);
        if(e == null){
            throw new IllegalArgumentException("Employee with that id does not exist!");
        }
        EmployeeDto employeeDto = employeeConverter.convert(e, new EmployeeDto());
        employeeDto.setEmployeeEmails(employeeEmailConverter.convert(e.getEmployeeEmails(), EmployeeEmailDto.class));
        employeeDto.setEmployeePhoneNumbers(employeePhoneNumberConverter.convert(e.getEmployeePhoneNumbers(), EmployeePhoneNumberDto.class));
        return employeeDto;
    }

    @Override
    public void add(EmployeeDto dto) {
        
    }

    @Override
    public void update(EmployeeDto dto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Autowired
    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
