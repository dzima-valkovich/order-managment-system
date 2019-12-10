package by.ihorosho.api.domain.employee;

import by.ihorosho.api.domain.IEntity;

import java.util.Date;

public interface IContractDuration extends IEntity<Long> {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getFinishDate();

    void setFinishDate(Date finishDate);

    Date getTerminationDate();

    void setTerminationDate(Date terminationDate);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);
}
