package program.menu;

import admin.Admin;
import admin.Depot;
import admin.Manufacturer;
import admin.Mobile;

import java.util.Scanner;

public class ManageAdmin {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    Admin admin;

    public void initManufacturer(int iDepot) {
        System.out.print("Nhập vào tên hãng: ");
        String nameManufacturer = scanner.nextLine().toUpperCase();
        Manufacturer manufacturer = new Manufacturer(nameManufacturer);
        admin.getDepotList().get(iDepot).getManufacturerList().add(manufacturer);
    }

    public void initMobile(int iManufacturer, int iDepot) {
        System.out.println("Nhập vào tên điện thoại");
        String nameMobile = scanner.nextLine();
        String ime;
        int imeNumber;
        do {
            System.out.println("Nhập vào số IME điện thoại");
            ime = scanner.nextLine();
            if (check.isCheckNumber(ime)){
                imeNumber = Integer.parseInt(ime);
                break;
            }else {
                System.out.println("Thông báo");
                System.out.println("Bạn phải nhập số, nhập lại");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không")){
                    System.out.println("Nhập lại: ");
                }else  return;
            }
        }while (true);

        double price;
        do {
            try {
                System.out.println("Nhập vào số tiền: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                break;
            }catch (Exception e){
                System.out.println("===== Thông báo =====");
                System.out.println("Nhập không đúng!");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục")){
                    System.out.println("Nhập lại: ");
                }else return;
            }
        }while (true);

        String amountPhone;
        int newAmountPhone;
        do {
            System.out.println("Nhập vào số lượng điện thoại");
            amountPhone = scanner.nextLine();
            if (check.isCheckNumber(amountPhone)) {
                newAmountPhone = Integer.parseInt(amountPhone);
                break;
            } else {
                System.out.println("Số luợng điện thoại không hợp lệ !");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không???")) {
                    System.out.println("Nhập lại số lựong điện thoại");
                } else return;
            }

        } while (true);

        System.out.println("Chọn kiểu (Loại) thiết bị");
        String choice;
        int newChoice;
        do {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1. Điện thoại di dộng");
            System.out.println("2. Máy tính sách tay");
            System.out.println("3. Máy ảnh");
            System.out.println("4. Đồng hồ");
            System.out.println("5. Phụ kiện");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                newChoice = Integer.parseInt(choice);
                Mobile mobile;
                switch (newChoice) {
                    case 1:
                        mobile = new Mobile("Điện thoại di động", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 2:
                        mobile = new Mobile("Máy tính sách tay", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 3:
                        mobile = new Mobile("Máy ảnh", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 4:
                        mobile = new Mobile("Đồng hồ", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 5:
                        mobile = new Mobile("Phụ kiện", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    default:
                        System.out.println("=====  Thông báo  =====");
                        System.out.println("Nhập không đúng");
                        if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                            break;
                        } else return;
                }

            } else {
                System.out.println("=====  Thông báo  =====");
                System.out.println("Nhập không đúng");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                    System.out.println("Nhập số hiển thị trên màn hình.");
                    System.out.println("--------------------------------------------------------------------------------------");
                } else return;
            }
        } while (true);
    }

    public void initDepot() {
        System.out.print("Nhập vào tên kho\n");
        String nameDepot = scanner.nextLine().toUpperCase();
        System.out.print("Nhập vào địa chỉ kho\n");
        String address = scanner.nextLine();
        Depot depot = new Depot(nameDepot, address);
        admin.getDepotList().add(depot);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
