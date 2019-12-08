package by.ihorosho.storage.domain.employee;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_duration")
public class ContractDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "finish_date")
    @Temporal(TemporalType.DATE)
    private Date finishDate;
    @Column(name = "termination_date")
    @Temporal(TemporalType.DATE)
    private Date terminationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", nullable = false)
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDuration)) return false;
        ContractDuration that = (ContractDuration) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getFinishDate(), that.getFinishDate()) &&
                Objects.equals(getTerminationDate(), that.getTerminationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getFinishDate(), getTerminationDate());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
