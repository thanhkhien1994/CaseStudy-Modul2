package admin;

import java.util.LinkedList;
import java.util.List;

public class Admin {
    static int stt;
    private String name;
    private int pin;
    private int id;
    List<Depot> depotList;

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
