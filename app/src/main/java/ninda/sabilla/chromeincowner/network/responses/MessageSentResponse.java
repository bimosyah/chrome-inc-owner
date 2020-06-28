package ninda.sabilla.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

public class MessageSentResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private Integer message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }
}
