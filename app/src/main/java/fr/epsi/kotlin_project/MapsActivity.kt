package fr.epsi.kotlin_project

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import org.json.JSONObject
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : Fragment() {

    lateinit var googleMap :GoogleMap

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingPermission")
    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                // Precise location access granted.
                googleMap.isMyLocationEnabled=true
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                // Only approximate location access granted.
                googleMap.isMyLocationEnabled=true
            } else -> {
            // No location access granted.
            }
        }
    }


    val stores = "{\"stores\":[" +
            "{\"storeId\": \"9566\",\n" +
            "\"name\": \"Le Grand marché\",\n" +
            "\"description\": \"situé au centre ville\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDSfySJzTR0Wbzxi05hiZxQxdqW6AQA4rqA&usqp=CAU\",\n" +
            "\"address\": \"10 Rue Merlot\",\n" +
            "\"zipcode\": \"75000\",\n" +
            "\"city\":\" Paris\"," +
            "\"longitude\":2.338646," +
            "\"latitude\":48.854885},\n" +

            "{\"storeId\": \"9566\",\n" +
            "\"name\": \"Marché de Bordeaux\",\n" +
            "\"description\": \"situé au centre ville\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDSfySJzTR0Wbzxi05hiZxQxdqW6AQA4rqA&usqp=CAU\",\n" +
            "\"address\": \"Centre ville\",\n" +
            "\"zipcode\": \"33000\",\n" +
            "\"city\":\" Bordeaux\"," +
            "\"longitude\":-0.57918," +
            "\"latitude\":44.837789},\n" +

            "{\"storeId\": \"3566\",\n" +
            "\"name\": \"Marché de Pau\",\n" +
            "\"description\": \"situé au centre ville\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDSfySJzTR0Wbzxi05hiZxQxdqW6AQA4rqA&usqp=CAU\",\n" +
            "\"address\": \"Centre ville\",\n" +
            "\"zipcode\": \"33000\",\n" +
            "\"city\":\" Pau\"," +
            "\"longitude\":-0.363570," +
            "\"latitude\":43.293295},\n" +

            "{\"storeId\": \"3356\",\n" +
            "\"name\": \"Le Grand marché Lille\",\n" +
            "\"description\": \"situé au centre de la capitale\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkZLcXb2slwlM0RGjyuiAj5jdF1_qrN-MBcA&usqp=CAU\",\n" +
            "\"address\": \"10 Rue Merlot\",\n" +
            "\"zipcode\": \"75000\",\n" +
            "\"city\":\" Lille\"," +
            "\"longitude\":3.063295," +
            "\"latitude\":50.608719},\n" +

            "{\"storeId\": \"9536\",\n" +
            "\"name\": \"marché de Nantes\",\n" +
            "\"description\": \"situé au centre ville\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDSfySJzTR0Wbzxi05hiZxQxdqW6AQA4rqA&usqp=CAU\",\n" +
            "\"address\": \"Centre ville\",\n" +
            "\"zipcode\": \"33000\",\n" +
            "\"city\":\" Nantes\"," +
            "\"longitude\":-1.553621," +
            "\"latitude\":47.218371},\n" +

            "{\"storeId\": \"9562\",\n" +
            "\"name\": \"Marché de Toulouse\",\n" +
            "\"description\": \"situé au centre ville\",\n" +
            "\"pictureStore\": \"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDSfySJzTR0Wbzxi05hiZxQxdqW6AQA4rqA&usqp=CAU\",\n" +
            "\"address\": \"Centre ville\",\n" +
            "\"zipcode\": \"31000\",\n" +
            "\"city\":\" Toulouse\"," +
            "\"longitude\":1.444209," +
            "\"latitude\":43.604652}" +
            "]}"


    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */


        val paris = LatLng(48.854885, 2.338646)
        val jsCities= JSONObject(stores)
        val items=jsCities.getJSONArray("stores")
        for (i in 0 until items.length()){
            val name = items.getJSONObject(i)
            val address = items.getJSONObject(i)
            val zipcode = items.getJSONObject(i)
            val city = items.getJSONObject(i)
            val cityLatLng = LatLng(city.optDouble("latitude",0.0),city.optDouble("longitude",0.0))
            googleMap.addMarker(MarkerOptions().position(cityLatLng).title(name.optString("name","")).snippet(address.optString("address","")+"-"+zipcode.optString("zipcode","")+city.optString("city"," ")))
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(paris))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(paris,5.5f))

        googleMap.setOnMapClickListener {
            (activity as BaseActivity).showToast(it.toString())
        }

        googleMap.setOnInfoWindowClickListener {
            (activity as BaseActivity).showToast(it.title.toString())
        }

        googleMap.setOnMarkerClickListener(object : GoogleMap.OnMarkerClickListener {
            override fun onMarkerClick(p0: Marker): Boolean {
                (activity as BaseActivity).showToast("Marker"+p0.title.toString())
                return false
            }
        })
        this.googleMap=googleMap
        locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_maps_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}