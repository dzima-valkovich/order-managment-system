package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.employee.EmployeeRole;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("employeeRoleDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeRoleDao extends AbstractOmsCrudDao<EmployeeRole, Long> {

    public EmployeeRoleDao() {
        super.setClazz(EmployeeRole.class);
    }
}
