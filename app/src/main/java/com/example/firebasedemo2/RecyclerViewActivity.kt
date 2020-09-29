package com.example.firebasedemo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_read_activity.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    var mList:ArrayList<User> = ArrayList()
    var keysList:ArrayList<String> = ArrayList()
    private var adapterUser:AdapterUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        databaseReference = FirebaseDatabase.getInstance().getReference(User.COLLECTION_NAME)

        init()
    }

    private fun init() {
        button_insert.setOnClickListener{
            startActivity(Intent(this, InsertActivity::class.java))
        }
        getData()
        adapterUser = AdapterUser(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapterUser
    }

    private fun getData() {
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mList.clear()
                keysList.clear()
                for(data in dataSnapshot.children){
                    var user = data.getValue(User::class.java)
                    var key = data.key
                    mList.add(user!!)
                    keysList.add(key!!)
                    adapterUser!!.setData(mList, keysList)

                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}