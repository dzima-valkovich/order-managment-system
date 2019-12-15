package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IEmployeeRoleDao;
import by.ihorosho.api.storage.domain.employee.IEmployeeRole;
import by.ihorosho.storage.adapters.domain.employee.EmployeeRoleAdapter;
import by.ihorosho.storage.daos.EmployeeRoleDao;
import by.ihorosho.storage.domain.employee.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("employeeRoleDaoAdapter")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeRoleDaoAdapter implements IEmployeeRoleDao {
    private EmployeeRoleDao employeeRoleDao;

    @Override
    public List<IEmployeeRole> getAll() {
        return employeeRoleDao.getAll().stream()
                .map(EmployeeRoleAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeeRole> getAll(int limit) {
        return employeeRoleDao.getAll(limit).stream()
                .map(EmployeeRoleAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IEmployeeRole> getAll(int offset, int limit) {
        return employeeRoleDao.getAll(offset, limit).stream()
                .map(EmployeeRoleAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IEmployeeRole getById(Long aLong) {
        return new EmployeeRoleAdapter(employeeRoleDao.getById(aLong));
    }

    @Override
    public IEmployeeRole save(IEmployeeRole entity) {
        EmployeeRole e = employeeRoleDao.save(((EmployeeRoleAdapter) entity).getEmployeeRole());
        return new EmployeeRoleAdapter(e);
    }

    @Override
    public IEmployeeRole update(IEmployeeRole entity) {
        EmployeeRole e = employeeRoleDao.update(((EmployeeRoleAdapter) entity).getEmployeeRole());
        return new EmployeeRoleAdapter(e);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return employeeRoleDao.deleteById(aLong);
    }

    @Autowired
    public void setEmployeeRoleDao(EmployeeRoleDao employeeRoleDao) {
        this.employeeRoleDao = employeeRoleDao;
    }
}
