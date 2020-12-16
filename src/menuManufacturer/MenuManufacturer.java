package menuManufacturer;

import admin.Admin;
import file.FileAdmin;
import menuMobile.MenuMobile;
import menu.Check;
import menu.ManageAdmin;

import java.util.Scanner;

public class MenuManufacturer {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    MenuMobile menuMobile = new MenuMobile();
    FileAdmin fileAdmin = new FileAdmin();

    public void programManufacturer(int choiceDepot, ManageAdmin manageAdmin) throws Exception {
        Admin admin = manageAdmin.getAdmin();
        String choice;

        int choiceManufacturer;
        do {
            showMenuManufacturer(admin, choiceDepot);
            choice = scanner.nextLine();
            if (!check.isCheckNumber(choice)) {
                switch (choice.toUpperCase()) {
                    case "C":
                        manageAdmin.initManufacturer(choiceDepot);
                        fileAdmin.writeFileAdmin(admin);
                        continue;
                    case "E":
                        manageAdmin.editManufacturer(admin, choiceDepot);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "D":
                        manageAdmin.deleteManufacturer(admin, choiceDepot);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "Q":
                        return;
                    case "T":
                        if (check.isCheckExitNow("Bạn muốn thoát không!")) {
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("=====  Thông báo  =====\n\tNhập không đúng!!!");

                        continue;
                }
            }

            if (check.isCheckNumber(choice)) {
                choiceManufacturer = Integer.parseInt(choice) - 1;
                if (check.isChoiceManufacturer(admin, choiceDepot, choiceManufacturer)) {
                    int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
                    if (check.isCheckMobile(lengthMobile, choiceManufacturer, choiceDepot, manageAdmin)) {

                        menuMobile.programMobile(choiceManufacturer, choiceDepot, manageAdmin);
                    }
                } else System.out.println("=====Thông báo=====\n\tChọn sai!!!");
            }
        } while (true);
    }

    public void showMenuManufacturer(Admin admin, int iDepot) {
        int sum = 0;
        int lengthManufacturerList = admin.getDepotList().get(iDepot).getManufacturerList().size();
        System.out.println("-->>Lựa chọn: ");
        for (int iManufacturer = 0; iManufacturer < lengthManufacturerList; iManufacturer++) {
            for (int i = 0; i < admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().size(); i++) {
                sum++;
            }
            System.out.println("\t" + (iManufacturer + 1) + ". Hãng " + admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getNameManufacturer() + "(" + sum + ")");
            sum = 0;
        }
        System.out.println("-->>Chức năng: \n\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tThoát");
    }
}

