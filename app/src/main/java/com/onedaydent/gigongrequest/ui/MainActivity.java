package com.onedaydent.gigongrequest.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.navigation.NavigationBarView;
import com.onedaydent.gigongrequest.databinding.ActivityMainBinding;
import com.onedaydent.gigongrequest.R;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private static String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding = null;
    private MainActivityViewModel viewModel;
    private NavigationBarView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.dataInit(getSupportFragmentManager());
        navView = binding.navView;
        navView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    @Override
    public void onBackPressed() {
        if(isTaskRoot()) finish();
        else super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_request) viewModel.goPage(0, navView, this);
        else if(item.getItemId() == R.id.navigation_list) viewModel.goPage(1, navView, this);
        return false;
    }
}