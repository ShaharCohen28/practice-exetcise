package ObjectsPractice.Targil1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class College {
    private String name;
    private int numOfLecturers;
    private Lecturer[] allLecturers;

    public College(){}

    public College(String name, int maxLecturers) {
        setName(name);
        allLecturers = new Lecturer[maxLecturers];
        numOfLecturers = 0;
    }

    public College(Scanner scanner){
        this.name=scanner.next();
        this.allLecturers=new Lecturer[scanner.nextInt()];
        this.numOfLecturers=scanner.nextInt();
        for (int index = 0; index <this.numOfLecturers ; index++) {
            allLecturers[index]=new Lecturer(scanner);
        }
    }

    public College(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.name=scanner.next();
        this.allLecturers=new Lecturer[scanner.nextInt()];
        this.numOfLecturers=scanner.nextInt();
        for (int index = 0; index <this.numOfLecturers ; index++) {
            allLecturers[index]=new Lecturer(scanner);
        }
        scanner.close();
    }

    public void save(PrintWriter printWriter){
        printWriter.println(this.name);
        printWriter.println(allLecturers.length);
        printWriter.println(this.numOfLecturers);
        for (int index = 0; index < numOfLecturers ; index++) {
            allLecturers[index].save(printWriter);
        }
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

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getMaxLecturers() {
        return allLecturers.length;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (numOfLecturers == allLecturers.length) {
            return false;
        }
        allLecturers[numOfLecturers] = lecturer;
        numOfLecturers++;
        return true;
    }

    public void sortByPenFalls() {
        Lecturer temp;
        for (int i = 0; i < numOfLecturers; i++) {
            for (int j = 0; j < numOfLecturers - i - 1; j++) {
                if (allLecturers[j].getNumOfTimesPenFalls() > allLecturers[j + 1].getNumOfTimesPenFalls()) {
                    temp = allLecturers[j + 1];
                    allLecturers[j + 1] = allLecturers[j];
                    allLecturers[j] = temp;
                }
            }
        }
    }

    public static void addLecturers(College college, int times) {
        Scanner scanner = new Scanner(System.in);
        String lecturerName, lecturerFavoriteIceCream;
        int penFalls;

        for (int counter = 0; counter < times; counter++) {
            System.out.println("Enter the name of lecturer number " + (counter + 1));
            lecturerName = scanner.next();
            System.out.println("Enter the number of times his pen fell");
            penFalls = scanner.nextInt();
            System.out.println("Enter his favorite ice cream name");
            lecturerFavoriteIceCream = scanner.next();
            if (college.addLecturer(new Lecturer(lecturerName, penFalls, lecturerFavoriteIceCream))) {
                System.out.println("Lecturer successfully added");
            } else {
                System.out.println("No more place for another lecturer");
                break;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Collage name: ");
        stringBuilder.append(this.name);
        stringBuilder.append("number of lecturers: ");
        stringBuilder.append(this.numOfLecturers);
        stringBuilder.append("\nLecturers:\n");
        stringBuilder.append(Arrays.toString(this.allLecturers));
        return stringBuilder.toString();
    }
}
