package by.ihorosho.storage.domain.employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_email")
public class EmployeeEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "enable_sending")
    private Boolean enableSending;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", nullable = false)
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEmail)) return false;
        EmployeeEmail that = (EmployeeEmail) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getEnableSending(), that.getEnableSending());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getEnableSending());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnableSending() {
        return enableSending;
    }

    public void setEnableSending(Boolean enableSending) {
        this.enableSending = enableSending;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
