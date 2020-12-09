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
    ManageAdmin manageAdmin;
    Admin admin;
    Check check = new Check();
    FileObjectStream file = new FileObjectStream();

    public void program() throws Exception {
        if (manageAdmin == null){
            manageAdmin = new ManageAdmin();
            file.writeFileAdmin(manageAdmin);
        }
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    if (manageAdmin.getAdmin() == null) {
                        System.out.println("Nhập tên login mới");
                        String name = scanner.nextLine();
                        System.out.println("Mhập mã pin mới");
                        int pin = scanner.nextInt();
                        scanner.nextLine();
                        manageAdmin.setAdmin(new Admin(name, pin));
                        System.out.println("Đã tạo mới tài khoản.");
                        file.writeFileAdmin(manageAdmin);
                    }
                    manageAdmin = file.readFileAdmin();
                    admin = manageAdmin.getAdmin();
                    boolean isCheckLogin = check.isCheckLogin(admin);

                    if (isCheckLogin) {
                        menuAdmin.programAdmin(manageAdmin);
                    }
                    continue;
                case "2":
                    break;
                case "3":
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
