package com.aryan.virtualtrading.api;

import com.aryan.virtualtrading.models.UserModel;
import com.aryan.virtualtrading.response.ImageResponse;
import com.aryan.virtualtrading.response.TokenResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface UserAPI {

    @POST("users/register")
    Call<TokenResponse> register(@Body UserModel users);

//    @POST("users/login")
//    Call<TokenResponse> login(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);


    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadProfile(@Part MultipartBody.Part img);

    @GET("users/profile")
    Call<UserModel> getUserProfile(@Header("Authorization")String token);

    @PUT("users/profile")
    Call<UserModel> updateProfile(@Header("Authorization")String token, @Body UserModel users);

    @FormUrlEncoded
    @PUT("users/changePassword")
    Call<Void> changePassword(@Header("Authorization")String token, @Field("password") String password);

    @FormUrlEncoded
    @POST("users/checkPassword")
    Call<Void> checkPassword(@Header("Authorization")String token, @Field("password") String password);
}
