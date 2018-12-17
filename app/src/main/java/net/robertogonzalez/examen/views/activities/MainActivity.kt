package net.robertogonzalez.examen.views.activities

import android.content.pm.ActivityInfo
import java.util.Calendar
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import net.robertogonzalez.examen.R
import net.robertogonzalez.examen.entities.Habilidad
import net.robertogonzalez.examen.entities.Pokemon
import net.robertogonzalez.examen.entities.Tipo
import net.robertogonzalez.examen.services.ConexionSQL
import net.robertogonzalez.examen.views.fragments.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var conn = ConexionSQL(this, null, 1)
        if (conn.listarTipo().size > 0 && conn.listarPokemon().size > 0) {
            fab.visibility = View.GONE
        }

        fab.setOnClickListener { view ->
            var tip1 = Tipo(1, "Acero", 1)
            var tip2 = Tipo(1, "Agua", 1)
            var tip3 = Tipo(1, "Bicho", 1)
            var tip4 = Tipo(1, "Dragon", 1)
            var tip5 = Tipo(1, "Electrico", 1)
            var tip6= Tipo(1, "Fantasma", 1)
            var tip7 = Tipo(1, "Fuego", 1)
            var tip8 = Tipo(1, "Hada", 1)
            var tip9 = Tipo(1, "Hielo", 1)
            var tip10 = Tipo(1, "Lucha", 1)
            var tip11 = Tipo(1, "Normal", 1)
            var tip12 = Tipo(1, "Planta", 1)
            var tip13 = Tipo(1, "Psiquico", 1)
            var tip14 = Tipo(1, "Roca", 1)
            var tip15 = Tipo(1, "Siniestro", 1)
            var tip16 = Tipo(1, "Tierra", 1)
            var tip17 = Tipo(1, "Veneno", 1)
            var tip18 = Tipo(1, "Volador", 1)

            conn.insertarTipo(tip1)
            conn.insertarTipo(tip2)
            conn.insertarTipo(tip3)
            conn.insertarTipo(tip4)
            conn.insertarTipo(tip5)
            conn.insertarTipo(tip6)
            conn.insertarTipo(tip7)
            conn.insertarTipo(tip8)
            conn.insertarTipo(tip9)
            conn.insertarTipo(tip10)
            conn.insertarTipo(tip11)
            conn.insertarTipo(tip12)
            conn.insertarTipo(tip13)
            conn.insertarTipo(tip14)
            conn.insertarTipo(tip15)
            conn.insertarTipo(tip16)
            conn.insertarTipo(tip17)
            conn.insertarTipo(tip18)


            var conn = ConexionSQL(this, null, 1)
            var hab1 = Habilidad(1, "Vaporeon, Poliwrath, chinchou" , 1)
            conn.insertarHabilidad(hab1)
            var hab2 = Habilidad(1, "Jolteon, Lanturn, Minun", 1)
            conn.insertarHabilidad(hab2)
            var hab3 = Habilidad(1, "Vulpix, Lampent, Cyndaquil", 1)
            conn.insertarHabilidad(hab3)
            var hab4 = Habilidad(1, "Psyduck, Drampa, Aitaria", 1)
            conn.insertarHabilidad(hab4)
            var hab5 = Habilidad(1, "Larvitar, Rattata,Flareon", 1)
            conn.insertarHabilidad(hab5)
            var hab6 = Habilidad(1, "Amorith, Kabuto, Cubone", 1)
            conn.insertarHabilidad(hab6)
            var hab7 = Habilidad(1, "Slakoth, Slakint, Durant", 1)
            conn.insertarHabilidad(hab7)
            var hab8 = Habilidad(1, "Rayquaza", 1)
            conn.insertarHabilidad(hab8)
            var hab9 = Habilidad(1, "Bagon, Geodude, Marowak", 1)
            conn.insertarHabilidad(hab9)
            var hab10 = Habilidad(1, "Kecleon", 1)
            conn.insertarHabilidad(hab10)
            var hab11 = Habilidad(1, "Mega, Shelder, Torkoal", 1)
            conn.insertarHabilidad(hab11)
            var hab12 = Habilidad(1, "Tyranitar", 1)
            conn.insertarHabilidad(hab12)
            var hab13 = Habilidad(1, "Oddish, Tangela, Bulbasur", 1)
            conn.insertarHabilidad(hab13)
            var hab14 = Habilidad(1, "Krabby, kingler, Pinsir", 1)
            conn.insertarHabilidad(hab14)
            var hab15 = Habilidad(1, "Beldum, Tentacool, Tentacruel", 1)
            conn.insertarHabilidad(hab15)
            var hab16 = Habilidad(1, "Lotad, Squirte, Tentacool", 1)
            conn.insertarHabilidad(hab16)
            var hab17 = Habilidad(1, "Slowpoke, Wallord, Spheal", 1)
            conn.insertarHabilidad(hab17)
            var hab18 = Habilidad(1, "Jirachi, Happiny, Deerling", 1)
            conn.insertarHabilidad(hab18)
            var hab19 = Habilidad(1, "Foogus, Shrromish, Villeplume", 1)
            conn.insertarHabilidad(hab19)
            var hab20 = Habilidad(1, "Deino, Togepi, Nirodina", 1)
            conn.insertarHabilidad(hab20)
            var hab21 = Habilidad(1, "Milotic, Dragonair", 1)
            conn.insertarHabilidad(hab21)
            var hab22 = Habilidad(1, "Slugma, Magcargo, Camerut", 1)
            conn.insertarHabilidad(hab22)
            var hab23 = Habilidad(1, "Bulbasur, Venusaur, Pansage", 1)
            conn.insertarHabilidad(hab23)
            var hab24 = Habilidad(1, "Vigoroth, Pensian, Electabuzz", 1)
            conn.insertarHabilidad(hab24)
            var hab25 = Habilidad(1, "Ditto, Persian, Buneary", 1)
            conn.insertarHabilidad(hab25)
            var hab26 = Habilidad(1, "Zubat, Abra, Drawzee", 1)
            conn.insertarHabilidad(hab26)
            var hab27 = Habilidad(1, "Whismur, Hakamo-o, Sheildon, Bastiodon", 1)
            conn.insertarHabilidad(hab27)
            var hab28 = Habilidad(1, "Minun, Klink, Electrike", 1)
            conn.insertarHabilidad(hab28)
            var hab29 = Habilidad(1, "Metapood, Ekans, Arbok", 1)
            conn.insertarHabilidad(hab29)








            val c = Calendar.getInstance()
            val anio = c.get(Calendar.YEAR)
            val mes = c.get(Calendar.MONTH)
            val dia = c.get(Calendar.DAY_OF_MONTH)
            var m = mes + 1
            var fecha: String = "$dia/$m/$anio"

            var poke = Pokemon(1, "prueba pokemon", "1", fecha, 1)
            conn.insertarPokemon(poke)
            fab.visibility = View.GONE
            Snackbar.make(view, "Agregados datos de prueba ;)", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        var miFrag = FragmentPortada()
        ft.replace(R.id.fragLay, miFrag)
        ft.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fm = supportFragmentManager
        var ft = fm.beginTransaction()


        when (item.itemId) {
            R.id.pokemon_list -> {
                val miFrag = PokemonesFragment()
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }


            R.id.nav_habilidades -> {
                var miFrag = FragmentHabilidades()
                miFrag.miContexto = this
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }

            R.id.nav_tipos -> {
                var miFrag = FragmentTipos()
                miFrag.miContexto = this
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }

            R.id.nav_pokemones -> {
                var miFrag = FragmentPokemones()
                miFrag.miContexto = this
                //miFrag.clientes = this.clientes
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }

            R.id.nav_listas -> {
                var miFrag = FragmentListas()
                miFrag.miContexto = this
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }

            R.id.nav_detalles -> {
                var miFrag = FragmentStock()
                miFrag.miContexto = this
                ft.replace(R.id.fragLay, miFrag)
                ft.commit()
            }
            R.id.nav_salir -> {
                finish()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
