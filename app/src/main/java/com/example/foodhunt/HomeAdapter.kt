package com.example.foodhunt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.ArrayList

class HomeAdapter(val context: Context,val item:ArrayList<hotel_info>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(view:View):RecyclerView.ViewHolder(view){
        //val main_layout:RelativeLayout=view.findViewById(R.id.main_layout)
        val img_list:ImageView=view.findViewById(R.id.img_list)
        val hotel_name:TextView=view.findViewById(R.id.hotel_name)
        val hotel_cost:TextView=view.findViewById(R.id.hotel_cost)
        //val favsymbol:TextView=view.findViewById(R.id.favsymbol)
        val rating:TextView=view.findViewById(R.id.rating)
        //val main_layout:RelativeLayout=view.findViewById(R.id.main_layout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item_menu,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val hotel_info=item[position]
        holder.hotel_name.text=hotel_info.hotelname
        holder.rating.text=hotel_info.hotelrating
        holder.hotel_cost.text=hotel_info.hotelcost
       // holder.img_list.setImageResource(hotel_info.image)
        Picasso.get().load(hotel_info.image).into(holder.img_list)

    }

    override fun getItemCount(): Int {
        return item.size
    }


}