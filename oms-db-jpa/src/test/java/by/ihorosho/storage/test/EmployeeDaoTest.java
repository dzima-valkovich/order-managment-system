package by.ihorosho.storage.test;

import by.ihorosho.storage.daos.EmployeeDao;
import by.ihorosho.storage.domain.employee.Employee;
import by.ihorosho.storage.domain.employee.EmployeePhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:data.access.config.test.xml")
public class EmployeeDaoTest extends EmployeeDao {
    private static final String TESTER_STR = "TESTER";
    private static final String LOGIN = "test_login_1";
    private static final String PASSWORD_HASH = "test_hash_1";
    private static final String NAME = "test_name_1";
    private static final String SURNAME = "test_surname_1";
    private static final String PATRONYMIC = "test_patronymic_1";

    private static Employee CONTROL_EMPLOYEE;

    static {
        CONTROL_EMPLOYEE = new Employee();
        CONTROL_EMPLOYEE.setLogin(LOGIN);
        CONTROL_EMPLOYEE.setPasswordHash(PASSWORD_HASH);
        CONTROL_EMPLOYEE.setName(NAME);
        CONTROL_EMPLOYEE.setSurname(SURNAME);
        CONTROL_EMPLOYEE.setPatronymic(PATRONYMIC);
    }

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testSaveAndGetByIdAndDeleteById() {
        int size1 = employeeService.getAll().size();
        employeeService.save(CONTROL_EMPLOYEE);
        int size2 = employeeService.getAll().size();
        Assertions.assertEquals(size1 + 1, size2);

        Employee e = employeeService.getById(CONTROL_EMPLOYEE.getId());
        Assertions.assertEquals(e, CONTROL_EMPLOYEE);

        Boolean isDeleted = employeeService.deleteById(e.getId());
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(size1, size2 - 1);
    }

    @Test
    void testUpdate() {
        CONTROL_EMPLOYEE.setId(null);
        employeeService.save(CONTROL_EMPLOYEE);
        CONTROL_EMPLOYEE.setLogin(TESTER_STR);
        CONTROL_EMPLOYEE = employeeService.update(CONTROL_EMPLOYEE);

        Assertions.assertEquals(CONTROL_EMPLOYEE.getLogin(), TESTER_STR);
        employeeService.deleteById(CONTROL_EMPLOYEE.getId());
    }

    @Service("employeeService")
    static class EmployeeService {
        @Autowired
        private EmployeeDao employeeDao;

        @Transactional
        public List<Employee> getAll() {
            return employeeDao.getAll();
        }

        @Transactional
        public Employee getById(Long id) {
            return employeeDao.getById(id);
        }

        @Transactional
        public Employee save(Employee employee) {
            return employeeDao.save(employee);
        }

        @Transactional
        public Employee update(Employee employee) {
            return employeeDao.update(employee);
        }

        @Transactional
        public Boolean deleteById(Long id) {
            return employeeDao.deleteById(id);
        }
    }
}
