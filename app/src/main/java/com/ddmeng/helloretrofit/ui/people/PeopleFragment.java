package com.ddmeng.helloretrofit.ui.people;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddmeng.helloretrofit.R;


public class PeopleFragment extends Fragment {
    public static final String TAG = "PeopleFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.people_fragment_layout, container, false);
    }
}
