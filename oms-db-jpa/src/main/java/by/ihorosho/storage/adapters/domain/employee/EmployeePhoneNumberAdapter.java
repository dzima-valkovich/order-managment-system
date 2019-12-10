package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeePhoneNumber;
import by.ihorosho.storage.domain.employee.EmployeePhoneNumber;

public class EmployeePhoneNumberAdapter implements IEmployeePhoneNumber {
    private EmployeePhoneNumber employeePhoneNumber;

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
