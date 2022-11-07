package com.devnic.webservices.api.apirm

import com.devnic.webservices.model.rickmorty.ObjectRM
import retrofit2.Call
import retrofit2.http.GET

interface ServiceRM {


    @GET("character")
    fun getAllCharacters(): Call<ObjectRM>
}