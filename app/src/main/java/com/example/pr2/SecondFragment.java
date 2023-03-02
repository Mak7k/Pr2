package com.example.pr2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
    }
}