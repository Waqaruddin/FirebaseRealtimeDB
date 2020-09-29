package com.example.firebasedemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_read_activity.*

class ReadActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    var mList:ArrayList<User> = ArrayList()
    var keysList:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_activity)

        databaseReference = FirebaseDatabase.getInstance().getReference(User.COLLECTION_NAME)

        init()
    }

    private fun init() {
        getData()
    }

    private fun getData() {

        databaseReference.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var text = ""
                for(data in dataSnapshot.children){
                    var user = data.getValue(User::class.java)
                    var key = data.key
                    mList.add(user!!)
                    keysList.add(key!!)
                    text += user.name + "\n"

                }
                text_view_data.text = text

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}