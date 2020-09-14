package com.example.expobre

import android.animation.Animator
import android.animation.AnimatorInflater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var llNumeros : LinearLayout
    private lateinit var btNewValues : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llNumeros = findViewById(R.id.llNumeros)

        btNewValues = findViewById(R.id.btNewValues)
        btNewValues.setOnClickListener {
            rotateAnimation(0, Megasena.getInstance())
        }
    }

    private fun rotateAnimation(index : Int, numbers: List<Int>) {
        if (index > 5) {
            return
        }
        val tvNumbers: TextView = llNumeros.getChildAt(index) as TextView

        val animation: Animator = AnimatorInflater.loadAnimator(this, R.animator.turnball)
        animation.setTarget(tvNumbers)
        animation.start()

        Handler().postDelayed({
            tvNumbers.text = numbers[index].toString().padStart(2, '0')
        }, 2500)
        Handler().postDelayed({
            rotateAnimation(index + 1, numbers)
        }, 3000)
    }
}
