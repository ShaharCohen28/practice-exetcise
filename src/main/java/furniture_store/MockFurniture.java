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
        int option=(int)(Math.random()*3);
        int length=(int)(Math.random()*(MAX_LENGTH-MIN_LENGTH))+MIN_LENGTH;
        int width=(int)(Math.random()*(MAX_WIDTH-MIN_WIDTH)+MIN_WIDTH);
        int height=(int)(Math.random()*(MAX_HEIGHT-MIN_HEIGHT))+MIN_HEIGHT;
        int color=(int)(Math.random()*colors.length);
        switch (option){
            case 0:
                furniture=new Chair(length,width,height,colors[color],
                        (int)(Math.random()*(MAX_LEGS-MIN_LEGS)+MIN_LEGS));
                break;
            case 1:
                furniture=new Table(length,width,height,colors[color],
                        (int)(Math.random()*(MAX_SEATS-MIN_SEATS))+MIN_SEATS);
                break;
            case 2:
                furniture=new Bed(length,width,height,colors[color],
                        ((int)(Math.random()*2))%2==0);
                break;
        }
        return furniture;
    }
}
