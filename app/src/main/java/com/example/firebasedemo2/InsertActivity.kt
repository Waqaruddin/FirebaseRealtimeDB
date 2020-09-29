package com.example.firebasedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        init()
    }

    private fun init() {
        button_insert.setOnClickListener {
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()
            var user = User(name, email)
            var databasereference = FirebaseDatabase.getInstance().getReference("users")

            var userId = databasereference.push().key
            databasereference.child(userId!!).setValue(user)
            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()


        }
    }
}