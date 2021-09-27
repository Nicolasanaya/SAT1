package com.example.sat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon
import kotlinx.android.synthetic.main.fragment_home_fragmento.*

import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//var listamuta: MutableList<Casos>? = null
var listaCasos: List<casesAndLabels>? = null
var adaptador: CasosAdapter? = null
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragmento : Fragment(), View.OnClickListener {
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

        val view: View =  inflater!!.inflate(R.layout.fragment_home_fragmento, container, false)
//        val btn:ImageButton =view.findViewById(R.id.ivSearch)
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
         * @return A new instance of fragment HomeFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }

    fun adapter (){
        var listaCasosi = mutableListOf<String>()

        val url1 = "https://api.apiupbateneo.xyz/CasesAndLabels/list"

        val queue = Volley.newRequestQueue(context)
        var arrayAdapter:ArrayAdapter<*>

        val stringRequest1 = StringRequest(Request.Method.GET,url1, {
                response ->  val klaxonC = Klaxon().parseArray<bueno>(response)

            if (klaxonC != null) {
//                for (element in klaxonC){
//                   listaCasosi.add(element.case_Name)
//                   listaCasosi.add(element.label_Name)
//                }

                Toast.makeText(context, response, Toast.LENGTH_SHORT).show()


   //             Toast.makeText(context, listaCasos, Toast.LENGTH_SHORT).show()

//                adaptador = CasosAdapter(requireContext(), listaCasos!!)
//
//                listviewCasos.adapter = adaptador

            }

        }, { Toast.makeText(context, "algo salio mal", Toast.LENGTH_SHORT).show() })

        queue.add(stringRequest1)

//        val caso = Casos("Computadora HP dv15","Formateo",  R.drawable.verde)
//        val caso1 = Casos("Lenovo17","Reparacion",R.drawable.rojo)
//        val caso2 = Casos("Asus Ultra Book","Mantenimiento",R.drawable.amarillo)

//        listamuta = listOf(listdeCasos)

//        adaptador = CasosAdapter(requireContext(), listaCasos!!)

//        listviewCasos.adapter = adaptador

        listviewCasos.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                //ACTIVITY
                val intent = Intent(requireContext(), SolicitudActivity::class.java)
                startActivity(intent)
            }
    }

//    fun listLLamado(){
////        val listanueva = mutableListOf("Multa${listCodigo}")
//
//        val url1 = "https://api.apiupbateneo.xyz/Cases/list"
//
//        val queue = Volley.newRequestQueue(context)
//        var arrayAdapter:ArrayAdapter<*>
//
//
//        val stringRequest1 = StringRequest(Request.Builder.method(),url1, {
//                response ->  val klaxonC = Klaxon().parseArray(Casos).(response)
//
//            if (klaxonC != null) {
//                for (element in klaxonC){
//                    listaCasos.add(element.id.toString())
////                    listCodigo.add(element.codigo)
//                }
////                arrayAdapter = ArrayAdapter(context,android.R.layout.simple_expandable_list_item_1,listaCasos)
//////                val arrayAdapter = ListAdapter(this,listanueva)
//
//                listviewCasos.adapter = adaptador
//
//            }
//
//        }, { Toast.makeText(context, "algo salio mal", Toast.LENGTH_SHORT).show() })
//
//        queue.add(stringRequest1)
//
//        lvdatos.setOnItemClickListener { parent, view, position, id ->
//            val intent = Intent(this, ConsultaActivity::class.java)
//            intent.putExtra("id", listCodigo[position])
//            startActivity(intent)
//        }
//
//    }

    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.ivSearch -> {
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


