package net.robertogonzalez.examen.views.adapters

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.item_estadistica.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import net.robertogonzalez.examen.entities.Lista
import net.robertogonzalez.examen.R

class AdapterEstadistica(val miLista:ArrayList<Lista>?) : RecyclerView.Adapter<AdapterEstadistica.ViewHolder>() , View.OnClickListener{


    override fun onClick(p0: View?) {
        Toast.makeText(p0!!.context,"clic", Toast.LENGTH_LONG).show()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_estadistica, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(miLista!![position])
    }


    override fun getItemCount(): Int {
        return miLista!!.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(list: Lista) {
            var vista = itemView
            var nombreLista: TextView = vista.findViewById(R.id.lblNombreListaE)
            var linearLayout : LinearLayout = vista.findViewById(R.id.linearEstadistica)
            var  idLista : TextView = vista.findViewById(R.id.lblID)



            nombreLista.text = list.nombre

            idLista.text = list.idLista.toString()

            if (list.idLista!! <=5){
                linearLayout.setBackgroundColor(ContextCompat.getColor(vista.context,
                    R.color.abc_secondary_text_material_dark
                ))
            }

            if (list.idLista!!>=6 ) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(vista.context,
                    R.color.amarilloMedio
                ))
            }
            if (list.idLista!!>=20){
                linearLayout.setBackgroundColor(ContextCompat.getColor(vista.context,
                    R.color.verdeMucho
                ))
            }
        }
    }

}