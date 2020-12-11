package program.menu;

import program.menuLogin.MenuLogin;

public class Program {
    public static void main(String[] args) {
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
