package exercise;

import java.util.Objects;

public class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void printAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
            count++;
        }
        System.out.println("The average salary is " + sum / count);
    }

    public static void printManagementAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                sum += employee.getSalary();
                count++;
            }
        }
        try {
            System.out.println("The average management salary is " + sum / count);
        } catch (ArithmeticException err) {
            System.out.println("No managers");
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("name= ' " + this.name + "' ,  salary= ' " + this.salary + "' ");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 && getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary());
    }
}
