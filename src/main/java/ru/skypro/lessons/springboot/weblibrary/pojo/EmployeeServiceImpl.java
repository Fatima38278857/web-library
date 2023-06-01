package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

     public List<Employee> getAllEmployees() {
         return employeeRepository.getAllEmployees();
     }

        @Override
        public int getSumAllEmployee() {
            return employeeRepository.getSumAllEmployee();
        }

        @Override
        public Employee getEmployeeMinSalary() {
            return employeeRepository.getEmployeeMinSalary();
        }

        @Override
        public Employee getEmployeeMaxSalary() {
            return employeeRepository.getEmployeeMaxSalary();
        }
    }


