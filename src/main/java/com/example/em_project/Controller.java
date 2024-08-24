package com.example.em_project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Object getEmployeeById(@PathVariable Long id){
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployees(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);

    }
    @DeleteMapping("employees")
    public String deleteEmployees() {
        if (employeeService.deleteEmployees())
            return "Deleted Successfully";
        return "Not Found";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id))
            return "Deleted Successfully";
        return "Not Found";
   }
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
}
