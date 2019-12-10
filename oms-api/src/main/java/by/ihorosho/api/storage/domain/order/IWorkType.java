package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.Set;

public interface IWorkType extends IEntity<Long> {

    String getType();

    void setType(String type);

    String getDescription();

    void setDescription(String description);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);
}
