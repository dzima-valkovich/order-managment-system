package by.ihorosho.api.domain.order;

import by.ihorosho.api.domain.IEntity;

import java.util.Set;

public interface IWorkType extends IEntity<Long> {

    String getType();

    void setType(String type);

    String getDescription();

    void setDescription(String description);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);
}
