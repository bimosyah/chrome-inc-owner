package bimo.syahputro.chromeincowner.network;


import bimo.syahputro.chromeincowner.network.responses.DashboardResponse;
import bimo.syahputro.chromeincowner.network.responses.OmsetHarianResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("data/dashboard")
    Call<DashboardResponse> dashboard();

    @GET("data/omsetHarian")
    Call<OmsetHarianResponse> omsetHarian();
}
