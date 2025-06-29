package com.example.moneye

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<LinearLayout>(R.id.btnDetect).setOnClickListener {
            startActivity(Intent(this, DetectActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnFeature).setOnClickListener {
            startActivity(Intent(this, FeatureActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnDataset).setOnClickListener {
            startActivity(Intent(this, DatasetActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnModel).setOnClickListener {
            startActivity(Intent(this, ModelActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.btnExit).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Keluar")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ -> finishAffinity() }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}
