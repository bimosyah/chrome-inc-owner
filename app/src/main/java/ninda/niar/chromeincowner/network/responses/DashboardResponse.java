package ninda.niar.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse {
    @SerializedName("jumlah_transaksi")
    private String jumlahTransaksi;
    @SerializedName("jumlah_selesai")
    private String jumlahSelesai;
    @SerializedName("jumlah_dikerjakan")
    private String jumlahDikerjakan;
    @SerializedName("jumlah_menunggu")
    private String jumlahMenunggu;

    public String getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(String jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getJumlahSelesai() {
        return jumlahSelesai;
    }

    public void setJumlahSelesai(String jumlahSelesai) {
        this.jumlahSelesai = jumlahSelesai;
    }

    public String getJumlahDikerjakan() {
        return jumlahDikerjakan;
    }

    public void setJumlahDikerjakan(String jumlahDikerjakan) {
        this.jumlahDikerjakan = jumlahDikerjakan;
    }

    public String getJumlahMenunggu() {
        return jumlahMenunggu;
    }

    public void setJumlahMenunggu(String jumlahMenunggu) {
        this.jumlahMenunggu = jumlahMenunggu;
    }
}
