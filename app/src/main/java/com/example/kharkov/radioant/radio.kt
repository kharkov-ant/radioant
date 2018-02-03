package com.example.kharkov.radioant

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.*

class Radio : AppCompatActivity(), MediaPlayer.OnPreparedListener {

    private lateinit var playButton: Button
    private var audioManager: AudioManager? = null
    private lateinit var mediaPlayer: MediaPlayer

    lateinit private var stream: String
    private var started: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)
        val image = intent.getIntExtra("image", 0)
        val imageView = findViewById<View>(R.id.image) as ImageView
        imageView.setImageResource(image)
        playButton = findViewById(R.id.playButton)
        playButton.isEnabled = false
        playButton.text = resources.getString(R.string.loading)
        mediaPlayer = MediaPlayer()
        stream = intent.getStringExtra("site")
        mediaPlayer.setDataSource(stream)
        mediaPlayer.setOnPreparedListener(this)
        mediaPlayer.prepareAsync()
        started = true



        playButton.setOnClickListener {
            if (started) {
                started = false
                mediaPlayer.pause()
                playButton.text = resources.getString(R.string.play)
            } else {
                started = true
                mediaPlayer.start()
                playButton.text = resources.getString(R.string.pause)
            }
        }
        initControls()
    }


    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start()
        playButton.text = resources.getString(R.string.pause)
        playButton.isEnabled = true


    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun initControls() {
        try {
            val volumeSeek = findViewById<SeekBar>(R.id.seekBar)
            audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            volumeSeek.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            volumeSeek.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
            volumeSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onStopTrackingTouch(arg0: SeekBar) {}
                override fun onStartTrackingTouch(arg0: SeekBar) {}
                override fun onProgressChanged(arg0: SeekBar, progress: Int, arg2:
                Boolean) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}