package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IEmployeePhoneNumberDao;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.storage.adapters.domain.employee.EmployeePhoneNumberAdapter;
import by.ihorosho.storage.daos.EmployeePhoneNumberDao;
import by.ihorosho.storage.domain.employee.EmployeePhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("employeePhoneNumberDaoAdapter")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeePhoneNumberDaoAdapter implements IEmployeePhoneNumberDao {
    private EmployeePhoneNumberDao employeePhoneNumberDao;

    @Override
    public List<IEmployeePhoneNumber> getAll() {
        return employeePhoneNumberDao.getAll().stream()
                .map(EmployeePhoneNumberAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeePhoneNumber> getAll(int limit) {
        return employeePhoneNumberDao.getAll(limit).stream()
                .map(EmployeePhoneNumberAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeePhoneNumber> getAll(int offset, int limit) {
        return employeePhoneNumberDao.getAll(offset, limit).stream()
                .map(EmployeePhoneNumberAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IEmployeePhoneNumber getById(Long aLong) {
        return new EmployeePhoneNumberAdapter(employeePhoneNumberDao.getById(aLong));
    }

    @Override
    public IEmployeePhoneNumber save(IEmployeePhoneNumber entity) {
        EmployeePhoneNumber e = employeePhoneNumberDao.save(((EmployeePhoneNumberAdapter) entity).getEmployeePhoneNumber());
        return new EmployeePhoneNumberAdapter(e);
    }

    @Override
    public IEmployeePhoneNumber update(IEmployeePhoneNumber entity) {
        EmployeePhoneNumber e = employeePhoneNumberDao.update(((EmployeePhoneNumberAdapter) entity).getEmployeePhoneNumber());
        return new EmployeePhoneNumberAdapter(e);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return employeePhoneNumberDao.deleteById(aLong);
    }

    @Autowired
    public void setEmployeePhoneNumberDao(EmployeePhoneNumberDao employeePhoneNumberDao) {
        this.employeePhoneNumberDao = employeePhoneNumberDao;
    }
}
