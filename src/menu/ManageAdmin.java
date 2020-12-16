package menu;

import admin.Admin;
import admin.Depot;
import admin.Manufacturer;
import admin.Mobile;
import file.FileAdmin;
import menuManufacturer.MenuManufacturer;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;

public class ManageAdmin implements Serializable {
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    Admin admin;
    FileAdmin fileAdmin = new FileAdmin();
    MenuManufacturer menuManufacturer = new MenuManufacturer();

    public ManageAdmin() {}

    public void initManufacturer(int iDepot) {
        System.out.print("Nhập vào tên hãng sản xuất thiết bị: ");
        String nameManufacturer = scanner.nextLine().toUpperCase();
        Manufacturer manufacturer = new Manufacturer(nameManufacturer);
        admin.getDepotList().get(iDepot).getManufacturerList().add(manufacturer);
    }

    public void initMobile(int iManufacturer, int iDepot) {
        System.out.println("Nhập vào tên thiết bị: ");
        String nameMobile = scanner.nextLine().toUpperCase();
        String ime;
        int imeNumber;
        do {
            System.out.println("Nhập vào số IME thiết bị: ");
            ime = scanner.nextLine();
            if (check.isCheckNumber(ime)) {
                imeNumber = Integer.parseInt(ime);
                break;
            } else {
                System.out.println("===== Thông báo =====");
                System.out.println("Bạn phải nhập số, nhập lại!!!");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                    System.out.println("Nhập lại: ");
                } else return;
            }
        } while (true);

