package com.simec.gfs

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import com.simec.gfs.utilities.R
import kotlin.math.ln

class Beeper(val context: Context?) {

    private val maxVolume = 100f
    private val mediaPlayer = MediaPlayer()

    init {

        val beep = Uri.parse("android.resource://" + context?.packageName + "/" + R.raw.love_sound)

        val audioAttributes = AudioAttributes.Builder()
            .setFlags(AudioAttributes.FLAG_AUDIBILITY_ENFORCED)
            .setLegacyStreamType(AudioManager.STREAM_ALARM)
            .setUsage(AudioAttributes.USAGE_ALARM)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        if (context != null) {
            mediaPlayer.setDataSource(context, beep)
        }
        mediaPlayer.setAudioAttributes(audioAttributes)

        mediaPlayer.prepare()
    }

    fun play(volume: Int){
        if (!mediaPlayer.isPlaying) {
            val calculatedVolume = 1 - (ln(maxVolume - volume.toFloat()) / ln(maxVolume))
            mediaPlayer.setVolume(calculatedVolume, calculatedVolume)
            mediaPlayer.start()
        }
    }
}