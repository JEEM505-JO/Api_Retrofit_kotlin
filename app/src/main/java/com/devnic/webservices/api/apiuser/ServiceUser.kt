package com.devnic.webservices.api.apiuser

import com.devnic.webservices.model.Users.HeadUser
import com.devnic.webservices.model.Users.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceUser {

    @GET("users")
    fun getAllData() : Call<HeadUser>

    @POST("users")
    fun sedUser(@Body user: User) : Call<User>
}