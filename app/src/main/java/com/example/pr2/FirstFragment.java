package com.example.pr2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private static final String TAG = "MyApp";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox checkbox_1 = getView().findViewById(R.id.checkbox_1);
        CheckBox checkbox_2 = getView().findViewById(R.id.checkbox_2);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            boolean ch1 = bundle.getBoolean("ch1_2",false);
            boolean ch2 = bundle.getBoolean("ch2_2", false);
            checkbox_1.setChecked(ch1);
            checkbox_2.setChecked(ch2);
        }


        Button bt_next_page = getView().findViewById(R.id.button_next_page);
        Button bt_search = getView().findViewById(R.id.button_search);

        ImageView imageCake = getView().findViewById(R.id.imageCake);  // задание 3
        TextView main_text = getView().findViewById(R.id.main_text);
        main_text.setText(R.string.main_text);
        imageCake.setImageResource(R.drawable.apple);   // задание 3

        bt_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment nextFrag= new SecondFragment();

                boolean ch1 = checkbox_1.isChecked();
                boolean ch2 = checkbox_2.isChecked();
                Bundle bundle = new Bundle();
                bundle.putBoolean("ch1", ch1);
                bundle.putBoolean("ch2", ch2);
                nextFrag.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_frame_layout, nextFrag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Кнопка нажата");
            }
        });
    }
}