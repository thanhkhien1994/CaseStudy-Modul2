package admin;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Admin implements Serializable {
    static int stt;
    private String name = "admin";
    private int pin = 1111;
    private int id;
    List<Depot> depotList;

    public Admin() {
        depotList = new LinkedList<>();
    }

    public Admin(String name, int pin) {
        depotList = new LinkedList<>();
        this.id = ++stt;
        this.pin = pin;
        this.name = name;
    }

    public List<Depot> getDepotList() {
        return depotList;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
