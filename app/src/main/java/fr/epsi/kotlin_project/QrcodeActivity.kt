package fr.epsi.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import org.json.JSONObject

class QrcodeActivity : BaseActivity() {

    private lateinit var codeScanner: CodeScanner

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)



        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)


        codeScanner = CodeScanner(this, scannerView)


        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not




        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                val jsonData = JSONObject(it.text)
                val firstName = jsonData.optString("firstName")
                val lastName = jsonData.optString("lastName")
                val email = jsonData.optString("email")
                val address = jsonData.optString("address")
                val zipcode = jsonData.optString("zipcode")
                val city = jsonData.optString("city")
                val cardRef = jsonData.optString("cardRef")
                val newIntent = Intent(application,CreateActivity::class.java)
                newIntent.putExtra("firstName",firstName)
                newIntent.putExtra("lastName",lastName)
                newIntent.putExtra("email",email)
                newIntent.putExtra("address",address)
                newIntent.putExtra("zipcode",zipcode)
                newIntent.putExtra("city",city)
                newIntent.putExtra("cardRef",cardRef)

                startActivity(newIntent)

            }
        }


        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }


        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }



    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }



    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}