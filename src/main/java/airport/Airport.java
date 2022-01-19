package airport;

public class Airport {
    public final static int TOTAL_PLANES = 20;
    private Thread[] threadPlanes = new Thread[TOTAL_PLANES];
    private Airplane[] airplanes = new Airplane[TOTAL_PLANES];
    private String name;

    public Airport(String name) {
        this.name = name;
    }

    public void startActivity() {
        System.out.println("Airport " + this.name + " is open");
        for (int counter = 0; counter < TOTAL_PLANES; counter++) {
            airplanes[counter] = new Airplane();
            this.threadPlanes[counter]=new Thread(airplanes[counter]);
        }
        for (Thread item : this.threadPlanes) {
            item.start();
        }
        for (Thread item : this.threadPlanes) {
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Airport " + this.name + " is closing");
    }
}
