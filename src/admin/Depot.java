package admin;

import java.util.LinkedList;
import java.util.List;

public class Depot {
    static int stt;
    private int id;
    private String nameDepot;
    private String addressDepot;
    List<Manufacturer> manufacturerList;

    public Depot(String nameDepot, String addressDepot) {
        this.id = ++stt;
        this.nameDepot = nameDepot;
        this.addressDepot = addressDepot;
        this.manufacturerList = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getNameDepot() {
        return nameDepot;
    }

    public void setNameDepot(String nameDepot) {
        this.nameDepot = nameDepot;
    }

    public String getAddressDepot() {
        return addressDepot;
    }

    public void setAddressDepot(String addressDepot) {
        this.addressDepot = addressDepot;
    }

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }
}
