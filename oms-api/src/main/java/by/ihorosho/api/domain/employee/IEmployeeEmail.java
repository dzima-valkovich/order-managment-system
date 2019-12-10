package by.ihorosho.api.domain.employee;

import by.ihorosho.api.domain.IEntity;

public interface IEmployeeEmail extends IEntity<Long> {

    String getEmail();

    void setEmail(String email);

    Boolean getEnableSending();

    void setEnableSending(Boolean enableSending);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);
}
