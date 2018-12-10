package com.example.user.picasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    String imageUrl = null;
    float derajat=0;
    ImageView ivHero;
    Button btnL, btnPutar, btnResz;
    EditText edtLnk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHero = findViewById(R.id.iv_hero);
        edtLnk = findViewById(R.id.edtLink);
        btnL = findViewById(R.id.btnGan);
        btnPutar = findViewById(R.id.btnRotate);
        btnResz = findViewById(R.id.btnResize);

        loadImage();

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLnk.getText().toString().length() != 0){
                    imageUrl = edtLnk.getText().toString();
                    loadImage();
                }
            }
        });

        btnPutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLnk.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"Gambar Kosong gan",Toast.LENGTH_SHORT).show();
                }else {
                    if (derajat != 360) {
                        derajat += 90;
                    } else {
                        derajat = 0;
                    }
                    rotateImage(derajat);
                }
            }
        });

        btnResz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLnk.getText().toString().length() != 0){
                    reSizeImage();
                }
            }
        });


    }

    private void loadImage(){
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.img_default_gan)
                .error(R.drawable.img_error)
                .into(ivHero);
    }

    private void rotateImage(float d){
        Picasso.with(this)
                .load(imageUrl)
                .rotate(d)
                .error(R.drawable.img_error)
                .into(ivHero);
    }

    private void reSizeImage(){
        Picasso.with(this)
                .load(imageUrl)
                .resize(250,250)
                .error(R.drawable.img_error)
                .into(ivHero);
    }

}
