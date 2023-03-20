package com.satyam.apidemo

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.satyam.apidemo.apicalls.Connect
import com.satyam.apidemo.databinding.ActivityMainBinding
import com.satyam.apidemo.databinding.FragmentListBinding
import com.satyam.apidemo.db.MyDatabase
import com.satyam.apidemo.db.UserData
import com.satyam.apidemo.helpers.Global
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainACtivity"
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.whats.setOnClickListener {
            Global.makeToast(this,"Turn On Accessibility For APIDEMO")
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
    }

}
