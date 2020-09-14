package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class OutraActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.btOk = findViewById(R.id.btOutraOk)
        this.etMessage = findViewById(R.id.etOutraMensagem)

        this.btOk.setOnClickListener(OnClickButton())
        Log.e("APP_VAI_VOLTA", "Outra - onCreate")

        this.etMessage.setText(intent.getStringExtra("MENSAGEM"))
    }

    override fun onStart() {
        super.onStart()
        Log.e("APP_VAI_VOLTA", "Outra - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("APP_VAI_VOLTA", "Outra - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("APP_VAI_VOLTA", "Outra - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("APP_VAI_VOLTA", "Outra - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("APP_VAI_VOLTA", "Outra - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("APP_VAI_VOLTA", "Outra - onDestroy")
    }

    inner class OnClickButton : View.OnClickListener {
        override fun onClick(v: View?) {
            val it = Intent()
            it.putExtra("MENSAGEM_VOLTA", this@OutraActivity.etMessage.text.toString())
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }
}
