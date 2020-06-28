package ninda.sabilla.chromeincowner.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ninda.sabilla.chromeincowner.network.ApiClient;
import ninda.sabilla.chromeincowner.network.ApiService;
import ninda.sabilla.chromeincowner.network.responses.DashboardResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<DashboardResponse> liveData;
    private ApiService apiService;

    private void loadData(){
        apiService = ApiClient.getClient().create(ApiService.class);
        apiService.dashboard().enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.isSuccessful()){
                    if (response.body()!= null){
                        liveData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<DashboardResponse> getDashboard() {
        if (liveData == null){
            liveData = new MutableLiveData<>();
            loadData();
        }
        return liveData;
    }
}