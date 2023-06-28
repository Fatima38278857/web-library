package ru.skypro.lessons.springboot.weblibrary.pojo;

import java.util.List;

public interface EmployeeService { // Интерфейс с методами



    /**
     * Создает нового работника
     * @param employee - работника для создания
     */
    void addEmployee(Employee employee);

    /**
     * Возвращает список всех имеющихся работника
     */
    void editEmployee(Employee employee);


    /**
     * Возвращает работника по его ID
     * @param id - ID клиента
     * @return - объект работника  с заданным ID
     */
    Employee read(int id);



    /**
     * Удаляет работника заданным ID
     * @param id - id работника, которого нужно удалить
     * @return - true если работник был удален, иначе false
     */
    boolean delete(int id);

    List<Employee> getEmployeePassedParameter(int salary);


}
