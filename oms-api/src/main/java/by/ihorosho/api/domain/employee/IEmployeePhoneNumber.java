package by.ihorosho.api.domain.employee;

import by.ihorosho.api.domain.IEntity;

public interface IEmployeePhoneNumber extends IEntity<Long> {

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    Boolean getEnableTelegramSending();

    void setEnableTelegramSending(Boolean enableTelegramSending);

    IEmployee getEmployee();

    void setEmployee(IEmployee employee);
}
