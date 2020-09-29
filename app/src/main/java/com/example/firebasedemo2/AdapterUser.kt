package com.example.firebasedemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_adapter_user.view.*

class AdapterUser(var mContext: Context, var mList:ArrayList<User>):RecyclerView.Adapter<AdapterUser.MyViewHolder>(){


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(user:User){
            itemView.text_view_name.text = user.name
            itemView.text_view_email.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = mList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:ArrayList<User>){
        mList = l
        notifyDataSetChanged()
    }
}