package com.onedaydent.gigongrequest.ui.gigongrequest;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequestBinding;
import com.onedaydent.gigongrequest.utils.Utils;

public class GigongRequestPage1ViewModel extends ViewModel {

    private static String TAG = GigongRequestPage1ViewModel.class.getSimpleName();
    private FragmentTransaction transaction = null;

    public GigongRequestPage1ViewModel() {}
    public void getNextStep(int hall, FragmentManager manager, FragmentGigongrequestBinding binding){
        if(hall == 1){
            Utils.changeButtonBackground(binding.btnHall1, true);
            Utils.changeButtonBackground(binding.btnHall2, false);
            Utils.changeButtonBackground(binding.btnHall3, false);
        }else if(hall == 2){
            Utils.changeButtonBackground(binding.btnHall1, false);
            Utils.changeButtonBackground(binding.btnHall2, true);
            Utils.changeButtonBackground(binding.btnHall3, false);
        }else if(hall == 3){
            Utils.changeButtonBackground(binding.btnHall1, false);
            Utils.changeButtonBackground(binding.btnHall2, false);
            Utils.changeButtonBackground(binding.btnHall3, true);
        }
        GigongRequestFragmentPage2 frag = new GigongRequestFragmentPage2(hall);
        transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_main, frag);
        transaction.addToBackStack("1");
        transaction.commit();
    }
}