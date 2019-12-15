package by.ihorosho.api.services.dto;

import java.util.List;

public class EmployeeDto {
    private Long id;
    private String login;
    private String passwordHash;
    private String name;
    private String surname;
    private String patronymic;
    private List<EmployeeEmailDto> employeeEmails;
    private List<EmployeePhoneNumberDto> employeePhoneNumbers;

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

    public List<EmployeeEmailDto> getEmployeeEmails() {
        return employeeEmails;
    }

    public void setEmployeeEmails(List<EmployeeEmailDto> employeeEmails) {
        this.employeeEmails = employeeEmails;
    }

    public List<EmployeePhoneNumberDto> getEmployeePhoneNumbers() {
        return employeePhoneNumbers;
    }

    public void setEmployeePhoneNumbers(List<EmployeePhoneNumberDto> employeePhoneNumbers) {
        this.employeePhoneNumbers = employeePhoneNumbers;
    }
}
