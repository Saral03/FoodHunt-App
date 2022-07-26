package com.example.foodhunt

import Database.HotelDatabase
import Database.entity
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var recycler_fav:RecyclerView
lateinit var progress_layout:RelativeLayout
lateinit var progress_bar:ProgressBar
lateinit var favAdapter: FavAdapter
lateinit var layoutManager:RecyclerView.LayoutManager
var dbhotellist= listOf<entity>()
class FavFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_fav, container, false)
        recycler_fav=view.findViewById(R.id.recycler_fav)
        progress_layout=view.findViewById(R.id.progress_layout)
        progress_bar=view.findViewById(R.id.progress_bar)
        layoutManager=LinearLayoutManager(activity as Context)
        dbhotellist=RetreiveFav(activity as Context).execute().get()
        if (activity!=null){
            progress_layout.visibility=View.GONE
            favAdapter= FavAdapter(activity as Context, dbhotellist as ArrayList<entity>)
            recycler_fav.adapter= favAdapter
            recycler_fav.layoutManager= layoutManager



        }
        return view
    }
    class RetreiveFav(val context: Context):AsyncTask<Void,Void,List<entity>>() {
        override fun doInBackground(vararg params: Void?):List<entity> {
            val db= Room.databaseBuilder(context,HotelDatabase::class.java,"hotel-db").build()
            return db.hotelDao().getallhotels()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}