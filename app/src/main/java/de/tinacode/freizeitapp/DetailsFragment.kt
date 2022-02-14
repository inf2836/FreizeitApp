package de.tinacode.freizeitapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import de.tinacode.freizeitapp.model.DataModel

private const val PLACENAME_TAG = "place"
private const val ADDRESS_TAG = "address"
private const val PHONE_TAG = "phone"
private const val DIST_TAG = "distance"
private const val OTIME_TAG = "optime"
class DetailsFragment : Fragment() {

    private var place: String? = null
    private var num: String? = null
    private var add: String? = null
    private var dis: String? = null
    private var otime: String? = null
    private var frame: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            place = it.getString(PLACENAME_TAG)
            num = it.getString(PHONE_TAG)
            add = it.getString(ADDRESS_TAG)
            dis = it.getString(DIST_TAG)
            otime = it.getString(OTIME_TAG)
            frame = it.getString("frame")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        view.findViewById<TextView>(R.id.placename).text = place
        view.findViewById<TextView>(R.id.address).text = add
        view.findViewById<TextView>(R.id.phone).text = num
        view.findViewById<TextView>(R.id.distance).text = dis
        view.findViewById<TextView>(R.id.optime).text = otime
        when(frame){
            "swimmer"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.swimmer)
            "picknick"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.picknick)
            "ice"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.eisstadion)
            "restaurant"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.restaurant)
            "bowling"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.bowling)
            "walking"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.walking)
            "ballon"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ballon)
            "karaoke"->view.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.karaoke)
        }
        return view;
    }

    companion object {
        fun newInstance(data: DataModel, frame: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(PLACENAME_TAG, data.placename)
                    putString(PHONE_TAG, data.phonenumber)
                    putString(ADDRESS_TAG, data.address)
                    putString(DIST_TAG, data.distance)
                    putString(OTIME_TAG, data.otime)
                    putString("frame", frame)
                }
            }
    }
}