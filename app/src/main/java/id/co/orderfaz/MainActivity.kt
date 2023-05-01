package id.co.orderfaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myButton: Button = findViewById(R.id.autoTextButton)
        val myButton2: Button = findViewById(R.id.button2)
        val myButton3: Button = findViewById(R.id.button3)

        myButton.setOnClickListener {
            val intent = Intent(this, TestActivity2::class.java)
            startActivity(intent)
        }
        myButton2.setOnClickListener {
            val intent = Intent(this, TestActivity3::class.java)
            startActivity(intent)
        }
        myButton3.setOnClickListener {
            val intent = Intent(this, TestActivity4::class.java)
            startActivity(intent)
        }
    }
}