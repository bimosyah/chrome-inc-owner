package ninda.niar.chromeincowner.ui.message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ninda.niar.chromeincowner.network.ApiClient;
import ninda.niar.chromeincowner.network.ApiService;
import ninda.niar.chromeincowner.network.responses.MessageResponse;
import ninda.niar.chromeincowner.network.responses.MessageSentResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageViewModel extends ViewModel {

    private MutableLiveData<MessageResponse> liveData;
    private ApiService apiService = ApiClient.getClient().create(ApiService.class);;

    private void loadData() {
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

    public void sentMessage(String message){
        apiService.sentMessage(message).enqueue(new Callback<MessageSentResponse>() {
            @Override
            public void onResponse(Call<MessageSentResponse> call, Response<MessageSentResponse> response) {

            }

            @Override
            public void onFailure(Call<MessageSentResponse> call, Throwable t) {

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