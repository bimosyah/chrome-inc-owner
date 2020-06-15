package bimo.syahputro.chromeincowner.network.entity;

import com.google.gson.annotations.SerializedName;

public class Omset {
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("jumlah")
    private String jumlah;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

}
