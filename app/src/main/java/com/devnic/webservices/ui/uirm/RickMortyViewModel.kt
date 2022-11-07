package com.devnic.webservices

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devnic.webservices.model.rickmorty.Characters
import com.devnic.webservices.model.rickmorty.ObjectRM
import com.devnic.webservices.repository.RepositoryRM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickMortyViewModel(private val repositoryRM: RepositoryRM) : ViewModel() {
    val characters: MutableLiveData<List<Characters>> = MutableLiveData()

    fun getDataRM(){
        val respon = repositoryRM.getCharacters()

        respon.enqueue(object : Callback<ObjectRM> {
            override fun onResponse(call: Call<ObjectRM>, response: Response<ObjectRM>) {
                response.body().let {
                    characters.postValue(it?.result)
                }
            }

            override fun onFailure(call: Call<ObjectRM>, t: Throwable) {
                Log.d("ERROR: ", t.message.toString())
            }

        })
    }
}

class RickMortyFactory(private val repositoryRM: RepositoryRM) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RickMortyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RickMortyViewModel(repositoryRM) as T
        }
        throw IllegalArgumentException("Unknow viewmodel Inicio class")
    }
}