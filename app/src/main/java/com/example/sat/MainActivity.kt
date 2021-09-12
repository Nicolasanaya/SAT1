package com.example.sat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    var correo : Boolean = false
    var contraseña :Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SAT)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun BtnIniciar_Click(view: View) {
        if (!Patterns.EMAIL_ADDRESS.matcher(etUsuario.text.toString()).matches()){
            etUsuario.error = "Correo Erroneo"
            correo = false
        }else{
            correo = true
            etUsuario.error=null
        }

        //val p:Pattern = Pattern.compile("[^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}\$]")
        if (etClave.length() == 0){
            etClave.error = "Digite la Clave"
            contraseña = false
        }else{
            contraseña = true
            etClave.error=null
        }

        if (correo && contraseña){
            val user:String = etUsuario.text.toString()
            val pass:String = etClave.text.toString()
            if (user.equals("nicolasanaya_s@hotmail.com")&&pass.equals("1") || user.equals("rene@gmail.com")&&pass.equals("1") || user.equals("ivan@gmail.com")&&pass.equals("1")){
                val intento1 = Intent(this, PrincipalActivity::class.java)
                startActivity(intento1)
            }else{
                Toast.makeText(applicationContext,"Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

//        val intento1 = Intent(this, PrincipalActivity::class.java)
//        startActivity(intento1)

    }



}