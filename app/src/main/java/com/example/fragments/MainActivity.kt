package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val colors = resources.getStringArray(R.array.Colors)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, colors
            )
            spinner.adapter = adapter
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val messageFragment = ColorFragment.newInstance(spinner.selectedItem.toString())
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_layout, messageFragment)
                .addToBackStack("fragment")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}
