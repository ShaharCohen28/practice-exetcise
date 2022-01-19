package furniture_store;

public class TestFurniture {
    public static void main(String[] args) {
        final int NUM_OF_FURNITURE=20;
        Furniture[] furnitures=new Furniture[NUM_OF_FURNITURE];

        for (int index = 0; index < furnitures.length ; index++) {
            furnitures[index]=MockFurniture.createFurniture(furnitures[index]);
        }

        for (Furniture furniture :furnitures) {
            System.out.println(furniture);
            System.out.println(furniture.draw());
            if(furniture instanceof Chair){
                System.out.println("Number of legs: " + ((Chair) furniture).getNumberOfLegs());
            }
            if (furniture instanceof Table){
                System.out.println("Number of seats: " + ((Table) furniture).getNumberOfSeats());
            }
            if(furniture instanceof Bed){
                System.out.println(((Bed) furniture).isDoubleBed()?"Double bed":"Single bed");
            }
            System.out.println("----------------------------");
        }
    }
}
