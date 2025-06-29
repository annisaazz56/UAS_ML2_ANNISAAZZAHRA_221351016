package com.example.moneye

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)

        val recyclerView = findViewById<RecyclerView>(R.id.modelRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sections = listOf(
            ModelSection(
                "Arsitektur Model ANN",
                "",
                "Model Artificial Neural Network (ANN) ini dibangun menggunakan TensorFlow dan Keras untuk mendeteksi keaslian uang kertas. Model ini dilatih dengan 4 fitur numerik: Variance, Skewness, Curtosis, dan Entropy."
            ),
            ModelSection(
                "Preprocessing Dataset",
                "",
                "\uD83D\uDCCC Dataset yang digunakan berasal dari Banknote Authentication (UCI). Label sudah dalam bentuk numerik: 0 = Palsu, 1 = Asli. Tidak diperlukan encoding tambahan.\n\n" +
                        "\uD83D\uDCCC Fitur terdiri dari 4 kolom: Variance, Skewness, Curtosis, Entropy. Label berasal dari kolom 'class'.",
                R.drawable.label
            ),
            ModelSection(
                "Standarisasi dan Pembagian Data",
                "",
                "Data dibagi menggunakan `train_test_split`. Standarisasi dilakukan menggunakan `MinMaxScaler` agar setiap fitur berada dalam skala yang sama, meningkatkan stabilitas dan akurasi model.",
                R.drawable.traintest
            ),
            ModelSection(
                "Model ANN",
                "",
                "Model terdiri dari 4 layer:\n" +
                        "- Dense(32, activation='relu')\n" +
                        "- Dropout(0.3)\n" +
                        "- Dense(16, activation='relu')\n" +
                        "- Dense(2, activation='softmax')\n\n" +
                        "Model dikompilasi dengan optimizer Adam, loss function categorical_crossentropy, dan metrik evaluasi accuracy.",
                R.drawable.modelann
            ),
            ModelSection(
                "Visualisasi Arsitektur Model",
                "",
                "Gambar di bawah ini menampilkan struktur lapisan ANN lengkap dengan jumlah neuron di setiap layer.",
                R.drawable.plotmodel
            ),
            ModelSection(
                "Layer Output",
                "",
                "Output layer menghasilkan dua kemungkinan:\n0 = Palsu, 1 = Asli. Hasil klasifikasi ditentukan berdasarkan probabilitas tertinggi dari layer Softmax.",
                R.drawable.dense
            ),
            ModelSection(
                "Evaluasi dan Akurasi Model",
                "",
                "Model diuji dengan data testing untuk mengevaluasi performanya. Hasil evaluasi menunjukkan nilai akurasi dan loss. Selain itu, grafik akurasi ditampilkan untuk melihat perkembangan model selama pelatihan.\n\n" +
                        "- Akurasi menunjukkan proporsi prediksi yang benar\n" +
                        "- Loss mencerminkan kesalahan prediksi oleh model\n\n" +
                        "Metrik yang digunakan adalah `accuracy` karena output merupakan klasifikasi antara dua kelas: Asli atau Palsu.",
                R.drawable.accuracy_graph
            ),
            ModelSection(
                "Konversi ke TensorFlow Lite",
                "",
                "Setelah model ANN dilatih, model disimpan dalam format `.h5` lalu dikonversi menjadi `.tflite` menggunakan `TFLiteConverter`. Konversi ini memungkinkan model digunakan secara offline di aplikasi Android. Proses optimasi juga diterapkan untuk memperkecil ukuran model.",
                R.drawable.tflite
            ),
            ModelSection(
                "Penyimpanan Skaler",
                "",
                "Untuk menjaga konsistensi input antara saat pelatihan dan prediksi, skaler `MinMaxScaler` disimpan dalam file `.pkl` menggunakan library `joblib`. Skaler ini digunakan kembali di aplikasi Android agar skala data tetap sesuai.",
                R.drawable.scaler
            )
        )

        recyclerView.adapter = ModelAdapter(sections)
    }
}