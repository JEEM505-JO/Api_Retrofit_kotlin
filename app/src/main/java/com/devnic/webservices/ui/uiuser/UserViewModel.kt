package com.devnic.webservices.ui.uiuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devnic.webservices.model.Users.HeadUser
import com.devnic.webservices.model.Users.User
import com.devnic.webservices.repository.RepositoryUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val repository: RepositoryUser) : ViewModel() {
    val userlist = MutableLiveData<List<User>>()
    val sms : MutableLiveData<String> = MutableLiveData("Mensaje")
    val code : MutableLiveData<String> = MutableLiveData("Codigo")
    var id: String = "1";
    var email: String = "espinoza@gmail.com"
    var first_name: String = "joaquin"
    var last_name: String = "stevn"
    var avatar: String =
        "https://image.shutterstock.com/image-illustration/img-file-document-icon-trendy-260nw-1407027353.jpg"

    fun getUser() {
        val response = repository.getalldata()
        response.enqueue(object : Callback<HeadUser> {
            override fun onResponse(call: Call<HeadUser>, response: Response<HeadUser>) {
                response.body()?.let {
                   userlist.postValue(it.data)
                }
            }

            override fun onFailure(call: Call<HeadUser>, t: Throwable) {
                println(t.message)
            }
        })
    }

    fun seddata() {
        val response = repository.seduser(User(id, email, first_name, last_name, avatar))

        response.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                sms.postValue("isSuccessful")
                code.postValue(response.code().toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                sms.postValue(t.message)
            }

        })
    }
}

class UserFactory(private val repository: RepositoryUser) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow viewmodel Inicio class")
    }
}

