package exercise;

import java.util.Objects;

public class Secretary extends Employee{
    protected String office;
    public Secretary(String name, double salary, String office) {
        super(name, salary);
        this.office=office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Secretary{" + super.toString() +
                "office='" + office + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Secretary)) return false;
        if (!super.equals(o)) return false;
        Secretary secretary = (Secretary) o;
        return getOffice().equals(secretary.getOffice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOffice());
    }
}
