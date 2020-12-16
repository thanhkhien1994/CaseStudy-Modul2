package menuDepot;

import admin.Admin;
import file.FileAdmin;
import menuManufacturer.MenuManufacturer;
import menu.Check;
import menu.ManageAdmin;

import java.util.Scanner;

public class MenuDepot {
    MenuManufacturer menuManufacturer = new MenuManufacturer();
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    FileAdmin fileAdmin = new FileAdmin();

    public void programDepot(ManageAdmin manageAdmin) throws Exception {
        Admin admin = manageAdmin.getAdmin();
        String choice;
        int choiceDepot;
        do {
            showMenu(admin);
            choice = scanner.nextLine().toUpperCase();
            if (!check.isCheckNumber(choice)) {
                switch (choice) {
                    case "C":
                        manageAdmin.initDepot();
                        fileAdmin.writeFileAdmin(admin);
                        continue;
                    case "E":
                        manageAdmin.editDepot(admin);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "D":
                        manageAdmin.deleteDepot(admin);
                        fileAdmin.writeFileAdmin(admin);
                        break;
                    case "Q":
                        return;
                    case "T":
                        if (check.isCheckExitNow("Bạn muốn thoát không")) {
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("===== Thông báo! =====");
                        System.out.println("\tKhông khớp nhập lại!!!");
                }
            }

            if (check.isCheckNumber(choice)) {
                choiceDepot = Integer.parseInt(choice) - 1;
                if (check.isChoiceDepot(admin, choiceDepot)) {
                    boolean isCheckManufacturer = check.isCheckManufacturer(choiceDepot, manageAdmin);
                    if (isCheckManufacturer) {
                        menuManufacturer.programManufacturer(choiceDepot, manageAdmin);
                    }
                } else System.out.println("Không khớp nhập lại !!!");
            }
        } while (true);
    }

    private void showMenu(Admin admin) {
        int amount = 0;
        System.out.println("-->>Cửa hàng: ");
        for (int i = 0; i < admin.getDepotList().size(); i++) {
            for (int j = 0; j < admin.getDepotList().get(i).getManufacturerList().size();j++){
                amount ++;
            }
            System.out.println("\t" + (i + 1) + ". Cửa hàng " + admin.getDepotList().get(i).getNameDepot() +"("+amount+")");
            amount = 0;
        }
        System.out.println("-->>Chức năng: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
    }
}
