package threads.practice;

public class TestSpeedy {
    public static void main(String[] args) {
        Speedy speedy1=new Speedy("speedy1",null);
        Speedy speedy2=new Speedy("speedy2", speedy1);
        speedy1.setEnemy(speedy2);
        Speedy loser;

        Thread speedyTread1=new Thread(speedy1);
        Thread speedyTread2=new Thread(speedy2);

        speedyTread1.start();
        speedyTread2.start();

        try {
            speedyTread1.join();
            speedyTread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(speedy1);
        System.out.println(speedy2);
        loser=Speedy.theLoser(speedy1,speedy2);
        System.out.println("The loser is:\n"+loser);
    }
}
