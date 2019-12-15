package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.employee.EmployeeEmail;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("employeeEmailDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeEmailDao extends AbstractOmsCrudDao<EmployeeEmail, Long> {

    public EmployeeEmailDao() {
        super.setClazz(EmployeeEmail.class);
    }
}
