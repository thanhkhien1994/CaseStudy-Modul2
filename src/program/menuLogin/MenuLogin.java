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
    Check check = new Check();
    Admin admin = manageAdmin.getAdmin();;

    public void program() throws Exception {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    if (admin.getName().equals("admin")) {
                        System.out.println("Đây là tài khoản mặc định!");
                        if (check.isCheckExitNow("Tạo tài khoản mới ngay")) {
                            System.out.println("Nhập tên tài khoản mới: ");
                            admin.setName(scanner.nextLine());
                            System.out.println("Nhập mật khẩu mới: ");
                            admin.setPin(scanner.nextInt());
                            if (check.isCheckLogin(admin)) {
                                menuAdmin.programAdmin(manageAdmin);
                                break;
                            }
                        }else{
                            System.out.println("Tên đăng nhập mặc định là: admin\nMã pin mặc định là 1111");
                            if (check.isCheckLogin(admin)) menuAdmin.programAdmin(manageAdmin);
                            break;
                        }
                    }
                    if (check.isCheckLogin(admin)) menuAdmin.programAdmin(manageAdmin);
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

    public void menu() {
        System.out.println("Truy cập với tư cách là:");
        System.out.println("          1.Quản trị viên            ");
        System.out.println("          2.Tiểu thương              ");
        System.out.println("          3.Thoát                    ");
    }

}
