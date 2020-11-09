package com.example.utspemrogramanmobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class web_fakultas : AppCompatActivity() {
    // Inisiasi Javascript
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting Layout
        setContentView(R.layout.web_fakultas)
        // Inisiasi WebView
        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        // Inisiasi Intent
        val intentFromFac = intent
        if (intentFromFac.hasExtra(Intent.ACTION_VIEW)) {
            // Grab Intent Detail Fac
            val partWeb = intentFromFac.getStringExtra(Intent.ACTION_VIEW)

            if (partWeb != null) {
                webView.loadUrl(partWeb)
            }
        }
    }
}


