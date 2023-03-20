package com.satyam.apidemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by SATYAM on 20/03/23.
 * Associated with IOVRVF
 * Contact me on: satyamiovrvf@gmail.com
 */
@Entity(tableName = "user_info")
data class UserData(
    @PrimaryKey
    @ColumnInfo("id") val id:Int?,
    @ColumnInfo("userId") val userId :Int?,
    @ColumnInfo("title") val title:String?,
    @ColumnInfo("body") val body:String?,
)
