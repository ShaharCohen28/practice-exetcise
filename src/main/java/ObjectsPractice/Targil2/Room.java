package ObjectsPractice.Targil2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Room {
    private int numOfBeds;
    private int numOfGuests;
    private Guest[] allGuests;

    public Room(int numOfBeds) {
        setNumOfBeds(numOfBeds);
        allGuests = new Guest[numOfBeds];
        numOfGuests = 0;
    }

    public Room(Scanner scanner){
        this.numOfBeds=scanner.nextInt();
        this.allGuests=new Guest[this.numOfBeds];
        this.numOfGuests=scanner.nextInt();
        for (int index = 0; index <this.numOfGuests ; index++) {
            this.allGuests[index]=new Guest(scanner);
        }
    }

    public Room(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.numOfBeds=scanner.nextInt();
        this.allGuests=new Guest[this.numOfBeds];
        this.numOfGuests=scanner.nextInt();
        for (int index = 0; index <this.numOfGuests ; index++) {
            this.allGuests[index]=new Guest(scanner);
        }
        scanner.close();
    }

    public void save(PrintWriter printWriter){
        printWriter.println(this.numOfBeds);
        printWriter.println(this.numOfGuests);
        for (int index = 0; index <this.numOfGuests ; index++) {
            this.allGuests[index].save(printWriter);
        }
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter printWriter=new PrintWriter(fileName);
        save(printWriter);
        printWriter.close();
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public boolean addGuest(Guest guest) {
        if (numOfGuests == allGuests.length) {
            return false;
        }
        allGuests[numOfGuests] = guest;
        numOfGuests++;
        return true;
    }

    public boolean findGuest(int passport) {
        for (int guestNumber = 0; guestNumber < numOfGuests; guestNumber++) {
            if (passport == allGuests[guestNumber].getPassport()) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return numOfGuests == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("number of beds: ");
        stringBuilder.append(this.numOfBeds);
        stringBuilder.append(", number of guests: ");
        stringBuilder.append(this.numOfGuests);
        stringBuilder.append("\nall guests:\n");
        stringBuilder.append(Arrays.toString(allGuests));
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}
