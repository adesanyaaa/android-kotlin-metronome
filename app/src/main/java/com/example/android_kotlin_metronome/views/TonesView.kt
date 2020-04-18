package com.example.android_kotlin_metronome.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import com.example.android_kotlin_metronome.MetronomeService
import com.example.android_kotlin_metronome.R

class TonesView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    val offColor = ContextCompat.getColor(context,
        R.color.faintDigitalText
    )
    val onColor = ContextCompat.getColor(context,
        R.color.digitalText
    )

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.tones_view, this, true)

        orientation = VERTICAL
    }

    fun selectTone(tone: MetronomeService.Tone) {
        for (child in children) {
            if (child is TextView) {
                if (child.text == tone.name)
                    child.setTextColor(onColor)
                else
                    child.setTextColor(offColor)
            }
        }
    }
}