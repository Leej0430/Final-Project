package com.example.finalproject

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Location : AppCompatActivity(){
    lateinit var tv_lat:TextView
    lateinit var tv_lon:TextView
    lateinit var tv_altitude:TextView
    lateinit var tv_accuracy:TextView
    lateinit var tv_sensor:TextView
    lateinit var tv_update:TextView
    lateinit var sw_gps: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        val locationManager:LocationManager
                = getSystemService(Context.LOCATION_SERVICE)
                as LocationManager

        tv_lat = findViewById(R.id.tv_lat)
        tv_lon = findViewById(R.id.tv_lon)
        tv_altitude = findViewById(R.id.tv_altitude)
        tv_accuracy = findViewById(R.id.tv_accuracy)
        tv_sensor = findViewById(R.id.tv_sensor)
        tv_update = findViewById(R.id.tv_updates)
        sw_gps= findViewById(R.id.sw_gps)

    sw_gps.setOnClickListener(){
        //Check the permission
        if(Build.VERSION.SDK_INT >=23 && ContextCompat.checkSelfPermission(applicationContext
                ,android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                0
            )

        }
        else{
            val location: Location? =
                locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            tv_lat.text  = location?.latitude.toString()
            tv_lon.text = location?.longitude.toString()
            tv_altitude.text = location?.altitude.toString()
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0.1f,locationListener)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,0.1f,locationListener)
        }
        }

    }
    val locationListener:LocationListener =object: LocationListener{
        override fun onLocationChanged(p0: Location) {
            tv_lat.text = p0.latitude.toString()
            tv_lon.text = p0.longitude.toString()
        }

    }
}


