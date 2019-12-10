package by.ihorosho.api.storage.domain.employee;

import by.ihorosho.api.storage.domain.IEntity;

public interface IEmployeeEmail extends IEntity<Long> {

    String getEmail();

    void setEmail(String email);

    Boolean getEnableSending();

    void setEnableSending(Boolean enableSending);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);
}
