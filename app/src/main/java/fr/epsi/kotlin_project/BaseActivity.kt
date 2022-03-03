package fr.epsi.kotlin_project

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

open class BaseActivity : AppCompatActivity() {


    fun showBtnBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility=View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun showToast(txt : String){
        Toast.makeText(this,txt, Toast.LENGTH_SHORT).show()
    }


    fun setHeaderTitle(txt : String){
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = txt
    }

    fun setLogoHeader(){
        val logoHeader = findViewById<ImageView>(R.id.logo)
        val textHeader = findViewById<TextView>(R.id.textViewTitle)
        val details = findViewById<ImageView>(R.id.detail)
        logoHeader.visibility = View.VISIBLE
        textHeader.visibility = View.GONE
        details.visibility = View.VISIBLE
        details.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,AccountActivity::class.java)
            startActivity(newIntent)
        })
    }

}