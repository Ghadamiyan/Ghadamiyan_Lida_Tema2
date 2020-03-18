package com.example.r;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    //private TextView TxtInfo;



    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_user, container, false);

   //TxtInfo = view.findViewById(R.id.txt_display_info);

   // read from room

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

        String info="";

        for(User usr : users)
        {
            int id = usr.getId();
            String name = usr.getName();
            Float grade = usr.getGrade();

            info = info +"\n\n"+"Id :"+ id +"\n\n"+"Name :"+ name +"\n\n"+"Grade :" + grade;


        }

        //TxtInfo.setText(info);
        MyRecyclerViewAdapter adapter;

        RecyclerView recyclerView = view.findViewById(R.id.rw);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(), users);
        recyclerView.setAdapter(adapter);

   return view;
    }
}
