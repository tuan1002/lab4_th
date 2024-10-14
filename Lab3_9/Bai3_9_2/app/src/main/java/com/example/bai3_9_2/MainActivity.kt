package com.example.bai3_9_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai3_9_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val productList = listOf(
        Product("Product 1", 29.99),
        Product("Product 2", 39.99),
        Product("Product 3", 19.99),
        Product("Product 4", 49.99),
        Product("Product 5", 24.99)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = if (resources.configuration.screenWidthDp >= 600) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = ProductAdapter(productList)
    }
}
