package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.ICustomerDao;
import by.ihorosho.api.storage.domain.order.ICustomer;
import by.ihorosho.storage.adapters.domain.order.CustomerAdapter;
import by.ihorosho.storage.daos.CustomerDao;
import by.ihorosho.storage.domain.order.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("customerDaoAdapter")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerDaoAdapter implements ICustomerDao {
    private CustomerDao customerDao;

    @Override
    public List<ICustomer> getAll() {
        return customerDao.getAll().stream()
                .map(CustomerAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<ICustomer> getAll(int limit) {
        return customerDao.getAll(limit).stream()
                .map(CustomerAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<ICustomer> getAll(int offset, int limit) {
        return customerDao.getAll(offset, limit).stream()
                .map(CustomerAdapter::new).collect(Collectors.toList());
    }

    @Override
    public ICustomer getById(Long aLong) {
        return new CustomerAdapter(customerDao.getById(aLong));
    }

    @Override
    public ICustomer save(ICustomer entity) {
        Customer c = customerDao.save(((CustomerAdapter) entity).getCustomer());
        return new CustomerAdapter(c);
    }

    @Override
    public ICustomer update(ICustomer entity) {
        Customer c = customerDao.update(((CustomerAdapter) entity).getCustomer());
        return new CustomerAdapter(c);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return customerDao.deleteById(aLong);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
