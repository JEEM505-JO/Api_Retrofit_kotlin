package com.devnic.webservices.api.apiuser

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HelperUser {
    val baseurl = "https://reqres.in/api/"
    var service : ServiceUser?= null

    fun getInstance() : ServiceUser? {
        if(service == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            service = retrofit.create(ServiceUser::class.java)
        }
        return service
    }
}