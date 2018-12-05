package com.thealtening.api.service;

import com.thealtening.api.json.error.PrivateError;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PrivateService {

    @GET("/private?acctoken={account_token}")
    Call<PrivateError> privateAccount(@Path("account_token") String accountToken);
}
