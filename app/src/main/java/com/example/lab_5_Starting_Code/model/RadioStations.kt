package com.example.lab_5_Starting_Code.model

import kotlin.collections.MutableList

class RadioStations() {

    private var stations: MutableList<RadioStation> = arrayListOf(RadioStation())

    init {

        stations.add(RadioStation("name", "http://stream.whus.org:8000/whusfm"))
        stations.add(RadioStation("Sainte Famille  ", "http://ns385874.ip-176-31-243.eu:8001/stream"))
        stations.add(RadioStation("Maine NPR  ", "https://playerservices.streamtheworld.com/api/livestream-redirect/WMEAFM.mp3"))


    }

    public fun getStations() : Array<RadioStation>{

        return stations.toTypedArray()
    }

    public fun size() : Int {
        return stations.size
    }
}
