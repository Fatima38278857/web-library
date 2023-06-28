package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.repository.EmployeeRepository;

import java.util.List;

@Service // Аннотация, которая сообщает Spring, что этот класс представляет собой сервис, содержащий бизнес-логику
          /* Она указывает Spring, что нужно взять этот класс на контроль,
             создать его объект и подложить объект туда, где его запросят.
             Также эта аннотация говорит другим разработчикам, что этот объект является держателем бизнес-логики.  */

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;


    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void editEmployee( Employee employee) {
        employeeRepository.editEmployee(employee);
    }


    @Override
    public Employee read(int id) {
        return employeeRepository.read(id);
    }


    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);

    }

    @Override
    public List<Employee> getEmployeePassedParameter(int salary) {
        return employeeRepository.getEmployeePassedParameter(salary);
    }

    }



