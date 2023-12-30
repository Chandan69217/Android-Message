package com.chandan.message.tab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chandan.message.R;
import com.chandan.message.recycler_view.MesssageRecyclerViewAdapter;
import com.chandan.message.recycler_view.RecyclerViewAdapter;

public class MesasgeFragment extends Fragment {

    public MesasgeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mesasge, container, false);
        ((RecyclerView)view.findViewById(R.id.recycler_view)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) view.findViewById(R.id.recycler_view)).setAdapter(MesssageRecyclerViewAdapter.getAdapter(getContext()));
        return view;
    }

}