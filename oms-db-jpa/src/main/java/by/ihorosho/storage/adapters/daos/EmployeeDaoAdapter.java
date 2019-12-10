package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IEmployeeDao;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.storage.adapters.domain.employee.EmployeeAdapter;
import by.ihorosho.storage.daos.EmployeeDao;
import by.ihorosho.storage.domain.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDaoAdapter implements IEmployeeDao {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<IEmployee> getAll() {
        return employeeDao.getAll().stream()
                .map(EmployeeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployee> getAll(int limit) {
        return employeeDao.getAll(limit).stream()
                .map(EmployeeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployee> getAll(int offset, int limit) {
        return employeeDao.getAll(offset, limit).stream()
                .map(EmployeeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IEmployee getById(Long aLong) {
        return new EmployeeAdapter(employeeDao.getById(aLong));
    }

    @Override
    public IEmployee save(IEmployee entity) {
        Employee e = employeeDao.save(((EmployeeAdapter) entity).getEmployee());
        return new EmployeeAdapter(e);
    }

    @Override
    public IEmployee update(IEmployee entity) {
        Employee e = employeeDao.update(((EmployeeAdapter) entity).getEmployee());
        return new EmployeeAdapter(e);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return employeeDao.deleteById(aLong);
    }
}
