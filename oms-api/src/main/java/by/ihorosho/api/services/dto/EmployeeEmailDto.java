package by.ihorosho.api.services.dto;

public class EmployeeEmailDto {
    private Long id;
    private String email;
    private Boolean enableSending;

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
}
