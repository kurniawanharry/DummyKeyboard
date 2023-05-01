package id.co.orderfaz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.core.util.DataWrapper
import id.co.orderfaz.feature.rate.client.RateApiClient
import id.co.orderfaz.feature.rate.model.Location
import id.co.orderfaz.feature.rate.service.RateService
import id.co.orderfaz.feature.rate.view.RecycleViewClickListener
import id.co.orderfaz.feature.rate.view.adapter.LocationAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class TestActivity5 : AppCompatActivity(), RecycleViewClickListener {
    var languages : ArrayList<Location> = arrayListOf();

    private var isOrigin : Boolean = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_location)

        val recyclerView = findViewById<RecyclerView>(R.id.rate_view)

        val destination = findViewById<EditText>(R.id.edit_search)

        val button = findViewById<Button>(R.id.search_button)

        val backButton = findViewById<ImageButton>(R.id.toolbar_back)

        isOrigin = intent.getBooleanExtra("CONDITION", true)

        button.setOnClickListener {
            val text = destination.text.toString()
            println(text);

            if(text.isNotEmpty()){

                val service = RateApiClient.buildService(RateService::class.java)

                val call = service.searchLocation(text,100)

                call.enqueue(object : Callback<BaseResponseModel<ArrayList<Location>>> {
                    override fun onResponse(
                        call: Call<BaseResponseModel<ArrayList<Location>>>,
                        response: Response<BaseResponseModel<ArrayList<Location>>>
                    ) {
                        languages = response.body()!!.data!!

                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(this@TestActivity5)
                            adapter = LocationAdapter(languages,this@TestActivity5)
                        }

                    }

                    override fun onFailure(call: Call<BaseResponseModel<ArrayList<Location>>>, t: Throwable) {
                    }

                })
            }
        }

        backButton.setOnClickListener(
            View.OnClickListener {
                finish()
            }

        )
    }

    override fun onItemClick(view: View, location: Location) {
        val data: Map<String, Any> = mapOf(
            "origin" to isOrigin,
            "location" to "${location.district}, ${location.subDistrict}, ${location.city}, ${location.province}, ${location.postalCode}",
            "code" to "${location.postalCode}"
        )

        val dataWrapper = DataWrapper(data)

        val intent = Intent()

        intent.putExtra("LOCATION", dataWrapper);

        setResult(Activity.RESULT_OK, intent);
        finish()
    }
}