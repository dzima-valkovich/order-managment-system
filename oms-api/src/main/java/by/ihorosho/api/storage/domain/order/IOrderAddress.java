package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.List;

public interface IOrderAddress extends IEntity<Long> {

    String getAddress();

    void setAddress(String address);

    String getAddressRegion();

    void setAddressRegion(String addressRegion);

    String getAddressPostalcode();

    void setAddressPostalcode(String addressPostalcode);

    ICity getCity();

    void setCity(ICity city);

    ICustomer getCustomer();

    void setCustomer(ICustomer customer);

    List<IOrder> getOrders();

    void setOrders(List<IOrder> orders);

    boolean addOrder(IOrder order);

    boolean removeOrder(IOrder order);
}
