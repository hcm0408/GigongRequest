package com.onedaydent.gigongrequest.ui.gigonglist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.onedaydent.gigongrequest.databinding.FragmentGigonglistBinding;

public class GigongListFragment extends Fragment {

    private FragmentGigonglistBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GigongListViewModel gigongListViewModel =
                new ViewModelProvider(this).get(GigongListViewModel.class);

        binding = FragmentGigonglistBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        gigongListViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}