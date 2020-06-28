package ninda.sabilla.chromeincowner.network.entity;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    private String id;
    @SerializedName("sender")
    private String sender;
    @SerializedName("message")
    private String message;
    @SerializedName("timestamp")
    private String timestamp;

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
