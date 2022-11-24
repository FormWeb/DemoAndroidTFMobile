package be.bxl.will.demoandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import be.bxl.will.demoandroid.R


class FirstFragment : Fragment() {

    private lateinit var btnGoToSecond : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        btnGoToSecond = view.findViewById(R.id.btn_go_to_second)

        btnGoToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}