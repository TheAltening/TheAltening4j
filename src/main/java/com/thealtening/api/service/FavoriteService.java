package com.thealtening.api.service;

import com.thealtening.api.json.error.FavoriteError;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FavoriteService {

    @GET("/favorite?acctoken={account_token}")
    Call<FavoriteError> favoriteAccount( @Path("account_token") String accountToken);
}
