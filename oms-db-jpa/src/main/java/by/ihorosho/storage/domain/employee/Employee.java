package by.ihorosho.storage.domain.employee;

import by.ihorosho.storage.domain.order.Order;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<EmployeeEmail> employeeEmails = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<EmployeePhoneNumber> employeePhoneNumbers = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "employees")
    private Set<EmployeeRole> employeeRoles = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<ContractDuration> contractDurations = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<VacationDuration> vacationDurations = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Order> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(login, employee.login) &&
                Objects.equals(passwordHash, employee.passwordHash) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, passwordHash, name, surname, patronymic);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<EmployeeEmail> getEmployeeEmails() {
        return employeeEmails;
    }

    public void setEmployeeEmails(Set<EmployeeEmail> employeeEmails) {
        this.employeeEmails = employeeEmails;
    }

    public Set<EmployeePhoneNumber> getEmployeePhoneNumbers() {
        return employeePhoneNumbers;
    }

    public void setEmployeePhoneNumbers(Set<EmployeePhoneNumber> employeePhoneNumbers) {
        this.employeePhoneNumbers = employeePhoneNumbers;
    }

    public Set<EmployeeRole> getEmployeeRoles() {
        return employeeRoles;
    }

    public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
        this.employeeRoles = employeeRoles;
    }

    public Set<ContractDuration> getContractDurations() {
        return contractDurations;
    }

    public void setContractDurations(Set<ContractDuration> contractDurations) {
        this.contractDurations = contractDurations;
    }

    public Set<VacationDuration> getVacationDurations() {
        return vacationDurations;
    }

    public void setVacationDurations(Set<VacationDuration> vacationDurations) {
        this.vacationDurations = vacationDurations;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}


