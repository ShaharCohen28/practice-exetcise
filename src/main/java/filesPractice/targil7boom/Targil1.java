package filesPractice.targil7boom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Targil1 {
    public static void main(String[] args) {
        try {
            sevenBoom("sevenBoom.txt", 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void sevenBoom(String fileName, int number) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(fileName));
        boolean isBoom;
        int temp;
        for (int counter = 1; counter <= number; counter++) {
            isBoom = false;
            temp = counter;
            while (temp > 0) {
                if (temp % 10 == 7) {
                    isBoom = true;
                    break;
                }
                temp /= 10;
            }
            if (isBoom || counter % 7 == 0) {
                pw.println("BOOM");
            } else {
                pw.println(counter);
            }
        }
        pw.close();
    }
}
