package com.example.facebook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyDataBase;

import static com.example.facebook.data.MyDataBase.DB_NAME;



public class FragmentThree extends Fragment {


    public static FragmentTwo newInstance(){
        FragmentTwo fragmetTwo = new FragmentTwo();
        return fragmetTwo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }
}

