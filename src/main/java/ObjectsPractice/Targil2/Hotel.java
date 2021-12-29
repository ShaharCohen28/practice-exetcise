package ObjectsPractice.Targil2;

import java.util.Arrays;

public class Hotel {
    private int numOfUsedRooms;
    private Room[][] allRooms;

    public Hotel(int floors, int numOfRooms) {
        allRooms = new Room[floors][numOfRooms];
        for (int floorNumber = 0; floorNumber < floors; floorNumber++) {
            for (int roomNumber = 0; roomNumber < numOfRooms; roomNumber++) {
                allRooms[floorNumber][roomNumber] = new Room((int) (Math.random() * 3) + 1);
            }
        }
        numOfUsedRooms = 0;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "numOfUsedRooms=" + numOfUsedRooms +
                ", allRooms=" + Arrays.toString(allRooms) +
                '}';
    }
}
