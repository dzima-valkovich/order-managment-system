package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.order.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderDao extends AbstractOmsCrudDao<Order, Long> {

    public OrderDao() {
        super.setClazz(Order.class);
    }
}
