package com.example.pr2;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private static final String TAG = "MyApp";

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Toast.makeText(context,"onAttach",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(),"onCreate",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getContext(),"onCreateView",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onPause() {
        Toast.makeText(getContext(),"onPause",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"onStart",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(),"onStop",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(),"onDestroyView",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(),"onDestroy",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(),"onDetach",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDetach");
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
        Toast.makeText(getContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");
    }
}