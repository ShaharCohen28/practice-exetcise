package ObjectsPractice.Targil2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Guest {
    private String name;
    private int passport;

    public Guest(String name, int passport) {
        setName(name);
        setPassport(passport);
    }

    public Guest(Scanner scanner){
        this.name=scanner.next();
        this.passport=scanner.nextInt();
        scanner.nextLine();
    }

    public Guest(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.name=scanner.next();
        this.passport=scanner.nextInt();
        scanner.nextLine();
        scanner.close();
    }

    public void save(PrintWriter printWriter){
        printWriter.print(this.name + "\t");
        printWriter.print(this.passport + " \t");
        printWriter.println();
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter printWriter=new PrintWriter(fileName);
        save(printWriter);
        printWriter.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        if (passport > 0) {
            this.passport = passport;
        } else {
            this.passport = 0;
            System.out.println("Invalid passport");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Guest name: ");
        stringBuilder.append(this.name);
        stringBuilder.append(", passport: ");
        stringBuilder.append(this.passport);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
