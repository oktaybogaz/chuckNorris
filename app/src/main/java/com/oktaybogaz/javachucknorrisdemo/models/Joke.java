package com.oktaybogaz.javachucknorrisdemo.models;

import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("value")
    private String value;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
