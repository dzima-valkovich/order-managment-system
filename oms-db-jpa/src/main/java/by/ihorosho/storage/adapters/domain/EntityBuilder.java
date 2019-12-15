package by.ihorosho.storage.adapters.domain;

import by.ihorosho.api.storage.domain.employee.*;
import by.ihorosho.api.storage.domain.order.*;
import by.ihorosho.storage.adapters.domain.employee.*;
import by.ihorosho.storage.adapters.domain.order.*;

public class EntityBuilder {
    public static IContractDuration buildContractDuration() {
        return new ContractDurationAdapter();
    }

    public static IEmployee buildEmployee() {
        return new EmployeeAdapter();
    }

    public static IEmployeeEmail buildEmployeeEmail() {
        return new EmployeeEmailAdapter();
    }

    public static IEmployeePhoneNumber buildEmployeePhoneNumber() {
        return new EmployeePhoneNumberAdapter();
    }

    public static IEmployeeRole buildEmployeeRole() {
        return new EmployeeRoleAdapter();
    }

    public static IVacationDuration buildVacationDuration() {
        return new VacationDurationAdapter();
    }

    public static ICity buildCity() {
        return new CityAdapter();
    }

    public static ICustomer buildCustomer() {
        return new CustomerAdapter();
    }

    public static IOrder buildOrder() {
        return new OrderAdapter();
    }

    public static IOrderAddress buildOrderAddress() {
        return new OrderAddressAdapter();
    }

    public static IWorkType buildWorkType() {
        return new WorkTypeAdapter();
    }
}
