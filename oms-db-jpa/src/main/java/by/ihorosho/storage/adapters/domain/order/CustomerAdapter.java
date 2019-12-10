package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.order.ICustomer;
import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.api.storage.domain.order.IOrderAddress;
import by.ihorosho.storage.domain.order.Customer;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomerAdapter implements ICustomer {
    private Customer customer;

    public CustomerAdapter(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getPhoneNumber() {
        return customer.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        customer.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getEmail() {
        return customer.getEmail();
    }

    @Override
    public void setEmail(String email) {
        customer.setEmail(email);
    }

    @Override
    public String getName() {
        return customer.getName();
    }

    @Override
    public void setName(String name) {
        customer.setName(name);
    }

    @Override
    public String getSurname() {
        return customer.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        customer.setSurname(surname);
    }

    @Override
    public String getPatronymic() {
        return customer.getPatronymic();
    }

    @Override
    public void setPatronymic(String patronymic) {
        customer.setPatronymic(patronymic);
    }

    @Override
    public Set<IOrder> getOrders() {
        return customer.getOrders().stream()
                .map(OrderAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrders(Set<IOrder> orders) {
        customer.setOrders(orders.stream()
                .map(e -> ((OrderAdapter) e).getOrder()).collect(Collectors.toSet()));
    }

    @Override
    public Set<IOrderAddress> getOrderAddresses() {
        return customer.getOrderAddresses().stream()
                .map(OrderAddressAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrderAddresses(Set<IOrderAddress> orderAddresses) {
        customer.setOrderAddresses(orderAddresses.stream()
                .map(e -> ((OrderAddressAdapter) e).getOrderAddress()).collect(Collectors.toSet()));
    }

    @Override
    public Long getId() {
        return customer.getId();
    }

    @Override
    public void setId(Long aLong) {
        customer.setId(aLong);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
