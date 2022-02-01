package drones.beans;

import java.sql.Date;

public class Drone implements  Comparable<Drone>{
    private int id;
    private int customer_id;
    private String manufacturer;
    private String model;
    private Date eta;
    private Date entered;
    private boolean isPopped = false;

    public Drone(int id, int customer_id, String manufacturer, String model, Date eta, Date entered) {
        this.id = id;
        this.customer_id = customer_id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.eta = eta;
        this.entered = entered;
    }

    public Drone() {
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getEntered() {
        return entered;
    }

    public void setEntered(Date entered) {
        this.entered = entered;
    }

    public boolean isPopped() {
        return isPopped;
    }

    public void setPopped(boolean popped) {
        isPopped = popped;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", eta=" + eta +
                ", entered=" + entered +
                '}';
    }


    @Override
    public int compareTo(Drone other) {
        if(other.getEta().before(this.getEta())){
            return 1;
        }else{
            return -1;
        }
    }
}
