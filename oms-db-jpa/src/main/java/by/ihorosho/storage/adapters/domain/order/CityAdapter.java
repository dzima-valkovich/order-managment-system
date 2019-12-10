package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.order.ICity;
import by.ihorosho.api.storage.domain.order.IOrderAddress;
import by.ihorosho.storage.domain.order.City;

import java.util.Set;
import java.util.stream.Collectors;

public class CityAdapter implements ICity {
    private City city;

    public CityAdapter(City city) {
        this.city = city;
    }

    @Override
    public String getCityName() {
        return city.getCityName();
    }

    @Override
    public void setCityName(String cityName) {
        city.setCityName(cityName);
    }

    @Override
    public Set<IOrderAddress> getOrderAddresses() {
        return city.getOrderAddresses().stream()
                .map(OrderAddressAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrderAddresses(Set<IOrderAddress> orderAddresses) {
        city.setOrderAddresses(orderAddresses.stream()
                .map(e -> ((OrderAddressAdapter) e).getOrderAddress()).collect(Collectors.toSet()));
    }

    @Override
    public Long getId() {
        return city.getId();
    }

    @Override
    public void setId(Long aLong) {
        city.setId(aLong);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
