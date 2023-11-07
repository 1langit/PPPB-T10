package com.example.pppb_t10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pppb_t10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterMahasiswa = MahasiswaAdapter(generateMahasiswa()) {
            mahasiswa ->
            Toast.makeText(this@MainActivity, mahasiswa.nama, Toast.LENGTH_SHORT).show()
            val intentToDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)
            intentToDetailActivity.putExtra("nama", mahasiswa.nama)
            intentToDetailActivity.putExtra("nim", mahasiswa.nim)
            intentToDetailActivity.putExtra("img", mahasiswa.img)
            intentToDetailActivity.putExtra("ipk", mahasiswa.ipk)
            startActivity(intentToDetailActivity)
        }

        with(binding) {
            rvMahasiswa.apply {
                adapter = adapterMahasiswa
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateMahasiswa() : List<Mahasiswa> {
        return listOf(
            Mahasiswa(nama = "Jonathan Nathan", nim = "22/501269/SV/21425", img = "https://picsum.photos/id/103/200", ipk = 3.4),
            Mahasiswa(nama = "Hannah Susanah", nim = "22/496503/SV/14569", img = "https://picsum.photos/id/832/200", ipk = 2.9),
            Mahasiswa(nama = "Syrtyr Irine", nim = "22/514263/SV/24513", img = "https://picsum.photos/id/660/200", ipk = 4.0),
            Mahasiswa(nama = "Gerald Fauzan", nim = "22/500000/SV/20000", img = "https://picsum.photos/id/91/200", ipk = 2.3),
            Mahasiswa(nama = "Vertin Veluriyan", nim = "22/501437/SV/19192", img = "https://picsum.photos/id/65/200", ipk = 3.7),
            Mahasiswa(nama = "Nova Avian", nim = "22/501437/SV/13545", img = "https://picsum.photos/id/177/200", ipk = 2.5),
            Mahasiswa(nama = "Stella Fortuna", nim = "22/548642/SV/20354", img = "https://picsum.photos/id/680/200", ipk = 3.5),
            Mahasiswa(nama = "Anton Kowalski", nim = "22/511435/SV/21354", img = "https://picsum.photos/id/447/200", ipk = 2.4),
            Mahasiswa(nama = "Rick Ashley", nim = "22/521626/SV/16985", img = "https://picsum.photos/id/823/200", ipk = 3.2),
            Mahasiswa(nama = "Vina Furina", nim = "22/516845/SV/25685", img = "https://picsum.photos/id/129/200", ipk = 2.6)
        )
    }
}