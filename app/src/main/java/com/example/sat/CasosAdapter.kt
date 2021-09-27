package com.example.sat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_casos.view.*

class CasosAdapter(private val mContext: Context, private var listaCasos: List<casesAndLabels>) : ArrayAdapter<casesAndLabels>(mContext,0,listaCasos){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_casos,parent,false)

        val caso = listaCasos[position]

        layout.tvReunionNombre.text = caso.case_Name
        layout.tvHoraNombre.text = caso.label_Name
//        layout.ivEstadoTareas.setImageResource(caso.estado)

        return layout
    }


}