package com.onedaydent.gigongrequest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;

import com.google.android.material.navigation.NavigationBarView;
import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.ui.gigonglist.GigongListFragment;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestFragmentPage1;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestFragmentPage5;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestPage2ViewModel;

public class MainActivityViewModel extends ViewModel {
    private static String TAG = MainActivityViewModel.class.getSimpleName();

    private FragmentTransaction transaction = null;
    private FragmentManager manager = null;
    private boolean bool = true;

    public MainActivityViewModel(){}
    public void dataInit(FragmentManager manager){
        this.manager = manager;
        transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment_activity_main, new GigongRequestFragmentPage1());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goPage(int i, NavigationBarView navView, Activity activity) {
        Fragment frag = manager.findFragmentById(R.id.nav_host_fragment_activity_main);
        String name = frag.getClass().getSimpleName();
        if (name.equals("GigongRequestFragmentPage2") || name.equals("GigongRequestFragmentPage3") || name.equals("GigongRequestFragmentPage4")|| name.equals("GigongRequestFragmentPage5")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage("주의:데이터가 초기화됩니다. 메인화면으로 돌아가시겠습니까?")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            change(i, navView);
                        }
                    }).setNegativeButton("취소", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else change(i, navView);
    }

    public void change(int i, NavigationBarView navView){
        Menu menu = navView.getMenu();
        MenuItem item = null;
        GigongRequestPage2ViewModel.getGigong().setValue(new GigongRequestDTO());
        switch(i){
            case 0:
                transaction = manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, new GigongRequestFragmentPage1());
                item = menu.findItem(R.id.navigation_request);
                break;
            case 1:
                transaction = manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, new GigongListFragment());
                item = menu.findItem(R.id.navigation_list);
                break;
            default :
        }
        transaction.addToBackStack(null);
        transaction.commit();
        item.setChecked(true); // 해당 아이템에 포커스를 줌
    }
}