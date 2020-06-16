package bimo.syahputro.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import bimo.syahputro.chromeincowner.network.entity.Message;

public class MessageResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("chat")
    private List<Message> chat = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Message> getChat() {
        return chat;
    }

    public void setChat(List<Message> chat) {
        this.chat = chat;
    }
}
