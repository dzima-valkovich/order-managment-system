package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.order.ICity;
import by.ihorosho.api.storage.domain.order.ICustomer;
import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.api.storage.domain.order.IOrderAddress;
import by.ihorosho.storage.domain.order.OrderAddress;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderAddressAdapter implements IOrderAddress {
    private OrderAddress orderAddress;

    public OrderAddressAdapter(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderAddressAdapter)) return false;
        OrderAddressAdapter that = (OrderAddressAdapter) o;
        return Objects.equals(getOrderAddress(), that.getOrderAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderAddress());
    }

    @Override
    public String getAddress() {
        return orderAddress.getAddress();
    }

    @Override
    public void setAddress(String address) {
        orderAddress.setAddress(address);
    }

    @Override
    public String getAddressRegion() {
        return orderAddress.getAddressRegion();
    }

    @Override
    public void setAddressRegion(String addressRegion) {
        orderAddress.setAddressRegion(addressRegion);
    }

    @Override
    public String getAddressPostalcode() {
        return orderAddress.getAddressPostalcode();
    }

    @Override
    public void setAddressPostalcode(String addressPostalcode) {
        orderAddress.setAddressPostalcode(addressPostalcode);
    }

    @Override
    public ICity getCity() {
        return new CityAdapter(orderAddress.getCity());
    }

    @Override
    public void setCity(ICity city) {
        orderAddress.setCity(((CityAdapter) city).getCity());
    }

    @Override
    public ICustomer getCustomer() {
        return new CustomerAdapter(orderAddress.getCustomer());
    }

    @Override
    public void setCustomer(ICustomer customer) {
        orderAddress.setCustomer(((CustomerAdapter) customer).getCustomer());
    }

    @Override
    public Set<IOrder> getOrders() {
        return orderAddress.getOrders().stream()
                .map(OrderAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrders(Set<IOrder> orders) {
        orderAddress.setOrders(orders.stream()
                .map(e -> ((OrderAdapter) e).getOrder()).collect(Collectors.toSet()));
    }

    @Override
    public Long getId() {
        return orderAddress.getId();
    }

    @Override
    public void setId(Long aLong) {
        orderAddress.setId(aLong);
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }
}
