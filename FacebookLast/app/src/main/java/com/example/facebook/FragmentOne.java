package com.example.facebook;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import com.example.facebook.data.MyDataBase;

        import static com.example.facebook.data.MyDataBase.DB_NAME;
        import static com.example.facebook.data.MyDataBase.DB_VERSION;

public class FragmentOne extends Fragment {

    MyDataBase dataBaseManager;
    EditText uname, age, marks;
    Button Button1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBaseManager = new MyDataBase(getContext(), DB_NAME, null, DB_VERSION);

        uname = view.findViewById(R.id.uname);
        age = view.findViewById(R.id.age);
        marks = view.findViewById(R.id.marks);
        Button1 =view.findViewById(R.id.button1);
        addData();
    }


    public void addData() {
        Button1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInsert = dataBaseManager.insertData(uname.getText().toString(), age.getText().toString(), marks.getText().toString());
                        if (isInsert = true)
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

}



















