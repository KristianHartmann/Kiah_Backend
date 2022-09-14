package DTO;

import Entity.Dat3.Employee;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDTO {
    private Long id;
    private String name;
    private String address;
    private int salary;


    public static List<EmployeeDTO> getDtos(List<Employee> employee) {
        List<EmployeeDTO> employeedtos = new ArrayList();
        employee.forEach(employees -> employeedtos.add(new EmployeeDTO(employees)));
        return employeedtos;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public EmployeeDTO(Employee employee) {
        if (employee.getId() >= 0)
            this.id = employee.getId();
        this.name = employee.getName();
        this.salary = employee.getSalary();
        this.address = employee.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}



