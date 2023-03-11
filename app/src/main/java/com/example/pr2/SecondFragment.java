package com.example.pr2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class SecondFragment extends Fragment {

    private static final String TAG = "MyApp";

    private String[] set_of_titles = new String[] {
            "Торт с малиной",
            "Мороженое с вишней в рожке",
            "Набор фруктов",
            "Шоколадный торт",
            "Чизкей с малиной",
            "Зефир",
            "Свадебный торт многоэтажный",
            "Конфеты в глазури",
            "Бургер",
            "Ванильный чизкей",
            "Свадебный торт в 1 слой",
            "Мимоза",
            "Пельмень",
            "Яблочный пирог",
            "Брускетта с тунцом и помидорами",
            "Свадебный торт в 1 слой",
            "Лазанья с кабачками и фаршем",
            "Плетенка с шоколадной пастой",
    };

    private Integer[] set_of_images = new Integer[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
    };

    //private String[] titles = new String[100];
    //private Integer[] images = new Integer[100];
    private ListView listView1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int random_number;
        ArrayList<DescribeList> arrayList = new ArrayList<>();

        listView1 = getView().findViewById(R.id.list_view_1);

        for (int i = 0; i <= 99; i++){
            random_number = (int) (Math.random() *  (10 + 1)) ;
            arrayList.add(new DescribeList(set_of_images[random_number], set_of_titles[random_number]));
        }


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), R.layout.design_list_view, arrayList);
        listView1.setAdapter(customAdapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position + 1;
                Log.i(TAG, "Клик " + pos + " элемента");
                Toast.makeText(getActivity(), "Клик " + pos + " элемента", Toast.LENGTH_SHORT).show();
            }
        });

/*
        for (int i = 0; i <= 99; i++){
            if (i <= 16){
                titles[i] = set_of_titles[i];
                images[i] = set_of_images[i];
            }
            else{
                random_number = (int) (Math.random() *  (16 + 1)) ;
                titles[i] = set_of_titles[random_number];
                images[i] = set_of_images[random_number];
            }
        }

        //ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_list_item_1, images);
        //listView1.setAdapter(adapter);
 */

    }
}



/*
        super.onViewCreated(view, savedInstanceState);


        CheckBox checkbox_1 = getView().findViewById(R.id.checkBox1_sec_page);
        CheckBox checkbox_2 = getView().findViewById(R.id.checkBox2_sec_page);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            boolean ch1 = bundle.getBoolean("ch1",false);
            boolean ch2 = bundle.getBoolean("ch2", false);
            checkbox_1.setChecked(ch1);
            checkbox_2.setChecked(ch2);
        }

        Button bt_next_page = getView().findViewById(R.id.button_next_page2);
        bt_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment nextFrag= new FirstFragment();

                boolean ch1 = checkbox_1.isChecked();
                boolean ch2 = checkbox_2.isChecked();
                Bundle bundle = new Bundle();
                bundle.putBoolean("ch1_2", ch1);
                bundle.putBoolean("ch2_2", ch2);
                nextFrag.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frame_layout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });
 */