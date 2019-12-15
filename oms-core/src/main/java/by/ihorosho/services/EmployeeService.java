package by.ihorosho.services;

import by.ihorosho.api.services.IEmployeeService;
import by.ihorosho.api.services.dto.EmployeeDto;
import by.ihorosho.api.services.dto.EmployeeEmailDto;
import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;
import by.ihorosho.api.storage.daos.IEmployeeDao;
import by.ihorosho.api.storage.daos.IEmployeePhoneNumberDao;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.services.utils.DtoConverter;
import by.ihorosho.services.utils.DtoFieldsChecker;
import by.ihorosho.storage.adapters.domain.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private DtoFieldsChecker<EmployeeDto> employeeDtoFieldsChecker =
            new DtoFieldsChecker<>("login", "passwordHash", "name", "surname", "patronymic", "employeePhoneNumbers", "employeeEmails");
    private DtoConverter<EmployeePhoneNumberDto, IEmployeePhoneNumber> employeePhoneNumberDtoConverter =
            employeePhoneNumberConverter.getReverseConverter();
    private DtoConverter<EmployeeDto, IEmployee> employeeDtoConverter =
            new DtoConverter<>("Id", "Login", "PasswordHash", "Name", "Surname", "Patronymic");

    private IEmployeeDao employeeDao;
    private IEmployeePhoneNumberDao employeePhoneNumberDao;

    @Override
    @Transactional
    public List<EmployeeDto> getAll(int offset, int limit) {
        return employeeDao.getAll(offset, limit).stream().map(e -> {
            EmployeeDto employeeDto = employeeConverter.convert(e, new EmployeeDto());
            employeeDto.setEmployeeEmails(employeeEmailConverter.convert(e.getEmployeeEmails(), EmployeeEmailDto.class));
            employeeDto.setEmployeePhoneNumbers(employeePhoneNumberConverter.convert(e.getEmployeePhoneNumbers(), EmployeePhoneNumberDto.class));
            return employeeDto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeDto getById(Long id) {
        IEmployee e = employeeDao.getById(id);
        if (e == null) {
            throw new IllegalArgumentException("Employee with that id does not exist!");
        }
        EmployeeDto employeeDto = employeeConverter.convert(e, new EmployeeDto());
        employeeDto.setEmployeeEmails(employeeEmailConverter.convert(e.getEmployeeEmails(), EmployeeEmailDto.class));
        employeeDto.setEmployeePhoneNumbers(employeePhoneNumberConverter.convert(e.getEmployeePhoneNumbers(), EmployeePhoneNumberDto.class));
        return employeeDto;
    }

    @Override
    @Transactional
    public Long add(EmployeeDto dto) {
        employeeDtoFieldsChecker.isNullOrEmpty(dto);
        IEmployee employee = employeeConverter.getReverseConverter().convert(dto, EntityBuilder.buildEmployee());
        employee.setPasswordHash(dto.getPasswordHash());

        List<IEmployeeEmail> emails = employeeEmailConverter.getReverseConverter().convert(dto.getEmployeeEmails(),
                EntityBuilder.buildEmployeeEmail().getClass());
        emails.forEach(e -> e.setEmployee(employee));
        employee.setEmployeeEmails(emails);

        List<IEmployeePhoneNumber> phoneNumbers = employeePhoneNumberConverter.getReverseConverter().convert(dto.getEmployeePhoneNumbers(),
                EntityBuilder.buildEmployeePhoneNumber().getClass());
        phoneNumbers.forEach(e -> e.setEmployee(employee));
        employee.setEmployeePhoneNumbers(phoneNumbers);

        return employeeDao.save(employee).getId();
    }

    @Override
    @Transactional
    public Long update(EmployeeDto dto) {
        IEmployee employee = employeeDao.getById(dto.getId());
        return employeeDao.update(employeeDtoConverter.convert(dto, employee)).getId();
    }

    @Override
    @Transactional
    public Boolean deleteById(Long id) {
        return employeeDao.deleteById(id);
    }

    @Override
    @Transactional
    public Long addNewPhoneNumberToEmployee(Long employeeId, EmployeePhoneNumberDto phoneNumberDto) {
        IEmployee employee = employeeDao.getById(employeeId);
        IEmployeePhoneNumber employeePhoneNumber = employeePhoneNumberDtoConverter
                .convert(phoneNumberDto, EntityBuilder.buildEmployeePhoneNumber().getClass());
        employeePhoneNumber.setEmployee(employee);
        employee.addEmployeePhoneNumber(employeePhoneNumber);
        return employeePhoneNumberDao.save(employeePhoneNumber).getId();
    }

    @Autowired
    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setEmployeePhoneNumberDao(IEmployeePhoneNumberDao employeePhoneNumberDao) {
        this.employeePhoneNumberDao = employeePhoneNumberDao;
    }
}
