package ru.itis.inf403.set403;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private int salary;
    private String company;


    public Employee(String name, int age, int salary, String company){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString(){
        return name + " | " + age + " y.o | "
                + salary + " $ | " + company;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return age == employee.age &&
               salary == employee.salary &&
               Objects.equals(name, employee.name) &&
               Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, salary, company);
    }
}
