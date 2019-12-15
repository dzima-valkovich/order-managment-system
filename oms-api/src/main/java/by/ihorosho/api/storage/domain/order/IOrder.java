package by.ihorosho.api.storage.domain.order;

import by.ihorosho.api.storage.domain.IEntity;
import by.ihorosho.api.storage.domain.employee.IEmployee;

import java.util.Date;
import java.util.List;

public interface IOrder extends IEntity<Long> {

    Date getOrderDate();

    void setOrderDate(Date orderDate);

    Date getPlannedStartDate();

    void setPlannedStartDate(Date plannedStartDate);

    Date getFactStartDate();

    void setFactStartDate(Date factStartDate);

    Date getPlannedFinishDate();

    void setPlannedFinishDate(Date plannedFinishDate);

    Date getFactFinishDate();

    void setFactFinishDate(Date factFinishDate);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);

    IOrderAddress getOrderAddress();

    void setOrderAddress(IOrderAddress orderAddress);

    ICustomer getCustomer();

    void setCustomer(ICustomer customer);

    List<IWorkType> getWorkTypes();

    void setWorkTypes(List<IWorkType> workTypes);

    boolean addWorkType(IWorkType workType);

    boolean removeWorkType(IWorkType workType);

    Date getTerminationDate();

    void setTerminationDate(Date terminationDate);
}
