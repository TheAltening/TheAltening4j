package com.thealtening.api.service;

import com.thealtening.api.json.AccountInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountService {

    @GET("/generate")
    Call<AccountInfo> getLicense();
}
