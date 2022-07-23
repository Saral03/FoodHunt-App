package com.example.foodhunt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FaqAdapter(val context: Context,val details:ArrayList<faq_deatils>):RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {
    class FaqViewHolder(view: View):RecyclerView.ViewHolder(view){
        val question_faq:TextView=view.findViewById(R.id.question_faq)
        val answer_faq:TextView=view.findViewById(R.id.answer_faq)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.faq_listitem,parent,false)
        return  FaqViewHolder(view)

    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        val faq_deatils=details[position]
            holder.question_faq.text=faq_deatils.question
            holder.answer_faq.text=faq_deatils.answer
    }

    override fun getItemCount(): Int {
        return details.size
    }
}