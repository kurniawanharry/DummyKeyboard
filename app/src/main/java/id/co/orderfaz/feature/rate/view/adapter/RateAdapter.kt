package id.co.orderfaz.feature.rate.view.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.co.orderfaz.R
import id.co.orderfaz.feature.autotext.model.AutoTexts
import id.co.orderfaz.feature.autotext.view.adapter.AutoTextViewHolder
import id.co.orderfaz.feature.rate.model.ResponseRate
import retrofit2.http.Url

class RateAdapter(val model: ArrayList<ResponseRate>): RecyclerView.Adapter<RateViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyboard_rate_result,parent,false)
        return RateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  model.size
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        return holder.bindView(model[position])
    }

}

class RateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val tvImage: ImageView = itemView.findViewById(R.id.rate_image_view)
    private val radioRecyclerView: RecyclerView = itemView.findViewById(R.id.rate_view)

    fun bindView(model: ResponseRate){
        Picasso.get().load(model.logisticLogoUrl).into(tvImage);
        val rateRadioAdapter = RateRadioAdapter(model.logisticDetails)
        radioRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
        radioRecyclerView.adapter = rateRadioAdapter
    }
}