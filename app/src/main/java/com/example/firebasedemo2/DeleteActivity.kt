package com.example.firebasedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        init()
    }

    private fun init() {
        button_delete.setOnClickListener {

            var databasereference = FirebaseDatabase.getInstance().getReference("users")

            var userId = edit_text_email.text.toString()

            databasereference.child(userId).setValue(null)

        }
    }
}