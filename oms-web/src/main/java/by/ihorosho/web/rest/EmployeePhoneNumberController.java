package by.ihorosho.web.rest;

import by.ihorosho.api.services.IEmployeePhoneNumberService;
import by.ihorosho.api.services.dto.EmployeePhoneNumberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees/phones")
public class EmployeePhoneNumberController {
    private IEmployeePhoneNumberService employeePhoneNumberService;

    @PutMapping()
    public Long update(@RequestBody EmployeePhoneNumberDto employeePhoneNumberDto) {
        return employeePhoneNumberService.update(employeePhoneNumberDto);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Long id) {
        return employeePhoneNumberService.deleteById(id);
    }

    @Autowired
    public void setEmployeePhoneNumberService(IEmployeePhoneNumberService employeePhoneNumberService) {
        this.employeePhoneNumberService = employeePhoneNumberService;
    }
}
