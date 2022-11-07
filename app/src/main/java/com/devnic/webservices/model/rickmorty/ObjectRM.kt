package com.devnic.webservices.model.rickmorty

import com.devnic.webservices.model.rickmorty.Characters
import com.devnic.webservices.model.rickmorty.InfoRM
import com.google.gson.annotations.SerializedName

data class ObjectRM(
    @SerializedName("info")
    val info: InfoRM,
    @SerializedName("results")
    val result: List<Characters>
)
