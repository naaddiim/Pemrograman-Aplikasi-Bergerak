package com.example.sportcardexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.awt.font.TextAttribute;

public class DetailActivity extends AppCompatActivity {

    private TextView tvSportTitleDetail, tvSportNewsTitle, tvSportsSubTitle;
    private ImageView ivSportDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvSportTitleDetail = findViewById(R.id.tvTitleDetail);
        tvSportsSubTitle = findViewById(R.id.tvSubTitleDetail);
        ivSportDetail = findViewById(R.id.ivSportDetail);

        tvSportTitleDetail.setText(getIntent().getStringExtra("TITLE"));
        Glide.with(this).load(getIntent().getIntExtra("IMAGE_RESOURCE", 0)).into(ivSportDetail);
    }
}