package com.thealtening.api.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thealtening.api.user.User;

/**
 * @author trol
 * @since 10/27/18
 */
public class Account {

    private User user;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("limit")
    @Expose
    private boolean limit;

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLimit() {
        return limit;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
