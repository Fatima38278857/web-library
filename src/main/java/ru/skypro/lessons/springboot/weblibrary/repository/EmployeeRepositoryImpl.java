package ru.skypro.lessons.springboot.weblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrary.pojo.Employee;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SuppressWarnings("ConstantConditions")
@Repository // мы вешаем аннотацию Repository, чтобы Spring впоследствии внедрил его в EmployeeServiceImp.
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee(1, "Катя", 90_000),
            new Employee(2, "Дима", 102_000),
            new Employee(3, "Олег", 80_000),
            new Employee(4, "Вика", 165_000));



    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }


    @Override
    public Employee read(int id) { // чтение по id
        return employeeList.stream()
                .filter(x -> x.getId() == id)
                .findAny().get();
    }

    @Override
    public void editEmployee( Employee employee) { // редоктирование
        employeeList.stream().map(e -> {
                            e.setName(employee.getName());
                            e.setSalary(employee.getSalary());
                            return e;
                        }
                )
                .collect(Collectors.toList());

    }
    @Override
    public boolean delete(int id) { // удоление
        return employeeList.remove(id) != null;
    }

    @Override
    public List<Employee> getEmployeePassedParameter(int salary) {
        return employeeList.stream()
                .filter(x -> x.getSalary() > salary)
                .collect(Collectors.toList());

    }
}

