package filesPractice.targil_phone;

import java.io.FileNotFoundException;

public class Tester {
    public static void main(String[] args) {
        PhoneBook phoneBook=new PhoneBook("Shahar", 4), newPhoneBook;
        phoneBook.add(new Phone("0548304700", "Shahar"));
        phoneBook.add(new Phone("0548028813", "Meni"));
        phoneBook.add(new Phone("0548028814", "Nina"));
        String fileName = "phones.txt";
        //PrintWriter printWriter;
        //Scanner scanner;

        try {
            //printWriter = new PrintWriter("phones.txt");
            phoneBook.save(fileName);
            //printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //scanner = new Scanner(new File("phones.txt"));
            newPhoneBook=new PhoneBook(fileName);
            //scanner.close();
            System.out.println(newPhoneBook.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}
