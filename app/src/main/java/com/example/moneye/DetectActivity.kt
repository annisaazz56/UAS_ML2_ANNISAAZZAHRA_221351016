package com.example.moneye

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.moneye.ml.Banknote
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class DetectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detect)

        val input1 = findViewById<EditText>(R.id.editVariance)
        val input2 = findViewById<EditText>(R.id.editSkewness)
        val input3 = findViewById<EditText>(R.id.editCurtosis)
        val input4 = findViewById<EditText>(R.id.editEntropy)
        val resultView = findViewById<TextView>(R.id.textResult)
        val buttonDetect = findViewById<Button>(R.id.btnDetect)

        buttonDetect.setOnClickListener {
            val v1 = input1.text.toString().toFloatOrNull()
            val v2 = input2.text.toString().toFloatOrNull()
            val v3 = input3.text.toString().toFloatOrNull()
            val v4 = input4.text.toString().toFloatOrNull()

            if (v1 == null || v2 == null || v3 == null || v4 == null) {
                Toast.makeText(this, "Isi semua input dengan angka yang valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isValidDecimal = listOf(input1, input2, input3, input4).all {
                val text = it.text.toString()
                text.contains(".") && text.substringAfter(".").length >= 3
            }

            if (!isValidDecimal) {
                Toast.makeText(this, "Masukkan minimal 3 angka di belakang koma (contoh: 1.234)", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val byteBuffer = ByteBuffer.allocateDirect(4 * 4)
            byteBuffer.order(ByteOrder.nativeOrder())
            byteBuffer.putFloat(v1)
            byteBuffer.putFloat(v2)
            byteBuffer.putFloat(v3)
            byteBuffer.putFloat(v4)

            val model = Banknote.newInstance(this)
            val inputTensor = TensorBuffer.createFixedSize(intArrayOf(1, 4), DataType.FLOAT32)
            inputTensor.loadBuffer(byteBuffer)

            val outputs = model.process(inputTensor)
            val prediction = outputs.outputFeature0AsTensorBuffer.floatArray[0]

            val result = if (prediction >= 0.5f) "Asli" else "Palsu"
            resultView.text = "Ini adalah uang $result"

            model.close()
        }
    }
}
