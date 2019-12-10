package by.ihorosho.api.storage.domain.employee;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.Set;

public interface IEmployeeRole extends IEntity<Long> {

    String getRole();

    void setRole(String role);

    String getDescription();

    void setDescription(String description);

    Set<IEmployee> getEmployees();

    void setEmployees(Set<IEmployee> employees);
}
