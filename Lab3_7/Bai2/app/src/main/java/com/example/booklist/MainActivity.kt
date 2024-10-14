package com.example.booklist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booklist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Danh sách sách mẫu
        val books = listOf(
            Book("Cuộc đời bạn", "Lâm Tuấn Kiệt"),
            Book ("Đời là bể khổ", "Lâm Tuấn Kiệt"),
            Book ("Đám trẻ ở đại dương đen", "Châu Sa Đáy Mắt"),
            Book ("Thư viện nửa đêm", "Matt Haig"),
            Book ("Harry Potter và Bảo bối tử thần", "J. K. Rowling")
        )

        // Cài đặt RecyclerView
        val bookAdapter = BookAdapter(books)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = bookAdapter
    }
}
