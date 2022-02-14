package de.tinacode.freizeitapp.menu.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import de.tinacode.freizeitapp.R

class NightFragment: Fragment(), View.OnClickListener {


    interface ActivityCallbacks {
        fun openRestaurantFragment()
        fun openBowlingFragment()
        fun openIceRunwayFragment()
        fun openKaraokeFragment()
    }

    private var activityCallbacks: ActivityCallbacks? = null

    // Inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_night, container, false)

        val res_button = view.findViewById<Button>(R.id.restaurant_button)
        val bow_button = view.findViewById<Button>(R.id.bowling_button)
        val ice_button = view.findViewById<Button>(R.id.ice_button)
        val kar_button = view.findViewById<Button>(R.id.karaoke_button)

        res_button.setOnClickListener(this)
        bow_button.setOnClickListener(this)
        ice_button.setOnClickListener(this)
        kar_button.setOnClickListener(this)

        return view

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallbacks = context as ActivityCallbacks?
    }

    override fun onDetach() {
        super.onDetach()
        activityCallbacks = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.restaurant_button->activityCallbacks?.openRestaurantFragment()
            R.id.bowling_button->activityCallbacks?.openBowlingFragment()
            R.id.ice_button->activityCallbacks?.openIceRunwayFragment()
            R.id.karaoke_button->activityCallbacks?.openKaraokeFragment()
        }
    }
}