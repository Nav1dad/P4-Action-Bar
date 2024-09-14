package com.example.p_toolbar

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var myToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myToolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.camara -> {
                Toast.makeText(this, "Abriendo camara", Toast.LENGTH_LONG).show()
                true
            }
            R.id.compartir -> {
                Toast.makeText(this, "Compartiendo datos", Toast.LENGTH_LONG).show()
                true
            }
            R.id.ajustes -> {
                val intent = Intent(this,Ajustes::class.java)
                startActivity(intent)
                true
            }
            R.id.salir -> {
                finish()
                true
            }

            else -> false
        }
    }
}
