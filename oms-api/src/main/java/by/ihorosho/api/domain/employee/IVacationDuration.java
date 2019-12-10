package by.ihorosho.api.domain.employee;

import by.ihorosho.api.domain.IEntity;

import java.util.Date;

public interface IVacationDuration extends IEntity<Long> {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getFinishDate();

    void setFinishDate(Date finishDate);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);
}
