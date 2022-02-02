package api_exam_practice.birthdays.threads;

import api_exam_practice.birthdays.beans.Person;

import java.time.LocalDate;
import java.util.Set;

public class BirthdayTask implements Runnable {
    private Set<Person> people;
    private boolean isRunning;

    public BirthdayTask(Set<Person> people) {
        this.people = people;
        this.isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                for (Person item : people) {
                    if (item.getBirthday().getMonthValue() == LocalDate.now().getMonthValue() &&
                            item.getBirthday().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
                        System.out.println("Happy birthday " + item.getName());
                    }
                    System.out.println("going to sleep");
                    Thread.sleep(1000 * 60 );
                    System.out.println("awake");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning() {
        this.isRunning = false;
    }
}
