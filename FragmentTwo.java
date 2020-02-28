package com.example.facebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyDataBase;

import static com.example.facebook.data.MyDataBase.STUDENT_TABLE;


public class FragmentTwo extends Fragment{
    MyDataBase myDataBase;
    Button View_Btn;

    public static FragmentTwo newInstance(){
        FragmentTwo fragmentTwo = new FragmentTwo();
        return fragmentTwo;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDataBase = new MyDataBase(getContext(),STUDENT_TABLE,null,1);
        View_Btn=(Button)view.findViewById(R.id.viewbtn);

        retrieveAll();


    }

    public void retrieveAll(){
        View_Btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDataBase.retrieveData();
                        if (res.getCount()==0){
                            notification("Error","Database Empty or Something Wrong!");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Index :"+res.getString(0)+"\n");
                            buffer.append("Name  :"+res.getString(1)+"\n");
                            buffer.append("Age   :"+res.getString(2)+"\n");
                            buffer.append("Marks :"+res.getString(3)+"\n");
                        }

                        notification("Information",buffer.toString());
                    }
                }
        );
    }

    public  void notification(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}


