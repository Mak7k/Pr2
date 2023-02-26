package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageCake = findViewById(R.id.imageCake);
        TextView main_text = findViewById(R.id.main_text);

        CheckBox checkbox_1 = findViewById(R.id.checkbox_1);
        CheckBox checkbox_2 = findViewById(R.id.checkbox_2);

        Button button_search = findViewById(R.id.button_search);
        Button button_next_page = findViewById(R.id.button_next_page);

        main_text.setText(R.string.main_text);   // задание 3
        imageCake.setImageResource(R.drawable.apple);   // задание 3

        button_search.setOnClickListener(new View.OnClickListener() {   // задание 4
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Кнопка нажата");
            }
        });


    }

    public void btnOneClick(View v)  // задание 4 - вариант 2
    {
        Log.i(TAG, "Кнопка нажата (метод 2)");
    }
}