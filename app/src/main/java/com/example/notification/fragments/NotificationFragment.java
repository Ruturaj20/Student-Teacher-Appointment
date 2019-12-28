package com.example.notification.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notification.adapters.AdapterNotification;
import com.example.notification.DataDrink;
import com.example.notification.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    RecyclerView rvDrink;
    AdapterNotification mAdapter;
    String notifications[]={"Notification1","Notification2","Notification3","Notification4"};
    String price[]={"5000","10000","5000","10000"};
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);
        rvDrink = v.findViewById(R.id.rvDrink);
        rvDrink.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvDrink.setLayoutManager(layoutManager);

        ArrayList<DataDrink> dataDrinks = getData();

        mAdapter = new AdapterNotification(dataDrinks,getActivity());
        rvDrink.setAdapter(mAdapter);

        return v;
    }

    private ArrayList<DataDrink> getData() {
        ArrayList<DataDrink> dataDrinks = new ArrayList<>();
        for (int i = 0; i< notifications.length; i++){
            DataDrink drink = new DataDrink();
            drink.setdrinkName(notifications[i]);
            drink.setPrice(price[i]);
            dataDrinks.add(drink);
        }
        return dataDrinks;
    }

}
