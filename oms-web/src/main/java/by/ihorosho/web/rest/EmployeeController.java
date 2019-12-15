package by.ihorosho.web.rest;

import by.ihorosho.api.services.IEmployeeService;
import by.ihorosho.api.services.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private IEmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAll(@RequestParam(defaultValue = "0") Integer offset,
                                    @RequestParam(defaultValue = "10") Integer limit) {
        return employeeService.getAll(offset, limit);
    }

    @GetMapping("{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @Autowired
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
