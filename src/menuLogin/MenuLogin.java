package menuLogin;

import admin.Admin;
import file.FileAdmin;
import menuAdmin.MenuAdmin;
import menu.Check;
import menu.ManageAdmin;

import java.util.Scanner;

public class MenuLogin {
    Scanner scanner = new Scanner(System.in);
    MenuAdmin menuAdmin = new MenuAdmin();
    FileAdmin fileAdmin = new FileAdmin();
    Check check = new Check();

    public void program(ManageAdmin manageAdmin) throws Exception {
        manageAdmin.setAdmin(fileAdmin.readFileAdmin());
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    loginAdmin(manageAdmin);
                    break;
                case "2":
                    System.out.println("Tiểu thuơng đang cập nhật");
                    break;
                case "3":
                    if (check.isCheckExitNow("Xác nhận thoát!")) System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public void loginAdmin(ManageAdmin manageAdmin) throws Exception {
        Admin admin = manageAdmin.getAdmin();
        if (admin.getName().equals("admin")) {
            if (check.isCheckExitNow("Tạo TK mới ngay")) {
                System.out.println("Tài khoản mới: ");
                admin.setName(scanner.nextLine());
                System.out.println("Mật khẩu mới: ");
                admin.setPin(scanner.nextInt());
                fileAdmin.writeFileAdmin(manageAdmin.getAdmin());
                if (check.isCheckLogin(admin)) {
                    menuAdmin.programAdmin(manageAdmin);
                    return;
                }
            } else {
                System.out.println("=====  Chú ý  =====\n\tTên đăng nhập mặc định là: admin\n\tMã pin mặc định là 1111");
                if (check.isCheckLogin(admin)) menuAdmin.programAdmin(manageAdmin);
                return;
            }
        }
        if (check.isCheckLogin(admin)) menuAdmin.programAdmin(manageAdmin);
    }

    public void menu() {
        System.out.println("=====  Lựa chọn  =====               ");
        System.out.println("          1.Quản trị viên            ");
        System.out.println("          2.Tiểu thương              ");
        System.out.println("          3.Thoát                    ");
    }

}
