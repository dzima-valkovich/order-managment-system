package by.ihorosho.api.storage.domain.employee;

import by.ihorosho.api.storage.domain.IEntity;
import by.ihorosho.api.storage.domain.order.IOrder;

import java.util.Set;

public interface IEmployee extends IEntity<Long> {
    String getLogin();

    void setLogin(String login);

    String getPasswordHash();

    void setPasswordHash(String passwordHash);

    String getName();

    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    String getPatronymic();

    void setPatronymic(String patronymic);

    Set<IEmployeeEmail> getEmployeeEmails();

    void setEmployeeEmails(Set<IEmployeeEmail> employeeEmails);

    Set<IEmployeePhoneNumber> getEmployeePhoneNumbers();

    void setEmployeePhoneNumbers(Set<IEmployeePhoneNumber> employeePhoneNumbers);

    Set<IEmployeeRole> getEmployeeRoles();

    void setEmployeeRoles(Set<IEmployeeRole> employeeRoles);

    Set<IContractDuration> getContractDurations();

    void setContractDurations(Set<IContractDuration> contractDurations);

    Set<IVacationDuration> getVacationDurations();

    void setVacationDurations(Set<IVacationDuration> vacationDurations);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);
}
