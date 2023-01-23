package com.example.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {
    companion object {
        private const val PURPLE = "Фиолетовый"
        private const val PINK = "Розовый"
        private const val BLACK = "Чёрный"
        private const val BLUE = "Синий"
        private const val AQUA = "Бирюзовый"
        private const val GREEN = "Тёмно-зелёный"
        private const val COLOR_KEY = "Color"
        fun newInstance(color: String): ColorFragment {
            val fragment = ColorFragment()
            val args: Bundle = Bundle()
            args.putString(COLOR_KEY, color)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val color = when (arguments?.getString(COLOR_KEY)) {
            PURPLE -> ContextCompat.getColor(requireContext(),R.color.purple_500)
            PINK -> ContextCompat.getColor(requireContext(),R.color.purple_200)
            BLACK -> ContextCompat.getColor(requireContext(),R.color.black)
            BLUE -> ContextCompat.getColor(requireContext(),R.color.purple_700)
            AQUA -> ContextCompat.getColor(requireContext(),R.color.teal_200)
            GREEN -> ContextCompat.getColor(requireContext(),R.color.teal_700)
            else -> ContextCompat.getColor(requireContext(),R.color.white)
        }
        view.setBackgroundColor(color)
    }
}