package com.example.moneye

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FeatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        val fiturList = listOf(
            Fitur(
                "1). Variance",
                "Float64",
                "Numerik",
                "Mengukur penyebaran nilai pixel dari hasil transformasi wavelet. Digunakan untuk mendeteksi tekstur dan pola cetakan uang."
            ),
            Fitur(
                "2). Skewness",
                "Float64",
                "Numerik",
                "Menunjukkan kemiringan distribusi pixel setelah wavelet transform. Membantu mengidentifikasi distribusi tinta atau cetakan miring."
            ),
            Fitur(
                "3). Curtosis",
                "Float64",
                "Numerik",
                "Mengukur ketajaman distribusi pixel. Nilai tinggi menunjukkan puncak tajam, sedangkan nilai rendah menunjukkan distribusi datar."
            ),
            Fitur(
                "4). Entropy",
                "Float64",
                "Numerik",
                "Mengukur tingkat kerandoman atau kompleksitas dari citra uang. Nilai entropy tinggi menunjukkan gambar lebih kompleks."
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvFitur)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FiturAdapter(fiturList)
    }
}
