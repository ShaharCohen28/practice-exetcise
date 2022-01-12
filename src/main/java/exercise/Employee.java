package exercise;

import java.text.DecimalFormat;
import java.util.Objects;

public class Employee {
    protected String name;
    protected double salary;
    public final static int MINIMUM_SALARY=5_000;

    private static final String pattern="###,###.00";
    private static final DecimalFormat decimalFormat = new DecimalFormat(pattern);

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

    public static void printAll(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static String printAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
            count++;
        }
        return decimalFormat.format(sum / employees.length);
    }

    public static String printManagementAverageSalary(Employee[] employees) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                sum += employee.getSalary();
                count++;
            }
        }
        try {
            return decimalFormat.format(sum/count);
        } catch (ArithmeticException err) {
            return "No managers";
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("name= ");
        stringBuilder.append(this.name);
        stringBuilder.append(", salary= ");
        stringBuilder.append(this.salary);
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
