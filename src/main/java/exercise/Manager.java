package exercise;

import java.util.Objects;

public class Manager extends Employee implements Managerable {
    protected String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(", department= ");
        stringBuilder.append(this.department);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return getDepartment().equals(manager.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDepartment());
    }
}
