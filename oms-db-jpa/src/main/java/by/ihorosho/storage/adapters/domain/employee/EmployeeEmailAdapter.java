package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.storage.domain.employee.EmployeeEmail;

import java.util.Objects;

public class EmployeeEmailAdapter implements IEmployeeEmail {
    private EmployeeEmail employeeEmail;

    public EmployeeEmailAdapter() {
        employeeEmail = new EmployeeEmail();
    }

    public EmployeeEmailAdapter(EmployeeEmail employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEmailAdapter)) return false;
        EmployeeEmailAdapter that = (EmployeeEmailAdapter) o;
        return Objects.equals(getEmployeeEmail(), that.getEmployeeEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeEmail());
    }

    @Override
    public String getEmail() {
        return employeeEmail.getEmail();
    }

    @Override
    public void setEmail(String email) {
        employeeEmail.setEmail(email);
    }

    @Override
    public Boolean getEnableSending() {
        return employeeEmail.getEnableSending();
    }

    @Override
    public void setEnableSending(Boolean enableSending) {
        employeeEmail.setEnableSending(enableSending);
    }

    @Override
    public IEmployee getEmployee() {
        return new EmployeeAdapter(employeeEmail.getEmployee());
    }

    @Override
    public void setEmployee(IEmployee employee) {
        employeeEmail.setEmployee(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public Long getId() {
        return employeeEmail.getId();
    }

    @Override
    public void setId(Long aLong) {
        employeeEmail.setId(aLong);
    }

    public EmployeeEmail getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(EmployeeEmail employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
