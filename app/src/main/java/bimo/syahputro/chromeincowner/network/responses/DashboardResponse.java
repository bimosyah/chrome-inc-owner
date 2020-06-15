package bimo.syahputro.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse {
    @SerializedName("jumlah_transaksi")
    private Integer jumlahTransaksi;
    @SerializedName("jumlah_selesai")
    private Integer jumlahSelesai;
    @SerializedName("jumlah_dikerjakan")
    private Integer jumlahDikerjakan;
    @SerializedName("jumlah_menunggu")
    private Integer jumlahMenunggu;

    public Integer getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(Integer jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public Integer getJumlahSelesai() {
        return jumlahSelesai;
    }

    public void setJumlahSelesai(Integer jumlahSelesai) {
        this.jumlahSelesai = jumlahSelesai;
    }

    public Integer getJumlahDikerjakan() {
        return jumlahDikerjakan;
    }

    public void setJumlahDikerjakan(Integer jumlahDikerjakan) {
        this.jumlahDikerjakan = jumlahDikerjakan;
    }

    public Integer getJumlahMenunggu() {
        return jumlahMenunggu;
    }

    public void setJumlahMenunggu(Integer jumlahMenunggu) {
        this.jumlahMenunggu = jumlahMenunggu;
    }
}
