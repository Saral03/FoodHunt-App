package com.example.foodhunt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var name_reg_tv: TextView
lateinit var email_reg_tv: TextView
lateinit var mobile_reg_tv: TextView
lateinit var delivery_reg_tv: TextView
lateinit var pass_reg_tv: TextView
lateinit var pass_confirm_reg_tv: TextView
class Register_show_fragment : Fragment() {
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
         val view=inflater.inflate(R.layout.fragment_register_show_fragment, container, false)
        name_reg_tv=view.findViewById(R.id.name_reg_tv)
        email_reg_tv=view.findViewById(R.id.email_reg_tv)
        mobile_reg_tv=view.findViewById(R.id.mobile_reg_tv)
        delivery_reg_tv=view.findViewById(R.id.delivery_reg_tv)
        pass_reg_tv=view.findViewById(R.id.pass_reg_tv)
        pass_confirm_reg_tv=view.findViewById(R.id.pass_confirm_reg_tv)
        val info=arguments
//        val inputName=info?.getString("Name")
//        val inputEmail=info?.getString("Email_reg")
//        val inputMobile=info?.getString("Mobile_reg")
//        val inputAddress=info?.getString("delivery_reg")
//        val inputPassword=info?.getString("pass_reg")
//        val inputPassword_confirm=info?.getString("pass_confirm_reg")
        if (info!=null){
            name_reg_tv.text=info.get("Name").toString()
            email_reg_tv.text=info.get("Email_reg").toString()
            mobile_reg_tv.text=info.get("Mobile_reg").toString()
            delivery_reg_tv.text=info.get("delivery_reg").toString()
            pass_reg_tv.text=info.get("pass_reg").toString()
            pass_confirm_reg_tv.text=info.get("pass_confirm_reg").toString()
        }

            //        name_reg_tv.setText(intent.getStringExtra("Name"))
//        email_reg_tv.setText(intent.getStringExtra("Email_reg"))
//        mobile_reg_tv.setText(intent.getStringExtra("Mobile_reg"))
//        delivery_reg_tv.setText(intent.getStringExtra("delivery_reg"))
//        pass_reg_tv.setText(intent.getStringExtra("pass_reg"))
//        pass_confirm_reg_tv.setText((intent.getStringExtra("pass_confirm_reg")))
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Register_show_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register_show_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}