package de.tinacode.freizeitapp.menu.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import de.tinacode.freizeitapp.R

class DayFragment: Fragment(), View.OnClickListener {

    interface ActivityCallbacks {
        fun openSwimmingFragment()
        fun openPicknickFragment()
        fun openWalkingFragment()
        fun openBallonFragment()
    }

    private var activityCallbacks: ActivityCallbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_day, container, false)

        val swimmButton = view.findViewById<Button>(R.id.swimm_button)
        val picknickButton = view.findViewById<Button>(R.id.picknick_button)
        val ballonButton = view.findViewById<Button>(R.id.ballon_button)
        val walkingButton = view.findViewById<Button>(R.id.walking_button)

        swimmButton.setOnClickListener(this)
        picknickButton.setOnClickListener(this)
        ballonButton.setOnClickListener(this)
        walkingButton.setOnClickListener(this)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallbacks = context as ActivityCallbacks
    }

    override fun onDetach() {
        super.onDetach()
        activityCallbacks = null
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.swimm_button -> activityCallbacks?.openSwimmingFragment()
            R.id.picknick_button -> activityCallbacks?.openPicknickFragment()
            R.id.ballon_button -> activityCallbacks?.openBallonFragment()
            R.id.walking_button -> activityCallbacks?.openWalkingFragment()
        }

    }

}