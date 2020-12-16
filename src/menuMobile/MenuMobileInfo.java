package menuMobile;

import admin.Admin;
import file.FileAdmin;
import menu.Check;
import menu.ManageAdmin;

import java.io.IOException;
import java.util.Scanner;

public class MenuMobileInfo {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    FileAdmin fileAdmin = new FileAdmin();

    public void program(int choiceMobile, int iDepot, int iManufacture, ManageAdmin manageAdmin) throws IOException {
        Admin admin = manageAdmin.getAdmin();
        int lengthProduct;
        do {
            showsInfo(admin, iDepot, iManufacture, choiceMobile);
            String choice = scanner.nextLine().toUpperCase();
            lengthProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().size();

            switch (choice) {
                case "E":
                    if (lengthProduct > 0) {
                        manageAdmin.programEditProduct(iDepot, iManufacture, choiceMobile, admin);
                        fileAdmin.writeFileAdmin(admin);
                    } else System.out.println("===== Thông báo =====\nSản phẩm không còn để sửa !");
                    return;
                case "D":
                    if (lengthProduct > 0) {
                        manageAdmin.deleteProduct(iDepot, iManufacture, choiceMobile, admin);
                        fileAdmin.writeFileAdmin(admin);
                    } else System.out.println("===== Thông báo  =====\nSản phẩm không còn để xóa !");
                    break;
                case "Q":
                    return;
                case "T":
                    if (check.isCheckExitNow("Xác nhận thoát")) {
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("=====  Thông báo  =====\n Nhập sai !!!\nNhập lại");
                    if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                        break;
                    } else return;
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
}
