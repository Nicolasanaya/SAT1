package com.example.sat

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_solicitud.*
import kotlinx.android.synthetic.main.activity_solicitud.btnImagen
import kotlinx.android.synthetic.main.activity_solicitud.edDescripcion
import kotlinx.android.synthetic.main.activity_solicitud.spCaso
import kotlinx.android.synthetic.main.activity_solicitud.spEtiqueta
import kotlinx.android.synthetic.main.fragment_reportes_fragmento.*

class SolicitudActivity : AppCompatActivity() {

    private val REQUEST_GALERY = 2
    val PICK_PDF_FILE = 2
    private val REQUEST_DOWNLOADS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitud)
        abrirGaleria_Click()
    }

    override fun onResume() {
        super.onResume()
        dialogo()
    }

    fun enviar_click(view: View){
        if (spCaso.selectedItem != "" && spEtiqueta.selectedItem != "") {

        } else {
            Toast.makeText(this, "Seleccione alguna Opcion", Toast.LENGTH_SHORT)
                .show()
        }
        if (edDescripcion.length() == 0) {
            edDescripcion.error = "Debe diligenciar la descripcion"
        } else {
            edDescripcion.error = null
            Toast.makeText(this, "Formulario Enviado", Toast.LENGTH_SHORT)
                .show()
            val intento1 = Intent(this, PrincipalActivity::class.java)
            startActivity(intento1)
        }


    }

    private fun abrirGaleria_Click(){
        btnImagen.setOnClickListener(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    val permisoarchivos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoarchivos,REQUEST_GALERY)
                }else{
                    muestragaleria()
                }
            }else{
                muestragaleria()
            }
        }

    }

    private fun muestragaleria(){
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria, REQUEST_GALERY)
        //Toast.makeText(applicationContext,"AQUI VAN LAS IMAGENES",Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            REQUEST_GALERY ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    muestragaleria()
                else
                    Toast.makeText(applicationContext, "NO PUEDE ACCEDER A TUS IMAGENES",Toast.LENGTH_SHORT).show()
            }
            REQUEST_DOWNLOADS ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                        addCategory(Intent.CATEGORY_OPENABLE)
                        type = "application/pdf"
                    }
                    startActivityForResult(intent, PICK_PDF_FILE)
                }
                else
                    Toast.makeText(this, "NO PUEDE ACCEDER A TUS IMAGENES", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun dialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("FORMULARIO")
        builder.setMessage("¿Quieres cerrar el formulario?")

        builder.setPositiveButton("Aceptar", null)
        builder.setNegativeButton("Cancelar", null)
        val dialog = builder.create()
        dialog.show()
    }

    fun openFile_Click(view: View) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/pdf"
        }
        startActivityForResult(intent, PICK_PDF_FILE)
    }
}