package ru.itis.inf403.set403;

import ru.itis.inf403.set403.Set.SetExample;




public class Main {
    public static void main(String[] args) {

        SetExample<Employee> names = new SetExample<>();

        Employee emp1 = new Employee("Vanya", 18, 10, "ooo rai");
        Employee emp2 = new Employee("Sanek", 18, 5, "boss of mafia");
        Employee emp3 = new Employee("Sanek", 18, 5, "boss of mafia");

        names.add(emp1);
        names.add(emp2);
        names.add(emp3);

        names.print();


    }
}
