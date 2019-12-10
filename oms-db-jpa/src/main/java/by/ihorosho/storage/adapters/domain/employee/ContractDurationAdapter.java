package by.ihorosho.storage.adapters.domain.employee;

import by.ihorosho.api.storage.domain.employee.IContractDuration;
import by.ihorosho.api.storage.domain.employee.IEmployee;
import by.ihorosho.storage.domain.employee.ContractDuration;

import java.util.Date;

public class ContractDurationAdapter implements IContractDuration {
    private ContractDuration contractDuration;

    public ContractDurationAdapter(ContractDuration contractDuration) {
        this.contractDuration = contractDuration;
    }

    @Override
    public Date getStartDate() {
        return contractDuration.getStartDate();
    }

    @Override
    public void setStartDate(Date startDate) {
        contractDuration.setStartDate(startDate);
    }

    @Override
    public Date getFinishDate() {
        return contractDuration.getFinishDate();
    }

    @Override
    public void setFinishDate(Date finishDate) {
        contractDuration.setFinishDate(finishDate);
    }

    @Override
    public Date getTerminationDate() {
        return contractDuration.getTerminationDate();
    }

    @Override
    public void setTerminationDate(Date terminationDate) {
        contractDuration.setTerminationDate(terminationDate);
    }

    @Override
    public IEmployee getEmployee() {
        return new EmployeeAdapter(contractDuration.getEmployee());
    }

    @Override
    public void setEmployee(IEmployee employee) {
        contractDuration.setEmployee(((EmployeeAdapter) employee).getEmployee());
    }

    @Override
    public Long getId() {
        return contractDuration.getId();
    }

    @Override
    public void setId(Long aLong) {
        contractDuration.setId(aLong);
    }

    public ContractDuration getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(ContractDuration contractDuration) {
        this.contractDuration = contractDuration;
    }
}
