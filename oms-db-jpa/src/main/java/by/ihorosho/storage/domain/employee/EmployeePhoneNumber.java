package by.ihorosho.storage.domain.employee;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_phone_number")
public class EmployeePhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "enable_telegram_sending")
    private Boolean enableTelegramSending;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", nullable = false)
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePhoneNumber)) return false;
        EmployeePhoneNumber that = (EmployeePhoneNumber) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getEnableTelegramSending(), that.getEnableTelegramSending());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getEnableTelegramSending());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getEnableTelegramSending() {
        return enableTelegramSending;
    }

    public void setEnableTelegramSending(Boolean enableTelegramSending) {
        this.enableTelegramSending = enableTelegramSending;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
