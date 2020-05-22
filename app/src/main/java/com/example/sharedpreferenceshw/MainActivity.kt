package com.example.sharedpreferenceshw

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPrefFile = "TEST_SHARED_PREFERENCE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        btnCount.setOnClickListener {

            var count = sharedPreferences.getInt("pref_count", 0)
            count++


            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            editor.putInt("pref_count", count)

            editor.apply()
            editor.commit()

            txtCount.text = count.toString()

        }
    }
}
