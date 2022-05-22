package proyekAkhir.JSN.mygadget.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import proyekAkhir.JSN.mygadget.R;
import proyekAkhir.JSN.mygadget.activities.HP.HpActivity;
import proyekAkhir.JSN.mygadget.activities.Laptop.LaptopActivity;

public class HomeActivity extends AppCompatActivity {

    private List<SlideModel> imageList = new ArrayList<>();
    private ImageSlider imageSlider;

    private AppCompatButton btnLaptop, btnHp, btnLain;
    private FloatingActionButton btnToContact;
    private TextView tvMoreLaptop, tvMoreHp, tvMoreLain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageList.add(new SlideModel(R.drawable.img_home,  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.img_home,  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.img_home,  ScaleTypes.CENTER_CROP));

        imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        btnLaptop = findViewById(R.id.btn_laptop_categories);
        btnHp = findViewById(R.id.btn_hp_categories);
        btnLain = findViewById(R.id.btn_lain_categories);
        btnToContact = findViewById(R.id.btn_toContact);
        tvMoreLaptop = findViewById(R.id.tv_more_laptop);
        tvMoreHp = findViewById(R.id.tv_more_hp);
        tvMoreLain = findViewById(R.id.tv_more_lain);

        btnToContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ContactUsActivity.class);
                startActivity(intent);
            }
        });

        btnLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LaptopActivity.class);
                startActivity(intent);
            }
        });

        btnHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HpActivity.class);
                startActivity(intent);
            }
        });

        btnLain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LainActivity.class);
                startActivity(intent);
            }
        });

        tvMoreLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LaptopActivity.class);
                startActivity(intent);
            }
        });

        tvMoreHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HpActivity.class);
                startActivity(intent);
            }
        });

        tvMoreLain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LainActivity.class);
                startActivity(intent);
            }
        });

    }

}