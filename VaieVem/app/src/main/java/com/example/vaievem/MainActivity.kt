package com.example.vaievem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btSucesso: Button
    private lateinit var btError: Button
    private lateinit var llSucesso: LinearLayout
    private lateinit var llErro: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSucesso = findViewById(R.id.btSucesso)
        btSucesso.setOnClickListener({
            this.llSucesso.visibility = View.VISIBLE
        })

        btError = findViewById(R.id.btError)
        btError.setOnClickListener({
            this.llErro.visibility = View.VISIBLE
        })

        llSucesso = findViewById(R.id.llSucesso)
        llSucesso.setOnClickListener({
            this.llSucesso.visibility = View.INVISIBLE
        })

        llErro = findViewById(R.id.llErro)
        llErro.setOnClickListener({
            this.llErro.visibility = View.INVISIBLE
        })

    }
}
