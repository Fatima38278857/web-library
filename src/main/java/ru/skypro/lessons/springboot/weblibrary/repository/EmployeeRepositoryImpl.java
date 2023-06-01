package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList.stream().filter(x -> x.getSalary() >= (employeeList.stream()
                        .mapToInt(Employee::getSalary).sum()) / employeeList.size())
                .collect(Collectors.toList());
    }

    @Override
    public int getSumAllEmployee() {
        return employeeList.stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Employee getEmployeeMinSalary() {
        return employeeList.stream().reduce((a, b) -> a.getSalary() < b.getSalary() ? a : b).get();
    }

    @Override
    public Employee getEmployeeMaxSalary() {
        return employeeList.stream().reduce((a, b) -> a.getSalary() > b.getSalary() ? a : b).get();
    }

    }

