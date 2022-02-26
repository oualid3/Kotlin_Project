package fr.epsi.kotlin_project

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentActivity : BaseActivity() {

    private lateinit var tab1Fragment : Fragment;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        tab1Fragment = Tab1Fragment.newInstance();


        val tab1=findViewById<TextView>(R.id.textViewTab1)

        showBtnBack()
        setLogoHeader()

        tab1.setOnClickListener(View.OnClickListener {
            showTab1()
        })

        showTab1()
    }


    private fun showTab1() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.addToBackStack("Tab1Fragment") // name can be null
        fragmentTransaction.replace(R.id.fragment_container, tab1Fragment, null)
        fragmentTransaction.commit()
    }


    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount>1)
            super.onBackPressed()
        else
            finish()
    }
    fun readSharedPref(key:String):String{
        val sharedPreferences: SharedPreferences = getSharedPreferences("account", Context.MODE_PRIVATE)
        return sharedPreferences.getString(key,"not found").toString()
    }
}