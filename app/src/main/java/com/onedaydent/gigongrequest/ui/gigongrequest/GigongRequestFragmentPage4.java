package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest4Binding;

import java.util.List;

public class GigongRequestFragmentPage4 extends Fragment implements View.OnClickListener {

    private static String TAG = GigongRequestFragmentPage4.class.getSimpleName();
    private FragmentGigongrequest4Binding binding;
    private GigongRequestPage4ViewModel viewModel;
    private GigongRequestDTO dto;
    private List<GigongOptionDTO> items;

    public GigongRequestFragmentPage4(){
        super();
    }

    public GigongRequestFragmentPage4(GigongRequestDTO dto, List<GigongOptionDTO> items){
        super();
        this.dto = dto;
        this.items = items;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            viewModel = new ViewModelProvider(this).get(GigongRequestPage4ViewModel.class);
            binding = FragmentGigongrequest4Binding.inflate(inflater, container, false);
            viewModel.Init(getContext(), binding, this);
            binding.request4Nextbtn.setOnClickListener(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public GigongRequestDTO getDto() {
        return dto;
    }

    public List<GigongOptionDTO> getItems() {
        return items;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request4_nextbtn:
                dto.setTempBitmap(viewModel.getDrawCanvas().getCurrentCanvas());
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                GigongRequestFragmentPage5 frag = new GigongRequestFragmentPage5(dto, items);
                transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, frag);
                transaction.addToBackStack("4");
                transaction.commit();
                break;
            default:
                break;
        }
    }
}