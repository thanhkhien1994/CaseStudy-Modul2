package admin;

import java.io.Serializable;

public class Mobile implements Serializable {
    static int stt;
    private int id;
    private String mobileStyle;
    private String nameMobile;
    private int imeMobile;
    private double priceMobile;
    private int amountMobile;

    public Mobile(String mobileStyle, String nameMobile, int imeMobile, double priceMobile, int amountMobile) {
        this.mobileStyle = mobileStyle;
        this.nameMobile = nameMobile;
        this.imeMobile = imeMobile;
        this.priceMobile = priceMobile;
        this.amountMobile = amountMobile;
        this.id = ++stt;
    }

    public int getId() {
        return id;
    }

    public String getMobileStyle() {
        return mobileStyle;
    }

    public void setMobileStyle(String mobileStyle) {
        this.mobileStyle = mobileStyle;
    }

    public String getNameMobile() {
        return nameMobile;
    }

    public void setNameMobile(String nameMobile) {
        this.nameMobile = nameMobile;
    }

    public int getImeMobile() {
        return imeMobile;
    }

    public void setImeMobile(int imeMobile) {
        this.imeMobile = imeMobile;
    }

    public double getPriceMobile() {
        return priceMobile;
    }

    public void setPriceMobile(double priceMobile) {
        this.priceMobile = priceMobile;
    }

    public int getAmountMobile() {
        return amountMobile;
    }

    public void setAmountMobile(int amountMobile) {
        this.amountMobile = amountMobile;
    }

    @Override
    public String toString() {
        return "=====  Mobile info  =====\n" +
                "\tStyle product: " + mobileStyle + '\n' +
                "\tName product: '" + nameMobile + '\n' +
                "\tIME product: " + imeMobile + '\n' +
                "\tPrice product: " + priceMobile + '\n' +
                "\tAmount product: " + amountMobile + '\n'
                ;
    }
}
