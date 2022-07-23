package com.example.foodhunt


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.foodhunt.HomeAdapter
import com.example.foodhunt.R
import com.example.foodhunt.hotel_info
import org.json.JSONException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomePage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recycler:RecyclerView
    lateinit var LayoutManager:RecyclerView.LayoutManager
    lateinit var recyclerAdapter:HomeAdapter
    lateinit var progress_layout:RelativeLayout
    lateinit var progressbar:ProgressBar
    val hotelinfolist= arrayListOf<hotel_info>()
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
        val view= inflater.inflate(R.layout.fragment_home_page, container, false)
        recycler=view.findViewById(R.id.recycler)
        progress_layout=view.findViewById(R.id.progress_layout)
        progressbar=view.findViewById(R.id.progressbar)
        progress_layout.visibility=View.VISIBLE
        LayoutManager=LinearLayoutManager(activity)
        val queue= Volley.newRequestQueue(activity as Context)
        val url="http://13.235.250.119/v2/restaurants/fetch_result/"
        val jsonObjectRequest=object:JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener {
                try {
                    progress_layout.visibility=View.GONE
                    val jsonObject=it.getJSONObject("data")
                    val success=jsonObject.getBoolean("success")
                    if (success){
                        val data=jsonObject.getJSONArray("data")
                        for (i in 0 until data.length()){
                            val hotelJSONObject=data.getJSONObject(i)
                            val hotelobj=hotel_info(hotelJSONObject.getString("id"),hotelJSONObject.getString("name"),
                                hotelJSONObject.getString("rating"),hotelJSONObject.getString("cost_for_one"),hotelJSONObject.getString("image_url"))
                            hotelinfolist.add(hotelobj)
                            recyclerAdapter=HomeAdapter(activity as Context,hotelinfolist)
                            recycler.adapter=recyclerAdapter
                            recycler.layoutManager=LayoutManager

                        }
                    }
                    else{
                        Toast.makeText(activity as Context, "some error occured ", Toast.LENGTH_SHORT).show()
                    }

                }
                catch (e:JSONException){
                    Toast.makeText(activity as Context, "json exception occured", Toast.LENGTH_SHORT).show()
                }

            },Response.ErrorListener {
                Toast.makeText(activity as Context, "Volley error occured", Toast.LENGTH_SHORT).show()
            })
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers=HashMap<String,String>()
                headers["Content-type"]="application/json"
                headers["token"]="9bf534118365f1"
                return headers
            }

        }
        queue.add(jsonObjectRequest)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePage.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}