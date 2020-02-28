package com.example.facebook;


import android.widget.Button;


import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyDataBase;




public class FragmentTwo extends Fragment{
    MyDataBase myDataBase;
    Button View_Btn;

    public static FragmentTwo newInstance(){
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }


}


