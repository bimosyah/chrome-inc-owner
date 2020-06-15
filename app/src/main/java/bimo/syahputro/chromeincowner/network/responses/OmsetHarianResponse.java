package bimo.syahputro.chromeincowner.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import bimo.syahputro.chromeincowner.network.entity.Omset;

public class OmsetHarianResponse {
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("omset")
    private List<Omset> omset = null;

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

    public List<Omset> getOmset() {
        return omset;
    }

    public void setOmset(List<Omset> omset) {
        this.omset = omset;
    }

}
