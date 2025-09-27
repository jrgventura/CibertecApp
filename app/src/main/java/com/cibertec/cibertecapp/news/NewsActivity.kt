package com.cibertec.cibertecapp.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val recyclerNews =
            findViewById<RecyclerView>(R.id.recyclerNews)
        val adapter = NewsAdapter()
        recyclerNews.adapter = adapter

        var newsList = arrayListOf<New>()
        newsList.add(
            New(
                R.drawable.noticia1,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))
        newsList.add(
            New(
                R.drawable.noticia2,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))
        newsList.add(
            New(
                R.drawable.noticia1,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))
        newsList.add(
            New(
                R.drawable.noticia1,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))
        newsList.add(
            New(
                R.drawable.noticia1,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))
        newsList.add(
            New(
                R.drawable.noticia1,
                "Cibertec: 9 de 10 trabajan",
                "Todos los egresdos tienen trabajo"))

        adapter.setNews(newsList)
        recyclerNews.layoutManager =
            LinearLayoutManager(this)
    }
}