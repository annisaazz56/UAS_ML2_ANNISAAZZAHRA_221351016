package com.example.moneye

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val linkText = "Link Dataset: Banknote Authentication UCI"
        val spannableString = SpannableString(linkText)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val url = "https://www.kaggle.com/datasets/shantanuss/banknote-authentication-uci"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }

        val startIndex = linkText.indexOf("Banknote")
        val endIndex = linkText.length
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val textView = findViewById<TextView>(R.id.linkDataset)
        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}
