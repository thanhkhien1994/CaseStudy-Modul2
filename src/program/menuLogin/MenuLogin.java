package program.menuLogin;

import admin.Admin;
import file.FileObjectStream;
import program.menuAdmin.MenuAdmin;
import program.menu.Check;
import program.menu.ManageAdmin;

import java.util.Scanner;

public class MenuLogin {
    Scanner scanner = new Scanner(System.in);
    MenuAdmin menuAdmin = new MenuAdmin();
    ManageAdmin manageAdmin = new ManageAdmin();
    Admin admin;
    Check check = new Check();

    public void program() throws Exception {

        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("-------------------------------------------------------------------------------------------");
                    if (manageAdmin.getAdmin() == null) {
                        System.out.println("Nhập tên login mới");
                        String name = scanner.nextLine();
                        System.out.println("Mhập mã pin mới");
                        int pin = scanner.nextInt();
                        scanner.nextLine();
                        manageAdmin.setAdmin(new Admin(name, pin));
                        System.out.println("Đã tạo mới tài khoản.");
                        admin = manageAdmin.getAdmin();
                    }
                    boolean isCheckLogin = check.isCheckLogin(admin);
                    if (isCheckLogin) {
                        menuAdmin.programAdmin(manageAdmin);
                    }
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                case "2":
                    System.out.println("Tiểu thuơng đang cập nhật");
                    break;
                case "3":
                    System.out.println("-------------------------------------------------------------------------------------------");
                    if (check.isCheckExitNow("Xác nhận thoát!")){
                        System.exit(0);
                    }
                    System.out.println("-------------------------------------------------------------------------------------------");
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public void menu() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Truy cập với tư cách là:");
        System.out.println("          1.Quản trị viên            ");
        System.out.println("          2.Tiểu thương              ");
        System.out.println("          3.Thoát                    ");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

}
