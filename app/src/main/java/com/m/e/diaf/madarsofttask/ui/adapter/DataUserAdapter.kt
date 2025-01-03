package com.m.e.diaf.madarsofttask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m.e.diaf.madarsofttask.R
import com.m.e.diaf.madarsofttask.model.DataUser

class DataUserAdapter(val arr:List<DataUser>): RecyclerView.Adapter<DataUserAdapter.DataUserViewHolder>() {

    class DataUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var userName = itemView.findViewById<TextView>(R.id.getUserName)
        var age = view.findViewById<TextView>(R.id.getAge)
        var jobTitle = itemView.findViewById<TextView>(R.id.getJobTitle)
        var gender = view.findViewById<TextView>(R.id.getGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataUserViewHolder {
        return DataUserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.applicant_item , parent , false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: DataUserViewHolder, position: Int) {
        val dataUser = arr[position]
        holder.userName.text = dataUser.user_name
        holder.age.text = dataUser.Age
        holder.jobTitle.text = dataUser.job_title
        holder.gender.text = dataUser.gender

    }
}