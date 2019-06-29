package com.thealtening.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thealtening.api.data.AccountData;
import com.thealtening.api.data.LicenseData;
import com.thealtening.api.utils.HttpUtils;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class TheAltening {

    private final String apiKey;
    private final String endpoint = "http://api.thealtening.com/v1/";
    private final Logger logger = Logger.getLogger("TheAltening");
    private final Gson gson = new Gson();

    public TheAltening(String apiKey) {
        this.apiKey = apiKey;
    }

    public LicenseData getLicenseData() {
        try {
            final String urlRead = HttpUtils.readURLToString(endpoint + "license?token=" + apiKey);
            final LicenseData data = gson.fromJson(urlRead, LicenseData.class);
            return data;
        } catch (IOException e) {
            if(e.getMessage().contains("401")) {
                logger.info("Invalid API Key provided");
            } else {
                logger.info("Failed to communicate with the website. Try again later");

            }
            return null;
        }
    }
    public AccountData getAccountData() {
        try {
            final String urlRead = HttpUtils.readURLToString(endpoint + "generate?info=true&token=" + apiKey);
            final AccountData data = gson.fromJson(urlRead, AccountData.class);
            return data;
        } catch (IOException e) {
            if(e.getMessage().contains("401")) {
                logger.info("Invalid API Key provided");
            } else {
                logger.info("Failed to communicate with the website. Try again later");

            }
            return null;
        }
    }
    public boolean privateAccount(String token) {
        try {
            final String urlRead = HttpUtils.readURLToString(endpoint + "private?acctoken="+token+"&token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(urlRead, JsonObject.class);
            if(jsonObject.has("success"))
                return jsonObject.get("success").getAsBoolean();
            return false;
        } catch (IOException e) {
            if(e.getMessage().contains("401")) {
                logger.info("Invalid API Key provided");
            } else {
                logger.info("Failed to communicate with the website. Try again later");

            }
            return false;
        }
    }

    public boolean favoriteAccount(String token) {
        try {
            final String urlRead = HttpUtils.readURLToString(endpoint + "favorite?acctoken="+token+"&token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(urlRead, JsonObject.class);
            if(jsonObject.has("success"))
                return jsonObject.get("success").getAsBoolean();
            return false;
        } catch (IOException e) {
            if(e.getMessage().contains("401")) {
                logger.info("Invalid API Key provided");
            } else {
                logger.info("Failed to communicate with the website. Try again later");

            }
            return false;
        }
    }
    public static class Asynchronous {
        private TheAltening theAltening;

        public Asynchronous(TheAltening theAltening) {
            this.theAltening = theAltening;
        }

        public CompletableFuture<LicenseData> getLicenseData() {
            return CompletableFuture.supplyAsync(theAltening::getLicenseData);
        }

        public CompletableFuture<AccountData> getAccountData() {
            return CompletableFuture.supplyAsync(theAltening::getAccountData);
        }
        public CompletableFuture<Boolean> privateAccount(String token) {
            return CompletableFuture.supplyAsync(() -> theAltening.privateAccount(token));
        }
        public CompletableFuture<Boolean> favoriteAccount(String token) {
            return CompletableFuture.supplyAsync(() -> theAltening.favoriteAccount(token));
        }
    }
}
