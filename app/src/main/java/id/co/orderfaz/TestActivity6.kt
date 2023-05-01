package id.co.orderfaz

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.orderfaz.feature.autotext.view.adapter.AutoTextAdapter
import id.co.orderfaz.feature.rate.model.ResponseRate
import id.co.orderfaz.feature.rate.view.adapter.RateAdapter

class TestActivity6 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboard_rate_result)

        val button = findViewById<ImageView>(R.id.toolbar_back)

        button.setOnClickListener(
            View.OnClickListener {
                finish()
            }

        )

        val response : ArrayList<ResponseRate>? = intent.getParcelableArrayListExtra("RESULT")

        val recyclerView = findViewById<RecyclerView>(R.id.tv_rate_result)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@TestActivity6)
            adapter = RateAdapter(response!!)
        }


    }
}