package program.menu;

import admin.Admin;
import admin.Depot;
import admin.Manufacturer;
import admin.Mobile;

import java.io.Serializable;
import java.util.Scanner;

public class ManageAdmin  implements Serializable {
    Scanner scanner = new Scanner(System.in);
    Admin admin;

    public void initManufacturer(int iDepot) {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Nhập vào tên hãng: ");
        String nameManufacturer = scanner.nextLine().toUpperCase();
        Manufacturer manufacturer = new Manufacturer(nameManufacturer);
        admin.getDepotList().get(iDepot).getManufacturerList().add(manufacturer);
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void initMobile(int iManufacturer, int iDepot) {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Nhập vào tên điện thoại");
        String nameMobile = scanner.nextLine();
        System.out.println("Nhập vào số IME điện thoại");
        int imeNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập vào số tiền");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nhập vào số lượng điện thoại");
        int amountPhone = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập vào kiểu (Loại) thiết bị");
        String loaiMobile = scanner.nextLine();
        Mobile mobile = new Mobile(loaiMobile, nameMobile, imeNumber, price, amountPhone);
        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void initDepot() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Nhập vào tên kho\n");
        String nameDepot = scanner.nextLine().toUpperCase();
        System.out.print("Nhập vào địa chỉ kho\n");
        String address = scanner.nextLine();
        Depot depot = new Depot(nameDepot, address);
        admin.getDepotList().add(depot);
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
