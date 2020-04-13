package com.example.fazyksiezyca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val Algo=findViewById<RadioGroup>(R.id.Algorithm)
        val Hemi=findViewById<RadioGroup>(R.id.Hemispheres)
        when (PreservedSettings.Companion.globalAlgorithm){
            "Trig1" -> Algo.check(findViewById<RadioButton>(R.id.Trig1Algo).id)
            "Trig2" -> Algo.check(findViewById<RadioButton>(R.id.Trig2Algo).id)
            "Conway" -> Algo.check(findViewById<RadioButton>(R.id.ConwayAlgo).id)
            "Simple" -> Algo.check(findViewById<RadioButton>(R.id.SimpleAlgo).id)
        }

        when (PreservedSettings.Companion.globalHemisphere){
            "N" -> Hemi.check(findViewById<RadioButton>(R.id.NorthHemi).id)
            "S" -> Hemi.check(findViewById<RadioButton>(R.id.SouthHemi).id)
        }


        val sRet = findViewById<Button>(R.id.returning)
        sRet?.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val acSet = findViewById<Button>(R.id.acceptSettings)
        acSet?.setOnClickListener(){

            var prop=Algo.checkedRadioButtonId==findViewById<RadioButton>(R.id.Trig1Algo).id
            if (prop) PreservedSettings.Companion.globalAlgorithm="Trig1"
            prop=Algo.checkedRadioButtonId==findViewById<RadioButton>(R.id.Trig2Algo).id
            if (prop) PreservedSettings.Companion.globalAlgorithm="Trig2"
            prop=Algo.checkedRadioButtonId==findViewById<RadioButton>(R.id.SimpleAlgo).id
            if (prop) PreservedSettings.Companion.globalAlgorithm="Simple"
            prop=Algo.checkedRadioButtonId==findViewById<RadioButton>(R.id.ConwayAlgo).id
            if (prop) PreservedSettings.Companion.globalAlgorithm="Conway"

            prop=Hemi.checkedRadioButtonId==findViewById<RadioButton>(R.id.NorthHemi).id
            if (prop) PreservedSettings.Companion.globalHemisphere="N"
            prop=Hemi.checkedRadioButtonId==findViewById<RadioButton>(R.id.SouthHemi).id
            if (prop) PreservedSettings.Companion.globalHemisphere="S"

            Log.i("PreservanceHemi", PreservedSettings.Companion.globalHemisphere)
            Log.i("PreservanceAlgo", PreservedSettings.Companion.globalAlgorithm)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}