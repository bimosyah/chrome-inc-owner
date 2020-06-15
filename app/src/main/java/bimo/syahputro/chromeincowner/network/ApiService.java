package bimo.syahputro.chromeincowner.network;


import bimo.syahputro.chromeincowner.network.responses.DashboardResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("inventory/daftartInventory")
    Call<DashboardResponse> dashboard();

}
