package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.storage.domain.employee.EmployeePhoneNumber;

import java.util.Objects;

public class EmployeePhoneNumberAdapter implements IEmployeePhoneNumber {
    private EmployeePhoneNumber employeePhoneNumber;

    public EmployeePhoneNumberAdapter() {
        this.employeePhoneNumber = new EmployeePhoneNumber();
    }

    public EmployeePhoneNumberAdapter(EmployeePhoneNumber employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return employeePhoneNumber.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        employeePhoneNumber.setPhoneNumber(phoneNumber);
    }

    @Override
    public Boolean getEnableTelegramSending() {
        return employeePhoneNumber.getEnableTelegramSending();
    }

    @Override
    public void setEnableTelegramSending(Boolean enableTelegramSending) {
        employeePhoneNumber.setEnableTelegramSending(enableTelegramSending);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePhoneNumberAdapter)) return false;
        EmployeePhoneNumberAdapter that = (EmployeePhoneNumberAdapter) o;
        return Objects.equals(getEmployeePhoneNumber(), that.getEmployeePhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeePhoneNumber());
    }

    @Override
    public IEmployee getEmployee() {
        return new EmployeeAdapter(employeePhoneNumber.getEmployee());
    }

    @Override
    public void setEmployee(IEmployee employee) {
        employeePhoneNumber.setEmployee(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public Long getId() {
        return employeePhoneNumber.getId();
    }

    @Override
    public void setId(Long aLong) {
        employeePhoneNumber.setId(aLong);
    }

    public EmployeePhoneNumber getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(EmployeePhoneNumber employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }
}
