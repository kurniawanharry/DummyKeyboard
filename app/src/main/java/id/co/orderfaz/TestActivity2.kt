package id.co.orderfaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.core.client.ApiService
import id.co.orderfaz.feature.autotext.client.ApiClient
import id.co.orderfaz.feature.autotext.model.ResponseAutoText
import id.co.orderfaz.feature.autotext.service.AutoTextService
import id.co.orderfaz.feature.autotext.view.adapter.AutoTextAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_autotext)

        val recyclerView = findViewById<RecyclerView>(R.id.tv_autotext)

        val button = findViewById<ImageButton>(R.id.toolbar_back)

        button.setOnClickListener(
            View.OnClickListener {
               finish()
            }

        )


        val service = ApiClient.buildService(AutoTextService::class.java)

        val call = service.getAll()

        call.enqueue(object : Callback<BaseResponseModel<ResponseAutoText>> {
            override fun onResponse(
                call: Call<BaseResponseModel<ResponseAutoText>>,
                response: Response<BaseResponseModel<ResponseAutoText>>
            ) {
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@TestActivity2)
                    adapter = AutoTextAdapter(response.body()!!.data!!.autoTexts)
                }
            }

            override fun onFailure(call: Call<BaseResponseModel<ResponseAutoText>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}