package com.example.fazyksiezyca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.fazyksiezyca.R.layout.*

class MainActivity : AppCompatActivity() {
    val TAG="StateChange"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val algo=SillyAlgorithms()
        val perzent=algo.toPercent(algo.currentAlgorithm(2021, 11, 20))
        val heute = findViewById<TextView>(R.id.Today)
        heute.text=perzent.toString()


        val sMain = findViewById<Button>(R.id.toSettingsMain)
        sMain?.setOnClickListener() {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }


        val tFull=findViewById<Button>(R.id.toFullmoon)
        tFull.setOnClickListener(){
            val intent = Intent(this, YearCalculationsActivity::class.java)
            startActivity(intent)
        }

        Log.i(TAG, "onCreate")
    }
}