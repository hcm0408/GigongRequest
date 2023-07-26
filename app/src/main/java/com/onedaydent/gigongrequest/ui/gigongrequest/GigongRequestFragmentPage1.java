package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequestBinding;

public class GigongRequestFragmentPage1 extends Fragment implements View.OnClickListener{

    private static String TAG = GigongRequestFragmentPage1.class.getSimpleName();
    private FragmentGigongrequestBinding binding;
    private GigongRequestPage1ViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(GigongRequestPage1ViewModel.class);
        binding = FragmentGigongrequestBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnHall1.setOnClickListener(this);
        binding.btnHall2.setOnClickListener(this);
        binding.btnHall3.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hall1 :
                viewModel.getNextStep(1, getParentFragmentManager(), binding);
                break;
            case R.id.btn_hall2 :
                viewModel.getNextStep(2, getParentFragmentManager(), binding);
                break;
            case R.id.btn_hall3 :
                viewModel.getNextStep(3, getParentFragmentManager(), binding);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}