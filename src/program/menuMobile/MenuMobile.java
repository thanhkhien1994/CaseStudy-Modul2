package program.menuMobile;

import admin.Admin;
import file.FileObjectStream;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuMobile {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    MenuMobileInfo functionMobile = new MenuMobileInfo();
    FileObjectStream file = new FileObjectStream();


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
                        file.writeFileAdmin(manageAdmin);
                        continue;
                    case "E":
                        showMenuEditMobile();
                        functionMobile.editAllInfo(choiceDepot, choiceManufacturer,admin);
                        continue;
                    case "D":

                        break;
                    case "Q":
                        return;
                    case "T":
                        break;
                    default:
                        System.out.println("Không khớp!!!");
                }
            }

            if (check.isCheckNumber(choice)){
                choiceMobile = Integer.parseInt(choice) - 1;
                functionMobile.program(choiceMobile, choiceDepot, choiceManufacturer, manageAdmin);
            }
        } while (true);
    }

    public void showMenuMobile(Admin admin, int choiceDepot, int choiceManufacturer) {
        int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
        for (int iMobile = 0; iMobile < lengthMobile; iMobile++) {
            System.out.println((iMobile + 1) + "." + admin.getDepotList().get(choiceDepot)
                    .getManufacturerList().get(choiceManufacturer).getMobileList().get(iMobile).getNameMobile()
            );
        }

        System.out.println("Chức năng: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
    }

    private void showMenuEditMobile() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("=====  Thay đổi thông tin thiết bị  =====");
        System.out.println("      1.Sửa tên                                                                      ");
        System.out.println("      2.Sửa IME                                                                      ");
        System.out.println("      3.Sửa giá                                                                      ");
        System.out.println("      4.Sửa số lượng                                                                 ");
        System.out.println("      4.Sửa tất cả thông tin                                                             ");
        System.out.println("Chức năng ");
        System.out.print("        Điều hướng:\tQ.Quay lại\tT.Thoát\n");
        System.out.println("------------------------------------------------------------------------------------");
    }
}
