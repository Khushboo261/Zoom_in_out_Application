package com.example.zoom_in_out

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import java.lang.Float.max
import java.lang.Float.min


class MainActivity : AppCompatActivity() {
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "ZoomInZoomOut"
        imageView = findViewById(R.id.imageView)
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }
    override fun onTouchEvent(motionEvent :MotionEvent): Boolean  {
        scaleGestureDetector.onTouchEvent(motionEvent)
        return true
    }
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener(){
       override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
           scaleFactor *=scaleGestureDetector.scaleFactor
           scaleFactor = max(0.1f,min(scaleFactor, 10.0f))
           imageView.scaleX = scaleFactor
           imageView.scaleY = scaleFactor
           return true
       }
    }
}