package com.kslim.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kslim.lovetest.R

class ResultFragment : Fragment() {

    lateinit var navController: NavController

    private var mOption = -1

    lateinit var mTvTitle: TextView
    lateinit var mTvBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mOption = arguments?.getInt("index") ?: -1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        mTvTitle = view.findViewById(R.id.txt_title)
        mTvBody = view.findViewById(R.id.txt_body)

        val imageHome: ImageView = view.findViewById(R.id.image_home)
        imageHome.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }

        setResult(mOption)
    }

    fun setResult(option: Int) {
        when (option) {
            1 -> {
                mTvTitle.text = "You are a QUITTER!"
                mTvBody.text = "You can let the person easily."
            }
            2 -> {
                mTvTitle.text = "You should focus on yourself"
                mTvBody.text = "You become really clingy to your ex."
            }
            3 -> {
                mTvTitle.text = "You should take it easy"
                mTvBody.text = "You can do crazy things no matter what it takes."
            }
            4 -> {
                mTvTitle.text = "You are pretty mature."
                mTvBody.text = "You can easily accept the break-up."
            }
        }
    }

}