package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.Set;

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

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);
}
