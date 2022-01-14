package ObjectsPractice.Targil2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester2 {
    public static String fileName="hotel.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        char option;
        int result;
        boolean isContinue = true;

        do{
            System.out.println("Please choose between the following options:");
            System.out.println("1- create new hotel");
            System.out.println("2- load existing hotel");
            option=scanner.next().charAt(0);
            switch (option){
                case '1':
                    hotel=createHotel();
                    isContinue=false;
                    break;
                case '2':
                    hotel=loadHotel();
                    isContinue=false;
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }while(isContinue);

        isContinue=true;

        do {
            showMessage();
            option = scanner.next().charAt(0);
            switch (option) {
                case '1':
                    Hotel.addGuestsToRoom(hotel);
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

        try {
            hotel.save(fileName);
            System.out.println("Hotel info was saved");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showMessage() {
        System.out.println("Please choose between the next options:");
        System.out.println("1 - add guests to the hotel");
        System.out.println("2 - search a guest in the hotel");
        System.out.println("3 - show hotel details");
        System.out.println("4 - show which floor has the most vacant rooms");
        System.out.println("to finish, enter anything else");
    }

    public static Hotel loadHotel(){
        Hotel hotel;
        try {
            Scanner scanner=new Scanner(new File(fileName));
            hotel=new Hotel(scanner);
            scanner.close();
            return hotel;
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("loading failed, creating new hotel");
            hotel=createHotel();
        }
        return null;
    }

    public static Hotel createHotel() {
        return new Hotel((int) (Math.random() * 9) + 1, (int) (Math.random() * 99) + 1);
    }
}
