package program.menuMobile;

import admin.Admin;
import file.FileObjectStream;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuMobile {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    MenuMobileInfo f = new MenuMobileInfo();

    public void programMobile(int choiceManufacturer, int choiceDepot, ManageAdmin manageAdmin) throws Exception{
        Admin admin = manageAdmin.getAdmin();
        String choice;
        int choiceMobile;
        do {
            showMenuMobile(admin, choiceDepot, choiceManufacturer);
            choice = scanner.nextLine();
            if (!check.isCheckNumber(choice)) {
                switch (choice.toUpperCase()) {
                    case "C":
                        manageAdmin.initMobile(choiceManufacturer, choiceDepot);
                        continue;
                    case "E":
                        editMobile(admin, choiceDepot, choiceManufacturer, manageAdmin);
                        break;
                    case "D":
                        choiceDelete(choiceDepot, choiceManufacturer, admin);
                        break;
                    case "Q":
                        return;
                    case "T":
                        if (check.isCheckExitNow("Xác nhận thoát!")){
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("===== Thông báo =====\nKhông khớp!!!\n");
                }
            }

            if (check.isCheckNumber(choice)){
                choiceMobile = Integer.parseInt(choice) - 1;
                f.program(choiceMobile, choiceDepot, choiceManufacturer, manageAdmin);
            }
        } while (true);
    }

    private void editMobile(Admin admin, int choiceDepot, int choiceManufacturer, ManageAdmin manageAdmin) {
        int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
        if (lengthMobile == 0){
            System.out.println("=====  Thông báo  =====\nBạn chưa có điện thoại nào cần thêm ngay!!!");
            if (check.isCheckExitNow("Bạn có muốn thêm sản phẩm mới")){
                manageAdmin.initMobile(choiceManufacturer, choiceDepot);
            }
        } else {
            System.out.println("Chọn thiết bị muốn sửa Thông tin: ");
            String choiceEdit = scanner.nextLine();
            int newChoiceEdit;
            if (check.isCheckNumber(choiceEdit)){
                newChoiceEdit = Integer.parseInt(choiceEdit) -1;
                f.ProgramEdit(choiceDepot, choiceManufacturer, newChoiceEdit, admin);
                return;
            }
            if (!check.isCheckNumber(choiceEdit)){
                System.out.println("Chọn sai!");
                return;
            }
        }
    }

    public void choiceDelete(int iDepot, int iManufacture, Admin admin) {
        System.out.print("Chọn thiết bị xóa: \n");
        String choice = scanner.nextLine();
        int choiceDelete;
        do {
            if (check.isCheckNumber(choice)) {
                choiceDelete = Integer.parseInt(choice) - 1;
                int lengthListMobile = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().size();
                if (choiceDelete >= 0 && choiceDelete <= lengthListMobile) {
                    String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceDelete).getNameMobile();
                    String nameDepot = admin.getDepotList().get(iDepot).getNameDepot();
                    admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(choiceDelete);
                    System.out.println("===== Thông báo =====\nĐã xóa thiết bị " + nameProduct + " khỏi kho " + nameDepot);
                    break;
                }


            }
            if (!check.isCheckNumber(choice)) {
                System.out.println("Nhập sai, nhập số thiết bị đang hiển thị trên màn hình");
                if (check.isCheckExitNow("Bạn muốn tiếp tục không")) {
                    System.out.println("=====  Nhập lại  =====");
                } else break;
            }
        } while (true);

    }

    public void showMenuMobile(Admin admin, int choiceDepot, int choiceManufacturer) {
        System.out.println("Sản phẩm: ");
        int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
        String nameMobile;
        for (int iMobile = 0; iMobile < lengthMobile; iMobile++) {
            nameMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().get(iMobile).getNameMobile();
            System.out.println((iMobile + 1) + "." + nameMobile);
        }
        System.out.println("Chức năng: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
    }
}
