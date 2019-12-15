package by.ihorosho.storage.daos;

import by.ihorosho.storage.AbstractOmsCrudDao;
import by.ihorosho.storage.domain.employee.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository("employeeDao")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeDao extends AbstractOmsCrudDao<Employee, Long> {

    public EmployeeDao() {
        super.setClazz(Employee.class);
    }

    public Employee getByLogin(String login) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        return getEntityManager()
                .createQuery(query.where(criteriaBuilder.equal(root.get("login"), login)).select(root))
                .getSingleResult();
    }
}
