package menuStatistical;

import admin.Admin;
import menu.ManageAdmin;

public class MenuStatistical {
    public void program(ManageAdmin manageAdmin) {
        Admin admin = manageAdmin.getAdmin();
        int sumPrice = 0;
        int sumMobile = 0;
        int sumDepot = 0;
        int sumMan = 0;

        do {
            for (int i = 0; i < admin.getDepotList().size(); i++) {
                sumDepot++;
                for (int j = 0; j < admin.getDepotList().get(i).getManufacturerList().size(); j++) {
                    sumMan++;
                    for (int k = 0; k < admin.getDepotList().get(i).getManufacturerList().get(j).getMobileList().size(); k++) {
                        sumPrice += (admin.getDepotList().get(i).getManufacturerList().get(j).getMobileList().get(k).getPriceMobile())
                                * (admin.getDepotList().get(i).getManufacturerList().get(j).getMobileList().get(k).getAmountMobile());
                        sumMobile++;
                    }
                }
            }

            System.out.println("=====  Số luợng  =====");
            System.out.println("\tSản phẩm: " + (sumMobile));
            System.out.println("\tCửa hàng : " + sumDepot);
            System.out.println("\tNhãn hàng: " + sumMan);
            System.out.println("=====  Tài sản  =====");
            System.out.println("\tChưa thuế chưa lãi: " + sumPrice);
            return;
        } while (true);

    }
}
