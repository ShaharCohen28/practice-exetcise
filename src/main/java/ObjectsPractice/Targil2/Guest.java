package ObjectsPractice.Targil2;

public class Guest {
    private String name;
    private int passport;

    public Guest(String name, int passport) {
        setName(name);
        setPassport(passport);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        if (passport > 0) {
            this.passport = passport;
        } else {
            this.passport = 0;
            System.out.println("Invalid passport");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Guest name: ");
        stringBuilder.append(this.name);
        stringBuilder.append(", passport: ");
        stringBuilder.append(this.passport);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
