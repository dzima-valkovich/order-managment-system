package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.order.ICustomer;
import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.api.storage.domain.order.IOrderAddress;
import by.ihorosho.api.storage.domain.order.IWorkType;
import by.ihorosho.storage.adapters.domain.employee.EmployeeAdapter;
import by.ihorosho.storage.domain.order.Order;

import java.util.Date;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class OrderAdapter implements IOrder {
    private Order order;

    public OrderAdapter() {
        this.order = new Order();
    }

    public OrderAdapter(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderAdapter)) return false;
        OrderAdapter that = (OrderAdapter) o;
        return Objects.equals(getOrder(), that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder());
    }

    @Override
    public Date getOrderDate() {
        return order.getOrderDate();
    }

    @Override
    public void setOrderDate(Date orderDate) {
        order.setOrderDate(orderDate);
    }

    @Override
    public Date getPlannedStartDate() {
        return order.getPlannedStartDate();
    }

    @Override
    public void setPlannedStartDate(Date plannedStartDate) {
        order.setPlannedStartDate(plannedStartDate);
    }

    @Override
    public Date getFactStartDate() {
        return order.getFactStartDate();
    }

    @Override
    public void setFactStartDate(Date factStartDate) {
        order.setFactStartDate(factStartDate);
    }

    @Override
    public Date getPlannedFinishDate() {
        return order.getPlannedFinishDate();
    }

    @Override
    public void setPlannedFinishDate(Date plannedFinishDate) {
        order.setPlannedFinishDate(plannedFinishDate);
    }

    @Override
    public Date getFactFinishDate() {
        return order.getFactFinishDate();
    }

    @Override
    public void setFactFinishDate(Date factFinishDate) {
        order.setFactFinishDate(factFinishDate);
    }

    @Override
    public IEmployee getEmployee() {
        return new EmployeeAdapter(order.getEmployee());
    }

    @Override
    public void setEmployee(IEmployee employee) {
        order.setEmployee(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public IOrderAddress getOrderAddress() {
        return new OrderAddressAdapter(order.getOrderAddress());
    }

    @Override
    public void setOrderAddress(IOrderAddress orderAddress) {
        order.setOrderAddress(((OrderAddressAdapter) orderAddress).getOrderAddress());
    }

    @Override
    public ICustomer getCustomer() {
        return new CustomerAdapter(order.getCustomer());
    }

    @Override
    public void setCustomer(ICustomer customer) {
        order.setCustomer(((CustomerAdapter) customer).getCustomer());
    }

    @Override
    public List<IWorkType> getWorkTypes() {
        return order.getWorkTypes().stream()
                .map(WorkTypeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public void setWorkTypes(List<IWorkType> workTypes) {
        order.setWorkTypes(workTypes.stream()
                .map(e -> ((WorkTypeAdapter) e).getWorkType()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addWorkType(IWorkType workType) {
        return order.getWorkTypes().add(((WorkTypeAdapter) workType).getWorkType());
    }

    @Override
    public boolean removeWorkType(IWorkType workType) {
        return order.getWorkTypes().remove(((WorkTypeAdapter) workType).getWorkType());
    }

    @Override
    public Date getTerminationDate() {
        return order.getTerminationDate();
    }

    @Override
    public void setTerminationDate(Date terminationDate) {
        order.setTerminationDate(terminationDate);
    }

    @Override
    public Long getId() {
        return order.getId();
    }

    @Override
    public void setId(Long aLong) {
        order.setId(aLong);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