        double price;
        String priceStr;
        do {
            System.out.println("Nhập vào số tiền: ");
            priceStr = scanner.nextLine();
            if (check.isCheckNumber(priceStr)) {
                price = Integer.parseInt(priceStr);
                break;
            } else {
                System.out.println("===== Thông báo =====");
                System.out.println("Nhập không đúng!");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục")) {
                    System.out.println("Nhập lại: ");
                } else return;
            }
        } while (true);

        String amountPhone;
        int newAmountPhone;
        do {
            System.out.println("Nhập vào số lượng thiết bị");
            amountPhone = scanner.nextLine();
            if (check.isCheckNumber(amountPhone)) {
                newAmountPhone = Integer.parseInt(amountPhone);
                break;
            } else {
                System.out.println("Số luợng Thiết bị không hợp lệ !");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không???")) {
                    System.out.println("=====  Thông báo  =====\nNhập lại: ");
                } else return;
            }

        } while (true);

        System.out.println("=====  Chọn kiểu (Loại) thiết bị  =====");
        String choice;
        int newChoice;
        do {
            System.out.println("1. Điện thoại di dộng");
            System.out.println("2. Máy tính sách tay");
            System.out.println("3. Máy ảnh");
            System.out.println("4. Đồng hồ");
            System.out.println("5. Phụ kiện");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                newChoice = Integer.parseInt(choice);
                Mobile mobile;
                switch (newChoice) {
                    case 1:
                        mobile = new Mobile("Điện thoại di động", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 2:
                        mobile = new Mobile("Máy tính sách tay", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 3:
                        mobile = new Mobile("Máy ảnh", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 4:
                        mobile = new Mobile("Đồng hồ", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    case 5:
                        mobile = new Mobile("Phụ kiện", nameMobile, imeNumber, price, newAmountPhone);
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacturer).getMobileList().add(mobile);
                        return;
                    default:
                        System.out.println("=====  Thông báo  =====");
                        System.out.println("Nhập không đúng");
                        if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                            break;
                        } else return;
                }

            } else {
                System.out.println("=====  Thông báo  =====");
                System.out.println("Nhập không đúng !!!");
                if (check.isCheckExitNow("Bạn có muốn tiếp tục không")) {
                    System.out.println("Nhập số hiển thị trên màn hình.");
                } else return;
            }
        } while (true);
    }

    public void initDepot() {
        System.out.print("Nhập vào tên cửa hàng bạn quản lý\n");
        String nameDepot = scanner.nextLine().toUpperCase();
        System.out.print("Nhập vào địa chỉ cửa hàng\n");
        String address = scanner.nextLine().toUpperCase();
        Depot depot = new Depot(nameDepot, address);
        admin.getDepotList().add(depot);
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void deleteManufacturer(Admin admin, int iDepot) {
        String choice;
        int choiceManufacturer;
        do {
            System.out.println("Chọn hãng muốn sửa: ");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                choiceManufacturer = Integer.parseInt(choice) - 1;
                if (check.isChoiceManufacturer(admin, iDepot, choiceManufacturer)) {
                    if (check.isCheckExitNow("Xác nhận xóa?")) {
                        System.out.println("Xác minh danh tính: ");
                        if (check.isCheckLogin(admin)) {
                            admin.getDepotList().get(iDepot).getManufacturerList().remove(choiceManufacturer);
                            System.out.println("Đã xóa hãng!");
                            return;
                        }
                    } else System.out.println("Đã hủy lệnh xóa!");
                    return;
                } else {
                    if (check.isCheckExitNow("bạn muốn tiếp tục không?")) {
                        System.out.println("Chọn không đúng!\n\tNhập lại: ");
                        menuManufacturer.showMenuManufacturer(admin, iDepot);
                    } else return;
                }
            } else {
                if (check.isCheckExitNow("Bạn muốn tiếp tục không?")) {
                    System.out.println("Nhập số đang hiển thị\n\tNhập lại: ");
                    menuManufacturer.showMenuManufacturer(admin, iDepot);
                } else return;
            }
        } while (true);
    }

    public void editManufacturer(Admin admin, int iDepot) {
        String choice;
        int choiceManufacturer;
        do {
            System.out.println("Chọn hãng muốn sửa: ");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                choiceManufacturer = Integer.parseInt(choice) - 1;
                if (check.isChoiceManufacturer(admin, iDepot, choiceManufacturer)) {
                    System.out.println("Nhập vào tên hãng mới: ");
                    String nameManufacturer = scanner.nextLine().toUpperCase();
                    admin.getDepotList().get(iDepot).getManufacturerList().get(choiceManufacturer).setNameManufacturer(nameManufacturer);
                    System.out.println("Đã thay đổi tên hãng!");
                    return;
                } else {
                    if (check.isCheckExitNow("bạn muốn tiếp tục không?")) {
                        System.out.println("Chọn không đúng!\n\tNhập lại: ");
                        menuManufacturer.showMenuManufacturer(admin, iDepot);
                    } else return;
                }
            } else {
                if (check.isCheckExitNow("Bạn muốn tiếp tục không?")) {
                    System.out.println("Nhập số đang hiển thị\n\tNhập lại: ");
                    menuManufacturer.showMenuManufacturer(admin, iDepot);
                } else return;
            }
        } while (true);
    }
    public void deleteDepot(Admin admin) {
        String choice;
        int choiceDelete;
        do {
            System.out.println("Chọn cửa hàng:");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)){
                choiceDelete = Integer.parseInt(choice) -1;
                if (check.isChoiceDepot(admin, choiceDelete)){
                    if (check.isCheckExitNow("Xác nhận: ")){
                        if (check.isCheckLogin(admin)){
                            admin.getDepotList().remove(choiceDelete);
                            System.out.println("Đã xóa cửa hàng !");
                        }else System.out.println("Không xóa !");
                    }else System.out.println("Không xóa !");
                    return;
                }else {
                    System.out.println("===== Thông báo  =====\n\tNhập số cửa hàng đang hiển thị trên màn hình!");
                    if (check.isCheckExitNow("Tiếp tục")){
                        System.out.println("Nhập lại: ");
                    }else {
                        return;
                    }
                }
            }else {
                System.out.println("===== Thông báo  =====\n\tNhập số cửa hàng đang hiển thị trên màn hình!");
                if (check.isCheckExitNow("Tiếp tục")){
                    System.out.println("Nhập lại: ");
                }else {
                    return;
                }
            }
        }while (true);

    }

    public void editDepot(Admin admin) {
        String choice;
        int choiceEdit;
        do {
            System.out.println("Chọn cửa hàng:");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)){
                choiceEdit = Integer.parseInt(choice) -1;
                if (check.isChoiceDepot(admin, choiceEdit)){
                    System.out.println("Tên cửa hàng mới: ");
                    String nameDepot = scanner.nextLine().toUpperCase();
                    System.out.println("Địa chỉ cửa hàng mới: ");
                    String addressDepot = scanner.nextLine().toUpperCase();
                    if (check.isCheckExitNow("Xác nhận: ")){
                        admin.getDepotList().get(choiceEdit).setNameDepot(nameDepot);
                        admin.getDepotList().get(choiceEdit).setAddressDepot(addressDepot);
                        System.out.println("Đã thay đổi !");
                    }else System.out.println("Không thay đổi !");
                    return;
                }else {
                    System.out.println("===== Thông báo  =====\n\tNhập số cửa hàng đang hiển thị trên màn hình!");
                    if (check.isCheckExitNow("Tiếp tục")){
                        System.out.println("Nhập lại: ");
                    }else {
                        return;
                    }
                }
            }else {
                System.out.println("===== Thông báo  =====\n\tNhập số cửa hàng đang hiển thị trên màn hình!");
                if (check.isCheckExitNow("Tiếp tục")){
                    System.out.println("Nhập lại: ");
                }else {
                    return;
                }
            }
        }while (true);

    }

    public void editMobile(Admin admin, int choiceDepot, int choiceManufacturer, ManageAdmin manageAdmin) {
        int lengthMobile = admin.getDepotList().get(choiceDepot).getManufacturerList().get(choiceManufacturer).getMobileList().size();
        if (lengthMobile == 0){
            System.out.println("=====  Thông báo  =====\n\tBạn chưa có điện thoại nào cần thêm ngay!!!");
            if (check.isCheckExitNow("Bạn có muốn thêm sản phẩm mới")){
                manageAdmin.initMobile(choiceManufacturer, choiceDepot);
            }
        } else {
            System.out.println("Chọn thiết bị: ");
            String choiceEdit = scanner.nextLine();
            int newChoiceEdit;
            if (check.isCheckNumber(choiceEdit)){
                newChoiceEdit = Integer.parseInt(choiceEdit) -1;
                if (check.isChoiceMobile(admin, choiceDepot, choiceManufacturer, newChoiceEdit)){
                    programEditProduct(choiceDepot, choiceManufacturer, newChoiceEdit, admin);
                    return;
                }else System.out.println("Chọn sai!\tBạn phải nhập thiết bị đang hiển thị");
                return;
            }
            if (!check.isCheckNumber(choiceEdit)){
                System.out.println("Chọn sai!\tBạn phải nhập thiết bị đang hiển thị");
            }
        }
    }

    public void deleteMobile(int iDepot, int iManufacture, Admin admin) {
        String choice;
        int choiceDelete;
        do {
            System.out.print("Chọn thiết bị xóa: \n");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                choiceDelete = Integer.parseInt(choice) - 1;
                if (check.isChoiceMobile(admin, iDepot, iManufacture, choiceDelete)) {
                    String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceDelete).getNameMobile();
                    String nameDepot = admin.getDepotList().get(iDepot).getNameDepot();
                    if (check.isCheckExitNow("Xác nhận xóa")){
                        admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(choiceDelete);
                        System.out.println("===== Thông báo =====\n\t-->>Đã xóa thiết bị " + nameProduct + " khỏi kho " + nameDepot);
                        return;
                    } else {
                        System.out.println("-->>Đã hủy lệnh xóa!");
                        if (check.isCheckExitNow("Bạn muốn tiếp tục không !")){
                            System.out.println("-->>Nhập lại: ");
                            continue;
                        }else return;
                    }
                }else {
                    System.out.println("Chọn sai!!!");
                    if (check.isCheckExitNow("Bạn muốn tiếp tục không !")){
                        System.out.println("-->>Nhập lại: ");
                        continue;
                    }else return;
                }
            }
            if (!check.isCheckNumber(choice)) {
                System.out.println("Nhập sai\n\t-->>Nhập số thiết bị đang hiển thị trên màn hình");
                if (check.isCheckExitNow("Bạn muốn tiếp tục không")) {
                    System.out.println("-->>Nhập lại!");
                } else break;
            }
        } while (true);

    }

    public void programEditProduct(int iDepot, int iManufacture, int iMobile, Admin admin){
        do {
            showMenuEditProduct();
            String choiceEditMobile = scanner.nextLine().toUpperCase();
            Mobile mobile = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile);
            switch (choiceEditMobile) {
                case "1":
                    editNameProduct(mobile);
                    return;
                case "2":
                    editIMEProduct(mobile);
                    return;
                case "3":
                    editPriceProduct(mobile);
                    return;
                case "4":
                    editAmountProduct(mobile);
                    return;
                case "5":
                    editAllInfoProduct(iDepot, iManufacture, iMobile, admin);
                    return;
                case "Q":
                    return;
                case "T":
                    if (check.isCheckExitNow("Xác nhận thoát")) {
                        System.exit(0);
                    }
                default:
                    System.out.println("===== Thông báo =====");
                    System.out.println("Nhập sai!");
            }
        }while (true);
    }

    public void editAmountProduct(Mobile mobile) {
        String choice;
        int amount;
        do {
            System.out.println("Nhập số lượng mới cho thiết bị.");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                amount = Integer.parseInt(choice);
                if (check.isCheckExitNow("Xác nhận thay đổi số lượng")) {
                    mobile.setAmountMobile(amount);
                    return;
                } else {
                    System.out.println("Số lượng chưa được thay đổi.");
                    return;
                }
            } else {
                System.out.println("Nhập sai !!!\nBạn phải nhập số");
                if (check.isCheckExitNow("Tiếp tục sửa số luợng")) {
                    System.out.println("Nhập lại: ");
                } else {
                    System.out.println("Số lượng chưa được thay đổi.");
                    break;
                }
            }
        } while (true);
    }

    public void editPriceProduct(Mobile mobile) {
        String choice;
        int price;
        do {
            System.out.println("Nhập giá mới cho thiết bị.");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                price = Integer.parseInt(choice);
                if (check.isCheckExitNow("Xác nhận thay đổi giá thiết bị")) {
                    mobile.setPriceMobile(price);
                    return;
                } else {
                    System.out.println("Giá chưa được thay đổi.");
                    return;
                }
            } else {
                System.out.println("Nhập sai !!!\nBạn phải nhập số");
                if (check.isCheckExitNow("Tiếp tục sửa giá")) {
                    System.out.println("Nhập lại: ");
                } else {
                    System.out.println("Giá chưa được thay đổi.");
                    return;
                }
            }

        } while (true);
    }

    public void editIMEProduct(Mobile mobile) {
        String choice;
        int ime;
        do {
            System.out.println("Nhập IME mới cho thiết bị.");
            choice = scanner.nextLine();
            if (check.isCheckNumber(choice)) {
                ime = Integer.parseInt(choice);
                if (check.isCheckExitNow("Xác nhận thay đổi IME")) {
                    mobile.setImeMobile(ime);
                    System.out.println("IME đã được thay đổi.");
                    return;
                } else {
                    System.out.println("IME chưa được thay đổi.");
                    return;
                }
            } else {
                System.out.println("=====  Thông báo  =====\n\tSố IME không hợp lệ!");
                if (check.isCheckExitNow("Tiếp tục")) {
                    System.out.println("Nhập lại!");
                } else {
                    System.out.println("IME chưa được thay đổi.");
                    return;
                }
            }
        } while (true);
    }

    public void editNameProduct(Mobile mobile) {
        System.out.println("Nhập tên mới cho thiết bị.");
        String name = scanner.nextLine().toUpperCase();
        if (check.isCheckExitNow("Xác nhận thay đổi tên")) {
            mobile.setNameMobile(name);
            System.out.println("Tên đã được thay đổi.");
        } else {
            System.out.println("Tên chưa được thay đổi.");
        }
    }

    public void showMenuEditProduct() {
        System.out.println("-->>Lựa chọn: ");
        System.out.println("      1.Sửa tên                                                                      ");
        System.out.println("      2.Sửa IME                                                                      ");
        System.out.println("      3.Sửa giá                                                                      ");
        System.out.println("      4.Sửa số lượng                                                                 ");
        System.out.println("      5.Sửa tất cả thông tin                                                             ");
        System.out.println("-->>Chức năng: ");
        System.out.print("        Điều hướng:\tQ.Quay lại\tT.Thoát\n");
    }

    public void editAllInfoProduct(int iDepot, int iManufacture, int choiceMobile, Admin admin) {
        do {
            System.out.println("Nhập tên mới cho thiết bị.                                         ");
            String name = scanner.nextLine().toUpperCase();
            System.out.println("Nhập IME mới cho thiết bị.                                         ");
            int ime = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập giá mới cho thiết bị.                                         ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nhập số lượng mới cho thiết bị.                                    ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            if (check.isCheckExitNow("Xác nhận thay đổi")) {
                admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceMobile).setNameMobile(name);
                admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceMobile).setImeMobile(ime);
                admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceMobile).setPriceMobile(price);
                admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(choiceMobile).setAmountMobile(amount);
                System.out.println("Đã thay đổi thông tin thiết bị.");
                return;
            } else {
                System.out.println("Đã hủy lệnh thông tin thiết bị chưa đựoc thay đổi.");
                return;
            }
        } while (true);
    }

    public void deleteProduct(int iDepot, int iManufacture, int iMobile, Admin admin) {
        String nameProduct = admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().get(iMobile).getNameMobile();
        String nameDepot = admin.getDepotList().get(iDepot).getNameDepot();
        if (check.isCheckExitNow("Xác nhận xóa")){
            admin.getDepotList().get(iDepot).getManufacturerList().get(iManufacture).getMobileList().remove(iMobile);
            System.out.println("===== Thông báo =====\n\tĐã xóa thiết bị " + nameProduct + "khỏi kho " + nameDepot);
        }else System.out.println("Chưa xóa thiết bị khỏi danh sách!");
    }
}
