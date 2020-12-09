package program.menuAdmin;

import admin.Admin;
import file.FileObjectStream;
import program.menu.ManageAdmin;
import program.menuDepot.MenuDepot;
import program.menu.Check;
import program.menuLogin.MenuLogin;

import java.util.Scanner;

public class MenuAdmin {
    Scanner scanner = new Scanner(System.in);
    MenuDepot menuDepot = new MenuDepot();
    Check check = new Check();
    FileObjectStream file = new FileObjectStream();


    public void programAdmin(ManageAdmin manageAdmin) throws Exception{
        Admin admin = manageAdmin.getAdmin();
        String choice;
        do {
            showMenuAdmin();
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    if (check.isCheckDepot(manageAdmin)){
                        file.writeFileAdmin(manageAdmin);
                        menuDepot.programDepot(manageAdmin);
                    }
                    continue;
                case "2":
                    break;
                case "3":
                    break;
                case "Q":
                    return;
                case "T":
                    if (check.isCheckExitNow("Bạn muốn thoát không")) {
                        System.exit(0);
                    } else continue;
                default:
                    System.out.println("Nhập sai, nhập lại!!!");
            }
        } while (true);
    }

    public void showMenuAdmin() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Lựa chọn");
        System.out.println("      1.Kho");
        System.out.println("      2.Tài sản");
        System.out.println("      3.Tài khoản");
        System.out.println("Chức năng            ");
        System.out.println("      Q.Quay lại \tT.Thoát");
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
