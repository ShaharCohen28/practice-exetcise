package ObjectsPractice.Targil2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Hotel {
    private int numOfUsedRooms;
    private Room[][] allRooms;

    public Hotel(){}

    public Hotel(int floors, int numOfRooms) {
        allRooms = new Room[floors][numOfRooms];
        for (int floorNumber = 0; floorNumber < floors; floorNumber++) {
            for (int roomNumber = 0; roomNumber < numOfRooms; roomNumber++) {
                allRooms[floorNumber][roomNumber] = new Room((int) (Math.random() * 3) + 1);
            }
        }
        numOfUsedRooms = 0;
    }

    public Hotel(Scanner scanner){
        this.allRooms=new Room[scanner.nextInt()][scanner.nextInt()];
        this.numOfUsedRooms=scanner.nextInt();
        for (int floorNumber = 0; floorNumber < this.allRooms.length; floorNumber++) {
            for (int roomNumber = 0; roomNumber < this.allRooms[0].length; roomNumber++) {
                allRooms[floorNumber][roomNumber] = new Room(scanner);
            }
        }
    }

    public Hotel(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.allRooms=new Room[scanner.nextInt()][scanner.nextInt()];
        this.numOfUsedRooms=scanner.nextInt();
        for (int floorNumber = 0; floorNumber < this.allRooms.length; floorNumber++) {
            for (int roomNumber = 0; roomNumber < this.allRooms[0].length; roomNumber++) {
                allRooms[floorNumber][roomNumber] = new Room(scanner);
            }
        }
        scanner.close();
    }

    public void save(PrintWriter printWriter) {
        printWriter.println(this.allRooms.length);
        printWriter.println(this.allRooms[0].length);
        printWriter.println(this.numOfUsedRooms);
        for (int floorNumber = 0; floorNumber < this.allRooms.length; floorNumber++) {
            for (int roomNumber = 0; roomNumber < this.allRooms[0].length; roomNumber++) {
                allRooms[floorNumber][roomNumber].save(printWriter);
            }
        }
    }

    public void save(String fileName) throws FileNotFoundException {
        PrintWriter printWriter=new PrintWriter(fileName);
        save(printWriter);
        printWriter.close();
    }

    public int addGuestsToRoom(Guest[] guests) {
        int floor = 0, room = 0;
        boolean roomFound = false;
        if (numOfUsedRooms == allRooms.length * allRooms[0].length) {
            //System.out.println("No more rooms left in the hotel");
            return -1;
        }
        for (int floorNumber = 0; floorNumber < allRooms.length; floorNumber++) {
            for (int roomNumber = 0; roomNumber < allRooms[0].length; roomNumber++) {
                if (allRooms[floorNumber][roomNumber].isEmpty() &&
                        (guests.length <= allRooms[floorNumber][roomNumber].getNumOfBeds())) {
                    floor = floorNumber;
                    room = roomNumber;
                    roomFound = true;
                    break;
                }
            }
            if (roomFound) {
                break;
            }
        }
        if (roomFound) {
            for (Guest guest : guests) {
                if (allRooms[floor][room].addGuest(guest)) {
                    //System.out.println("Guest added successfully");
                }
            }
            numOfUsedRooms++;
            return (floor * 100 + room);
        } else {
            //System.out.println("No room was found for the requirements");
            return -2;
        }
    }

    public int searchGuest(int passport) {
        for (int floor = 0; floor < allRooms.length; floor++) {
            for (int room = 0; room < allRooms[0].length; room++) {
                if (allRooms[floor][room].findGuest(passport)) {
                    return (floor * 100 + room);
                }
            }
        }
        return -1;
    }

    public int mostVacantFloor() {
        int maxFloor = 0, maxEmpty = Integer.MIN_VALUE, countEmpty;
        for (int floor = 0; floor < allRooms.length; floor++) {
            countEmpty = 0;
            for (int room = 0; room < allRooms[0].length; room++) {
                if (allRooms[floor][room].isEmpty()) {
                    countEmpty++;
                }
            }
            if (countEmpty > maxEmpty) {
                maxEmpty = countEmpty;
                maxFloor = floor;
            }
        }
        return maxFloor;
    }

    public static void addGuestsToRoom(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        Guest[] newGuests;
        String name;
        int passport, result;

        System.out.println("Please enter number of guests");
        newGuests = new Guest[scanner.nextInt()];

        for (int guestNumber = 0; guestNumber < newGuests.length; guestNumber++) {
            System.out.println("Please enter name of guest number " + (guestNumber + 1));
            name = scanner.next();
            System.out.println("PLease enter guest passport");
            passport = scanner.nextInt();
            newGuests[guestNumber] = new Guest(name, passport);
        }
        result =hotel.addGuestsToRoom(newGuests);
        if (result == -1) {
            System.out.println("No more rooms left in the hotel");
        } else if (result == -2) {
            System.out.println("No room was found for the requirements");
        } else {
            System.out.println("Guests added successfully to room number " + result);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("number of floors: ");
        stringBuilder.append(this.allRooms.length);
        stringBuilder.append("\nnumber of room at each floor: ");
        stringBuilder.append(this.allRooms[0].length);
        stringBuilder.append("\n");
        stringBuilder.append("number of used rooms: ");
        stringBuilder.append(this.numOfUsedRooms);
        stringBuilder.append("\n");
        for (int floor = 0; floor < this.allRooms.length; floor++) {
            for (int room = 0; room < this.allRooms[0].length; room++) {
                stringBuilder.append("room number ");
                stringBuilder.append(floor * 100 + room);
                if (this.allRooms[floor][room].isEmpty()) {
                    stringBuilder.append(this.allRooms[floor][room].getNumOfBeds());
                    stringBuilder.append(" is empty\n");
                } else {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.allRooms[floor][room].toString());
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
