package fr.epsi.kotlin_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        if(sharedPreferences.getBoolean("isCreated",false)){
            val newIntent = Intent(application,FragmentActivity::class.java)
            startActivity(newIntent)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonZone1: Button = findViewById(R.id.buttonZone1)
        val buttonZone2: Button = findViewById(R.id.buttonZone2)

        buttonZone2.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,CreateActivity::class.java)
            newIntent.putExtra("title",getString(R.string.zone_2))
            startActivity(newIntent)
        })

        buttonZone1.setOnClickListener(View.OnClickListener {
            val newIntent= Intent(application,QrcodeActivity::class.java)
            newIntent.putExtra("title",getString(R.string.zone_1))
            startActivity(newIntent)
        })

    }


}