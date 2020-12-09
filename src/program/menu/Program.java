package program.menu;

import file.FileObjectStream;
import program.menuLogin.MenuLogin;

public class Program {
    public static void main(String[] args) {
        FileObjectStream file = new FileObjectStream();
        MenuLogin menu = new MenuLogin();
        do {
            try{
                menu.program();

            }catch (Exception e){
                System.out.println("Lỗi chưa xác định, thử lại");
            }
        }while (true);
    }
}
