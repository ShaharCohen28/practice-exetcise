package furniture_store;

public class Table extends Furniture{
    private int numberOfSeats;

    public Table() {
        this((int)(Math.random()*(MockFurniture.MAX_LENGTH-MockFurniture.MIN_LENGTH))+MockFurniture.MIN_LENGTH,
                (int)(Math.random()*(MockFurniture.MAX_WIDTH-MockFurniture.MIN_WIDTH)+MockFurniture.MIN_WIDTH),
                (int)(Math.random()*(MockFurniture.MAX_HEIGHT-MockFurniture.MIN_HEIGHT))+MockFurniture.MIN_HEIGHT,
                MockFurniture.colors[ (int)(Math.random()*MockFurniture.colors.length)],
                (int)(Math.random()*(MockFurniture.MAX_SEATS-MockFurniture.MIN_SEATS)+MockFurniture.MIN_SEATS));
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
