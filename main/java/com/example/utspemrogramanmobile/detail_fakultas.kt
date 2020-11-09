package com.example.utspemrogramanmobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail.*

class detail_fakultas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting Tampilan Konten Layout Dari detail_fac.xml
        setContentView(R.layout.detail)
        // Inisiasi Intent
        var intentThatStartedThisActivity = intent
        // Check EXTRA_INTENT
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_INTENT)) {
            // Masuk Ke Function
            showContent(intentThatStartedThisActivity)
        }
    }
    private fun showContent(intentThatStartedThisActivity: Intent) {
        // Inisiasi Val
        var nameF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INTENT)
        var deskF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
        var deskS = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
        var imgF = intentThatStartedThisActivity.getIntExtra(Intent.EXTRA_TEXT, 0)
        var emailF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
        var webF = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_ORIGINATING_URI)
        // Convert To Layout
        tv_name_detail.text = nameF
        tv_desc_detail.text = deskF
        tv_short_detail.text = deskS
        tv_link_email.text = emailF
        tv_link_web.text = webF
        image_detail.contentDescription = nameF
        image_detail.setImageResource(imgF)
        if (emailF == "") {
            tv_link_email.text = ""
            tv_email_detail.text = ""
        } else {
            tv_link_email.text = emailF
        }
        if (webF == "") {
            tv_link_web.text = ""
            tv_website_detail.text = ""
        } else {
            tv_link_web.text = webF
        }

        tv_link_email.setOnClickListener {
            //Jalankan function klikWeb dengan parameter partWeb

                clickEmail(emailF)

        }
        tv_link_web.setOnClickListener {
            //Jalankan function klikWeb dengan parameter partWeb

                clickWeb(webF)

        }
    }
    private fun clickEmail(email: String?) {
        // Intent Send for call 3rd application in your device
        val mailIntent = Intent(Intent.ACTION_SEND)
        // Component for email
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        // Penerima menggunakan array, karena emaiil dikirim ke beberapa penerima
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        // For Subject
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "From Faculty Profile Ver 2")
        // For Isi Email
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Attention")
        startActivity(Intent.createChooser(mailIntent, "Choose Email..."))
    }
    private fun clickWeb(url: String?) {
        val showWebActivity = Intent(this, web_fakultas::class.java)
        //Kiriman Intent
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        //Menjalankan Activity FakultasWeb dengan Intent
        startActivity(showWebActivity)
    }
}

