package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.domain.employee.*;
import by.ihorosho.api.domain.order.IOrder;
import by.ihorosho.storage.adapters.domain.order.OrderAdapter;
import by.ihorosho.storage.domain.employee.Employee;

import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAdapter implements IEmployee {
    private Employee employee;

    public EmployeeAdapter(Employee employee) {
        this.employee = employee;
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
