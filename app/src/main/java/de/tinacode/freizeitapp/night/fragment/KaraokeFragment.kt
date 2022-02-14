package de.tinacode.freizeitapp.night.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.tinacode.freizeitapp.R
import de.tinacode.freizeitapp.model.DataModel
import de.tinacode.freizeitapp.model.DataViewModel

class KaraokeFragment: Fragment() {

    interface ActivityCallbacks {
        fun openKaraokeDetails(data: DataModel)
    }
    private var activityCallbacks: ActivityCallbacks? = null
    private val viewmodel: DataViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_swimming, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = KaraokeAdapter(viewmodel.list)
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

    private inner class KaraokeHolder(view: View) :
        RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var data: DataModel

        val placename: TextView = itemView.findViewById(R.id.placename)
        val address: TextView = itemView.findViewById(R.id.address)
        val distance: TextView = itemView.findViewById(R.id.distance)
        val button: Button = itemView.findViewById(R.id.button)

        init {
            this.button.setOnClickListener(this)
        }

        fun bind(e: DataModel) {
            data = e
            placename.text = e.placename
            address.text = e.address
            distance.text = e.distance
        }

        override fun onClick(v: View) {
            activityCallbacks?.openKaraokeDetails(data)
        }

    }

    private inner class KaraokeAdapter(var list: List<DataModel>) :
        RecyclerView.Adapter<KaraokeHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KaraokeHolder {
            val view = layoutInflater.inflate(R.layout.karaoke_list_item, parent, false)
            return KaraokeHolder(view)
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: KaraokeHolder, position: Int) {
            val element = list[position]
            holder.bind(element)
        }

    }


}