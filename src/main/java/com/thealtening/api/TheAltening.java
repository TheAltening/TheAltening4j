package com.thealtening.api;

import com.thealtening.api.json.AccountInfo;
import com.thealtening.api.json.LicenseInfo;
import com.thealtening.api.json.error.FavoriteError;
import com.thealtening.api.json.error.PrivateError;
import com.thealtening.api.service.AccountService;
import com.thealtening.api.service.FavoriteService;
import com.thealtening.api.service.LicenseService;
import com.thealtening.api.service.PrivateService;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;

public class TheAltening {
    private final Retrofit retrofit;
    private final String apiKey;

    private TheAltening() {
        this("");
    }

    private TheAltening(String apiKey) {
        this.apiKey = apiKey;
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", apiKey)
                    .build();
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }).build();
        retrofit = new Retrofit.Builder().client(httpClient).addConverterFactory(MoshiConverterFactory.create()).build();
    }

    public boolean favoriteAccount(AccountInfo accountInfo) throws IOException {
        return this.favoriteAccount(accountInfo.getToken());
    }

    public boolean favoriteAccount(String token) throws IOException {
        final LicenseInfo licenseInfo = getLicenseInfo();

        if (licenseInfo.isPremium() && licenseInfo.getPremiumName().equals("premium")) {
            final FavoriteService favoriteService = retrofit.create(FavoriteService.class);
            final Call<FavoriteError> favoriteServiceCall = favoriteService.favoriteAccount(token);
            final Response<FavoriteError> favoriteErrorResponse = favoriteServiceCall.execute();
            if (!favoriteErrorResponse.isSuccessful())
                return false;
            if (favoriteErrorResponse.raw().body() == null)
                return false;
            if (favoriteErrorResponse.raw().body().string().contains("[ERROR]Already private."))
                return false;
            if (favoriteErrorResponse.body() == null)
                return false;
            return favoriteErrorResponse.body().isSuccessful();
        }
        return false;
    }

    public boolean privateAccount(AccountInfo accountInfo) throws IOException {
        return this.privateAccount(accountInfo.getToken());
    }

    public boolean privateAccount(String token) throws IOException {
        final LicenseInfo licenseInfo = getLicenseInfo();

        if (licenseInfo.isPremium() && licenseInfo.getPremiumName().equals("premium")) {
            final PrivateService privateService = retrofit.create(PrivateService.class);
            final Call<PrivateError> privateServiceCall = privateService.privateAccount(token);
            final Response<PrivateError> privateErrorResponse = privateServiceCall.execute();
            if (!privateErrorResponse.isSuccessful())
                return false;
            if (privateErrorResponse.raw().body() == null)
                return false;
            if (privateErrorResponse.raw().body().string().contains("[ERROR]Already private."))
                return false;
            if (privateErrorResponse.body() == null)
                return false;
            return privateErrorResponse.body().isSuccessful();
        }
        return false;
    }

    public LicenseInfo getLicenseInfo() throws IOException {
        final LicenseService licenseService = retrofit.create(LicenseService.class);
        final Call<LicenseInfo> licenseInfoCall = licenseService.getLicense();
        final Response<LicenseInfo> licenseInfoResponse = licenseInfoCall.execute();
        return licenseInfoResponse.isSuccessful() ? licenseInfoResponse.body() : LicenseInfo.EMPTY;
    }

    public AccountInfo getAccountInfo() throws IOException {
        if(!getLicenseInfo().isPremium())
            return AccountInfo.EMPTY;
        final AccountService accountService = retrofit.create(AccountService.class);
        final Call<AccountInfo> accountInfoCall = accountService.getLicense();
        final Response<AccountInfo> accountInfoResponse = accountInfoCall.execute();
        return accountInfoResponse.isSuccessful() ? accountInfoResponse.body() : AccountInfo.EMPTY;
    }

    public static class Builder {
        private String apiKey = "";


        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public TheAltening build() {
            return new TheAltening(apiKey);
        }

    }

}
