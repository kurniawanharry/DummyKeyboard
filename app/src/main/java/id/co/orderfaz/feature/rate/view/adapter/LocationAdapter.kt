package id.co.orderfaz.feature.rate.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.R
import id.co.orderfaz.feature.rate.model.Location
import id.co.orderfaz.feature.rate.view.RecycleViewClickListener

class LocationAdapter(val model: ArrayList<Location>, private val onItemClickListener: RecycleViewClickListener) : RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyboard_autotext,parent,false)
        return LocationViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bindView(model[position])
        holder.onClick(model[position])
    }

}

class LocationViewHolder(itemView: View, private val onItemClickListener: RecycleViewClickListener) : RecyclerView.ViewHolder(itemView){
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_item_keyboard_main)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_item_keyboard_subtitle)


    fun bindView(model: Location){
        tvTitle.text = model.district
        tvBody.text = model.city
    }

    fun onClick(model: Location){
        itemView.setOnClickListener{
            onItemClickListener.onItemClick(it, model)
        }
    }


}