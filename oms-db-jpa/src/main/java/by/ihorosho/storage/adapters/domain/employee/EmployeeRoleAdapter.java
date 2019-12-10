package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeRole;
import by.ihorosho.storage.domain.employee.EmployeeRole;

import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRoleAdapter implements IEmployeeRole {
    private EmployeeRole employeeRole;

    public EmployeeRoleAdapter(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
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
    public Set<IEmployee> getEmployees() {
        return employeeRole.getEmployees().stream().map(EmployeeAdapter::new).collect(Collectors.toSet());
    }

    @Override
    public void setEmployees(Set<IEmployee> employees) {
        employeeRole.setEmployees(employees.stream()
                .map(e -> ((EmployeeAdapter) e).getEmployee()).collect(Collectors.toSet()));
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
