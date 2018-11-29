package com.thealtening;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.istack.internal.Nullable;
import com.thealtening.domain.Account;
import com.thealtening.domain.User;
import com.thealtening.utils.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Trol
 * @since 11:57 AM, 11/19/18
 */

public final class TheAltening {
    private final String apiKey;
    private final String website = "http://api.thealtening.com/v1/";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public TheAltening(final String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @return the object user and the value
     */
    public User getUser() throws IOException {
        final URLConnection licenseEndpoint = new URL(attach(this.website + "license")).openConnection();
        final String userInfo = new String(Utilities.getInstance().readAllBytes(licenseEndpoint.getInputStream()));
        return gson.fromJson(userInfo, User.class);
    }

    /**
     * Generates an account
     *
     * @return account
     */

    public Account generateAccount(User user) throws IOException {
        final URLConnection generateEndpoint = new URL(attach(this.website + "generate")).openConnection();

        final String accountInfo = new String(Utilities.getInstance().readAllBytes(generateEndpoint.getInputStream()));
        if (user.isPremium())
            return gson.fromJson(accountInfo, Account.class);
        return null;
    }

    /**
     * Adds the account to the favorite list.
     *
     * @param account
     * @return
     * @throws IOException
     */
    public boolean favoriteAccount(Account account) throws IOException {
        final URLConnection favoriteAccount = new URL(attachAccount(this.website + "favorite", account)).openConnection();
        final String info = new String(Utilities.getInstance().readAllBytes(favoriteAccount.getInputStream()));
        return info.isEmpty();
    }

    /**
     * Adds the account to the private list
     *
     * @param account
     * @return
     * @throws IOException
     */
    public boolean privateAccount(Account account) throws IOException {
        final URLConnection privateAccount = new URL(attachAccount(this.website + "private", account)).openConnection();
        final String info = new String(Utilities.getInstance().readAllBytes(privateAccount.getInputStream()));
        return info.isEmpty();
    }

    /**
     * Lazy way of adding a token to the website String
     *
     * @param website
     * @return the website with the token attached
     */
    private String attach(final String website) {
        return website + "?token=" + apiKey;
    }

    /**
     * Lazy way of adding a token and account token to the website String
     *
     * @param website
     * @param account for getting the token
     * @return the website with the token and account attached
     */
    private String attachAccount(final String website, final Account account) {
        return website + "?token=" + apiKey + "&acctoken=" + account.getToken();
    }


}
