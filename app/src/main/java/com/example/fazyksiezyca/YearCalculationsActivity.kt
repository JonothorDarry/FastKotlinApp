package com.example.fazyksiezyca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import kotlinx.android.synthetic.main.settings.*
import java.util.*

class YearCalculationsActivity : AppCompatActivity() {

    private fun datesChanger(year: Int) {
        val layout = findViewById<LinearLayout>(R.id.States)
        layout.removeAllViews()
        val zeiter = MoonGeta()
        var i = 0
        //var cal = zeiter.NextMoon(year, 0, 1, 1, 1) //Nieprecyzjyjny algorytm
        var cal = zeiter.NextMoon(year, 0, 1, 1, 1, 1)

        while (cal.get(Calendar.YEAR) == year && i < 1000) {
            val view = TextView(this)
            view.text = zeiter.GetDate(cal)
            layout.addView(view)
            //cal = zeiter.NextMoon(cal,1, 1) //Nieprecyzjyjny algorytm
            cal = zeiter.NextMoon(cal,1, 1, 1)
            i++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.year_calculations)
        val layout = findViewById<LinearLayout>(R.id.States)
        datesChanger(2020)

        val year=findViewById<EditText>(R.id.Year)
        val btnPlus=findViewById<Button>(R.id.btnPlus)
        btnPlus.setOnClickListener() {
            val c=year.text.toString().toInt()+1
            if (c in 1900..2200){
                year.setText(c.toString())
                datesChanger(c)
            }
        }

        val btnMinus=findViewById<Button>(R.id.btnMinus)
        btnMinus.setOnClickListener() {
            val c=year.text.toString().toInt()-1
            if (c in 1900..2200){
                year.setText(c.toString())
                datesChanger(c)
            }
        }

        val Ok=findViewById<Button>(R.id.Ok)
        Ok.setOnClickListener{
            val c=year.text.toString().toInt()
            if (c in 1900..2200)  datesChanger(c)
        }

        val sMain = findViewById<Button>(R.id.toMain)
        sMain?.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}