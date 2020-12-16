package menuMobile;

import admin.Admin;
import file.FileAdmin;
import menu.Check;
import menu.ManageAdmin;

import java.util.Scanner;

public class MenuMobile {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    MenuMobileInfo f = new MenuMobileInfo();
    FileAdmin fileAdmin = new FileAdmin();

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
                        fileAdmin.writeFileAdmin(admin);
                        manageAdmin.initMobile(choiceManufacturer, choiceDepot);
                        continue;
                    case "E":
                        manageAdmin.editMobile(admin, choiceDepot, choiceManufacturer, manageAdmin);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "D":
                        manageAdmin.deleteMobile(choiceDepot, choiceManufacturer, admin);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "Q":
                        return;
                    case "T":
                        if (check.isCheckExitNow("Xác nhận thoát!")){
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("===== Thông báo =====\n\tKhông khớp!!!\n");
                }
            }

            if (check.isCheckNumber(choice)){
                choiceMobile = Integer.parseInt(choice) - 1;
                if (check.isChoiceMobile(admin, choiceDepot, choiceManufacturer, choiceMobile)){
                    f.program(choiceMobile, choiceDepot, choiceManufacturer, manageAdmin);
                }else System.out.println("=====Thông báo=====\n\tChọn sai!!!");
            }
        } while (true);
    }

    public void showMenuMobile(Admin admin, int choiceDepot, int choiceManufacturer) {
        System.out.println("-->>Lựa chọn: ");
        int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
        String nameMobile;
        int amount;
        for (int iMobile = 0; iMobile < lengthMobile; iMobile++) {
            nameMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().get(iMobile).getNameMobile();
            amount = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().get(iMobile).getAmountMobile();
            System.out.println("\t"+(iMobile + 1) + "." + nameMobile +"("+amount+")");
        }
        System.out.println("-->>Chức năng: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
    }
}
