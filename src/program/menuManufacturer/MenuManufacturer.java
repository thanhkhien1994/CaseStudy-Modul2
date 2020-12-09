package program.menuManufacturer;

import admin.Admin;
import file.FileObjectStream;
import program.menuMobile.MenuMobile;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuManufacturer {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    MenuMobile menuMobile = new MenuMobile();
    FileObjectStream file = new FileObjectStream();


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
                        file.writeFileAdmin(manageAdmin);
                        continue;
                    case "E":
                        break;
                    case "D":
                        break;
                    case "Q":
                        return;
                    case "T":
                        break;
                }
            }

            if (check.isCheckNumber(choice)) {
                choiceManufacturer = Integer.parseInt(choice) - 1;
                int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().size();
                boolean isCheckChoiceManufacturer = false;

                for (int iManufacture = 0; iManufacture < lengthMobile; iManufacture++) {
                    if (choiceManufacturer == iManufacture) {
                        isCheckChoiceManufacturer = true;
                        break;
                    }
                }

                if (isCheckChoiceManufacturer) {
                    boolean isCheckMobile = check.isCheckMobile(lengthMobile, choiceManufacturer, choiceDepot, manageAdmin);
                    if (isCheckMobile) {
                        file.writeFileAdmin(manageAdmin);
                        menuMobile.programMobile(choiceManufacturer, choiceDepot, manageAdmin);
                    }
                } else System.out.println("Không khớp nhập lại !!!");
            }
        } while (true);

    }

    public void showMenuManufacturer(Admin admin, int iDepot) {
        int sum = 0;
        int lengthManufacturerList = admin.getDepotList().get(iDepot).getManufacturerList().size();
        for (int iManufacturer = 0; iManufacturer < lengthManufacturerList; iManufacturer++) {
            for (int i = 0; i < admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().size(); i++) {
                sum++;
            }
            System.out.println(
                    (iManufacturer + 1) + ". Hãng " + admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getNameManufacturer()
                            + "(" + sum + " thiết bị)"
            );
            sum = 0;
        }
        System.out.println("Chức năng cho hãng sản xuất: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tThoát");
        System.out.println("*------------------------------------------------------------------------------*");
    }
}
