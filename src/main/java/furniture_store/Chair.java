package furniture_store;

public class Chair extends Furniture{
    private int numberOfLegs;

  /*  public Chair() {
        this(MockFurniture.randomLength(),
                MockFurniture.randomWidth(),
                MockFurniture.randomHeight(),
                MockFurniture.randomColor(),
                MockFurniture.randomNumOfLegs());
    }
    \
   */

    public Chair(int length, int width, int height, String color, int numberOfLegs) {
        super(length, width, height, color);
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Chair:\n").append(super.toString());
        stringBuilder.append("Number of legs: ").append(this.numberOfLegs).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  i_______i\n");
        stringBuilder.append("  I_______I\n");
        stringBuilder.append("  I       I\n");
        stringBuilder.append("  I_______I\n");
        stringBuilder.append(" /       /I\n");
        stringBuilder.append("(______(  I\n");
        stringBuilder.append("I  I    I I\n");
        stringBuilder.append("I       I\n");
        return stringBuilder.toString();
    }
}
