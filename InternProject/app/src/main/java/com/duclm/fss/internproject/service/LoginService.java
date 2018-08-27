package com.duclm.fss.internproject.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginAccount (@Field("username") String username,
                                     @Field("password") String password);
}
