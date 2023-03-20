package com.satyam.apidemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.satyam.apidemo.databinding.FragmentDetailBinding
import com.satyam.apidemo.databinding.FragmentListBinding
import com.satyam.apidemo.db.UserData

class DetailFrag : Fragment() {

    lateinit var listDetailBinding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listDetailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        listDetailBinding.tit.text= arguments?.getString("title")
        listDetailBinding.body.text= arguments?.getString("body")

        return listDetailBinding.root
    }

}
