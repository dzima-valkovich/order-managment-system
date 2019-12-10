package by.ihorosho.storage.adapters.domain.order;

import by.ihorosho.api.domain.order.IOrder;
import by.ihorosho.api.domain.order.IWorkType;
import by.ihorosho.storage.domain.order.WorkType;

import java.util.Set;
import java.util.stream.Collectors;

public class WorkTypeAdapter implements IWorkType {
    private WorkType workType;

    public WorkTypeAdapter(WorkType workType) {
        this.workType = workType;
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
    public Set<IOrder> getOrders() {
        return workType.getOrders().stream()
                .map(OrderAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrders(Set<IOrder> orders) {
        workType.setOrders(orders.stream()
                .map(e -> ((OrderAdapter) e).getOrder()).collect(Collectors.toSet()));
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
