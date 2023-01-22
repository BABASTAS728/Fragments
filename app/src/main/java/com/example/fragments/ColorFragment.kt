package com.example.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {
    companion object {
        private val COLOR = "Color"

        fun newInstance(color: String): ColorFragment {
            val fragment = ColorFragment()
            val args: Bundle = Bundle()
            args.putString(COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)
        return view
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val frame = view.findViewById<View>(R.id.view)
        val color = when (arguments?.getString(COLOR)) {
            "Фиолетовый" -> resources.getDrawable(R.color.purple_500)
            "Розовый" -> resources.getDrawable(R.color.purple_200)
            "Чёрный" -> resources.getDrawable(R.color.black)
            "Синий" -> resources.getDrawable(R.color.purple_700)
            "Бирюзовый" -> resources.getDrawable(R.color.teal_200)
            "Тёмно-зелёный" -> resources.getDrawable(R.color.teal_700)
            else -> resources.getDrawable(R.color.white)
        }
        frame.background = color
    }
}