package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.List;

public interface ICity extends IEntity<Long> {

    String getCityName();

    void setCityName(String cityName);

    List<IOrderAddress> getOrderAddresses();

    void setOrderAddresses(List<IOrderAddress> orderAddresses);

    boolean addOrderAddress(IOrderAddress orderAddress);

    boolean removeOrderAddress(IOrderAddress orderAddress);
}
