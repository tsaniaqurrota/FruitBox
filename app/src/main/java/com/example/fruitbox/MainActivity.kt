package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        var adapterFruit = FruitAdapter(generateFruitsData()) {
                fruit ->
            Toast.makeText(this@MainActivity, "Anda memilih ${fruit.name}",
                Toast.LENGTH_SHORT).show()


            val intent = Intent(this, DetailFruitActivity::class.java)

            intent.putExtra("fruit_name", fruit.name)
            intent.putExtra("fruit_type", fruit.type)
            intent.putExtra("fruit_status", fruit.status)
            intent.putExtra("fruit_price", fruit.price)
            intent.putExtra("fruit_desc", fruit.desc)
            intent.putExtra("fruit_image", fruit.imageFruitId)

            startActivity(intent)
        }
        with(binding) {
            rvStudents.apply {
                adapter = adapterFruit
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruitsData() : List<Fruit>{
        return listOf(
            Fruit(
                name = "Mangga",
                type = "Manalagi",
                status = "TERSEDIA",
                price = "Rp 15.000,-/kg",
                desc = "Ini desc. Ini desc. Ini desc.Ini desc.Ini desc",
                imageFruitId = R.drawable.mangga_manalagi),
            Fruit(
                name = "Jeruk",
                type = "Siam",
                status = "KOSONG",
                price = "Rp 13.000,-/kg",
                desc = "Ini desc. Ini desc. Ini desc.Ini desc.Ini desc",
                imageFruitId = R.drawable.jeruk_siam
            ),
            Fruit(
                name = "Anggur",
                type = "Crimson",
                status = "TERSEDIA",
                price = "Rp 16.000,-/kg",
                desc = "Ini desc. Ini desc. Ini desc.Ini desc.Ini desc",
                imageFruitId = R.drawable.anggur_merah),
            Fruit(
                name = "Apel",
                type = "Fuji",
                status = "TERSEDIA",
                price = "Rp 14.000,-/kg",
                desc = "Ini desc. Ini desc. Ini desc.Ini desc.Ini desc",
                imageFruitId = R.drawable.apel_fuji),



            )
    }
}