package com.kslim.lovetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kslim.lovetest.R

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.findViewById<TextView>(R.id.option_1).setOnClickListener(this)
        view.findViewById<TextView>(R.id.option_2).setOnClickListener(this)
        view.findViewById<TextView>(R.id.option_3).setOnClickListener(this)
        view.findViewById<TextView>(R.id.option_4).setOnClickListener(this)

        view.findViewById<ImageView>(R.id.btn_previous).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option_1 -> {
                navigateWithIndex(1)
            }
            R.id.option_2 -> {
                navigateWithIndex(2)
            }
            R.id.option_3 -> {
                navigateWithIndex(3)
            }
            R.id.option_4 -> {
                navigateWithIndex(4)
            }
            R.id.btn_previous -> {
                navController.popBackStack()
            }
        }
    }

    fun navigateWithIndex(index: Int) {
        val bundle: Bundle = bundleOf("index" to index)

        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }
}