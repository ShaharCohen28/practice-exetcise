package exercise;

import java.util.Objects;

public class Director extends Manager{
    private String group;

    public Director(String name, double salary, String department, String group) {
        super(name, salary, department);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("group='");
        stringBuilder.append(this.group);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return getGroup().equals(director.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGroup());
    }
}
