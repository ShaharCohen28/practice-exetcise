package ObjectsPractice.Targil1;

import java.util.Scanner;

public class Tester1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        College college;
        String collegeName;
        int maxLecturers;

        System.out.println("Please enter college name");
        collegeName = scanner.next();
        System.out.println("Please enter number pf lecturers in college");
        maxLecturers = scanner.nextInt();
        college = new College(collegeName, maxLecturers);
        addLecturers(college, 3);
        System.out.println(college.toString());
        college.sortByPenFalls();
        System.out.println(college.toString());


    }

    public static void addLecturers(College college, int times) {
        Scanner scanner=new Scanner(System.in);
        String lecturerName, lecturerFavoriteIceCream;
        int penFalls;

        for (int counter = 0; counter <times ; counter++) {
            System.out.println("Enter the name of lecturer number " + (counter+1));
            lecturerName= scanner.next();
            System.out.println("Enter the number of times his pen fell");
            penFalls= scanner.nextInt();
            System.out.println("Enter his favorite ice cream name");
            lecturerFavoriteIceCream= scanner.next();
            if(college.addLecturer(new Lecturer(lecturerName,penFalls,lecturerFavoriteIceCream))){
                System.out.println("Lecturer successfully added");
            }else{
                System.out.println("No more place for another lecturer");
            }
        }
    }
}
