package bimo.syahputro.chromeincowner.ui.omsetharian;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import bimo.syahputro.chromeincowner.network.ApiClient;
import bimo.syahputro.chromeincowner.network.ApiService;
import bimo.syahputro.chromeincowner.network.responses.OmsetHarianResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OmsetHarianViewModel extends ViewModel {

    private MutableLiveData<OmsetHarianResponse> liveData;
    private ApiService apiService;

    private void loadData() {
        apiService = ApiClient.getClient().create(ApiService.class);
        apiService.omsetHarian().enqueue(new Callback<OmsetHarianResponse>() {
            @Override
            public void onResponse(Call<OmsetHarianResponse> call, Response<OmsetHarianResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<OmsetHarianResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<OmsetHarianResponse> getOmsetHarian() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }
}