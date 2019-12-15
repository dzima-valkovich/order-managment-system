package by.ihorosho.api.storage.domain.employee;

import by.ihorosho.api.storage.domain.IEntity;
import by.ihorosho.api.storage.domain.order.IOrder;

import java.util.List;

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

    List<IEmployeeEmail> getEmployeeEmails();

    void setEmployeeEmails(List<IEmployeeEmail> employeeEmails);

    boolean addEmployeeEmail(IEmployeeEmail employeeEmail);

    boolean removeEmployeeEmail(IEmployeeEmail employeeEmail);

    List<IEmployeePhoneNumber> getEmployeePhoneNumbers();

    void setEmployeePhoneNumbers(List<IEmployeePhoneNumber> employeePhoneNumbers);

    boolean addEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber);

    boolean removeEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber);

    List<IEmployeeRole> getEmployeeRoles();

    void setEmployeeRoles(List<IEmployeeRole> employeeRoles);

    boolean addEmployeeRole(IEmployeeRole employeeRole);

    boolean removeEmployeeRole(IEmployeeRole employeeRole);

    List<IContractDuration> getContractDurations();

    void setContractDurations(List<IContractDuration> contractDurations);

    boolean addContractDuration(IContractDuration contractDuration);

    boolean removeContractDuration(IContractDuration contractDuration);

    List<IVacationDuration> getVacationDurations();

    void setVacationDurations(List<IVacationDuration> vacationDurations);

    boolean addVacationDuration(IVacationDuration vacationDuration);

    boolean removeVacationDuration(IVacationDuration vacationDuration);

    List<IOrder> getOrders();

    void setOrders(List<IOrder> orders);

    boolean addOrder(IOrder order);

    boolean removeOrder(IOrder order);
}
