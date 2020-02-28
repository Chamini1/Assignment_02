package com.example.facebook;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebook.data.MyDataBase;

import static com.example.facebook.data.MyDataBase.DB_NAME;

//import static com.example.facebook.MydataBase.STUDENT_TABLE;

public class FragmentThree extends Fragment {

    MyDataBase db;
    View view;
    String s[] ;
    ListView v1;


    Button View;

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
        db=new MyDataBase(getContext(),DB_NAME,null,1);
        View=(Button)view.findViewById(R.id.btnView);

        retrieveAll();


    }
    public void retrieveAll(){
        View.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = db.getAll();
                        if (res.getCount()==0){
                            notification("Error","Database is Empty");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){

                            buffer.append("Name  :"+res.getString(1)+"\n");
                            buffer.append("Age   :"+res.getString(2)+"\n");
                            buffer.append("Marks :"+res.getString(3)+"\n");
                        }

                        notification("Infor",buffer.toString());
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

