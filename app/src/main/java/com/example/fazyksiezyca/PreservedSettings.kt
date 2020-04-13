package com.example.fazyksiezyca
import android.app.Application

class PreservedSettings : Application(){
    companion object {
        var globalHemisphere = "N"
        var globalAlgorithm = "Trig2"
    }
}