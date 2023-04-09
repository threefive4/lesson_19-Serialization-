package ua.lviv.lgs;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee("Pavlo", 45, 1500);

        FileOutputStream fileOut = new FileOutputStream("filename.ser");
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(employee);
        objOut.close();

        Employee employee1 = null;

        FileInputStream fileIn = new FileInputStream("filename.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        employee1 = (Employee) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(employee1.getName());
        System.out.println(employee1.getId());
        System.out.println(employee1.getSalary());

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maria", 2, 2000));
        employees.add(new Employee("Bob", 3, 3000));
        System.out.println(employees);
    }
}
