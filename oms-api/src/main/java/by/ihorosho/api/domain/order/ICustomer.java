package by.ihorosho.api.domain.order;

import by.ihorosho.api.domain.IEntity;

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

    Set<IOrderAddress> getOrderAddresses();

    void setOrderAddresses(Set<IOrderAddress> orderAddresses);
}
