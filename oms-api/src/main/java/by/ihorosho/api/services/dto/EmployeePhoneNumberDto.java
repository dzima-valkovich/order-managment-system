package by.ihorosho.api.services.dto;


public class EmployeePhoneNumberDto {
    private Long id;
    private String phoneNumber;
    private Boolean enableTelegramSending;

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
}
