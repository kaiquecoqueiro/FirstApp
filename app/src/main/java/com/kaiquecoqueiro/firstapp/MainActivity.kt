package com.kaiquecoqueiro.firstapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()
                button_reset.isClickable = true

                val translationDistance = (initialTextViewTranslationY + progress *
                        resources.getDimension(R.dimen.text_anim_step) * -1)

                if (!fromUser) {
                    textView_progress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
                }

                textView_progress.animate().translationY(translationDistance)

                if (progress == 0)
                    button_reset.isClickable = false
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })


        button_reset.setOnClickListener { v ->
            seekBar.progress = 0

        }
    }
}
