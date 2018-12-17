package net.robertogonzalez.examen.context

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_editar_lista.*
import net.robertogonzalez.examen.R
import net.robertogonzalez.examen.entities.Habilidad
import net.robertogonzalez.examen.entities.Lista
import net.robertogonzalez.examen.entities.Pokemon
import net.robertogonzalez.examen.entities.Tipo
import net.robertogonzalez.examen.services.ConexionSQL

class EditarLista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_lista)
        this.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        listarSpinner()
        var idLista = intent.getIntExtra("idLista",0)
        val db = ConexionSQL(this, null, 1)
        val lista : Lista? = db.buscarLista(idLista)

        val pokemon : Pokemon? = db.buscarPokemon(lista!!.idPokemon!!)
        val tipo : Tipo? = db.buscarTipo(lista.idTipo!!)
        val habilidad: Habilidad? = db.buscarHabilidad(lista.idHabilidad!!)
        val nombreListaEdit :TextView = findViewById(R.id.txtNombreListaEdit)

        nombreListaEdit.text = lista.nombre
 nombreListaEdit.text = lista.idTipo.toString()
        nombreListaEdit.text = lista.idHabilidad.toString()
        nombreListaEdit.text = lista.nombre
        lblEstadoListaEdit.text = if(lista.estado==1){"Activado"}else{"Desactivado"}


        sp_tipoEdit.setSelection(numeroSpinner(sp_tipoEdit,tipo!!.nombreTipo))
        sp_habilidadEdit.setSelection(numeroSpinner(sp_habilidadEdit,habilidad!!.nombreHabilidad))
        sp_pokemonEdit.setSelection(numeroSpinner(sp_pokemonEdit, pokemon!!.nombrePokemon!!))

    }

    fun numeroSpinner(sp : Spinner, nombre : String): Int{
        var posicion = 0;

        for (i in 0 until sp.count){
            if (sp.getItemAtPosition(i).toString().equals(nombre)){
                posicion=i
            }
        }

        return  posicion
    }

    fun listarSpinner(){
        var pokemones :ArrayList<Pokemon>  = ArrayList()
        var pokemonesActivos :ArrayList<Pokemon>  = ArrayList()
        var tipos : ArrayList<Tipo> = ArrayList()
        var tiposActivos : ArrayList<Tipo> = ArrayList()
        var habilidades : ArrayList<Habilidad> = ArrayList()
        var habilidadesActivas: ArrayList<Habilidad> = ArrayList()
        val db = ConexionSQL(this, null, 1)
        tipos = db.listarTipo()
        pokemones = db.listarPokemon()
        habilidades = db.listarHabilidad()

        for(hab in habilidades){
            if (hab.estado ==1){
                habilidadesActivas.add(hab)
            }
        }


        for (ti in tipos){
            if (ti.estado==1){
                tiposActivos.add(ti)
            }
        }

        for(poke in pokemones){
            if (poke.estado ==1){
                pokemonesActivos.add(poke)
            }
        }



        if (pokemonesActivos.size>0 && tiposActivos.size>0){
            sp_pokemonEdit.adapter =  ArrayAdapter<Pokemon>(this, android.R.layout.simple_expandable_list_item_1,pokemonesActivos)
            sp_tipoEdit.adapter = ArrayAdapter<Tipo>(this, android.R.layout.simple_expandable_list_item_1,tiposActivos)
            sp_habilidadEdit.adapter = ArrayAdapter<Habilidad>(this, android.R.layout.simple_expandable_list_item_1,habilidadesActivas)
        }else{
            Toast.makeText(this,"No hay datos activos", Toast.LENGTH_SHORT).show()
            finish()
        }


    }
}
