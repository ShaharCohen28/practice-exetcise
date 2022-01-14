package ObjectsPractice.Targil2;

import java.util.Arrays;

public class Room {
    private int numOfBeds;
    private int numOfGuests;
    private Guest[] allGuests;

    public Room(int numOfBeds) {
        setNumOfBeds(numOfBeds);
        allGuests = new Guest[numOfBeds];
        numOfGuests = 0;
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
