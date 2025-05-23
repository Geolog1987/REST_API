package ru.kodanev.aleksey.RERT_API_Invite_PAY;
//Напишем класс запроса платежа:
public class PaymentRequest {

    private int userId;
    private String itemID;
    private double discount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
