package com.satyam.apidemo.apicalls

import com.satyam.apidemo.db.UserData
import com.satyam.apidemo.models.ReceivedData
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
interface ConnectionMethods {

    @GET("posts")
    fun getData(): Call<List<UserData>>

}