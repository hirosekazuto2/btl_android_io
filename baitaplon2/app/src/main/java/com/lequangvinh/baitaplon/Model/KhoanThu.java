package com.lequangvinh.baitaplon.Model;

public class KhoanThu {
    String khoanthu;
    int idthu;
    public String getKhoanthu(){
        return khoanthu;
    }
    public void setKhoanthu(String khoanthu) {
        this.khoanthu = khoanthu;
    }

    public int getIdthu() {
        return idthu;
    }

    public void setIdthu(int idthu) {
        this.idthu = idthu;
    }
    public KhoanThu(String khoanthu,int idthu){
        this.khoanthu=khoanthu;
        this.idthu=idthu;
    }
}
