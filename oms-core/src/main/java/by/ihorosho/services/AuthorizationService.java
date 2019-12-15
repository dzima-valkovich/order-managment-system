package by.ihorosho.services;

import by.ihorosho.api.services.IAuthorizationService;
import by.ihorosho.api.services.dto.AuthorizationDto;
import by.ihorosho.api.storage.daos.IEmployeeDao;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.utils.ICryptographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("authorizationService")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AuthorizationService implements IAuthorizationService {
    private ICryptographer cryptographer;
    private IEmployeeDao employeeDao;

    private Map<String, Long> tokenStorage;

    public AuthorizationService() {
        tokenStorage = new HashMap<>();
    }

    @Autowired
    public void setCryptographer(ICryptographer cryptographer) {
        this.cryptographer = cryptographer;
    }

    @Autowired
    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Boolean isExist(String login) {
        IEmployee employee = employeeDao.getByLogin(login);
        return employee != null;
    }

    @Override
    public Long isAuthorized(String token) {
        return tokenStorage.get(token);
    }

    @Override
    public String logIn(AuthorizationDto authorizationDto) throws IllegalAccessException {
        IEmployee employee = employeeDao.getByLogin(authorizationDto.getLogin());
        if (employee == null) {
            throw new IllegalAccessException("Employee does not exist!");
        }
        if (!employee.getPasswordHash().equals(authorizationDto.getPasswordHash())) {
            throw new IllegalAccessException("Wrong password!");
        }

        String token = cryptographer.encode(employee.getLogin(), employee.getPasswordHash());
        tokenStorage.put(token, employee.getId());
        return token;
    }

    @Override
    public void logOut(String token) {
        tokenStorage.remove(token);
    }
}
