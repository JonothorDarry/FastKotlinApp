package com.example.fazyksiezyca

import java.util.*

class MoonGeta {

    //full=0: new moon;
    fun NextMoon(year: Int, month: Int, day: Int, full: Int=1, next: Int=1): Calendar{
        val cal= Calendar.getInstance()
        cal.set(year, month, day)
        val algo=SillyAlgorithms()

        var c1=-1.0
        var c2=1.0
        if (full==1){
            c1=14.5
            c2=15.5
        }
        var sgn=1
        if (next==0) sgn=-1

        while(algo.currentAlgorithm(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))>c2 || algo.currentAlgorithm(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))<c1){
            cal.add(Calendar.DAY_OF_MONTH, sgn*1)
        }
        return cal
    }
}