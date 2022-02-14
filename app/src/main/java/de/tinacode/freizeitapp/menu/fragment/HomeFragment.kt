package de.tinacode.freizeitapp.menu.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import de.tinacode.freizeitapp.R

class HomeFragment: Fragment(), View.OnClickListener {

    interface ActivityCallbacks {
        fun openSwimming()
        fun openBowling()
        fun openWalking()
        fun openBallon()
        fun openKaraoke()
        fun openRestaurant()
    }

    private var activityCallbacks: ActivityCallbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val swimmButton = view.findViewById<Button>(R.id.s_button)
        val ballonButton = view.findViewById<Button>(R.id.ba_button)
        val bowlingButton = view.findViewById<Button>(R.id.b_button)
        val restaurantButton = view.findViewById<Button>(R.id.r_button)
        val karaokeButton = view.findViewById<Button>(R.id.k_button)
        val walkingButton = view.findViewById<Button>(R.id.w_button)

        swimmButton.setOnClickListener(this)
        ballonButton.setOnClickListener(this)
        bowlingButton.setOnClickListener(this)
        restaurantButton.setOnClickListener(this)
        karaokeButton.setOnClickListener(this)
        walkingButton.setOnClickListener(this)


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
            R.id.s_button->activityCallbacks?.openSwimming()
            R.id.ba_button->activityCallbacks?.openBallon()
            R.id.k_button->activityCallbacks?.openKaraoke()
            R.id.w_button->activityCallbacks?.openWalking()
            R.id.r_button->activityCallbacks?.openRestaurant()
            R.id.b_button->activityCallbacks?.openBowling()
        }
    }

}