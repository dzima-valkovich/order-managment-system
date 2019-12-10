package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.order.Customer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerDao extends AbstractOmsCrudDao<Customer, Long> {

    public CustomerDao() {
        super.setClazz(Customer.class);
    }
}
