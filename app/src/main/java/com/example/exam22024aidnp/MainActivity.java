package com.example.exam22024aidnp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentControlPanel.OnControlPanelListener {

    private FragmentShapeDrawer fragmentShapeDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            fragmentShapeDrawer = new FragmentShapeDrawer();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentShapeDrawer)
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_control_panel, new FragmentControlPanel())
                    .commit();
        }
    }

    @Override
    public void onGenerateButtonClicked() {
        if (fragmentShapeDrawer != null) {
            fragmentShapeDrawer.drawNextShape();
        }
    }

    @Override
    public void onResetButtonClicked() {
        if (fragmentShapeDrawer != null) {
            fragmentShapeDrawer.resetDrawing();
        }
    }
}
