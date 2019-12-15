package by.ihorosho.web.rest;

import by.ihorosho.api.services.IEmployeeEmailService;
import by.ihorosho.api.services.dto.EmployeeEmailDto;
import by.ihorosho.storage.domain.employee.EmployeeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees/emails")
public class EmployeeEmailController {
    private IEmployeeEmailService employeeEmailService;

    @PutMapping
    public Long update(@RequestBody EmployeeEmailDto dto) {
        return employeeEmailService.update(dto);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Long id) {
        return employeeEmailService.deleteById(id);
    }

    @Autowired
    public void setEmployeeEmailService(IEmployeeEmailService employeeEmailService) {
        this.employeeEmailService = employeeEmailService;
    }
}
