package by.ihorosho.storage.domain.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_address")
public class OrderAddress {
    @Id
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "address_region")
    private String addressRegion;
    @Column(name = "address_postalcode")
    private String addressPostalcode;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_city_id", nullable = false)
    private City city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderAddress")
    private Set<Order> orders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderAddress)) return false;
        OrderAddress that = (OrderAddress) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getAddressRegion(), that.getAddressRegion()) &&
                Objects.equals(getAddressPostalcode(), that.getAddressPostalcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getAddressRegion(), getAddressPostalcode());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddressPostalcode() {
        return addressPostalcode;
    }

    public void setAddressPostalcode(String addressPostalcode) {
        this.addressPostalcode = addressPostalcode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
