package com.example.sat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home_fragmento.*
import kotlinx.android.synthetic.main.fragment_tareas_fragmento.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TareasFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class TareasFragmento : Fragment() , View.OnClickListener{
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
        val view: View =  inflater!!.inflate(R.layout.fragment_tareas_fragmento, container, false)

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
         * @return A new instance of fragment TareasFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TareasFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun adapter (){
        val tarea = Tareas("Computadora HP dv15","Formatear",  R.drawable.verde)
        val tarea1 = Tareas("Lenovo17","Reparar",R.drawable.rojo)
        val tarea2 = Tareas("Asus Ultra Book","Mantenimiento",R.drawable.amarillo)

        val listaTareas = listOf(tarea,tarea1,tarea2)

        val adapter = TareasAdapter(requireContext(), listaTareas)

        listviewTareas.adapter = adapter

        listviewTareas.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                //ACTIVITY
                val intent = Intent(requireContext(), SolicitudActivity::class.java)
                startActivity(intent)
            }
    }

    override fun onClick(v: View?) {

    }
}