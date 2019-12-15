package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.List;

public interface IWorkType extends IEntity<Long> {

    String getType();

    void setType(String type);

    String getDescription();

    void setDescription(String description);

    List<IOrder> getOrders();

    void setOrders(List<IOrder> orders);

    boolean addOrder(IOrder order);

    boolean removeOrder(IOrder order);
}
