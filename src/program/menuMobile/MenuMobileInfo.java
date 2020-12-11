package program.menuMobile;

import admin.Admin;
import admin.Mobile;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuMobileInfo {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();

    public void program(int choiceMobile, int iDepot, int iManufacture, ManageAdmin manageAdmin) {
        Admin admin = manageAdmin.getAdmin();
        do {
            showsInfo(admin, iDepot, iManufacture, choiceMobile);
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "E":
                    ProgramEdit(iDepot, iManufacture, choiceMobile, admin);
                    return;
                case "D":
                    delete(iDepot, iManufacture, choiceMobile, admin);
                    break;
                case "Q":
                    return;
                case "T":
                    if (check.isCheckExitNow("Xác nhận thoát")) {
                        System.exit(0);
                    }
                    break;
            }

        } while (true);

    }

    public void showsInfo(Admin admin, int iDepot, int iManufacture, int choiceMobile) {
        int lengthMobileList = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().size();
        for (int iMobile = 0; iMobile < lengthMobileList; iMobile++) {
            if (choiceMobile == iMobile) {
                String mobileInfo = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile).toString();
                String nameManufacture = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getNameManufacturer().toUpperCase();
                String depotName = admin.getDepotList().get(iDepot).getNameDepot().toUpperCase();
                String addressDepot = admin.getDepotList().get(iDepot).getAddressDepot();

                System.out.println("=====  Thông tin chi tiết  =====");
                System.out.println("Đơn vị sản xuất: " + nameManufacture);
                System.out.println("Đang có hàng tại kho: " + depotName + "\nĐịa chỉ: " + addressDepot.toUpperCase());
                System.out.println(mobileInfo);
            }
        }
        System.out.println("Chức năng: ");
        System.out.println("\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
    }

    public void ProgramEdit(int iDepot, int iManufacture, int iMobile, Admin admin) {
        System.out.println("-------------------------------------------------------------------------------------------");
        showMenuEdit();
        System.out.println("-------------------------------------------------------------------------------------------");
        String choiceEditMobile = scanner.nextLine().toUpperCase();
        Mobile mobile = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile);
        switch (choiceEditMobile) {
            case "1":
                System.out.println("-------------------------------------------------------------------------------------------");
                editName(mobile);
                System.out.println("Đã xong!");
                System.out.println("-------------------------------------------------------------------------------------------");
                break;
            case "2":
                System.out.println("-------------------------------------------------------------------------------------------");
                editIME(mobile);
                System.out.println("Đã xong!");
                System.out.println("-------------------------------------------------------------------------------------------");
                break;
            case "3":
                System.out.println("-------------------------------------------------------------------------------------------");
                editPrice(mobile);
                System.out.println("Đã xong!");
                System.out.println("-------------------------------------------------------------------------------------------");
                break;
            case "4":
                System.out.println("-------------------------------------------------------------------------------------------");
                editAmount(mobile);
                System.out.println("Đã xong!");
                System.out.println("-------------------------------------------------------------------------------------------");
                break;
            case "5":
                System.out.println("-------------------------------------------------------------------------------------------");
                editAllInfo(iDepot, iManufacture, admin);
                System.out.println("Đã xong!");
                System.out.println("-------------------------------------------------------------------------------------------");
                break;
            case "Q":
                return;
            case "T":
                System.out.println("-------------------------------------------------------------------------------------------");
                if (check.isCheckExitNow("Xác nhận thoát")){
                    System.exit(0);
                }
                System.out.println("-------------------------------------------------------------------------------------------");
            default:
                System.out.println("===== Thông báo =====");
                System.out.println("Nhập sai!");
        }
    }

    public void editAmount(Mobile mobile) {
        System.out.println("Nhập số lượng mới cho thiết bị.");
        int amount = scanner.nextInt();
        if (check.isCheckExitNow("Xác nhận thay đổi số lượng")) {
            mobile.setAmountMobile(amount);
            return;
        } else {
            System.out.println("Số lượng chưa được thay đổi.");
            return;
        }
    }

    public void editPrice(Mobile mobile) {
        System.out.println("Nhập giá mới cho thiết bị.");
        int price = scanner.nextInt();
        if (check.isCheckExitNow("Xác nhận thay đổi giá thiết bị")) {
            mobile.setPriceMobile(price);
            return;
        } else {
            System.out.println("Giá chưa được thay đổi.");
            return;
        }
    }

    public void editIME(Mobile mobile) {
        System.out.println("Nhập IME mới cho thiết bị.");
        int ime = scanner.nextInt();
        if (check.isCheckExitNow("Xác nhận thay đổi IME")) {
            mobile.setImeMobile(ime);
            System.out.println("IME đã được thay đổi.");
            return;
        } else {
            System.out.println("IME chưa được thay đổi.");
            return;
        }
    }

    public void editName(Mobile mobile) {
        System.out.println("Nhập tên mới cho thiết bị.");
        String name = scanner.nextLine();
        if (check.isCheckExitNow("Xác nhận thay đổi tên")) {
            mobile.setNameMobile(name);
            System.out.println("Tên đã được thay đổi.");
            return;
        } else {
            System.out.println("Tên chưa được thay đổi.");
            return;
        }
    }

    public void showMenuEdit() {
        System.out.println("=====  Thay đổi thông tin thiết bị  =====");
        System.out.println("      1.Sửa tên                                                                      ");
        System.out.println("      2.Sửa IME                                                                      ");
        System.out.println("      3.Sửa giá                                                                      ");
        System.out.println("      4.Sửa số lượng                                                                 ");
        System.out.println("      5.Sửa tất cả thông tin                                                             ");
        System.out.println("Chức năng ");
        System.out.print("        Điều hướng:\tQ.Quay lại\tT.Thoát\n");
    }

    public void editAllInfo(int iDepot, int iManufacture, Admin admin) {
        System.out.println("=====  Sửa thông tin  =====");
        System.out.print("Chọn thiết bị bạn muốn sửa:                                      ");
        String choice = scanner.nextLine();
        int choiceEdit = 0;
        if (check.isCheckNumber(choice)) {
            choiceEdit = Integer.parseInt(choice) - 1;
        }
        if (!check.isCheckNumber(choice)) {
            System.out.println("Không hợp lệ !!!");
            return;
        }
        System.out.println("\n");
        for (int i = 0; true; ) {
            if (choiceEdit == i) {
                scanner.nextLine();
                System.out.println("Nhập tên mới cho thiết bị.                                         ");
                String name = scanner.nextLine();
                System.out.println("Nhập IME mới cho thiết bị.                                         ");
                int ime = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập giá mới cho thiết bị.                                         ");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Nhập số lượng mới cho thiết bị.                                    ");
                int amount = scanner.nextInt();
                scanner.nextLine();

                if (check.isCheckExitNow("Xác nhận thay đổi")) {
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(i).setNameMobile(name);
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(i).setImeMobile(ime);
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(i).setPriceMobile(price);
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(i).setAmountMobile(amount);
                    System.out.println("Đã thay đổi thông tin thiết bị.");
                    break;
                } else {
                    System.out.println("Đã hủy lệnh thông tin thiết bị chưa đựoc thay đổi.");
                    break;
                }
            } else {
                System.out.println("Không tìm thấy thiết bị ");
                break;
            }
        }
    }

    public void delete(int iDepot, int iManufacture, int iMobile, Admin admin) {
        String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile).getNameMobile();
        String nameDepot = admin.getDepotList().get(iDepot).getNameDepot();
        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(iMobile);
        System.out.println("Đã xóa thiết bị " + nameProduct + "khỏi kho " + nameDepot);
    }
}
