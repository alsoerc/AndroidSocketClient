package org.redes.jorge

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.redes.jorge.ui.LightView
import org.redes.jorge.ui.presenceView
import org.redes.jorge.ui.soundView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        menu_luz.setOnClickListener {
           var intent = Intent(this, LightView::class.java)
            startActivity(intent)
        }

        menu_sonido.setOnClickListener {
            var intent = Intent(this, soundView::class.java)
            startActivity(intent)
        }

        menu_movimiento.setOnClickListener {
            var intent = Intent(this, presenceView::class.java)
            startActivity(intent)
        }



    }
}
