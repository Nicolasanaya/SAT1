package com.example.sat

//import androidx.core.content.PermissionChecker.checkSelfPermission
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_reportes_fragmento.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val REQUEST_GALERY = 2
const val PICK_PDF_FILE = 2
private val REQUEST_DOWNLOADS = 1



/**
 * A simple [Fragment] subclass.
 * Use the [reportesFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class reportesFragmento : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_reportes_fragmento, container, false)
        val btn: Button = view.findViewById(R.id.btnEnviar)
        val btn1: Button = view.findViewById(R.id.btnImagen)
        val btn2: Button = view.findViewById(R.id.btnArchivo)
        btn.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment reportesFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            reportesFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnEnviar -> {

                if (spCaso.selectedItem != "" && spEtiqueta.selectedItem != "") {

                } else {
                    Toast.makeText(context, "Seleccione alguna Opcion", Toast.LENGTH_SHORT)
                        .show()
                }
                if (edDescripcion.length() == 0) {
                    edDescripcion.error = "Debe diligenciar la descripcion"
                } else {
                    edDescripcion.error = null
                    Toast.makeText(context, "Formulario Enviado", Toast.LENGTH_SHORT)
                        .show()
                }

            }


            else -> {
            }

        }

        when (v?.id) {
            R.id.btnImagen -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(
                            requireContext(),
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                        ) == PackageManager.PERMISSION_DENIED
                    ) {
                        val permisoarchivos =
                            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                            requestPermissions(permisoarchivos, REQUEST_GALERY)
                    } else {
                        muestragaleria()
                    }
                } else {
                    muestragaleria()
                }

            }
            else -> {

            }
        }

        when(v?.id){
            R.id.btnArchivo ->{
                openFile()
            }
            else ->{

            }
        }
    }



    //Metodo para mostrar la galeria y tomar foto
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
                    Toast.makeText(requireContext(), "NO PUEDE ACCEDER A TUS IMAGENES",Toast.LENGTH_SHORT).show()
            }
            REQUEST_DOWNLOADS ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    openFile()
                else
                    Toast.makeText(requireContext(), "NO PUEDE ACCEDER A TUS IMAGENES",Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun dialogo(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("FORMULARIO")
        builder.setMessage("¿Quieres cerrar el formulario?")

        builder.setPositiveButton("Aceptar", null)
        builder.setNegativeButton("Cancelar", null)
        val dialog = builder.create()
        dialog.show()
    }



    fun openFile() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/pdf"
        }
        startActivityForResult(intent, PICK_PDF_FILE)
    }

}




