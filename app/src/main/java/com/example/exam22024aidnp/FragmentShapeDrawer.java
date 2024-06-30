package com.example.exam22024aidnp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentShapeDrawer extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private ShapeDrawerView shapeDrawerView;

    public FragmentShapeDrawer() {

    }

    public static FragmentShapeDrawer newInstance(String param1, String param2) {
        FragmentShapeDrawer fragment = new FragmentShapeDrawer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shape_drawer, container, false);
        shapeDrawerView = view.findViewById(R.id.shape_drawer_view);
        return view;
    }

    public void drawNextShape() {
        shapeDrawerView.drawNextShape();
    }

    public void resetDrawing() {
        shapeDrawerView.resetDrawing();
    }
}
