package filesPractice.targil_phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {
    private String owner;
    private Phone[] phones;
    private int numberContacts;

    public PhoneBook(String owner, int maxContacts){
        this.owner=owner;
        this.phones=new Phone[maxContacts];
        this.numberContacts=0;
    }

    public PhoneBook(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.owner=scanner.nextLine();
        this.phones=new Phone[scanner.nextInt()];
        this.numberContacts=scanner.nextInt();
        for (int index = 0; index <this.numberContacts ; index++) {
            this.phones[index]=new Phone(scanner);
        }
        scanner.close();
    }

    public void add(Phone phone){
        if(this.numberContacts==this.phones.length){
            System.out.println("Max contacts reached");
            return;
        }
        this.phones[numberContacts]=phone;
        numberContacts++;
        System.out.println("Contact added successfully");
    }

    public void save(String filename) throws FileNotFoundException {
        PrintWriter printWriter=new PrintWriter(new File(filename));
        printWriter.println(this.owner);
        printWriter.println(this.phones.length);
        printWriter.println(this.numberContacts);
        for (int index = 0; index <this.numberContacts ; index++) {
            this.phones[index].save(printWriter);
        }
        printWriter.close();
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "owner='" + owner + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", numberContacts=" + numberContacts +
                '}';
    }
}
