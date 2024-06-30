package com.example.exam22024aidnp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentControlPanel extends Fragment {

    private OnControlPanelListener listener;

    public interface OnControlPanelListener {
        void onGenerateButtonClicked();
        void onResetButtonClicked();
    }

    public FragmentControlPanel() {

    }

    public static FragmentControlPanel newInstance(String param1, String param2) {
        FragmentControlPanel fragment = new FragmentControlPanel();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control_panel, container, false);

        Button buttonGenerate = view.findViewById(R.id.button_generate);
        Button buttonReset = view.findViewById(R.id.button_reset);

        buttonGenerate.setOnClickListener(v -> {
            if (listener != null) {
                listener.onGenerateButtonClicked();
            }
        });

        buttonReset.setOnClickListener(v -> {
            if (listener != null) {
                listener.onResetButtonClicked();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnControlPanelListener) {
            listener = (OnControlPanelListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnControlPanelListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
