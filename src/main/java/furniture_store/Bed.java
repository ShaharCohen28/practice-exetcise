package furniture_store;

public class Bed extends Furniture{
    private boolean isDoubleBed;

    public Bed() {
        this((int)(Math.random()*(MockFurniture.MAX_LENGTH-MockFurniture.MIN_LENGTH))+MockFurniture.MIN_LENGTH,
                (int)(Math.random()*(MockFurniture.MAX_WIDTH-MockFurniture.MIN_WIDTH)+MockFurniture.MIN_WIDTH),
                (int)(Math.random()*(MockFurniture.MAX_HEIGHT-MockFurniture.MIN_HEIGHT))+MockFurniture.MIN_HEIGHT,
                MockFurniture.colors[ (int)(Math.random()*MockFurniture.colors.length)],
                ((int)(Math.random()*2))%2==0);
    }

    public Bed(int length, int width, int height, String color, boolean isDoubleBed) {
        super(length, width, height, color);
        this.isDoubleBed=isDoubleBed;
    }

    public boolean isDoubleBed() {
        return isDoubleBed;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Bed:\n").append(super.toString());
        stringBuilder.append("The bed is ").append(this.isDoubleBed?"double bed":"single bed").append("\n");
        return stringBuilder.toString();
    }

    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ||\n");
        stringBuilder.append("   ||                  ||\n");
        stringBuilder.append("||/||____              ||\n");
        stringBuilder.append("|| /     )__________||_/|\n");
        stringBuilder.append("||/_____/_/_/_/_/_/_/||/|\n");
        stringBuilder.append("||(___)/_/_/_/_/_/__||  |\n");
        stringBuilder.append("||     |_|_|_|_|_|__|| /|\n");
        stringBuilder.append("||     |_|_|_|_|_|__||/||\n");
        stringBuilder.append("||~~~~~~~~~~~~~~~~~~||\n");
        stringBuilder.append("||                  ||\n");
        return stringBuilder.toString();
    }
}
