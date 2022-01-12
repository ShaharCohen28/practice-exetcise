package filesPractice.targil_phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Phone {
    private String lineNumber;
    private String owner;
    private int lastPay;
    //private Scanner scanner;
    //private boolean hasScanner=false;

    public Phone(String lineNumber, String owner) {
        this.lineNumber = lineNumber;
        this.owner = owner;
        this.lastPay =-1;
    }

    public Phone(Scanner scanner){
        this.lineNumber=scanner.next();
        this.owner=scanner.next();
        this.lastPay=scanner.nextInt();
        scanner.nextLine();
    }

    public Phone(String fileName){
        Scanner scanner=new Scanner(fileName);
        this.lineNumber=scanner.next();
        this.owner=scanner.next();
        this.lastPay=scanner.nextInt();
        scanner.nextLine();
        scanner.close();
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void save(PrintWriter pw){
        pw.print(this.lineNumber +"\t");
        pw.print(this.owner+"\t");
        pw.print(this.lastPay);
        pw.print("\t\n");
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw=new PrintWriter(new File(fileName));
        this.save(pw);
        pw.close();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "lineNumber='" + lineNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", lastPay=" + lastPay +
                '}';
    }
}
