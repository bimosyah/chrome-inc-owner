package ninda.niar.chromeincowner.ui.transaksiharian;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ninda.niar.chromeincowner.network.ApiClient;
import ninda.niar.chromeincowner.network.ApiService;
import ninda.niar.chromeincowner.network.responses.TransaksiHarianResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransaksiHarianViewModel extends ViewModel {

    private MutableLiveData<TransaksiHarianResponse> liveData;
    private ApiService apiService;

    private void loadData() {
        apiService = ApiClient.getClient().create(ApiService.class);
        apiService.transaksiHarian().enqueue(new Callback<TransaksiHarianResponse>() {
            @Override
            public void onResponse(Call<TransaksiHarianResponse> call, Response<TransaksiHarianResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<TransaksiHarianResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<TransaksiHarianResponse> getTransaksiHarian() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }

}