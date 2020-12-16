package menuAdmin;

import admin.Admin;
import menu.ManageAdmin;
import menuDepot.MenuDepot;
import menu.Check;
import menuStatistical.MenuStatistical;

import java.util.Scanner;

public class MenuAdmin {
    Scanner scanner = new Scanner(System.in);
    MenuDepot menuDepot = new MenuDepot();
    Check check = new Check();
    MenuStatistical functionAdmin = new MenuStatistical();

    public void programAdmin(ManageAdmin manageAdmin) throws Exception {
        Admin admin = manageAdmin.getAdmin();
        String choice;
        do {
            showMenuAdmin();
            choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    if (check.isCheckDepot(manageAdmin)) {
                        menuDepot.programDepot(manageAdmin);
                    }
                    continue;
                case "2":
                    functionAdmin.program(manageAdmin);
                    break;
                case "3":
                    break;
                case "Q":
                    return;
                case "T":
                    if (check.isCheckExitNow("Bạn muốn thoát không")) System.exit(0);
                    break;
                default:
                    System.out.println("===== Thông báo =====");
                    System.out.println("Nhập sai, nhập lại!!!");
            }
        } while (true);
    }

    public void showMenuAdmin() {
        System.out.println("-->>Lựa chọn: ");
        System.out.println("\t1.Cửa hàng");
        System.out.println("\t2.Thống kê");
        System.out.println("\t3.Tài khoản");
        System.out.println("-->>Chức năng:");
        System.out.println("\tQ.Quay lại \tT.Thoát");
    }
}
