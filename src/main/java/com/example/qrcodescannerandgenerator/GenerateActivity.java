package com.example.qrcodescannerandgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateActivity extends AppCompatActivity {

    Button getBtn;
    ImageView imageView;
    EditText field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        getSupportActionBar().setTitle("Generate QR code");
        getBtn = findViewById(R.id.generateBtn);
        imageView = findViewById(R.id.img);
        field = findViewById(R.id.field);


        getBtn.setOnClickListener(v -> generateCode());
    }

    private void generateCode() {
        String content = field.getText().toString().trim();

        BarcodeEncoder encoder = new BarcodeEncoder();
        try {
            Bitmap bitmap = encoder.encodeBitmap(content, BarcodeFormat.QR_CODE, 400,400);
            imageView.setImageBitmap(bitmap);
            imageView.setVisibility(View.VISIBLE);
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}