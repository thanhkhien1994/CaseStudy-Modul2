package menu;

import admin.Admin;
import file.FileAdmin;
import menuLogin.MenuLogin;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        MenuLogin menu = new MenuLogin();
        ManageAdmin manageAdmin = new ManageAdmin();
        FileAdmin fileAdmin = new FileAdmin();
        do {
            try{
                menu.program(manageAdmin);
            }catch (Exception e){
                String adminNull = "java.lang.NullPointerException: Cannot invoke \"admin.Admin.getName()\" because \"admin\" is null";
                if (adminNull.equals("java.lang.NullPointerException: Cannot invoke \"admin.Admin.getName()\" because \"admin\" is null")){
                    Admin admin = new Admin();
                    manageAdmin.setAdmin(admin);
                    fileAdmin.writeFileAdmin(manageAdmin.getAdmin());
                } else {
                    System.out.println("Thông báo" +"\n"+
                            "Chúng tôi rất tiếc vì sự cố này!\n" +
                            "Có vẻ như một sự cố đã xảy ra\n" +
                            "Thông báo sự cố mà bạn gặp phải\n" +
                            "1. SĐT: 0335915359\n" +
                            "2. Email: thanhkhien1994@gmail.com");
                    System.out.println(e);
                }
            }
        }while (true);
    }
}
