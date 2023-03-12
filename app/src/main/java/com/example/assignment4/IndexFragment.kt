package com.example.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class IndexFragment : Fragment(){
    private var navController: NavController?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.about_me)?.setOnClickListener{
            navController?.navigate(R.id.action_titleFragment_to_aboutMeFragment)
        }
        view.findViewById<Button>(R.id.task1_button)?.setOnClickListener {
            navController?.navigate(R.id.action_titleFragment_to_task1Activity)
        }

    }

}