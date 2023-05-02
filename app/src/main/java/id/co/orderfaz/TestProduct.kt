package id.co.orderfaz

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.feature.product.client.ProductClient
import id.co.orderfaz.feature.product.model.ResponseProduct
import id.co.orderfaz.feature.product.service.ProductService
import id.co.orderfaz.feature.product.view.adapter.ProductAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_product)

        val recyclerView = findViewById<RecyclerView>(R.id.tv_product)

        val button = findViewById<ImageButton>(R.id.toolbar_back)

        val title = findViewById<TextView>(R.id.toolbar_title)

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        title.text = "Produk"

        button.setOnClickListener(
            View.OnClickListener {
                finish()
            }

        )

        val service = ProductClient.buildService(ProductService::class.java)


        val call = service.getAll(search = "", limit = 10)


        call.enqueue(object : Callback<BaseResponseModel<ResponseProduct>> {
            override fun onResponse(
                call: Call<BaseResponseModel<ResponseProduct>>,
                response: Response<BaseResponseModel<ResponseProduct>>
            ) {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@TestProduct)
                    adapter = ProductAdapter(response.body()!!.data!!.products, clipboardManager)
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<ResponseProduct>>, t: Throwable) {
                Log.d("Error", t.toString())

            }

        })

    }

}