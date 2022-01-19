package furniture_store;

import java.util.Random;

public class MockFurniture {
    private static String[] colors={"black","white","blue","red","yellow",
            "green","orange","pink","grey","violet"};
    public static Furniture createFurniture(Furniture furniture){
        int option=(int)(Math.random()*3);
        int length=(int)(Math.random()*100)+50;
        int width=(int)(Math.random()*50+50);
        int height=(int)(Math.random()*100)+100;
        int color=(int)(Math.random()*colors.length);
        switch (option){
            case 0:
                furniture=new Chair(length,width,height,colors[color],
                        (int)(Math.random()*1+3));
                break;
            case 1:
                furniture=new Table(length,width,height,colors[color],
                        (int)(Math.random()*9)+1);
                break;
            case 2:
                furniture=new Bed(length,width,height,colors[color],
                        ((int)(Math.random()*9)+1)%2==0);
                break;
        }
        return furniture;
    }
}
