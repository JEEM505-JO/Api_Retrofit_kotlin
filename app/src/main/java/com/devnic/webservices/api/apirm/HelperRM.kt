package com.devnic.webservices.api.apirm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HelperRM {
    val baseurl = "https://rickandmortyapi.com/api/"
    var service : ServiceRM?= null

    fun getInstance() : ServiceRM? {
        if(service == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            service = retrofit.create(ServiceRM::class.java)
        }
        return service
    }
}