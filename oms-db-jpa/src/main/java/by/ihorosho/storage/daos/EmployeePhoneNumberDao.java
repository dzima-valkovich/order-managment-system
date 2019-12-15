package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.employee.EmployeePhoneNumber;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("employeePhoneNumberDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeePhoneNumberDao extends AbstractOmsCrudDao<EmployeePhoneNumber, Long> {

    public EmployeePhoneNumberDao() {
        super.setClazz(EmployeePhoneNumber.class);
    }
}
