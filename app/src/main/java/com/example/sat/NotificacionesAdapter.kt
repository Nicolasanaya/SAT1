package com.example.sat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_casos.view.*
import kotlinx.android.synthetic.main.item_casos.view.tvHoraNombre
import kotlinx.android.synthetic.main.item_casos.view.tvReunionNombre
import kotlinx.android.synthetic.main.item_notificaciones.view.*

class NotificacionesAdapter (private val mContext: Context, private var listaNotificacion: List<Notificaciones>) : ArrayAdapter<Notificaciones>(mContext,0,listaNotificacion){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_notificaciones,parent,false)

        val notificion = listaNotificacion[position]

        layout.tvFechaNombre.text = notificion.hora
        layout.tvHoraNombre.text = notificion.fecha
        layout.tvReunionNombre.text = notificion.reunion

        return layout
    }


}