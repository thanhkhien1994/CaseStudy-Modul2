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


    public void programAdmin(ManageAdmin manageAdmin) throws Exception{
        Admin admin = manageAdmin.getAdmin();
        String choice;
        do {
            System.out.println("-------------------------------------------------------------------------------------------");
            showMenuAdmin();
            System.out.println("-------------------------------------------------------------------------------------------");
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1"://Kho
                    System.out.println("-------------------------------------------------------------------------------------------");
                    if (check.isCheckDepot(manageAdmin)){
                        menuDepot.programDepot(manageAdmin);
                    }
                    System.out.println("-------------------------------------------------------------------------------------------");
                    continue;
                case "2"://Tài sản
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case "3"://Tải khoản
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case "Q":
                    return;
                case "T":
                    System.out.println("-------------------------------------------------------------------------------------------");
                    if (check.isCheckExitNow("Bạn muốn thoát không")) {
                        System.exit(0);
                    }
                    System.out.println("-------------------------------------------------------------------------------------------");
                default:
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("===== Thông báo =====");
                    System.out.println("Nhập sai, nhập lại!!!");
                    System.out.println("-------------------------------------------------------------------------------------------");
            }
        } while (true);
    }

    public void showMenuAdmin() {
        System.out.println("Lựa chọn");
        System.out.println("\t1.Kho");
        System.out.println("\t2.Tài sản");
        System.out.println("\t3.Tài khoản");
        System.out.println("Chức năng            ");
        System.out.println("\tQ.Quay lại \tT.Thoát");
    }
}
