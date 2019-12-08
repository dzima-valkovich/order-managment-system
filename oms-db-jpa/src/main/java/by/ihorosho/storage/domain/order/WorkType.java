package by.ihorosho.storage.domain.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "work_type")
public class WorkType {
    @Id
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_work_type",
            joinColumns = @JoinColumn(name = "fk_work_type_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_order_id", referencedColumnName = "id"))
    private Set<Order> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkType)) return false;
        WorkType workType = (WorkType) o;
        return Objects.equals(getId(), workType.getId()) &&
                Objects.equals(getType(), workType.getType()) &&
                Objects.equals(getDescription(), workType.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getDescription());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
