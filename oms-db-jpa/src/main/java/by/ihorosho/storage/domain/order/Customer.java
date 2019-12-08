package by.ihorosho.storage.domain.order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<OrderAddress> orderAddresses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getSurname(), customer.getSurname()) &&
                Objects.equals(getPatronymic(), customer.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoneNumber(), getEmail(), getName(), getSurname(), getPatronymic());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<OrderAddress> getOrderAddresses() {
        return orderAddresses;
    }

    public void setOrderAddresses(Set<OrderAddress> orderAddresses) {
        this.orderAddresses = orderAddresses;
    }
}
