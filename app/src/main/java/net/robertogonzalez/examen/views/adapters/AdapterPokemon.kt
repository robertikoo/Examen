package net.robertogonzalez.examen.views.adapters

import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import net.robertogonzalez.examen.services.ConexionSQL
import net.robertogonzalez.examen.context.EditarPokemon
import net.robertogonzalez.examen.entities.Pokemon
import net.robertogonzalez.examen.R

class AdapterPokemon(val miLista: ArrayList<Pokemon>?) : RecyclerView.Adapter<AdapterPokemon.ViewHolder>(),
    View.OnClickListener {

    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context, "clic", Toast.LENGTH_LONG).show()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(miLista!![position])
    }


    override fun getItemCount(): Int {
        return miLista!!.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(poke: Pokemon) {
            var vista = itemView

            var nombrePokemon: TextView = vista.findViewById(R.id.lblNombreP)

            val boton: Button = vista.findViewById(R.id.btnDesactivarP)
            val boton2: ImageButton = vista.findViewById(R.id.btnActualizarP)
            val fotoImageView: ImageView = vista.findViewById(R.id.fotoImageView)


            Glide.with(itemView.context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + poke.numero + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(fotoImageView)


            nombrePokemon.text = poke.nombrePokemon





            if (poke.estado == 1) {
                boton.setText("Activado")
            } else {
                boton.setText("Desactivado")
            }

            boton.setOnClickListener {
                val alerta = AlertDialog.Builder(vista.context)
                alerta.setTitle("Eliminar")
                var estado = "Activar"
                var valor = 0
                if (poke.estado == 1) {
                    estado = "Desactivar"
                    valor = 0
                } else {
                    estado = "Activar"
                    valor = 1
                }

                alerta.setMessage("¿Estás seguro que quieres $estado Pokemon2?")
                alerta.setPositiveButton("Si", { dialog, which ->
                    val db = ConexionSQL(vista.context, null, 1)
                    poke.estado = valor
                    db.actualizarPokemon(poke)
                    bindItems(poke)
                })
                alerta.setNegativeButton("No", { dialog, which ->
                    dialog.cancel()
                })

                alerta.show()
            }

            boton2.setOnClickListener {
                var id = poke.idPokemon
                var intento: Intent = Intent(vista.context, EditarPokemon::class.java)
                intento.putExtra("idPokemon", id)
                ContextCompat.startActivity(vista.context, intento, null)
            }
        }
    }
}