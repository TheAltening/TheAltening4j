package com.thealtening.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author trol
 * @since 10/27/18
 */
public class User {
    @Expose
    @SerializedName("username")
    private String name;
    @Expose
    @SerializedName("premium")
    private boolean hasPremium;
    @Expose
    @SerializedName("premium_name")
    private String subscriptionName;
    @Expose
    @SerializedName("expires")
    private String expiryDate;

    private UserKey key;
    public User() {

    }
    public User(String name, boolean hasPremium, String subscriptionName, String expiryDate, UserKey key) {
        this.name = name;
        this.hasPremium = hasPremium;
        this.subscriptionName = subscriptionName;
        this.expiryDate = expiryDate;
        this.key = key;
    }


    public String getName() {
        return name;
    }

    public boolean hasPremium() {
        return hasPremium;
    }

    public String getSubscriptionType() {
        return subscriptionName;
    }

    public SubscriptionType getSubscriptionTypeAsEnum() {
        return SubscriptionType.valueOf(subscriptionName.toUpperCase());
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public UserKey getKey() {
        return key;
    }

    public void setKey(UserKey key) {
        this.key = key;
    }
}
