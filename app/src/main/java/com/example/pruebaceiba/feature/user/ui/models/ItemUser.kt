package com.example.pruebaceiba.feature.user.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemUser(val name:String,val phoneNumber:String,val email:String,val id:Int) : Parcelable
