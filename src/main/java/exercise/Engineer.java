package exercise;

import java.util.Objects;

public class Engineer extends Employee{
    private String specialty;

    public Engineer(String name, double salary, String specialty) {
        super(name, salary);
        this.specialty=specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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
        stringBuilder.append(super.toString());
        stringBuilder.append("specialty='");
        stringBuilder.append(this.specialty);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engineer)) return false;
        if (!super.equals(o)) return false;
        Engineer engineer = (Engineer) o;
        return getSpecialty().equals(engineer.getSpecialty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecialty());
    }
}
