package api_exam_practice.birthdays.facades;

import api_exam_practice.birthdays.beans.Person;
import api_exam_practice.birthdays.dao.Remindable;
import api_exam_practice.birthdays.threads.BirthdayTask;
import com.mysql.cj.x.protobuf.MysqlxExpr;

import java.util.*;

public class BirthdaySystemReminder implements Remindable {
    private static Set<Person> people;
    private BirthdayTask task;
    private static Scanner scanner=new Scanner(System.in);

    public BirthdaySystemReminder() {
        people = new HashSet<>();
        people.add(new Person(2,2,2022));
        this.task = new BirthdayTask(people);
        Thread thread=new Thread(this.task);
        thread.start();
        startSystem();
    }

    public static Set<Person> getPeople() {
        return people;
    }

    @Override
    public void showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MENU\nchoose an option\n");
        stringBuilder.append("1- add person\n");
        stringBuilder.append("2- delete person\n");
        stringBuilder.append("3- print all people\n");
        stringBuilder.append("4- print num of friends\n");
        stringBuilder.append("5- happy month\n");
        stringBuilder.append("6- sad Month\n");
        stringBuilder.append("7- print events\n");
        stringBuilder.append("8- end system\n");
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void startSystem() {
        int choice;
        do{
            showMenu();
            choice= scanner.nextInt();
            switch (choice){
                case 1:
                    addPerson(new Person());
                    break;
                case 2:
                    System.out.println("enter id to delete");
                    deletePerson(scanner.nextInt());
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    System.out.println("number of friends: " +BirthdayStatistics.countMembers());
                    break;
                case 5:
                    System.out.println("happy month: "+BirthdayStatistics.getHappyMonth());
                    break;
                case 6:
                    System.out.println("sad month: "+BirthdayStatistics.getSadMonth());
                    break;
                case 7:
                    for(Map.Entry<Integer,Integer> item: BirthdayStatistics.getEvents().entrySet()) {
                        System.out.println("month: "+ item.getKey() + "\tevents: " +item.getValue());
                    }
                    break;
                case 8:
                    endSystem();
                    break;
                default:
                    System.out.println("invalid input, tru again");
            }
        }while (choice!=8);
    }

    @Override
    public void endSystem() {
        System.out.println("shutting down");
        this.task.stopRunning();
        System.exit(0);
    }

    @Override
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public void deletePerson(int id) {
        for(Person item:people){
            if(item.getId()==id){
                people.remove(item);
                break;
            }
        }
    }

    @Override
    public void printAll() {
        for (Person item:people){
            System.out.println(item);
        }
    }

    private List<Person> set2List(){
        List<Person> peopleList=new ArrayList<>();
        peopleList.addAll(people);
        return peopleList;
    }
}
