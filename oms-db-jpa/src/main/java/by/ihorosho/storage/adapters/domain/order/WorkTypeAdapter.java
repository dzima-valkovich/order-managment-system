package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.api.storage.domain.order.IWorkType;
import by.ihorosho.storage.domain.order.WorkType;

import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class WorkTypeAdapter implements IWorkType {
    private WorkType workType;

    public WorkTypeAdapter() {
        this.workType = new WorkType();
    }

    public WorkTypeAdapter(WorkType workType) {
        this.workType = workType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkTypeAdapter)) return false;
        WorkTypeAdapter that = (WorkTypeAdapter) o;
        return Objects.equals(getWorkType(), that.getWorkType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkType());
    }

    @Override
    public String getType() {
        return workType.getType();
    }

    @Override
    public void setType(String type) {
        workType.setType(type);
    }

    @Override
    public String getDescription() {
        return workType.getDescription();
    }

    @Override
    public void setDescription(String description) {
        workType.setDescription(description);
    }

    @Override
    public List<IOrder> getOrders() {
        return workType.getOrders().stream()
                .map(OrderAdapter::new).collect(Collectors.toList());
    }

    @Override
    public void setOrders(List<IOrder> orders) {
        workType.setOrders(orders.stream()
                .map(e -> ((OrderAdapter) e).getOrder()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addOrder(IOrder order) {
        return workType.getOrders().add(((OrderAdapter) order).getOrder());
    }

    @Override
    public boolean removeOrder(IOrder order) {
        return workType.getOrders().remove(((OrderAdapter) order).getOrder());
    }

    @Override
    public Long getId() {
        return workType.getId();
    }

    @Override
    public void setId(Long aLong) {
        workType.setId(aLong);
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }
}
