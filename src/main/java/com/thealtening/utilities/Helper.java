package com.thealtening.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thealtening.api.user.UserKey;

/**
 * @author trol
 * @since 10/27/18
 */
public class Helper {

    private static final Helper INSTANCE = new Helper();
    public final String THEALTENING_API = "http://api.thealtening.com/v1/";

    public final String GENERATE_ENDPOINT = THEALTENING_API + "generate";
    public final String LICENSE_ENDPOINT = THEALTENING_API + "license";
    public final String AUTHSERVER_THEALTENING = "158.69.199.196";
    public final Gson GSON = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    public String attachApiKey(String url, UserKey key) {
        return url + "?token=" + key.getApiKey();
    }

    public static Helper getInstance() {
        return INSTANCE;
    }
}
