package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IEmployeeEmailDao;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.storage.adapters.domain.employee.EmployeeEmailAdapter;
import by.ihorosho.storage.daos.EmployeeEmailDao;
import by.ihorosho.storage.domain.employee.EmployeeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("employeeEmailDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeEmailDaoAdapter implements IEmployeeEmailDao {
    private EmployeeEmailDao employeeEmailDao;

    @Override
    public List<IEmployeeEmail> getAll() {
        return employeeEmailDao.getAll().stream()
                .map(EmployeeEmailAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeeEmail> getAll(int limit) {
        return employeeEmailDao.getAll(limit).stream()
                .map(EmployeeEmailAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeeEmail> getAll(int offset, int limit) {
        return employeeEmailDao.getAll(offset, limit).stream()
                .map(EmployeeEmailAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IEmployeeEmail getById(Long aLong) {
        return new EmployeeEmailAdapter(employeeEmailDao.getById(aLong));
    }

    @Override
    public IEmployeeEmail save(IEmployeeEmail entity) {
        EmployeeEmail e = employeeEmailDao.save(((EmployeeEmailAdapter) entity).getEmployeeEmail());
        return new EmployeeEmailAdapter(employeeEmailDao.save(e));
    }

    @Override
    public IEmployeeEmail update(IEmployeeEmail entity) {
        EmployeeEmail e = employeeEmailDao.update(((EmployeeEmailAdapter) entity).getEmployeeEmail());
        return new EmployeeEmailAdapter(employeeEmailDao.save(e));
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return employeeEmailDao.deleteById(aLong);
    }

    @Autowired
    public void setEmployeeEmailDao(EmployeeEmailDao employeeEmailDao) {
        this.employeeEmailDao = employeeEmailDao;
    }
}
