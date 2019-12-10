package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.api.storage.domain.employee.IVacationDuration;
import by.ihorosho.storage.domain.employee.VacationDuration;

import java.util.Date;

public class VacationDurationAdapter implements IVacationDuration {
    private VacationDuration vacationDuration;

    public VacationDurationAdapter(VacationDuration vacationDuration) {
        this.vacationDuration = vacationDuration;
    }

    @Override
    public Long getId() {
        return vacationDuration.getId();
    }

    @Override
    public void setId(Long id) {
        vacationDuration.setId(id);
    }

    @Override
    public Date getStartDate() {
        return vacationDuration.getStartDate();
    }

    @Override
    public void setStartDate(Date startDate) {
        vacationDuration.setStartDate(startDate);
    }

    @Override
    public Date getFinishDate() {
        return vacationDuration.getFinishDate();
    }

    @Override
    public void setFinishDate(Date finishDate) {
        vacationDuration.setFinishDate(finishDate);
    }

    @Override
    public IEmployee getEmployee() {
        return new EmployeeAdapter(vacationDuration.getEmployee());
    }

    @Override
    public void setEmployee(IEmployee employee) {
        vacationDuration.setEmployee(((EmployeeAdapter) employee).getEmployee());
    }

    public VacationDuration getVacationDuration() {
        return vacationDuration;
    }

    public void setVacationDuration(VacationDuration vacationDuration) {
        this.vacationDuration = vacationDuration;
    }
}
