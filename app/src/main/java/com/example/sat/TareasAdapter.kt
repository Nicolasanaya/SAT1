package com.example.sat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_casos.view.*

class TareasAdapter (private val mContext: Context, private var listaTareas: List<Tareas>) : ArrayAdapter<Tareas>(mContext,0,listaTareas){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_tareas,parent,false)

        val caso = listaTareas[position]

        layout.tvReunionNombre.text = caso.caso
        layout.tvHoraNombre.text = caso.tarea
        layout.ivEstadoTareas.setImageResource(caso.estado)

        return layout
    }


}