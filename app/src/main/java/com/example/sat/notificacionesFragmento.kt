package com.example.sat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_notificaciones_fragmento.*
import kotlinx.android.synthetic.main.fragment_tareas_fragmento.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [notificacionesFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class notificacionesFragmento : Fragment(), View.OnClickListener {
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater!!.inflate(R.layout.fragment_notificaciones_fragmento, container, false)
//        val btn: Button =view.findViewById(R.id.btnNotificaciones)
//        btn.setOnClickListener(this)
        return view

    }
    override fun onStart() {
        super.onStart()
        adapter()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment notificacionesFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            notificacionesFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun adapter (){
        val tarea = Notificaciones("Computadora HP dv15","Formatear",  "hoy")
        val tarea1 = Notificaciones("Lenovo17","Reparar","mañana")
        val tarea2 = Notificaciones("Asus Ultra Book","Mantenimiento","beber")

        val listaNotificaciones = listOf(tarea,tarea1,tarea2)

        val adapter = NotificacionesAdapter(requireContext(), listaNotificaciones)

        listviewNotificaciones.adapter = adapter

    }

    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btnNotificaciones -> {
//                adapter ()
//            }
//            else -> {
//                Toast.makeText(context, "NO ESTA FUNCIONANDO", Toast.LENGTH_SHORT)
//                    .show()
//
//            }
//
//        }
    }
}