package com.nadim.recycleviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNews;
    private List<News> mData = new ArrayList<>();
    private NewsViewAdapter newsViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNews = findViewById(R.id.rvNews);

        //Penambahan Data
        rvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        newsViewAdapter = new NewsViewAdapter(mData, new NewsViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(News item, int position) {
                Toast.makeText(MainActivity.this, "Ini adalah berita dengan judul "+item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        rvNews.setAdapter(newsViewAdapter);
        dummyNews();
    }

    public void dummyNews() {
        News news = new News();
        news.setId(0);
        news.setTitle("News 24 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 24 April 2022");
        mData.add(news);

        news = new News();
        news.setId(1);
        news.setTitle("News 25 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 25 April 2022");
        mData.add(news);

        news = new News();
        news.setId(2);
        news.setTitle("News 26 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 26 April 2022");
        mData.add(news);

        news = new News();
        news.setId(3);
        news.setTitle("News 27 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 27 April 2022");
        mData.add(news);

        news = new News();
        news.setId(4);
        news.setTitle("News 28 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 28 April 2022");
        mData.add(news);

        news = new News();
        news.setId(5);
        news.setTitle("News 29 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 29 April 2022");
        mData.add(news);

        news = new News();
        news.setId(6);
        news.setTitle("News 30 April 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 30 April 2022");
        mData.add(news);

        news = new News();
        news.setId(7);
        news.setTitle("News 1 Mei 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 1 Mei 2022");
        mData.add(news);

        news = new News();
        news.setId(8);
        news.setTitle("News 2 Mei 2022");
        news.setDescription("Ini adalah deskripsi news pada tanggal 2 Mei 2022");
        mData.add(news);

    }
}