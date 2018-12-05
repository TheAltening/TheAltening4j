package com.thealtening.api.service;

import com.thealtening.api.json.LicenseInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LicenseService {
    @GET("/license")
    Call<LicenseInfo> getLicense();
}


