package com.thealtening.domain;

import com.google.gson.annotations.SerializedName;

/**
 * @author Trol
 * @since 11:57 AM, 11/19/18
 */

public class User {

    @SerializedName("username")
    private String username;

    @SerializedName("premium")
    private boolean premium;

    @SerializedName("premium_name")
    private String premiumName;

    @SerializedName("expires")
    private String expiryDate;

    public String getUsername() {
        return username;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getPremiumName() {
        return premiumName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
