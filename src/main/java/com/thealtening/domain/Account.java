package com.thealtening.domain;


import com.google.gson.annotations.SerializedName;

/**
 * @author Trol
 * @since 11:57 AM, 11/19/18
 */

public class Account {
    @SerializedName("token")
    private String token;

    @SerializedName(("username"))
    private String username;

    @SerializedName("expires")
    private String expiryDate;

    @SerializedName("limit")
    private boolean isLimitReached;

    @SerializedName("skin")
    private String skinHash;

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean isLimitReached() {
        return isLimitReached;
    }

    public String getSkinHash() {
        return skinHash;
    }
}
