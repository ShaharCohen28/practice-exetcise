package furniture_store;

import java.util.Random;

public class MockFurniture {
    public static final int MAX_LENGTH=150;
    public static final int MIN_LENGTH=50;
    public static final int MAX_WIDTH=100;
    public static final int MIN_WIDTH=50;
    public static final int MAX_HEIGHT=200;
    public static final int MIN_HEIGHT=100;
    public static final int MAX_LEGS=4;
    public static final int MIN_LEGS=3;
    public static final int MAX_SEATS=10;
    public static final int MIN_SEATS=1;
    public static final String[] colors={"black","white","blue","red","yellow",
            "green","orange","pink","grey","violet"};

    public static Furniture createFurniture(Furniture furniture){
        int option=(int)(Math.random()*3)+1;
        int length=randomLength();
        int width=randomWidth();
        int height=randomHeight();
        String color=randomColor();
        switch (option){
            case 1:
                furniture=new Chair(length,width,height,color,randomNumOfLegs());
                break;
            case 2:
                furniture=new Table(length,width,height,color,randomNumOfSeats());

                break;
            case 3:
                furniture=new Bed(length,width,height,color,randomIsDoubleBed());
                break;
        }
        return furniture;
    }

    public static int randomLength(){
        return (int)(Math.random()*(MAX_LENGTH-MIN_LENGTH))+MIN_LENGTH;
    }

    public static int randomWidth(){
        return (int)(Math.random()*(MAX_WIDTH-MIN_WIDTH)+MIN_WIDTH);
    }

    public static int randomHeight(){
        return (int)(Math.random()*(MAX_HEIGHT-MIN_HEIGHT))+MIN_HEIGHT;
    }

    public static String randomColor(){
        return colors[(int)(Math.random()*colors.length)];
    }

    public static int randomNumOfLegs(){
        return (int)(Math.random()*(MAX_LEGS-MIN_LEGS)+MIN_LEGS);
    }

    public static int randomNumOfSeats(){
        return (int)(Math.random()*(MAX_SEATS-MIN_SEATS))+MIN_SEATS;
    }

    public static boolean randomIsDoubleBed(){
        return new Random().nextBoolean();
    }
}
