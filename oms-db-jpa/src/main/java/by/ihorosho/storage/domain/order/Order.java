package by.ihorosho.storage.domain.order;

import by.ihorosho.storage.domain.employee.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "planned_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedStartDate;
    @Column(name = "fact_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date factStartDate;
    @Column(name = "planned_finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedFinishDate;
    @Column(name = "fact_finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date factFinishDate;
    @Column(name = "termination_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", nullable = false)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_order_address_id", nullable = false)
    private OrderAddress orderAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer_id", nullable = false)
    private Customer customer;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private Set<WorkType> workTypes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getOrderDate(), order.getOrderDate()) &&
                Objects.equals(getPlannedStartDate(), order.getPlannedStartDate()) &&
                Objects.equals(getFactStartDate(), order.getFactStartDate()) &&
                Objects.equals(getPlannedFinishDate(), order.getPlannedFinishDate()) &&
                Objects.equals(getFactFinishDate(), order.getFactFinishDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrderDate(), getPlannedStartDate(), getFactStartDate(), getPlannedFinishDate(), getFactFinishDate());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getFactStartDate() {
        return factStartDate;
    }

    public void setFactStartDate(Date factStartDate) {
        this.factStartDate = factStartDate;
    }

    public Date getPlannedFinishDate() {
        return plannedFinishDate;
    }

    public void setPlannedFinishDate(Date plannedFinishDate) {
        this.plannedFinishDate = plannedFinishDate;
    }

    public Date getFactFinishDate() {
        return factFinishDate;
    }

    public void setFactFinishDate(Date factFinishDate) {
        this.factFinishDate = factFinishDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<WorkType> getWorkTypes() {
        return workTypes;
    }

    public void setWorkTypes(Set<WorkType> workTypes) {
        this.workTypes = workTypes;
    }
}
