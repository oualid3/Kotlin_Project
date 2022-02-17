package fr.epsi.kotlin_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class CreateActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        showBtnBack()
    }
}