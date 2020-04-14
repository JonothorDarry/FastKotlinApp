package com.example.fazyksiezyca

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.fazyksiezyca.R.layout.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG="StateChange"

    fun ownCalFormatter(curcal: Calendar, full: Int=1, next: Int=1, place: TextView, custom_string: String="Watever: "){
        val myUtils=MoonGeta()
        val cal=myUtils.NextMoon(curcal.get(Calendar.YEAR), curcal.get(Calendar.MONTH), curcal.get(Calendar.DAY_OF_MONTH), full, next)
        val myString=custom_string+"%d.%d.%d".format(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR))
        place.text=myString
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val algo=SillyAlgorithms()
        val cal=Calendar.getInstance()
        val day=cal.get(Calendar.DAY_OF_MONTH)
        val month=cal.get(Calendar.MONTH)
        val year=cal.get(Calendar.YEAR)

        val imag=findViewById<ImageView>(R.id.blackSun)
        val res=algo.currentAlgorithm(year, month, day)
        if (PreservedSettings.Companion.globalHemisphere=="S"){
            if (res>4.5 && res<12.5) imag.setImageResource(R.drawable.sw47_4)
            else if (res>12.5 && res<17.5) imag.setImageResource(R.drawable.sw99_4)
            else if (res>17.5 && res<25.5) imag.setImageResource(R.drawable.sz48_7)
            else imag.setImageResource(R.drawable.sz0_1)
        }
        else if (PreservedSettings.Companion.globalHemisphere=="N"){
            if (res>=4.5 && res<12.5) imag.setImageResource(R.drawable.nw48_6)
            else if (res>=12.5 && res<17.5) imag.setImageResource(R.drawable.nw99_9)
            else if (res>=17.5 && res<25.5) imag.setImageResource(R.drawable.nz48)
            else imag.setImageResource(R.drawable.nz0_4)
        }

        val perzent=algo.toPercent(res)

        val heute = findViewById<TextView>(R.id.Today)
        heute.text="Dziś, %d.%d.%d księżyc jest w %.2f procentach widoczny".format(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR), perzent)
        ownCalFormatter(cal, 0, 1, findViewById<TextView>(R.id.NextNew), "Następny Nów: ")
        ownCalFormatter(cal, 0, 0, findViewById<TextView>(R.id.PrevNew), "Poprzedni Nów: ")
        ownCalFormatter(cal, 1, 0, findViewById<TextView>(R.id.PrevFull), "Poprzednia Pełnia: ")
        ownCalFormatter(cal, 1, 1, findViewById<TextView>(R.id.NextFull), "Następna Pełnia: ")



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