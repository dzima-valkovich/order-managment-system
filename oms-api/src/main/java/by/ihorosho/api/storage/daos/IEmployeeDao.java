package by.ihorosho.api.storage.daos;

import by.ihorosho.api.storage.domain.employee.IEmployee;

public interface IEmployeeDao extends IOmsCrudDao<IEmployee, Long> {

    IEmployee getByLogin(String login);
}
