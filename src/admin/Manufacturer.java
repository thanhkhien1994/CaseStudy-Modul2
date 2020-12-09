package admin;

import java.util.LinkedList;
import java.util.List;

public class Manufacturer {
    static int stt;
    private int id;
    private String nameManufacturer;
    List<Mobile> mobileList;

    public Manufacturer(String nameManufacturer) {
        this.id = ++stt;
        this.nameManufacturer = nameManufacturer;
        this.mobileList = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public List<Mobile> getMobileList() {
        return mobileList;
    }
}
