package ObjectsPractice.Targil2;

import java.util.Scanner;

public class Tester2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel((int) (Math.random() * 9) + 1, (int) (Math.random() * 99) + 1);
        char option;
        int result;
        boolean isContinue = true;

        do {
            showMessage();
            option = scanner.next().charAt(0);
            switch (option) {
                case '1':
                    addGuestsToRoom(hotel);
                    break;
                case '2':
                    System.out.println("Please enter passport number");
                    result = hotel.searchGuest(scanner.nextInt());
                    System.out.println(result == -1 ? "Guest not found" : "Guest found in room number " + result);
                    break;
                case '3':
                    System.out.println(hotel.toString());
                    break;
                case '4':
                    System.out.println("The most vacant floor is floor number " + hotel.mostVacantFloor());
                    break;
                default:
                    isContinue = false;
            }
        } while (isContinue);
    }

    public static void showMessage() {
        System.out.println("Please choose between the next options:");
        System.out.println("1 - add guests to the hotel");
        System.out.println("2 - search a guest in the hotel");
        System.out.println("3 - show hotel details");
        System.out.println("4 - show which floor has the most vacant rooms");
        System.out.println("to finish, enter anything else");
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
        result = hotel.addGuestsToRoom(newGuests);
        if (result == -1) {
            System.out.println("No more rooms left in the hotel");
        } else if (result == -2) {
            System.out.println("No room was found for the requirements");
        } else {
            System.out.println("Guests added successfully to room number " + result);
        }
    }
}
