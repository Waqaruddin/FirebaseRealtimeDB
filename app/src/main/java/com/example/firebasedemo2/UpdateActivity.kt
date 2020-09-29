//package com.example.firebasedemo2
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.firebase.database.FirebaseDatabase
//import kotlinx.android.synthetic.main.activity_update.*
//
//class UpdateActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_update)
//
//        init()
//    }
//
//    private fun init() {
//        button_update.setOnClickListener {
//            var databaseReference = FirebaseDatabase.getInstance().getReference("users")
//
//            var name = edit_text_name.text.toString()
//            var email = edit_text_email.text.toString()
//
//            var newUser = User(name, email)
//            databaseReference.child(userId).setValue(newUser)
//        }
//    }
//}