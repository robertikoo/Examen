package net.robertogonzalez.examen.views.fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_pokemones.*
import net.robertogonzalez.examen.context.AgregarPokemon
import net.robertogonzalez.examen.services.ConexionSQL
import net.robertogonzalez.examen.R
import net.robertogonzalez.examen.views.adapters.AdapterPokemon


class FragmentPokemones : Fragment() {

    var miContexto : Context? = null
    var adaptador: AdapterPokemon? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = inflater.inflate(R.layout.fragment_pokemones, container, false)

        val botonAgregar: FloatingActionButton = view.findViewById(R.id.btnAgregarP)
        var list : RecyclerView = view.findViewById(R.id.lv_Pokemon)

        var conn = ConexionSQL(miContexto!!, null, 1)
        val arrayPokemon = conn.listarPokemon()
        adaptador = AdapterPokemon(arrayPokemon!!)
        list?.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        list?.adapter = adaptador


        botonAgregar.setOnClickListener {
            var intento: Intent = Intent(miContexto, AgregarPokemon::class.java)
            startActivity(intento)
        }

        return view
    }

    override fun onResume() {
        var conn = ConexionSQL(miContexto!!, null, 1)
        val arrayPokemon = conn.listarPokemon()
        adaptador = AdapterPokemon(arrayPokemon!!)
        lv_Pokemon.layoutManager = LinearLayoutManager(miContexto,LinearLayout.VERTICAL,false)
        lv_Pokemon.adapter = adaptador
        super.onResume()
    }
}