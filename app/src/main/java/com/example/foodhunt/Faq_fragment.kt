package com.example.foodhunt

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

lateinit var recycler_faq:RecyclerView
lateinit var layoutManger:RecyclerView.LayoutManager
lateinit var recyclerAdapter: FaqAdapter
class Faq_fragment : Fragment() {
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

        val view=inflater.inflate(R.layout.fragment_faq, container, false)
        val faq_list= arrayListOf<faq_deatils>(
        faq_deatils("How do I Make a regular Table Booking?","It's a piece of cake - once you've found your preferred restaurant simply select your Date and Time required, and then so long as we have an email address and phone number your booking is instantly confirmed the minute you hit"),
        faq_deatils("How can I be certain my booking's been received?","We'll send an instant confirmation email to the address used in your booking. If you book more than a day ahead, we'll also send a reminder 24 hours before your booking is due. You can reconfirm your booking using a link in your reminder email."),
        faq_deatils("What happens if I don't reconfirm my booking?","Don't worry, your restaurant will still hold your booking without a reconfirmation."),
            faq_deatils("Why do you need my email address?","All Restaurant Hub bookings are automatically confirmed via email. Without an address to send the confirmation to the booking can't be accepted. We'll also use your email address to send reminders for any bookings made more than 24 hours in advance of your dining date."),
            faq_deatils("How much do I have to pay for my booking?","Absolutely nothing! All bookings made through Restaurant Hub are free to the consumer."),
            faq_deatils("What happens if I get to the restaurant and they won't honour my deal?","Restaurant Hub restaurants are committed to honour promotions sold as part of any Restaurant Hub booking. It's a good idea to always show the mobile phone email of your Coupon or Booking confirmation with you, just in case there is an issue."),
            faq_deatils("How do I book a Bookable-Special?","It's quick and easy - once you've found your preferred restaurant special, simply click 'Book Special' then select a date when its available, then the time, and then so long as we have an email address and phone number your booking is instantly confirmed the minute you hit."),
            faq_deatils("What happens if I'm running late?","Call the restaurant. Every restaurant is different, but most will hold a booking for at least twenty minutes before reassigning your table."),
            faq_deatils("How do I cancel a booking?","To help our restaurants manage their sittings we ask our diners to give at least 24 hours' notice of any cancellations. You can do this by calling your restaurant direct.")
        )
        recycler_faq=view.findViewById(R.id.recycler_faq)
        layoutManger= LinearLayoutManager(activity)
        recyclerAdapter= FaqAdapter(activity as Context, faq_list)
        recycler_faq.adapter=recyclerAdapter
        recycler_faq.layoutManager= layoutManger
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Faq_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Faq_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}