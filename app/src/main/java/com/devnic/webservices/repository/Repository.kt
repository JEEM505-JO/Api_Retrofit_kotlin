package com.devnic.webservices.repository

import com.devnic.webservices.api.apiuser.ServiceUser
import com.devnic.webservices.model.Users.User

class RepositoryUser(private val service: ServiceUser) {

    fun getalldata() = service.getAllData()

    fun seduser(user: User) =
        service.sedUser(user)
}