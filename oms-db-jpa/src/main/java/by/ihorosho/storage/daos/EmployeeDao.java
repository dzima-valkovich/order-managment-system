package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.employee.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeDao extends AbstractOmsCrudDao<Employee, Long> {

    public EmployeeDao() {
        super.setClazz(Employee.class);
    }
}
