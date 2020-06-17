package bimo.syahputro.chromeincowner.network;


import bimo.syahputro.chromeincowner.network.responses.DashboardResponse;
import bimo.syahputro.chromeincowner.network.responses.LoginResponse;
import bimo.syahputro.chromeincowner.network.responses.MessageResponse;
import bimo.syahputro.chromeincowner.network.responses.MessageSentResponse;
import bimo.syahputro.chromeincowner.network.responses.OmsetHarianResponse;
import bimo.syahputro.chromeincowner.network.responses.TransaksiHarianResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("data/dashboard")
    Call<DashboardResponse> dashboard();

    @GET("data/omsetHarian")
    Call<OmsetHarianResponse> omsetHarian();

    @GET("data/transaksiHarian")
    Call<TransaksiHarianResponse> transaksiHarian();

    @GET("message/loadMessage")
    Call<MessageResponse> loadMessage();

    @FormUrlEncoded
    @POST("message/sentMessage")
    Call<MessageSentResponse> sentMessage(@Field("message") String message);

    @FormUrlEncoded
    @POST("login/dologin")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );
}
