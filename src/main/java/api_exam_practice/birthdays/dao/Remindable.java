package api_exam_practice.birthdays.dao;

import api_exam_practice.birthdays.beans.Person;

public interface Remindable {

    void showMenu();
    void startSystem();
    void endSystem();
    void addPerson(Person person);
    void deletePerson(int id);
    void printAll();
}
