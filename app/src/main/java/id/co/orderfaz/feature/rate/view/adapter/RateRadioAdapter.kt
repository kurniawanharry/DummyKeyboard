package id.co.orderfaz.feature.rate.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.co.orderfaz.R
import id.co.orderfaz.core.util.formatThousand
import id.co.orderfaz.feature.rate.model.LogisticDetails
import id.co.orderfaz.feature.rate.model.ResponseRate

class RateRadioAdapter(val model: ArrayList<LogisticDetails>): RecyclerView.Adapter<RateRadioHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateRadioHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyboard_rate_radio, parent, false)
        return RateRadioHolder(view)
    }

    override fun getItemCount(): Int {
        return  model.size
    }

    override fun onBindViewHolder(holder: RateRadioHolder, position: Int) {
        holder.bindView(model[position])
    }
}

class RateRadioHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val rateName: TextView = itemView.findViewById(R.id.rate_check_name)
    private val rateChecbox: CheckBox = itemView.findViewById(R.id.rate_checkBox)

    @SuppressLint("SetTextI18n")
    fun bindView(model: LogisticDetails){
        var duration: String = ""
        duration = if(model.minDuration == model.maxDuration){
            "${model.minDuration}"
        } else {
            "${model.minDuration} - ${model.maxDuration}"
        }
        val price = formatThousand(model.price!!)
        rateName.text = "$price ${model.logisticRate} ($duration ${model.durationType?.lowercase()})"
    }
}