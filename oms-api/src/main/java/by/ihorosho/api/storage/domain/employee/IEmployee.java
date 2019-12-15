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

    boolean addEmployeeEmail(IEmployeeEmail employeeEmail);

    boolean removeEmployeeEmail(IEmployeeEmail employeeEmail);

    Set<IEmployeePhoneNumber> getEmployeePhoneNumbers();

    void setEmployeePhoneNumbers(Set<IEmployeePhoneNumber> employeePhoneNumbers);

    boolean addEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber);

    boolean removeEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber);

    Set<IEmployeeRole> getEmployeeRoles();

    void setEmployeeRoles(Set<IEmployeeRole> employeeRoles);

    boolean addEmployeeRole(IEmployeeRole employeeRole);

    boolean removeEmployeeRole(IEmployeeRole employeeRole);

    Set<IContractDuration> getContractDurations();

    void setContractDurations(Set<IContractDuration> contractDurations);

    boolean addContractDuration(IContractDuration contractDuration);

    boolean removeContractDuration(IContractDuration contractDuration);

    Set<IVacationDuration> getVacationDurations();

    void setVacationDurations(Set<IVacationDuration> vacationDurations);

    boolean addVacationDuration(IVacationDuration vacationDuration);

    boolean removeVacationDuration(IVacationDuration vacationDuration);

    Set<IOrder> getOrders();

    void setOrders(Set<IOrder> orders);

    boolean addOrder(IOrder order);

    boolean removeOrder(IOrder order);
}
