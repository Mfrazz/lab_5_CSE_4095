package com.example.lab_5_Starting_Code

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_5_Starting_Code.model.RadioStation
import com.example.lab_5_Starting_Code.model.RadioStations

//const val url = "http://176.31.243.35:8014/stream"

class MainActivity : AppCompatActivity() {

    private var radioOn: Boolean = false
    private lateinit var radioButton: Button
    private lateinit var stationName: TextView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radioStations = RadioStations()

        radioButton = findViewById(R.id.on_off_button)

        var stations: Array<RadioStation> = radioStations.getStations()

        var url = stations[1].uri.toString()
        setUpRadio(url)

        radioButton.setOnClickListener {

            if (radioOn) {
                mediaPlayer.pause()
                radioButton.setText("Radio On")
            } else {
                mediaPlayer.start()
                radioButton.setText("Radio Off")
            }

            radioOn = !radioOn
        }

        recyclerView = findViewById(R.id.recycleview)
        recyclerView.adapter = RadioAdapter(radioStations)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)

    }


    private fun setUpRadio(url: String) {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        }
        setAndPrepareRadioLink(url)
    }

    private fun setAndPrepareRadioLink(url: String) {
        mediaPlayer.reset()
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepareAsync()
    }


}
