package bimo.syahputro.chromeincowner.ui.message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import bimo.syahputro.chromeincowner.network.ApiClient;
import bimo.syahputro.chromeincowner.network.ApiService;
import bimo.syahputro.chromeincowner.network.responses.MessageResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageViewModel extends ViewModel {

    private MutableLiveData<MessageResponse> liveData;
    private ApiService apiService;

    private void loadData() {
        apiService = ApiClient.getClient().create(ApiService.class);
        apiService.loadMessage().enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<MessageResponse> getMessage() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }
}