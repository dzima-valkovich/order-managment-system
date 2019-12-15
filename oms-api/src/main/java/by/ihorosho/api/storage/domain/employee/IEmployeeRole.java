package by.ihorosho.api.storage.domain.employee;

import by.ihorosho.api.storage.domain.IEntity;

import java.util.List;

public interface IEmployeeRole extends IEntity<Long> {

    String getRole();

    void setRole(String role);

    String getDescription();

    void setDescription(String description);

    List<IEmployee> getEmployees();

    void setEmployees(List<IEmployee> employees);

    boolean addEmployee(IEmployee employee);

    boolean removeEmployee(IEmployee employee);
}
