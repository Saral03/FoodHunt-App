package com.example.foodhunt

import Database.HotelDatabase
import Database.entity
import android.content.Context
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.squareup.picasso.Picasso
import java.util.ArrayList


class HomeAdapter(val context: Context,val item:ArrayList<hotel_info>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(view:View):RecyclerView.ViewHolder(view){
        //val main_layout:RelativeLayout=view.findViewById(R.id.main_layout)
        val img_list:ImageView=view.findViewById(R.id.img_list)
        val hotel_name:TextView=view.findViewById(R.id.hotel_name)
        val hotel_cost:TextView=view.findViewById(R.id.hotel_cost)
        val icon:ImageView=view.findViewById(R.id.icon)
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
        holder.hotel_cost.text="₹ " + hotel_info.hotelcost + "/person"
       // holder.img_list.setImageResource(hotel_info.image)
        Picasso.get().load(hotel_info.image).error(R.drawable.def_img).into(holder.img_list)
        val hotelentity= entity(
            hotel_info.hotelid.toInt(),
            hotel_info.hotelname,
            hotel_info.hotelrating,
            hotel_info.hotelcost,
            hotel_info.image
        )
        val check_fav= DBAsynctask(context,hotelentity, 1).execute()
        val isFav=check_fav.get()
        if (isFav){
            val IM= R.drawable.heartred
            holder.icon.setImageResource(IM)
        }else{
            val black=R.drawable.heart
            holder.icon.setImageResource(black)
        }
            holder.icon.setOnClickListener {
            if (!DBAsynctask(context, hotelentity, 1).execute().get()){
                val async=DBAsynctask(context, hotelentity, 2).execute()
                val result=async.get()
                if (result){
                    Toast.makeText(context, "Added to favorites", Toast.LENGTH_SHORT).show()
                    val IM= R.drawable.heartred
                    holder.icon.setImageResource(IM)
                }else{
                    Toast.makeText(context, "some error occured", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                val async=DBAsynctask(context, hotelentity, 3).execute()
                val result=async.get()
                if (result){
                    Toast.makeText(context, "Removed from favorites", Toast.LENGTH_SHORT).show()
                    val black=R.drawable.heart
                    holder.icon.setImageResource(black)
                }else{
                    Toast.makeText(context, "some error occured", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
    override fun getItemCount(): Int {
        return item.size
    }
    class DBAsynctask(val context: Context,val hotelentity:entity,val Mode:Int):
        AsyncTask<Void, Void, Boolean>(){
        val get_database= Room.databaseBuilder(context, HotelDatabase::class.java,"hotel-db").build()
        override fun doInBackground(vararg params: Void?): Boolean {
            when(Mode){
                1->{
                    val checkhotel:entity?=get_database.hotelDao().gethotelid(hotelentity.hotel_id.toString())
                    get_database.close()
                    return checkhotel!=null
                }
                2->{
                    get_database.hotelDao().insert(hotelentity)
                    get_database.close()
                    return true
                }
                3->{
                    get_database.hotelDao().delete(hotelentity)
                    get_database.close()
                    return true
                }
            }
            return false
        }

    }




}