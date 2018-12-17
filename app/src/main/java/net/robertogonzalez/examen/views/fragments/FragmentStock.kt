package net.robertogonzalez.examen.views.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import net.robertogonzalez.examen.services.ConexionSQL
import net.robertogonzalez.examen.entities.Lista
import net.robertogonzalez.examen.R
import net.robertogonzalez.examen.views.adapters.AdapterEstadistica


class FragmentStock : Fragment() {

    var miContexto : Context?= null

    var arrayLista: ArrayList<Lista>? = null
    var lista: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adaptador: AdapterEstadistica? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_stock, container, false)

        lista = view.findViewById(R.id.rv_estadistica)
        layoutManager = LinearLayoutManager(miContexto)

        var conn = ConexionSQL(miContexto!!, null, 1)
        arrayLista = conn.listarLista()

        adaptador = AdapterEstadistica(arrayLista!!)
        lista?.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador

        return view
    }

    override fun onResume() {
        layoutManager = LinearLayoutManager(miContexto)
        var conn = ConexionSQL(miContexto!!, null, 1)
        arrayLista = conn.listarLista()

        adaptador = AdapterEstadistica(arrayLista!!)
        lista?.layoutManager = LinearLayoutManager(miContexto, LinearLayout.VERTICAL,false)
        lista?.adapter = adaptador
        super.onResume()
    }
}
