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
            furniture.draw();
        }
    }
}
