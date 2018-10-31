package com.thealtening.process.processes;

import com.google.gson.Gson;
import com.thealtening.api.account.Account;
import com.thealtening.api.user.User;
import com.thealtening.process.Process;
import com.thealtening.utilities.Helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author trol
 * @since 10/27/18
 */
public class GeneratingAccountProcess extends Process {
    private final User user;
    private Account account;

    public GeneratingAccountProcess(User user) {
        this.user = user;
    }
    @Override
    public void run() {
        final Gson gson = Helper.getInstance().GSON;
        try {
            URL url = new URL(Helper.getInstance().attachApiKey(Helper.getInstance().GENERATE_ENDPOINT, user.getKey()));
            account = gson.fromJson(new InputStreamReader(url.openStream()), Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Account getAccount() {
        return account;
    }
}
