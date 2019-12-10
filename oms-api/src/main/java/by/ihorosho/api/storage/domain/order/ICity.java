package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.Set;

public interface ICity extends IEntity<Long> {

    String getCityName();

    void setCityName(String cityName);

    Set<IOrderAddress> getOrderAddresses();

    void setOrderAddresses(Set<IOrderAddress> orderAddresses);
}
