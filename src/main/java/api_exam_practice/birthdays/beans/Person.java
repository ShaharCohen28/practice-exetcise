package api_exam_practice.birthdays.beans;

import api_exam_practice.birthdays.utils.DateFactory;
import api_exam_practice.birthdays.utils.DateUtil;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person>{
    private int id;
    private String name;
    private LocalDate birthday;
    private static int counter=1;

    public Person(){
        this.id=counter++;
        this.name="Person " +this.id;
        setBirthday(DateFactory.getLocalDate());
    }

    public Person(int day, int month, int year){
        this.id=counter++;
        this.name="Person " +this.id;
        setBirthday(LocalDate.of(year, month, day));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Person other) {
        /*
        if(other.getBirthday().isBefore(this.getBirthday())){
            return -1;
        }else if(other.getBirthday().isAfter(this.getBirthday())){
            return 1;
        }else{
            return 0;
        }

         */
        long thisDay=this.birthday.toEpochDay();
        long otherDay=other.getBirthday().toEpochDay();
        return Long.compare(thisDay,otherDay);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + DateUtil.BeautifyDate(this.birthday) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() && Objects.equals(getName(), person.getName()) && Objects.equals(getBirthday(), person.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirthday());
    }
}
