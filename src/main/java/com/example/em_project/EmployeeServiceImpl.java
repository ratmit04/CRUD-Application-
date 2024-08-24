package com.example.em_project;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public Object readEmployee(Long id) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()){
            return "Employee not found";
        }
        EmployeeEntity employeeEntity= optionalEmployee.get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList=employeeRepository.findAll();
        List<Employee> employees= new ArrayList<>() ;
           for(EmployeeEntity employeeEntity:employeeList){
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
//        Optional<Employee> removedEmployee = Optional.of(employees.remove(id));
//        boolean present = removedEmployee.isPresent();
//        return present;
        EmployeeEntity emp= employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public boolean deleteEmployees() {
        List<EmployeeEntity> employeeList=employeeRepository.findAll();
//        List<Employee> employees= new ArrayList<>() ;
//        for(EmployeeEntity employeeEntity:employeeList){
//            Employee emp = new Employee();
//            emp.setId(employeeEntity.getId());
//            emp.setName(employeeEntity.getName());
//            emp.setEmail(employeeEntity.getEmail());
//            emp.setPhone(employeeEntity.getPhone());
//
//            employees.remove(id);
//        }

            employeeRepository.deleteAll();

        return true;
    }


    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee=employeeRepository.findById(id).get();

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);

        return "Updated Successfully";

    }
}

