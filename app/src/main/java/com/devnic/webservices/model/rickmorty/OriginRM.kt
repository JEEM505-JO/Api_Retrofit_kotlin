package com.devnic.webservices.model.rickmorty

import com.google.gson.annotations.SerializedName

data class OriginRM(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
