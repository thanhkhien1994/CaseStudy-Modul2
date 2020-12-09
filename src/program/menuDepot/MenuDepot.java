package program.menuDepot;

import admin.Admin;
import file.FileObjectStream;
import program.menuManufacturer.MenuManufacturer;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuDepot {
    MenuManufacturer menuManufacturer = new MenuManufacturer();
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    FileObjectStream file = new FileObjectStream();


    public void programDepot(ManageAdmin manageAdmin) throws Exception {
        Admin admin = manageAdmin.getAdmin();
        String choice;
        int choiceDepot;
        do {
            showMenu(admin);
            choice = scanner.nextLine().toUpperCase();
            if (!check.isCheckNumber(choice)) {
                switch (choice) {
                    case "C":/*Chức năng tạo mới kho đã xong*/
                        manageAdmin.initDepot();
                        file.writeFileAdmin(manageAdmin);
                        continue;
                    case "E":

                        break;
                    case "D":
                        break;
                    case "Q":/*Chức năng quay lại đã xong*/
                        return;
                    case "T":/*Chức năng thoát đã xong*/
                        if (check.isCheckExitNow("Bạn muốn thoát không")) {
                            System.exit(0);
                        }
                    default:
                        System.out.println("Không khớp nhập lại!!!");
                }
            }

            if (check.isCheckNumber(choice)) {
                choiceDepot = Integer.parseInt(choice) - 1;
                int lengthDepotList = admin.getDepotList().size();
                boolean isCheckChoiceDepot = false;

                for (int iDepot = 0; iDepot < lengthDepotList; iDepot++) {
                    if (iDepot == choiceDepot) {
                        isCheckChoiceDepot = true;
                        break;
                    }
                }

                if (isCheckChoiceDepot) {
                    boolean isCheckManufacturer = check.isCheckManufacturer(choiceDepot, manageAdmin);
                    if (isCheckManufacturer) {
                        file.writeFileAdmin(manageAdmin);
                        menuManufacturer.programManufacturer(choiceDepot, manageAdmin);
                    }
                } else System.out.println("Không khớp nhập lại !!!");
            }

        } while (true);
    }

    public void showMenu(Admin admin) {
        int sum = 0;
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Truy cập kho chứa: ");
        for (int i = 0; i < admin.getDepotList().size(); i++) {
            for (int j = 0; j < admin.getDepotList().get(i).getManufacturerList().size();j++){
                sum ++;
            }
            System.out.println("\t" + (i + 1) + ". Kho " + admin.getDepotList().get(i).getNameDepot()
                    +"("+sum+" nhãn hàng)"
            );
            sum = 0;
        }
        System.out.println("Chức năng cho kho chứa: ");
        System.out.println("\tC.Thêm\tE.Sửa\tD.Xóa\tQ.Quay lại\tT.Thoát");
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}