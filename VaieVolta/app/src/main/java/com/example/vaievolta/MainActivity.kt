package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMessage: EditText

    val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btOk = findViewById(R.id.btMainOk)
        this.etMessage = findViewById(R.id.etMainMensagem)

        this.btOk.setOnClickListener(OnClickButton())

        Log.i("APP_VAI_VOLTA", "Main - onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_VAI_VOLTA", "Main - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_VAI_VOLTA", "Main - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_VAI_VOLTA", "Main - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_VAI_VOLTA", "Main - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_VAI_VOLTA", "Main - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_VAI_VOLTA", "Main - onDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == OUTRA){
                val msg = data?.getStringExtra("MENSAGEM_VOLTA")
                this.etMessage.setText(msg)
            }
        } else {
            Toast.makeText(this, "Voltou pelo Dispositivo", Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnClickButton : View.OnClickListener {
        override fun onClick(v: View?) {
            val it = Intent(this@MainActivity, OutraActivity::class.java)
            val msg = this@MainActivity.etMessage.text.toString()

            it.putExtra("MENSAGEM", msg)

//            startActivity(it)
            startActivityForResult(it, this@MainActivity.OUTRA)
        }
    }
}
