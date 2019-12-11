package by.ihorosho.storage.test;

import by.ihorosho.api.storage.daos.IEmployeeDao;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IEmployeeEmail;
import by.ihorosho.storage.adapters.domain.employee.EmployeeAdapter;
import by.ihorosho.storage.adapters.domain.employee.EmployeeEmailAdapter;
import by.ihorosho.storage.daos.EmployeeDao;
import by.ihorosho.storage.domain.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:data.access.config.test.xml")
public class EmployeeAdapterTest {
    private static final String TESTER_STR = "TESTER";
    private static final String LOGIN = "test_login_1";
    private static final String PASSWORD_HASH = "test_hash_1";
    private static final String NAME = "test_name_1";
    private static final String SURNAME = "test_surname_1";
    private static final String PATRONYMIC = "test_patronymic_1";

    private static Employee CONTROL_EMPLOYEE;
    private static IEmployee CONTROL_IEMPLOYEE;

    static {
        CONTROL_EMPLOYEE = new Employee();
        CONTROL_EMPLOYEE.setLogin(LOGIN);
        CONTROL_EMPLOYEE.setPasswordHash(PASSWORD_HASH);
        CONTROL_EMPLOYEE.setName(NAME);
        CONTROL_EMPLOYEE.setSurname(SURNAME);
        CONTROL_EMPLOYEE.setPatronymic(PATRONYMIC);
        CONTROL_IEMPLOYEE = new EmployeeAdapter(CONTROL_EMPLOYEE);
    }

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testSaveAndGetByIdAndDeleteById() {
        int size1 = employeeService.getAll().size();
        employeeService.save(CONTROL_IEMPLOYEE);
        int size2 = employeeService.getAll().size();
        Assertions.assertEquals(size1 + 1, size2);

        IEmployee e = employeeService.getById(CONTROL_IEMPLOYEE.getId());
        Assertions.assertEquals(e, CONTROL_IEMPLOYEE);

        Boolean isDeleted = employeeService.deleteById(e.getId());
        Assertions.assertTrue(isDeleted);
        Assertions.assertEquals(size1, size2 - 1);
    }

    @Test
    void testUpdate() {
        CONTROL_IEMPLOYEE.setId(null);
        employeeService.save(CONTROL_IEMPLOYEE);
        CONTROL_IEMPLOYEE.setLogin(TESTER_STR);
        CONTROL_IEMPLOYEE = employeeService.update(CONTROL_IEMPLOYEE);

        Assertions.assertEquals(CONTROL_IEMPLOYEE.getLogin(), TESTER_STR);
        employeeService.deleteById(CONTROL_IEMPLOYEE.getId());
    }

//    @Test
//    void test() {
//        employeeService.test(1L);
//    }

    @Service("employeeServiceWithAdapter")
    static class EmployeeService {
        @Autowired
        private IEmployeeDao employeeDao;

        @Transactional
        public List<IEmployee> getAll() {
            return employeeDao.getAll();
        }

        @Transactional
        public IEmployee getById(Long id) {
            return employeeDao.getById(id);
        }

        @Transactional
        public IEmployee save(IEmployee employee) {
            return employeeDao.save(employee);
        }

        @Transactional
        public IEmployee update(IEmployee employee) {
            return employeeDao.update(employee);
        }

        @Transactional
        public Boolean deleteById(Long id) {
            return employeeDao.deleteById(id);
        }


//        @Transactional
//        public void test(Long id) {
//            IEmployee e = employeeDao.getById(id);
//
//            EmployeeEmailAdapter asd = new EmployeeEmailAdapter();
//            asd.setEmail("TEST");
//            asd.setEnableSending(true);
//            asd.setEmployee(e);
//
//            Object a = e.getEmployeeRoles();
//            Set<IEmployeeEmail> set = e.getEmployeeEmails();
//            set.add(asd);
//            e.setEmployeeEmails(set);
//            employeeDao.update(e);
//            Object b = e.getEmployeeEmails();
//            Object c = e.getEmployeePhoneNumbers();
//        }
    }
}
