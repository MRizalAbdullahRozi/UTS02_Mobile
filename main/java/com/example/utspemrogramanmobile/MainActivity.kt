package com.example.utspemrogramanmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = createFac()
        myrecyclerview.layoutManager = LinearLayoutManager(this)
        myrecyclerview.setHasFixedSize(true)
        myrecyclerview.adapter = adapter_fakultas(data, { onItem: data_fakultas -> onItemClicked(onItem)})
    }

    private fun onItemClicked(onItem: data_fakultas) {
        val showDetailActivityIntent = Intent(this, detail_fakultas::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, onItem.imgFak)
        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, onItem.namaFakultas)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, onItem.DescFakultas)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, onItem.descprodi)
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, onItem.emailFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI, onItem.webFac)
        startActivity(showDetailActivityIntent)
    }

    private fun createFac(): List<data_fakultas> {
        val rvList = ArrayList<data_fakultas>()
        rvList.add(
            data_fakultas(
                R.drawable.feb,
                "Fakultas Ekonomi Dan Bisnis",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Ekonomi Pembangunan\n" +
                        "2. Akuntansi\n" +
                        "3. Manajemen",
                "feb@upnjatim.ac.id",
                "https://febis.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.fp,
                "Fakultas Pertanian",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Agroteknologi\n" +
                        "2. Agribisnis",
                "-",
                "http://faperta.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.ft,
                "Fakultas Teknik",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Teknik Kimia\n" +
                        "2. Teknik Industri\n" +
                        "3. Teknik Sipil\n" +
                        "4. Teknik Lingkungan\n" +
                        "5. Teknologi Pangan",

                "-",
                "http://ft.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.fisip,
                "Fakultas Ilmu Sosial dan Politik",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Administrasi Bisnis\n" +
                        "2. Administrasi Negara\n" +
                        "3. Hubungan Internasional",

                "-",
                "http://fisip.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.fik,
                "Fakultas Ilmu Komputer",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Teknik Informatika\n" +
                        "2. Sistem Informasi\n" +
                        "3. Data Sains",
                "-",
                "https://fik.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.fad,
                "Fakultas Arsitektur Dan Desain",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Teknik Arsitektur\n" +
                        "2. Desain Komunikasi Visual",
                "fad@upnjatim.ac.id",
                "http://fad.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.hukum,
                "Fakultas Hukum",
                "merupakan salah satu dari 7\n" +
                        "Fakultas 'Veteran' Jawa\n" +
                        "Timur. Yang terdiri dari program\n" +
                        "studi: ",
                "1. Hukum",
                "-",
                "http://fhukum.upnjatim.ac.id/"
            )
        )
        rvList.add(
            data_fakultas(
                R.drawable.rizal,
                "Profil Saya",
                "Nama : M Rizal Abdullah Rozi\n" +
                        "TTL : Magetan, 03 Juli 2000\n" +
                        "Alamat : Perumahan Pesona Permata Ungu Blok D no 21, Krian, Sidoarjo\n" +
                        "Nomor Telepon : 085704712640\n",
                "Riwayat Pendidikan : \n" +
                        "\t\t 1. SDN Watugolong 2 Krian \n" +
                        "\t\t 2. SMP Al Islam Krian \n" +
                        "\t\t 3. SMK Telekomunikasi DU \n\n" +
                        "Penghargaan : -",
                "Email : zalrizal040416@gmail.com",
                "Github : https://github.com/MRizalAbdullahRozi"
            )
        )
        return rvList
    }
}

