package com.devnic.webservices.repository

import com.devnic.webservices.api.apirm.ServiceRM

class RepositoryRM(private val serviceRM: ServiceRM) {


     fun getCharacters() = serviceRM.getAllCharacters()

}