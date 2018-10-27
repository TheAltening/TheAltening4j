package com.thealtening.api.user;

/**
 * @author trol
 * @since 10/27/18
 */
public class UserKey {

    private final String API_KEY;


    public UserKey(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getApiKey() {
        return API_KEY;
    }
}
