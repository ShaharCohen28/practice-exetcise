package ObjectsPractice.Targil1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecturer {
    private String name;
    private int numOfTimesPenFalls;
    private String favoriteIceCream;
    private int id;
    private static int idGenerator=1000;

    public Lecturer(String name, int numOfTimesPenFalls, String favoriteIceCream) {
        setName(name);
        setNumOfTimesPenFalls(numOfTimesPenFalls);
        setFavoriteIceCream(favoriteIceCream);
        this.id=idGenerator++;
    }

    public Lecturer(Scanner scanner){
        this.name=scanner.next();
        this.numOfTimesPenFalls=scanner.nextInt();
        scanner.nextLine();
        this.favoriteIceCream=scanner.next();
        this.id=scanner.nextInt();
    }

    public Lecturer(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new File(fileName));
        this.name=scanner.next();
        this.numOfTimesPenFalls=scanner.nextInt();
        scanner.nextLine();
        this.favoriteIceCream=scanner.next();
        this.id=scanner.nextInt();
        scanner.close();
    }

    public void save(PrintWriter printWriter){
        printWriter.println(this.name);
        printWriter.println(this.numOfTimesPenFalls);
        printWriter.println(this.favoriteIceCream);
        printWriter.println(this.id);
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

    public int getNumOfTimesPenFalls() {
        return numOfTimesPenFalls;
    }

    public void setNumOfTimesPenFalls(int numOfTimesPenFalls) {
        if (numOfTimesPenFalls > 0) {
            this.numOfTimesPenFalls = numOfTimesPenFalls;
        } else {
            this.numOfTimesPenFalls = 0;
        }
    }

    public String getFavoriteIceCream() {
        return favoriteIceCream;
    }

    public void setFavoriteIceCream(String favoriteIceCream) {
        this.favoriteIceCream = favoriteIceCream;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Lecturer name: ");
        stringBuilder.append(this.name);
        stringBuilder.append(", id: ");
        stringBuilder.append(this.id);
        stringBuilder.append(", number of times he dropped the pen: ");
        stringBuilder.append(this.numOfTimesPenFalls);
        stringBuilder.append(", his favorite ice-cream: ");
        stringBuilder.append(this.favoriteIceCream);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
