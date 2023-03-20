package com.satyam.apidemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.satyam.apidemo.adapter.ListAdapter
import com.satyam.apidemo.apicalls.Connect
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
import kotlin.math.log

class ListFrag : Fragment() {
    val TAG = "ListFrag"

    lateinit var listFragBinding: FragmentListBinding
    lateinit var mydb: MyDatabase
    lateinit var adapter: ListAdapter
    lateinit var list:List<UserData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragBinding = FragmentListBinding.inflate(inflater, container, false)

        mydb = MyDatabase.getDatabases(requireContext())
        listFragBinding.list.layoutManager = LinearLayoutManager(requireContext())
        listFragBinding.list.setHasFixedSize(true)

        getData()
        return listFragBinding.root
    }

    private fun getData() {
        Connect().getInstance().getData().enqueue(object : Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                Log.d(TAG, "onResponse: ")
                if (response.body() != null) {
                        lifecycleScope.launch{
                            list=response.body()!!
                            saveInDB()
                        }
                } else {
                    Global.makeToast(requireContext(), "Data not received")
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }

    fun saveInDB() {
        Log.d(TAG, "saveInDB: ")
        lifecycleScope.launch {
            val data = mydb.userDataDao().getAllUser()
            if (data.size != list.size) {
                showList(list)
            }else {
                mydb.userDataDao().insertAllUsers(list)
                showList(list)
            }
        }
    }

    private fun showList(list: List<UserData>) {
        listFragBinding.list.adapter = ListAdapter(list, requireContext())
    }

    fun showDetail(){

    }
}