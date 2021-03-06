package com.example.fazyksiezyca

import java.util.*

class MoonGeta {

    private fun outerFunction(cal: Calendar,  full: Int=1, next: Int=1, precise: Int=0): Calendar{

        val algo=SillyAlgorithms()

        var c1=-1.0
        var c2=1.0
        if (full==1){
            c1=14.5
            c2=15.5
        }
        var sgn=1
        if (next==0) sgn=-1
        cal.add(Calendar.DAY_OF_MONTH, sgn*1)

        if (precise==0) {
            while (algo.currentAlgorithm(
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH)
                ) > c2 || algo.currentAlgorithm(
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH)
                ) < c1
            ) {
                cal.add(Calendar.DAY_OF_MONTH, sgn * 1)
            }
        }

        else{
            while (algo.Trig2(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH)
                ) > c2 || algo.Trig2(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH)
                ) < c1){
                cal.add(Calendar.DAY_OF_MONTH, sgn * 1)
            }
        }
        return cal
    }

    fun NextMoon(mycal: Calendar, full: Int=1, next: Int=1, precise: Int=0): Calendar{
        val cal= Calendar.getInstance()
        cal.set(mycal.get(Calendar.YEAR), mycal.get(Calendar.MONTH), mycal.get(Calendar.DAY_OF_MONTH))
        return outerFunction(cal, full, next, precise)
    }

    //full=0: new moon;
    fun NextMoon(year: Int, month: Int, day: Int, full: Int=1, next: Int=1, precise: Int=0): Calendar{
        val cal= Calendar.getInstance()
        cal.set(year, month, day)
        return outerFunction(cal, full, next, precise)
    }


    fun GetDate(cal: Calendar): String{
        return "%d.%d.%d".format(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR))
    }
}