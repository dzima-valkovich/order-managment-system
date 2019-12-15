package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.*;
import by.ihorosho.api.storage.domain.order.IOrder;
import by.ihorosho.storage.adapters.domain.order.OrderAdapter;
import by.ihorosho.storage.domain.employee.Employee;
import by.ihorosho.storage.domain.employee.EmployeeEmail;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAdapter implements IEmployee {
    private Employee employee;

    public EmployeeAdapter() {
        employee = new Employee();
    }

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeAdapter)) return false;
        EmployeeAdapter that = (EmployeeAdapter) o;
        return Objects.equals(getEmployee(), that.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee());
    }

    @Override
    public String getLogin() {
        return employee.getLogin();
    }

    @Override
    public void setLogin(String login) {
        employee.setLogin(login);
    }

    @Override
    public String getPasswordHash() {
        return employee.getPasswordHash();
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        employee.setPasswordHash(passwordHash);
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public void setName(String name) {
        employee.setName(name);
    }

    @Override
    public String getSurname() {
        return employee.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        employee.setSurname(surname);
    }

    @Override
    public String getPatronymic() {
        return employee.getPatronymic();
    }

    @Override
    public void setPatronymic(String patronymic) {
        employee.setPatronymic(patronymic);
    }

    @Override
    public Set<IEmployeeEmail> getEmployeeEmails() {
        return employee.getEmployeeEmails().stream()
                .map(EmployeeEmailAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setEmployeeEmails(Set<IEmployeeEmail> employeeEmails) {
        employee.setEmployeeEmails(employeeEmails.stream()
                .map(e -> ((EmployeeEmailAdapter) e).getEmployeeEmail()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addEmployeeEmail(IEmployeeEmail employeeEmail) {
        return employee.getEmployeeEmails().add(((EmployeeEmailAdapter) employeeEmail).getEmployeeEmail());
    }

    @Override
    public boolean removeEmployeeEmail(IEmployeeEmail employeeEmail) {
        return employee.getEmployeeEmails().remove(((EmployeeEmailAdapter) employeeEmail).getEmployeeEmail());
    }

    @Override
    public Set<IEmployeePhoneNumber> getEmployeePhoneNumbers() {
        return employee.getEmployeePhoneNumbers().stream()
                .map(EmployeePhoneNumberAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setEmployeePhoneNumbers(Set<IEmployeePhoneNumber> employeePhoneNumbers) {
        employee.setEmployeePhoneNumbers(employeePhoneNumbers.stream()
                .map(e -> ((EmployeePhoneNumberAdapter) e).getEmployeePhoneNumber()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber) {
        return employee.getEmployeePhoneNumbers().add(((EmployeePhoneNumberAdapter) employeePhoneNumber).getEmployeePhoneNumber());
    }

    @Override
    public boolean removeEmployeePhoneNumber(IEmployeePhoneNumber employeePhoneNumber) {
        return employee.getEmployeePhoneNumbers().remove(((EmployeePhoneNumberAdapter) employeePhoneNumber).getEmployeePhoneNumber());
    }

    @Override
    public Set<IEmployeeRole> getEmployeeRoles() {
        return employee.getEmployeeRoles().stream()
                .map(EmployeeRoleAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setEmployeeRoles(Set<IEmployeeRole> employeeRoles) {
        employee.setEmployeeRoles(employeeRoles.stream()
                .map(e -> ((EmployeeRoleAdapter) e).getEmployeeRole()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addEmployeeRole(IEmployeeRole employeeRole) {
        return employee.getEmployeeRoles().add(((EmployeeRoleAdapter) employeeRole).getEmployeeRole());
    }

    @Override
    public boolean removeEmployeeRole(IEmployeeRole employeeRole) {
        return employee.getEmployeeRoles().remove(((EmployeeRoleAdapter) employeeRole).getEmployeeRole());
    }

    @Override
    public Set<IContractDuration> getContractDurations() {
        return employee.getContractDurations().stream()
                .map(ContractDurationAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setContractDurations(Set<IContractDuration> contractDurations) {
        employee.setContractDurations(contractDurations.stream()
                .map(e -> ((ContractDurationAdapter) e).getContractDuration()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addContractDuration(IContractDuration contractDuration) {
        return employee.getContractDurations().add(((ContractDurationAdapter) contractDuration).getContractDuration());
    }

    @Override
    public boolean removeContractDuration(IContractDuration contractDuration) {
        return employee.getContractDurations().remove(((ContractDurationAdapter) contractDuration).getContractDuration());
    }

    @Override
    public Set<IVacationDuration> getVacationDurations() {
        return employee.getVacationDurations().stream()
                .map(VacationDurationAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setVacationDurations(Set<IVacationDuration> vacationDurations) {
        employee.setVacationDurations(vacationDurations.stream()
                .map(e -> ((VacationDurationAdapter) e).getVacationDuration()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addVacationDuration(IVacationDuration vacationDuration) {
        return employee.getVacationDurations().add(((VacationDurationAdapter) vacationDuration).getVacationDuration());
    }

    @Override
    public boolean removeVacationDuration(IVacationDuration vacationDuration) {
        return employee.getVacationDurations().remove(((VacationDurationAdapter) vacationDuration).getVacationDuration());
    }

    @Override
    public Set<IOrder> getOrders() {
        return employee.getOrders().stream()
                .map(OrderAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setOrders(Set<IOrder> orders) {
        employee.setOrders(orders.stream()
                .map(e -> ((OrderAdapter) e).getOrder()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addOrder(IOrder order) {
        return employee.getOrders().add(((OrderAdapter) order).getOrder());
    }

    @Override
    public boolean removeOrder(IOrder order) {
        return employee.getOrders().remove(((OrderAdapter) order).getOrder());
    }

    @Override
    public Long getId() {
        return employee.getId();
    }

    @Override
    public void setId(Long aLong) {
        employee.setId(aLong);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
