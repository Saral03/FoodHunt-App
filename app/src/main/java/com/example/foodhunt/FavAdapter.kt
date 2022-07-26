package com.example.foodhunt

import Database.entity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FavAdapter(val context: Context, val Hotellist:ArrayList<entity>): RecyclerView.Adapter<FavAdapter.FavViewHolder>() {
        class FavViewHolder(view: View): RecyclerView.ViewHolder(view){
            val img_list_fav:ImageView=view.findViewById(R.id.img_list_fav)
            val hotel_name_fav:TextView=view.findViewById(R.id.hotel_name_fav)
            val hotel_cost_fav:TextView=view.findViewById(R.id.hotel_cost_fav)
            val icon_fav:TextView=view.findViewById(R.id.icon_fav)
            val rating_fav:TextView=view.findViewById(R.id.rating_fav)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavAdapter.FavViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fav_items_fragment,parent,false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavAdapter.FavViewHolder, position: Int) {
        val hotel_info=Hotellist[position]
        holder.hotel_name_fav.text=hotel_info.hotelname
        holder.rating_fav.text=hotel_info.hotelrating
        holder.hotel_cost_fav.text="₹ " + hotel_info.hotelcost + "/person"
        // holder.img_list.setImageResource(hotel_info.image)
        Picasso.get().load(hotel_info.image).error(R.drawable.def_img).into(holder.img_list_fav)
    }

    override fun getItemCount(): Int {
        return Hotellist.size

    }


}