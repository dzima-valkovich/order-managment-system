package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeRole;
import by.ihorosho.storage.domain.employee.EmployeeRole;

import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRoleAdapter implements IEmployeeRole {
    private EmployeeRole employeeRole;

    public EmployeeRoleAdapter() {
        this.employeeRole = new EmployeeRole();
    }

    public EmployeeRoleAdapter(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRoleAdapter)) return false;
        EmployeeRoleAdapter that = (EmployeeRoleAdapter) o;
        return Objects.equals(getEmployeeRole(), that.getEmployeeRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeRole());
    }

    @Override
    public String getRole() {
        return employeeRole.getRole();
    }

    @Override
    public void setRole(String role) {
        employeeRole.setRole(role);
    }

    @Override
    public String getDescription() {
        return employeeRole.getDescription();
    }

    @Override
    public void setDescription(String description) {
        employeeRole.setDescription(description);
    }

    @Override
    public List<IEmployee> getEmployees() {
        return employeeRole.getEmployees().stream().map(EmployeeAdapter::new).collect(Collectors.toList());
    }

    @Override
    public void setEmployees(List<IEmployee> employees) {
        employeeRole.setEmployees(employees.stream()
                .map(e -> ((EmployeeAdapter) e).getEmployee()).collect(Collectors.toSet()));
    }

    @Override
    public boolean addEmployee(IEmployee employee) {
        return employeeRole.getEmployees().add(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public boolean removeEmployee(IEmployee employee) {
        return employeeRole.getEmployees().remove(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public Long getId() {
        return employeeRole.getId();
    }

    @Override
    public void setId(Long aLong) {
        employeeRole.setId(aLong);
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
