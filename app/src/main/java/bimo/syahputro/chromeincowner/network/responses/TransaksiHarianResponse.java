package bimo.syahputro.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import bimo.syahputro.chromeincowner.network.entity.Omset;
import bimo.syahputro.chromeincowner.network.entity.Transaksi;

public class TransaksiHarianResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("transaksi")
    private List<Transaksi> transaksiList = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Transaksi> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<Transaksi> transaksiList) {
        this.transaksiList = transaksiList;
    }
}
