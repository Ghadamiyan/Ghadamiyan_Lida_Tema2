package com.example.r;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUserFragment extends Fragment {


    private EditText UserId, UserName, UserGrade;
    private Button BnSave;




    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user, container, false);

        UserId = view.findViewById(R.id.txt_user_id);
        UserName= view.findViewById(R.id.txt_name);
        UserGrade = view.findViewById(R.id.grade);
        BnSave =  view.findViewById(R.id.bn_save_user);


        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ia informatiile din interfata
                int userid = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                Float usergrade = Float.parseFloat(UserGrade.getText().toString());

                // Incarca informatiile
                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setGrade(usergrade);

                // Incarca informatiile in baza de date
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                // Sterge info din editText
                UserId.setText("");
                UserName.setText("");
                UserGrade.setText("");


            }
        });


        return view;

    }
}
