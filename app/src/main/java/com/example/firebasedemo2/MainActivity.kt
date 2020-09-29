package com.example.firebasedemo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button_insert.setOnClickListener{
            startActivity(Intent(this, ReadActivity::class.java))
        }

        button_delete.setOnClickListener{
            startActivity(Intent(this, DeleteActivity::class.java))
        }
    }
}