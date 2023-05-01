package id.co.orderfaz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import id.co.orderfaz.core.base.BaseResponseModel
import id.co.orderfaz.core.util.DataWrapper
import id.co.orderfaz.feature.rate.client.RateApiClient
import id.co.orderfaz.feature.rate.model.Location
import id.co.orderfaz.feature.rate.model.RequestRate
import id.co.orderfaz.feature.rate.model.ResponseRate
import id.co.orderfaz.feature.rate.service.RateService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestActivity3 : AppCompatActivity() {

    var location : Location? = Location()
    private var editTextOrigin : EditText? = null;
    private var editTextDestination : EditText? = null;
    private var postCodeOrigin : String? = "";
    private var postCodeDestination : String? = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_rate)


        val toolbar = findViewById<View>(R.id.toolbar)
        val button = toolbar.findViewById<ImageButton>(R.id.toolbar_back)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val buttonSubmit = findViewById<Button>(R.id.btn_submit)

        editTextOrigin = findViewById(R.id.origin_edit_text)
        editTextDestination = findViewById(R.id.destination_edit_text)


        val weight = findViewById<EditText>(R.id.weight_edit_text)



        editTextOrigin?.setOnClickListener(
            View.OnClickListener {
                openSomeActivityForResult(true)
            }
        )

        editTextDestination?.setOnClickListener(
            View.OnClickListener {
                openSomeActivityForResult(false)
            }
        )

        button.setOnClickListener(
            View.OnClickListener {
                finish()
            }
        )

        fun checkResult(response: ArrayList<ResponseRate>?){
            if(response?.isNotEmpty() == true){
                Log.d("RESPONSE RATE",response.toString())
                val intent = Intent(this, TestActivity6::class.java)
                intent.putExtra("RESULT", response)
                startActivity(intent)
            }

        }

        buttonSubmit.setOnClickListener(
            View.OnClickListener {
                progressBar.visibility = View.VISIBLE

                val org = postCodeOrigin
                val des = postCodeDestination
                val weg = weight.text.toString().toInt()


                val requestBody = RequestRate(
                    originPostalCode = org,
                    destinationPostalCode = des,
                    weight = weg,
                    itemPrice = 1000,
                    packageTypeId = 1,
                    shipmentType = "PICKUP")

                Log.d("REQUEST RATE",requestBody.toString())



                if(org!!.isNotEmpty() && des!!.isNotEmpty() && weg != 0){

                    val service = RateApiClient.buildService(RateService::class.java)

                    val call = service.createRate(requestBody)

                    call.enqueue(object : Callback<BaseResponseModel<ArrayList<ResponseRate>>> {
                        override fun onResponse(
                            call: Call<BaseResponseModel<ArrayList<ResponseRate>>>,
                            response: Response<BaseResponseModel<ArrayList<ResponseRate>>>
                        ) {
                            checkResult(response.body()?.data)
                            progressBar.visibility = View.INVISIBLE
                        }

                        override fun onFailure(call: Call<BaseResponseModel<ArrayList<ResponseRate>>>, t: Throwable) {
                            progressBar.visibility = View.INVISIBLE
                        }

                    })
                }
            }
        )
    }

    private fun openSomeActivityForResult(isOrigin: Boolean) {
        val intent = Intent(this, TestActivity5::class.java)
        intent.putExtra("CONDITION", isOrigin)
        resultLauncher.launch(intent)
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data

            val returnedData = data?.getSerializableExtra("LOCATION") as? DataWrapper
            val mapData = returnedData?.data

            Log.d("TEST 3", mapData.toString())

            if(mapData != null){
                if(mapData["origin"] == true){
                    postCodeOrigin = mapData["code"].toString()
                    editTextOrigin?.setText(mapData["location"].toString())
                } else {
                    postCodeDestination = mapData["code"].toString()
                    editTextDestination?.setText(mapData["location"].toString())
                }

            }

        }
    }
}