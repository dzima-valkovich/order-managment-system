package by.ihorosho.services;

import by.ihorosho.api.services.IEmployeeEmailService;
import by.ihorosho.api.services.dto.EmployeeEmailDto;
import by.ihorosho.api.storage.daos.IEmployeeEmailDao;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.services.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("employeeService")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeEmailService implements IEmployeeEmailService {
    private DtoConverter<EmployeeEmailDto, IEmployeeEmail> employeeEmailDtoConverter =
            new DtoConverter<>("Id", "Email", "EnableSending");

    private IEmployeeEmailDao employeeEmailDao;

    @Override
    public Long update(EmployeeEmailDto dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Employee Email id can not bu null!");
        }
        IEmployeeEmail e = employeeEmailDao.getById(dto.getId());
        return employeeEmailDao.update(employeeEmailDtoConverter.convert(dto, e)).getId();
    }

    @Override
    public Boolean deleteById(Long id) {
        return employeeEmailDao.deleteById(id);
    }

    @Autowired
    public void setEmployeeEmailDao(IEmployeeEmailDao employeeEmailDao) {
        this.employeeEmailDao = employeeEmailDao;
    }
}
