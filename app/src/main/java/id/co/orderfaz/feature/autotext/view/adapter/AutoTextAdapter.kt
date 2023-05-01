package id.co.orderfaz.feature.autotext.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.R
import id.co.orderfaz.feature.autotext.model.AutoTexts
import id.co.orderfaz.feature.autotext.model.ResponseAutoText

class AutoTextAdapter(val model: ArrayList<AutoTexts>) :RecyclerView.Adapter<AutoTextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoTextViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyboard_autotext,parent,false)
        return AutoTextViewHolder(view)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: AutoTextViewHolder, position: Int) {
        return holder.bindView(model[position])
    }
}

class AutoTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_item_keyboard_main)
    private val tvBody: TextView = itemView.findViewById(R.id.tv_item_keyboard_subtitle)

    fun bindView(model: AutoTexts){
        tvTitle.text = model.name
        tvBody.text = model.content
    }
}