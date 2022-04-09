package com.example.pruebaceiba.feature.user.ui.models

import androidx.lifecycle.ViewModel
import com.example.pruebaceiba.feature.user.interactors.FetchUsersFromWebService
import com.example.pruebaceiba.feature.user.interactors.ShowAllDatabaseUsers
import javax.inject.Inject

class UserViewModel
    @Inject constructor(
        private val fecthFromWebService: FetchUsersFromWebService,
        private val showAllDatabaseUsers: ShowAllDatabaseUsers
    ):ViewModel() {








}