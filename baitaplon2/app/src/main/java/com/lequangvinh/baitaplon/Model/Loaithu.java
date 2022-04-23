package com.lequangvinh.baitaplon.Model;

public class Loaithu {
    String loaithu;
    int idthu;

    public int getIdthu() {
        return idthu;
    }
    public void setLoaithu(String loaithu){
        this.loaithu=loaithu;

    }

    public String getLoaithu() {
        return loaithu;
    }
    public void setIdthu(int idthu){
        this.idthu=idthu;
    }
    public Loaithu(String loaithu,int idthu){
        this.loaithu=loaithu;
        this.idthu=idthu;
    }
}
