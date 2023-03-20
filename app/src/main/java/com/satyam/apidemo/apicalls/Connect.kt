package com.satyam.apidemo.apicalls

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
class Connect {

    val baseUrl = " https://jsonplaceholder.typicode.com/"

    fun getInstance(): ConnectionMethods {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build().create(ConnectionMethods::class.java)
    }

}