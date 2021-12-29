package ObjectsPractice.Targil1;

public class Lecturer {
    private String name;
    private int numOfTimesPenFalls;
    private String favoriteIceCream;

    public Lecturer(String name, int numOfTimesPenFalls, String favoriteIceCream) {
        setName(name);
        setNumOfTimesPenFalls(numOfTimesPenFalls);
        setFavoriteIceCream(favoriteIceCream);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfTimesPenFalls() {
        return numOfTimesPenFalls;
    }

    public void setNumOfTimesPenFalls(int numOfTimesPenFalls) {
        if (numOfTimesPenFalls > 0) {
            this.numOfTimesPenFalls = numOfTimesPenFalls;
        } else {
            this.numOfTimesPenFalls = 0;
        }
    }

    public String getFavoriteIceCream() {
        return favoriteIceCream;
    }

    public void setFavoriteIceCream(String favoriteIceCream) {
        this.favoriteIceCream = favoriteIceCream;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", numOfTimesPenFalls=" + numOfTimesPenFalls +
                ", favoriteIceCream='" + favoriteIceCream + '\'' +
                "}\n";
    }
}
