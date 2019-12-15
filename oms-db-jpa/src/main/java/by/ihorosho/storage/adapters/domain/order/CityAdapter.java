package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.order.ICity;
import by.ihorosho.api.storage.domain.order.IOrderAddress;
import by.ihorosho.storage.domain.order.City;

import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class CityAdapter implements ICity {
    private City city;

    public CityAdapter() {
        this.city = new City();
    }

    public CityAdapter(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityAdapter)) return false;
        CityAdapter that = (CityAdapter) o;
        return Objects.equals(getCity(), that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity());
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
    public List<IOrderAddress> getOrderAddresses() {
        return city.getOrderAddresses().stream()
                .map(OrderAddressAdapter::new).collect(Collectors.toList());
    }

    @Override
    public void setOrderAddresses(List<IOrderAddress> orderAddresses) {
        city.setOrderAddresses(orderAddresses.stream()
                .map(e -> ((OrderAddressAdapter) e).getOrderAddress()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addOrderAddress(IOrderAddress orderAddress) {
        return city.getOrderAddresses().add(((OrderAddressAdapter) orderAddress).getOrderAddress());
    }

    @Override
    public boolean removeOrderAddress(IOrderAddress orderAddress) {
        return city.getOrderAddresses().remove(((OrderAddressAdapter) orderAddress).getOrderAddress());
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
