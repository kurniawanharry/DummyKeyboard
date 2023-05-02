package id.co.orderfaz.feature.product.view.adapter

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.co.orderfaz.R
import id.co.orderfaz.core.util.copyTextToClipboard
import id.co.orderfaz.core.util.formatThousand
import id.co.orderfaz.feature.product.model.Products

class ProductAdapter(val model: ArrayList<Products>, val clipbar: ClipboardManager) : RecyclerView.Adapter<ProductHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolderAdapter {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyboard_product, parent,false)
        return ProductHolderAdapter(view)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: ProductHolderAdapter, position: Int) {
       return holder.bindView(model[position], clipbar)
    }
}

class ProductHolderAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var rvTitle : TextView = itemView.findViewById(R.id.product_title)
    private var rvSubtitle : TextView = itemView.findViewById(R.id.product_subtitle)
    private var rvImage : ImageView = itemView.findViewById(R.id.image)
    private var rvCopyButton : ImageButton = itemView.findViewById(R.id.share_button)

    @SuppressLint("SetTextI18n")
    fun bindView(model: Products,clipbar:ClipboardManager){
        var weight: String = ""

        if(model.productTypeId == 100){
            val w = model.productVariant[0].variantWeight!! / 1000
            weight = "(${w} Kg)"
        }


        rvTitle.text = "${model.productName} $weight"


        if(model.productPriceUnit != null){
            val price = formatThousand(model.productPriceUnit!!)
            rvSubtitle.text = "Rp. $price"
        }

        if(model.productImage.isNotEmpty()){
            Picasso.get().load(model.productImage.first()).into(rvImage);
        }


        rvCopyButton.setOnClickListener {
            copyTextToClipboard(it.context, rvTitle.text.toString(),clipbar)
        }
    }

}