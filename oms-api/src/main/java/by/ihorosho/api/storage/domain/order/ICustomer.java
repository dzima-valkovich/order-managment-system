package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.Set;

public interface ICustomer extends IEntity<Long> {

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getEmail();

    void setEmail(String email);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    String getPatronymic();

    void setPatronymic(String patronymic);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);

    boolean addOrder(IOrder order);

    boolean removeOrder(IOrder order);

    Set<IOrderAddress> getOrderAddresses();

    void setOrderAddresses(Set<IOrderAddress> orderAddresses);

    boolean addOrderAddress(IOrderAddress orderAddress);

    boolean removeOrderAddress(IOrderAddress orderAddress);
}
