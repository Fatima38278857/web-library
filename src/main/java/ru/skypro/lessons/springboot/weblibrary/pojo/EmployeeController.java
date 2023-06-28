package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Это  специальный тип контроллера, который автоматически преобразует данные в JSON-формат
        /* Эта аннотация говорит Spring:
        что отмеченный класс — бин и его надо внедрить в свой алгоритм работы;
        что Spring нужно маршрутизировать запросы к приложению именно на метод этого класса;
        что этот класс возвращает не веб-страницу (для возврата веб-страницы нужна аннотация @Controller,
        а какой-то объект или строку, которую и нужно отобразить пользователю.
        Если метод этого контроллера возвращает строку, то пользователь увидит эту строку в ответе от сервера.
        Если метод возвращает объект, то Spring конвертирует его в формате JSON.
        указывает, что данный класс является
        контроллером, и все методы внутри этого класса должны возвращать данные
        в виде JSON или XML.
         */
@RequestMapping("/employee") //  Определяет, какой URL будет обрабатываться этим контроллером.

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PutMapping (value = "/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    @GetMapping(value = "/employee {id}")
    public ResponseEntity<Employee> read(@PathVariable(name = "id") int id) {
        final Employee employee = employeeService.read(id);

        return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping ("/employee")
    public void editEmployee(@RequestBody Employee employee) {
        employeeService.editEmployee(employee);
    }

    @DeleteMapping(value = "/employee /{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = employeeService.delete(id);

        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/salary/")
    public List<Employee>getEmployeePassedParameter(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeePassedParameter(salary);
    }


}




