package com.example.pruebaceiba.core

import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pruebaceiba.R
import com.google.android.material.snackbar.Snackbar


fun View.visible(status:Boolean){
    this.visibility = if (status) View.VISIBLE else View.GONE
}

fun Fragment.notifyErrorWithAction(
    message: String,
    actionText: String,
    action: () -> Any
){
    val snackBar = Snackbar.make(this.requireView(), message, Snackbar.LENGTH_INDEFINITE)
    snackBar.setAction(actionText) { _ -> action.invoke() }
    snackBar.setActionTextColor(ContextCompat.getColor(this.requireContext(), R.color.green_primary))
    snackBar.show()

}