package by.ihorosho.storage.domain.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Set<OrderAddress> orderAddresses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getId(), city.getId()) &&
                Objects.equals(getCityName(), city.getCityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCityName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<OrderAddress> getOrderAddresses() {
        return orderAddresses;
    }

    public void setOrderAddresses(Set<OrderAddress> orderAddresses) {
        this.orderAddresses = orderAddresses;
    }
}
