package com.satyam.apidemo.helpers

import android.content.Context
import android.widget.Toast


/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
class Global {

    companion object {
        fun makeToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}