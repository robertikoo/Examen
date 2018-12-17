package net.robertogonzalez.examen.context

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_lista.*
import net.robertogonzalez.examen.R
import net.robertogonzalez.examen.entities.Habilidad
import net.robertogonzalez.examen.entities.Lista
import net.robertogonzalez.examen.entities.Pokemon
import net.robertogonzalez.examen.entities.Tipo
import net.robertogonzalez.examen.services.ConexionSQL


class AgregarLista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_lista)
        this.requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        listarSpinner()







        var idTipo: String = ""
        var idHabilidad: String = ""

        var estado: Int =1



        var nombreP: String =""



        btnAgregarLista.setOnClickListener {


            var pokemon = sp_pokemon.selectedItem as Pokemon
            var tipo = sp_tipo.selectedItem as Tipo
            var habilidad = sp_habilidad.selectedItem as Habilidad



            if(TextUtils.isEmpty(txtNombreLista.text.toString())){
                txtNombreLista.error = "Ingrese nombre lista"
                return@setOnClickListener
            }else{
                nombreP = txtNombreLista.text.toString()
            }


            var lista = Lista(
                1,
                nombreP,
                pokemon.idPokemon,
                tipo.idTipo,
                habilidad.idHabilidad,
                1
            )

            var conn = ConexionSQL(this, null, 1)

            conn.insertarLista(lista)

            finish()

        }


    }

    fun listarSpinner(){
        var pokemones :ArrayList<Pokemon>  = ArrayList()
        var tipos : ArrayList<Tipo> = ArrayList()
        var habilidades: ArrayList<Habilidad> = ArrayList()
        val db = ConexionSQL(this, null, 1)
        habilidades = db.listarHabilidad()
        tipos = db.listarTipo()
        pokemones = db.listarPokemon()


        var habilidadesActivas: ArrayList<Habilidad> = ArrayList()
        var tiposActivos : ArrayList<Tipo> = ArrayList()
        var pokemonesActivos :ArrayList<Pokemon>  = ArrayList()

        for (ha in habilidades){
            if (ha.estado==1){
                habilidadesActivas.add(ha)
            }
        }
        for (ti in tipos){
            if (ti.estado==1){
                tiposActivos.add(ti)
            }
        }

        for(lis in pokemones){
            if (lis.estado ==1){
                pokemonesActivos.add(lis)
            }
        }

        if (pokemonesActivos.size>0 && tiposActivos.size>0){
            sp_pokemon.adapter =  ArrayAdapter<Pokemon>(this, android.R.layout.simple_expandable_list_item_1, pokemonesActivos)
            sp_tipo.adapter = ArrayAdapter<Tipo>(this, android.R.layout.simple_expandable_list_item_1,tiposActivos)
            sp_habilidad.adapter = ArrayAdapter<Habilidad>(this, android.R.layout.simple_expandable_list_item_1,habilidadesActivas)
        }else{
            Toast.makeText(this,"Faltan Datos", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

