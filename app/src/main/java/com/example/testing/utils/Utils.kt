package com.example.testing.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

object Utils {

    fun Activity.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    const val EMAIL = "xua57570@gmail.com"
    const val PASSWORD = "moto1111"
}