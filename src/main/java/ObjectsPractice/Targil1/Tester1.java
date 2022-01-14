package ObjectsPractice.Targil1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester1 {
    public static String fileName="collage.txt";
    public static void main(String[] args) {
        College college=showMessage();
        sortByPen(college);
    }

    public static College showMessage(){
        Scanner scanner=new Scanner(System.in);
        College college;
        int option;
        do{
            System.out.println("Do you want to load collage from an existing file of create a new one?");
            System.out.println("1- load collage");
            System.out.println("2- create new collage");
            option=scanner.nextInt();
            switch (option){
                case 1:
                    return loadCollage();
                case 2:
                    return createNewCollage();
                default:
                    System.out.println("Invalid input");
            }
        }while (true);
    }

    public static College createNewCollage(){
        Scanner scanner = new Scanner(System.in);
        College college;
        String collegeName;
        int maxLecturers;

        System.out.println("Please enter college name");
        collegeName = scanner.next();
        System.out.println("Please enter number of lecturers in college");
        maxLecturers = scanner.nextInt();
        college = new College(collegeName, maxLecturers);
        System.out.println("Please enter number of lecturers you want to add");
        College.addLecturers(college, scanner.nextInt());
        System.out.println(college.toString());
        try {
            college.save(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return college;
    }

    public static College loadCollage(){
        College college=null;
        try {
            college=new College(fileName);
            System.out.println(college.toString());
            return college;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return college;
    }

    public static void sortByPen(College college){
        college.sortByPenFalls();
        System.out.println(college.toString());
    }
}
