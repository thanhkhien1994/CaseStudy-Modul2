package menu;

import admin.Admin;

import java.io.IOException;
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
        if (!isCheckNumber(mess)) {
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
        } else {
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
            } while (true);

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

    public boolean isCheckDepot(ManageAdmin manageAdmin) throws IOException {
        int lengthDepotList = manageAdmin.getAdmin().getDepotList().size();
        if (lengthDepotList == 0) {
            if (isCheckExitNow("Bạn chưa có kho chưa nào\nTạo ngay")) {
                manageAdmin.initDepot();
                return true;
            } else return false;
        } else return true;
    }

    public boolean isCheckManufacturer(int choiceDepot, ManageAdmin manageAdmin) throws IOException {
        int lengthListDepot = manageAdmin.getAdmin().getDepotList().get(choiceDepot).getManufacturerList().size();
        if (lengthListDepot == 0) {
            if (isCheckExitNow(" Kho bạn đang trống\n* Thêm nhãn hàng ngay")) {
                manageAdmin.initManufacturer(choiceDepot);
                return true;
            } else return false;
        } else return true;
    }

    public boolean isCheckMobile(int LengthMobileList, int choiceManufacturer, int iDepot, ManageAdmin manageAdmin) throws IOException {
        if (LengthMobileList == 0) {
            if (isCheckExitNow("Bạn chưa có sản phẩm nào cả\n Thêm ngay")) {
                manageAdmin.initMobile(choiceManufacturer, iDepot);
                return true;
            } else return false;
        }
        return true;
    }

    public boolean isChoiceDepot(Admin admin, int choice) {
        if (choice >= 0 && choice < admin.getDepotList().size()) {
            return true;
        } else return false;
    }
    public boolean isChoiceManufacturer(Admin admin,int iDepot, int choice) {
        if (choice >= 0 && choice < admin.getDepotList().get(iDepot).getManufacturerList().size()) {
            return true;
        } else return false;
    }
    public boolean isChoiceMobile(Admin admin, int iDepot, int iManufacturer, int choice) {
        if (choice >= 0 && choice < admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().size()) {
            return true;
        } else return false;
    }
}
