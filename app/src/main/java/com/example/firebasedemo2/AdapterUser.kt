package com.example.firebasedemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.row_adapter_user.view.*

class AdapterUser(var mContext: Context, var mList:ArrayList<User>, private var keysList:ArrayList<String>):RecyclerView.Adapter<AdapterUser.MyViewHolder>(){


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(user:User, position: Int){
            itemView.text_view_name.setText(user.name)
            itemView.text_view_email.setText(user.email)

            itemView.button_delete.setOnClickListener{
                var databaseReference = FirebaseDatabase.getInstance().getReference("users")
                databaseReference.child(keysList[position]).setValue(null)
                Toast.makeText(mContext, "User deleted successfully", Toast.LENGTH_SHORT).show()

            }

            itemView.button_update.setOnClickListener {
                val user = User(itemView.text_view_name.text.toString(),itemView.text_view_email.text.toString())
                var databaseReference = FirebaseDatabase.getInstance().getReference("users")
                var item = databaseReference.child(keysList[position])
                item.setValue(user)
                Toast.makeText(mContext, "User updated successfully", Toast.LENGTH_SHORT).show()


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = mList[position]
        holder.bind(user, position)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:ArrayList<User>){
        mList = l
        notifyDataSetChanged()
    }
}