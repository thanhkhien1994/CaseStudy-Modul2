package program.menu;

import admin.Admin;
import program.menuManufacturer.MenuManufacturer;

import java.util.Scanner;

public class Check {
    Scanner scanner = new Scanner(System.in);

    public boolean isCheckNumber(String string) {
        try {
            int choiceInt = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isCheckExitNow(String mess) {
        if (!isCheckNumber(mess)){
            do {
                System.out.println("=====  Thông báo  =====");
                System.out.println(mess + ":\t[C\\K]");
                String choice = scanner.nextLine().toUpperCase();
                boolean isContinue = choice.equals("C");
                boolean isExitNow = choice.equals("K");
                if (isContinue) return true;
                if (isExitNow) return false;
                System.out.println("Cảnh báo nhập sai!");
            } while (true);
        }else{
            System.out.println("Nhập không đúng !!!");
            return false;
        }
    }

    public boolean isCheckLogin(Admin admin) {
        do {
            System.out.println("===== Đăng nhập =====");
            System.out.print("Tên đăng nhập: ");
            String userName = scanner.nextLine().toUpperCase();
            System.out.print("\nMật khẩu: ");
            String password;
            int intPassword;
            do {
                password = scanner.nextLine();
                if (isCheckNumber(password)) {
                  intPassword = Integer.parseInt(password);
                  break;
                }
                System.out.println("Nhập sai, mã pin chỉ bao gồm số ");
                System.out.println("Nhập lại mã pin:");
            }while (true);

            boolean isUser = userName.equals(admin.getName().toUpperCase());
            boolean isPassword = (intPassword == admin.getPin());

            if (isUser && !isPassword) {
                System.out.println("Sai mật khẩu ! ");
                if (isCheckExitNow("Nhập lại")) {
                    continue;
                } else return false;
            }

            if (isPassword && !isUser) {
                System.out.println("Sai tên đăng nhập ! ");
                if (isCheckExitNow("Tiếp tục")) {
                    continue;
                } else return false;
            }

            if (!isPassword && !isUser) {
                System.out.println("Sai tên đăng nhập và mật khẩu");
                if (isCheckExitNow("Nhập lại")) {
                    continue;
                } else return false;
            }

            if (isPassword) {
                return true;
            }
        } while (true);

    }

    public boolean isCheckDepot(ManageAdmin manageAdmin) {
        int lengthDepotList = manageAdmin.getAdmin().getDepotList().size();
        if (lengthDepotList == 0) {
            if (isCheckExitNow("Bạn chưa có kho chưa nào\nTạo ngay")) {
                manageAdmin.initDepot();
                return true;
            }else return false;
        }else return true;
    }

    public boolean isCheckManufacturer(int choiceDepot, ManageAdmin manageAdmin){
        int lengthListDepot = manageAdmin.getAdmin().getDepotList().get(choiceDepot).getManufacturerList().size();
        if (lengthListDepot == 0) {
            if (isCheckExitNow(" Kho bạn đang trống\n* Thêm nhãn hàng ngay")) {
                manageAdmin.initManufacturer(choiceDepot);
                return true;
            }else return false;
        }else return true;
    }

    public boolean isCheckMobile(int LengthMobileList, int choiceManufacturer, int iDepot, ManageAdmin manageAdmin){
        if (LengthMobileList == 0) {
            if (isCheckExitNow("Bạn chưa có sản phẩm nào cả\n Thêm ngay")) {
                manageAdmin.initMobile(choiceManufacturer, iDepot);
                return true;
            }else return false;
        }return true;
    }
}
