/*
 * Copyright (C) 2019 TheAltening
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.thealtening.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thealtening.api.data.AccountData;
import com.thealtening.api.data.LicenseData;
import com.thealtening.api.utils.HttpUtils;
import com.thealtening.api.utils.exceptions.TheAlteningException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class TheAltening extends HttpUtils {

    private final String apiKey;
    private final String endpoint = "http://api.thealtening.com/v1/";
    private final Logger logger = Logger.getLogger("TheAltening");
    private final Gson gson = new Gson();

    public TheAltening(String apiKey) {
        this.apiKey = apiKey;
    }

    public LicenseData getLicenseData() throws TheAlteningException {
        try {
            final String connectionData = connect(endpoint + "license?token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(connectionData, JsonObject.class);
            if (jsonObject == null) {
                throw new TheAlteningException("JSON", "Unable to parse JSON data, here's what is in there: \n" + connectionData);
            }
            if (jsonObject.has("error") && jsonObject.has("errorMessage")) {
                throw new TheAlteningException(jsonObject.get("error").getAsString(), jsonObject.get("errorMessage").getAsString());
            } else {
                return gson.fromJson(jsonObject, LicenseData.class);
            }
        } catch (IOException e) {
            throw new TheAlteningException("IOException", "Unable to establish a connection, here's why: \n" + e.getCause());
        }
    }

    public AccountData getAccountData() throws TheAlteningException {
        try {
            final String connectionData = connect(endpoint + "generate?info=true&token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(connectionData, JsonObject.class);
            if (jsonObject == null) {
                throw new TheAlteningException("JSON", "Unable to parse JSON data, here's what is in there: \n" + connectionData);
            }
            if (jsonObject.has("error") && jsonObject.has("errorMessage")) {
                throw new TheAlteningException(jsonObject.get("error").getAsString(), jsonObject.get("errorMessage").getAsString());
            } else {
                return gson.fromJson(jsonObject, AccountData.class);
            }
        } catch (IOException e) {
            throw new TheAlteningException("IOException", "Unable to establish a connection, here's why: \n" + e.getCause());
        }
    }

    public boolean isPrivate(String token) throws TheAlteningException {
        try {
            final String connectionData = connect(endpoint + "private?acctoken=" + token + "&token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(connectionData, JsonObject.class);
            if (jsonObject == null) {
                throw new TheAlteningException("JSON", "Unable to parse JSON data, here's what is in there: \n" + connectionData);
            }
            if (jsonObject.has("success")) {
                return jsonObject.get("success").getAsBoolean();
            } else if (jsonObject.has("error") && jsonObject.has("errorMessage")) {
                throw new TheAlteningException(jsonObject.get("error").getAsString(), jsonObject.get("errorMessage").getAsString());
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new TheAlteningException("IOException", "Unable to establish a connection, here's why: \n" + e.getCause());
        }
    }

    public boolean isFavorite(String token) throws TheAlteningException {
        try {
            final String connectionData = connect(endpoint + "favorite?acctoken=" + token + "&token=" + apiKey);
            final JsonObject jsonObject = gson.fromJson(connectionData, JsonObject.class);
            if (jsonObject == null) {
                throw new TheAlteningException("JSON", "Unable to parse JSON data, here's what is in there: \n" + connectionData);
            }
            if (jsonObject.has("success")) {
                return jsonObject.get("success").getAsBoolean();
            } else if (jsonObject.has("error") && jsonObject.has("errorMessage")) {
                throw new TheAlteningException(jsonObject.get("error").getAsString(), jsonObject.get("errorMessage").getAsString());
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new TheAlteningException("IOException", "Unable to establish a connection, here's why: \n" + e.getCause());
        }
    }

    public static class Asynchronous {
        private final TheAltening instance;

        public Asynchronous(TheAltening instance) {
            this.instance = instance;
        }

        public CompletableFuture<LicenseData> getLicenseData() {
            CompletableFuture<LicenseData> returnValue = new CompletableFuture<>();
            try {
                returnValue.complete(instance.getLicenseData());
            } catch (TheAlteningException exception) {
                returnValue.completeExceptionally(exception);
            }
            return returnValue;
        }

        public CompletableFuture<AccountData> getAccountData() {
            CompletableFuture<AccountData> returnValue = new CompletableFuture<>();
            try {
                returnValue.complete(instance.getAccountData());
            } catch (TheAlteningException exception) {
                returnValue.completeExceptionally(exception);
            }
            return returnValue;
        }

        public CompletableFuture<Boolean> isPrivate(String token) {
            CompletableFuture<Boolean> returnValue = new CompletableFuture<>();
            try {
                returnValue.complete(instance.isPrivate(token));
            } catch (TheAlteningException exception) {
                returnValue.completeExceptionally(exception);
            }
            return returnValue;
        }

        public CompletableFuture<Boolean> isFavorite(String token) {
            CompletableFuture<Boolean> returnValue = new CompletableFuture<>();
            try {
                returnValue.complete(instance.isFavorite(token));
            } catch (TheAlteningException exception) {
                returnValue.completeExceptionally(exception);
            }
            return returnValue;
        }
    }
}
