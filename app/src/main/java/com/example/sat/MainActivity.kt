package com.example.sat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SAT)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun BtnIniciar_Click(view: View) {

        val intento1 = Intent(this, PrincipalActivity::class.java)
        startActivity(intento1)

    }

}