package com.example.applemarket

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarket.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 제거 코드
        supportActionBar?.hide()

        binding.backBtn.setOnClickListener {
            finish()
        }

        val bundle = intent.getBundleExtra("bundle")
        val img = bundle?.getInt("img")
        val name = bundle?.getString("name")
        val info = bundle?.getString("info")
        val seller = bundle?.getString("seller")
        val price = bundle?.getInt("price")
        val locate = bundle?.getString("locate")

        binding.detailImg.setImageResource(img ?: R.drawable.sample1)
        binding.detailInfo.text = info
        binding.detailName.text = name
        binding.detailLocate.text = locate
        binding.detailSeller.text = seller
        val dec = DecimalFormat("#,###원")
        binding.detailPrice.text = dec.format(price)
    }
}