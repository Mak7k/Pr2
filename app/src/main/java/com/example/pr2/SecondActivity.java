package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle arg = getIntent().getExtras();
        boolean ch1 = (boolean) arg.get("check1");
        boolean ch2 = (boolean) arg.get("check2");

        CheckBox chbx1 = findViewById(R.id.checkBox1_sec_page);
        CheckBox chbx2 = findViewById(R.id.checkBox2_sec_page);

        chbx1.setChecked(ch1);
        chbx2.setChecked(ch2);

        Button bt = findViewById(R.id.button_next_page2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean a = chbx1.isChecked();
                boolean b = chbx2.isChecked();

                Intent data = new Intent();
                data.putExtra("start_1", a);
                data.putExtra("start_2", b);
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
}