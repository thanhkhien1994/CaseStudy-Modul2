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
                    edit(iDepot, iManufacture, choiceMobile, admin);
                    return;
                case "D":
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(choiceMobile);
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

    private void edit(int iDepot, int iManufacture, int iMobile, Admin admin) {
        String choiceEditMobile = scanner.nextLine();
        Mobile mobile = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile);
        if (choiceEditMobile.equals("1")) {
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
        if (choiceEditMobile.equals("2")) {
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
        scanner.nextLine();
        if (choiceEditMobile.equals("3")) {
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
        scanner.nextLine();
        if (choiceEditMobile.equals("4")) {
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
        scanner.nextLine();
        if (choiceEditMobile.equals("5")) {
            System.out.println("Nhập IME mới cho thiết bị.");
            int ime = scanner.nextInt();
            if (check.isCheckExitNow("Xác nhận thay đổi IME thiết bị")) {
                mobile.setImeMobile(ime);
                System.out.println("IME thiết bị đã được thay đổi.");
                return;
            } else {
                System.out.println("IME thiết bị chưa được thay đổi.");
                return;
            }
        }

        if (choiceEditMobile.equals("Q")) {
            return;
        }
        if (choiceEditMobile.equals("T")) {
            if (check.isCheckExitNow("Xác nhận thoát")) {
                System.exit(0);
            }
        }
    }

    public void editAllInfo(int iDepot, int iManufacture, Admin admin) {
        System.out.println("------------------------------------------------------------------------------------");
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
                    System.out.println("------------------------------------------------------------------------------------");
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

    public void choiceDelete(int iDepot, int iManufacture, Admin admin){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Bạn muốn xóa thiết bị nào???");
        String choice = scanner.nextLine();
        int choiceDelete;
        do {
            if (check.isCheckNumber(choice)){
                choiceDelete = Integer.parseInt(choice)-1;
                int lengthListMobile = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().size();
                if (choiceDelete >=0 && choiceDelete<=lengthListMobile){
                    String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceDelete).getNameMobile();
                    String nameDepot = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getNameManufacturer();

                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(choiceDelete);
                    System.out.println("Đã xóa thiết bị "+ nameProduct + "khỏi kho "+nameDepot);
                    break;
                }


            }
            if (!check.isCheckNumber(choice)){
                System.out.println("Nhập sai, nhập số thiết bị đang hiển thị trên màn hình");
                if (check.isCheckExitNow("Bạn muốn tiếp tục không ")){
                } else break;
            }
            System.out.println("------------------------------------------------------------------------------------");

        }while (true);

    }

    public void delete(int iDepot, int iManufacture, int iMobile, Admin admin){
        System.out.println("------------------------------------------------------------------------------------");
        String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile).getNameMobile();
        String nameDepot = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getNameManufacturer();

        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(iMobile);
        System.out.println("Đã xóa thiết bị "+ nameProduct + "khỏi kho "+nameDepot);

        System.out.println("------------------------------------------------------------------------------------");
    }
}
