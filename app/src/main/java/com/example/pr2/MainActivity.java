package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    CheckBox checkbox_1 = findViewById(R.id.checkbox_1);
                    CheckBox checkbox_2 = findViewById(R.id.checkbox_2);

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        boolean but1 = intent.getBooleanExtra("start_1", false);
                        boolean but2 = intent.getBooleanExtra("start_2", false);

                        checkbox_1.setChecked(but1);
                        checkbox_2.setChecked(but2);

                    }
                }
            });



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        CheckBox checkbox_1 = findViewById(R.id.checkbox_1);
        CheckBox checkbox_2 = findViewById(R.id.checkbox_2);


        Button button_next_page = findViewById(R.id.button_next_page);

        ImageView imageCake = findViewById(R.id.imageCake);  // задание 3
        TextView main_text = findViewById(R.id.main_text);
        main_text.setText(R.string.main_text);
        imageCake.setImageResource(R.drawable.apple);   // задание 3

        Button button_search = findViewById(R.id.button_search);
        button_search.setOnClickListener(new View.OnClickListener() {   // задание 4
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Кнопка нажата");
            }
        });


        button_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ch1 = checkbox_1.isChecked();
                boolean ch2 = checkbox_2.isChecked();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("check1", ch1);
                intent.putExtra("check2", ch2);

                mStartForResult.launch(intent);
            }
        });
    }

    public void btnOneClick(View v)  // задание 4 - вариант 2
    {
        Log.i(TAG, "Кнопка нажата (метод 2)");
    }
}