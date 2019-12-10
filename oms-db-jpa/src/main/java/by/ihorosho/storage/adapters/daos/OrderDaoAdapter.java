package by.ihorosho.storage.adapters.daos;

import by.ihorosho.api.storage.daos.IOrderDao;
import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.storage.adapters.domain.order.OrderAdapter;
import by.ihorosho.storage.daos.OrderDao;
import by.ihorosho.storage.domain.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("orderDaoAdapter")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderDaoAdapter implements IOrderDao {
    private OrderDao orderDao;

    @Override
    public List<IOrder> getAll() {
        return orderDao.getAll().stream()
                .map(OrderAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IOrder> getAll(int limit) {
        return orderDao.getAll(limit).stream()
                .map(OrderAdapter::new).collect(Collectors.toList());
    }

    @Override
    public List<IOrder> getAll(int offset, int limit) {
        return orderDao.getAll(offset, limit).stream()
                .map(OrderAdapter::new).collect(Collectors.toList());
    }

    @Override
    public IOrder getById(Long aLong) {
        return new OrderAdapter(orderDao.getById(aLong));
    }

    @Override
    public IOrder save(IOrder entity) {
        Order o = orderDao.save(((OrderAdapter) entity).getOrder());
        return new OrderAdapter(o);
    }

    @Override
    public IOrder update(IOrder entity) {
        Order o = orderDao.update(((OrderAdapter) entity).getOrder());
        return new OrderAdapter(o);
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return orderDao.deleteById(aLong);
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
