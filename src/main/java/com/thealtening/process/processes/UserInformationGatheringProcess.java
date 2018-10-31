package com.thealtening.process.processes;

import com.google.gson.Gson;
import com.thealtening.api.user.User;
import com.thealtening.api.user.UserKey;
import com.thealtening.process.Process;
import com.thealtening.utilities.Helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author trol
 * @since 10/27/18
 */
public class UserInformationGatheringProcess extends Process {
    private final UserKey key;
    private User user;

    public UserInformationGatheringProcess(UserKey key) {
        this.key = key;
    }

    public void run() {
        final Gson gson = Helper.getInstance().GSON;
        try {
            URL url = new URL(Helper.getInstance().attachApiKey(Helper.getInstance().LICENSE_ENDPOINT, key));
            user = gson.fromJson(new InputStreamReader(url.openStream()), User.class);
            user.setKey(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser() {
        return user;
    }
}
