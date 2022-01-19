package furniture_store;

public class Table extends Furniture{
    private int numberOfSeats;

    public Table() {
        this(MockFurniture.randomLength(),
                MockFurniture.randomWidth(),
                MockFurniture.randomHeight(),
                MockFurniture.randomColor(),
                MockFurniture.randomNumOfSeats());
    }

    public Table(int length, int width, int height, String color, int numberOfSeats) {
        super(length, width, height, color);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Table:\n").append(super.toString());
        stringBuilder.append("Number of seats: ").append(this.numberOfSeats).append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   =====================\n");
        stringBuilder.append("  /                   /\n");
        stringBuilder.append(" /                   /|\n");
        stringBuilder.append("===================== |\n");
        stringBuilder.append(" | |               |  |\n");
        stringBuilder.append(" | |               |  |\n");
        stringBuilder.append(" | |               |  |\n");
        stringBuilder.append(" |                 |\n");
        stringBuilder.append(" |                 |\n");
        stringBuilder.append(" |                 |\n");
        return stringBuilder.toString();
    }
}
