package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.os.Bundle;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.model.MemberDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest2Binding;
import com.onedaydent.gigongrequest.utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class GigongRequestFragmentPage2 extends Fragment implements View.OnTouchListener, View.OnClickListener, View.OnKeyListener, AdapterView.OnItemSelectedListener {

    private static String TAG = GigongRequestFragmentPage2.class.getSimpleName();
    private FragmentGigongrequest2Binding binding;
    private GigongRequestPage2ViewModel viewModel;

    private int hall = 0;
    public GigongRequestFragmentPage2(){
        super();
    }
    public GigongRequestFragmentPage2(int hall){
        this.hall = hall;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(GigongRequestPage2ViewModel.class);
        binding = FragmentGigongrequest2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel.Init(getContext(), hall, binding.request2Txt1);

        viewModel.getDr().observe(getViewLifecycleOwner(), new Observer<List<MemberDTO>>() {
            @Override
            public void onChanged(List<MemberDTO> items) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, items.stream().map(MemberDTO::getMb_name).collect(Collectors.toList()));
                binding.request2Dr.setAdapter(adapter);
            }
        });
        viewModel.getDh().observe(getViewLifecycleOwner(), new Observer<List<MemberDTO>>() {
            @Override
            public void onChanged(List<MemberDTO> items) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, items.stream().map(MemberDTO::getMb_name).collect(Collectors.toList()));
                binding.request2Dh.setAdapter(adapter);
            }
        });
        viewModel.getGigong().observe(getViewLifecycleOwner(), new Observer<GigongRequestDTO>() {
            @Override
            public void onChanged(GigongRequestDTO dto) {
                binding.request2Txt1.setText(dto.getGr_RequestDateTemp());
                binding.request2Txt3.setText(dto.getGr_Name());
                if(dto.getGr_Gender() == 0){
                    Utils.changeButtonBackground(binding.request2Gender1, true);
                    Utils.changeButtonBackground(binding.request2Gender2, false);
                }
                else if(dto.getGr_Gender() == 1){
                    Utils.changeButtonBackground(binding.request2Gender1, false);
                    Utils.changeButtonBackground(binding.request2Gender2, true);
                }
                if(dto.getGr_Type() == 1){
                    Utils.changeButtonBackground(binding.request2Btn1, true);
                    Utils.changeButtonBackground(binding.request2Btn2, false);
                }
                else if(dto.getGr_Type() == 2){
                    Utils.changeButtonBackground(binding.request2Btn1, false);
                    Utils.changeButtonBackground(binding.request2Btn2, true);
                }else{
                    Utils.changeButtonBackground(binding.request2Btn1, false);
                    Utils.changeButtonBackground(binding.request2Btn2, false);
                }
            }
        });
        binding.request2Txt1.setOnTouchListener(this);
        binding.request2Txt2.setOnClickListener(this);
        binding.request2Txt3.setOnClickListener(this);
        binding.request2Gender1.setOnClickListener(this);
        binding.request2Gender2.setOnClickListener(this);
        binding.request2Btn1.setOnClickListener(this);
        binding.request2Btn2.setOnClickListener(this);
        binding.request2Nextbtn.setOnClickListener(this);
        binding.request2Dr.setOnItemSelectedListener(this);
        binding.request2Dh.setOnItemSelectedListener(this);
        binding.request2Txt2.setOnKeyListener(this);
        return root;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view.getId() == R.id.request2_txt1 && motionEvent.getAction() == MotionEvent.ACTION_UP) viewModel.openDatePicker(binding.request2Txt2);
        return false;
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(view.getId() == R.id.request2_txt2) {
            if(i == 66 && keyEvent.getAction() == KeyEvent.ACTION_DOWN) viewModel.getPatientData(binding.request2Txt2.getText().toString());
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request2_gender1:
                viewModel.setGender(0);
                break;
            case R.id.request2_gender2:
                viewModel.setGender(1);
                break;
            case R.id.request2_btn1:
                viewModel.setType(0);
                break;
            case R.id.request2_btn2:
                viewModel.setType(1);
                break;
            case R.id.request2_nextbtn:
                viewModel.getNextStep(getParentFragmentManager(), binding);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId()== R.id.request2_dr) viewModel.clickSpinnerItem(0, i);
        else if(adapterView.getId() == R.id.request2_dh) viewModel.clickSpinnerItem(1, i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}