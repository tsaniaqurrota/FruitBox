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
                desc = "Mangga Manalagi memiliki rasa manis dan lezat dengan sedikit keasaman.Mangga mengandung banyak vitamin dan antioksidan yang baik untuk kesehatan kulit, sistem kekebalan tubuh, serta pencernaan",
                imageFruitId = R.drawable.mangga_manalagi),
            Fruit(
                name = "Jeruk",
                type = "Siam",
                status = "KOSONG",
                price = "Rp 13.000,-/kg",
                desc = " Jeruk Siam memiliki rasa segar, manis, dan sedikit asam. Buah ini kaya akan vitamin C dan mendukung sistem kekebalan tubuh, serta baik untuk kesehatan jantung.",
                imageFruitId = R.drawable.jeruk_siam
            ),
            Fruit(
                name = "Anggur",
                type = "Crimson",
                status = "TERSEDIA",
                price = "Rp 16.000,-/kg",
                desc = "Anggur adalah buah yang ditanam di berbagai wilayah dunia, dengan varietas Crimson berasal dari Amerika Serikat. Anggur Crimson memiliki rasa manis dan unik. Buah ini merupakan sumber antioksidan dan serat yang baik untuk kesehatan jantung dan melawan radikal bebas.",
                imageFruitId = R.drawable.anggur_merah),
            Fruit(
                name = "Apel",
                type = "Fuji",
                status = "TERSEDIA",
                price = "Rp 14.000,-/kg",
                desc = " Apel Fuji memiliki rasa manis yang renyah.Buah ini kaya akan serat dan vitamin, yang baik untuk pencernaan dan menjaga kesehatan tubuh.",
                imageFruitId = R.drawable.apel_fuji),
            Fruit(
                name = "Nanas",
                type = "Madu",
                status = "KOSONG",
                price = "Rp 16.000,-/kg",
                desc = "Nanas Madu biasanya memiliki kulit yang berwarna kuning cerah dan daging yang sangat juicy. Rasanya yang manis membuatnya menjadi camilan yang populer, baik saat dimakan secara langsung atau digunakan dalam berbagai hidangan, seperti salad buah, jus, dan makanan penutup tropis. Nanas Madu juga dikenal kaya akan nutrisi, seperti vitamin C dan serat, menjadikannya pilihan yang sehat dan lezat.",
                imageFruitId = R.drawable.nanas_madu),
            Fruit(
                name = "Manggis",
                type = "Raya",
                status = "KOSONG",
                price = "Rp 17.000,-/kg",
                desc = "Buah manggis yang berasal asal Kabupaten Bogor ini memiliki keunggulan dari segi cita rasanya yang sangat anggun. Selain itu ukuran daging buahnya juga mungil sehingga daging buah terasa lebih tebal. ukuran butir manggis raya terbilang mini dengan warna buah merah keunguan.",
                imageFruitId = R.drawable.manggis_raya),
            Fruit(
                name = "Pir",
                type = "Asian",
                status = "TERSEDIA",
                price = "Rp 13.000,-/kg",
                desc = "Pir Asia, juga dikenal dengan sebutan \"Asian Pear\" atau \"Nashi Pear,\" adalah jenis pir yang berasal dari Asia Timur. Buah ini memiliki tekstur yang renyah dan segar, mirip dengan apel, namun memiliki rasa manis dengan sedikit sentuhan krisis. Pir Asia sering memiliki kulit berwarna kuning atau coklat dengan daging yang sangat juicy. ",
                imageFruitId = R.drawable.pir_asian),
            )
    }
}