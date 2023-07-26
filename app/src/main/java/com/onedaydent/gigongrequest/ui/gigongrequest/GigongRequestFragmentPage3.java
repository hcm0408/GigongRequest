package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.content.DialogInterface;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest3Binding;
import com.onedaydent.gigongrequest.utils.Utils;

import java.text.SimpleDateFormat;

public class GigongRequestFragmentPage3 extends Fragment implements View.OnClickListener, View.OnTouchListener, View.OnLongClickListener{

    private static String TAG = GigongRequestFragmentPage3.class.getSimpleName();
    private FragmentGigongrequest3Binding binding;
    private GigongRequestPage3ViewModel viewModel;

    private boolean isPontic = false;
    private boolean isCopy = false;
    private boolean longTouch = false;

    private GigongRequestDTO item = null;

    public GigongRequestFragmentPage3(){
        super();
    }

    public GigongRequestFragmentPage3(GigongRequestDTO item){
        super();
        this.item = item;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            viewModel = new ViewModelProvider(this).get(GigongRequestPage3ViewModel.class);
            binding = FragmentGigongrequest3Binding.inflate(inflater, container, false);
            GigongRequestDTO dto = GigongRequestPage2ViewModel.getGigong().getValue();
            if(dto != null) dto.setGr_RequestDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getGr_RequestDateTemp()));
            viewModel.Init(getContext(), getActivity(), this, binding, this, this);
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

    public void showPopupMenu(View view, int idx) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.context_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu2:
                        viewModel.openMenu(idx);
                        break;
                    case R.id.menu1:
                        viewModel.resetItem(idx);
                        break;
                    default:
                        return false;
                }
                longTouch = false;
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request3_all1:
                if(!isPontic) viewModel.getComponentEnum().clickAll(0);
                else Utils.getMessageShort("PONTIC설정 모드입니다.");
                break;
            case R.id.request3_all2:
                if(!isPontic) viewModel.getComponentEnum().clickAll(1);
                else Utils.getMessageShort("PONTIC설정 모드입니다.");
                break;
            case R.id.request3_all3:
                if(!isPontic) viewModel.getComponentEnum().clickAll(2);
                else Utils.getMessageShort("PONTIC설정 모드입니다.");
                break;
            case R.id.request3_all4:
                if(!isPontic) viewModel.getComponentEnum().clickAll(3);
                else Utils.getMessageShort("PONTIC설정 모드입니다.");
                break;
            case R.id.request3_reset:
                if(!longTouch){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("주의:데이터가 초기화됩니다.")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    viewModel.getComponentEnum().reset();
                                    isPontic = false;
                                    isCopy = false;
                                    longTouch = false;
                                }
                            }).setNegativeButton("취소", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;
            case R.id.request3_copyshow:
                if(isCopy) {
                    binding.request3Copyshow.setVisibility(View.INVISIBLE);
                    viewModel.setCopyOriginal(null);
                    isCopy = false;
                }
                break;
            case R.id.request3_pontic:
                if(isCopy) Utils.getMessageShort("복사모드 입니다.");
                 else if(isPontic) {
                    binding.request3Ponticshow.setVisibility(View.INVISIBLE);
                    isPontic = false;
                }
                else {
                    binding.request3Ponticshow.setVisibility(View.VISIBLE);
                    Utils.getMessageShort("선택한 치식은 PONTIC으로 설정됩니다.\n완료한 후 PONTIC버튼을 한번 더 눌러주세요.");
                    isPontic = true;
                }
                break;
            case R.id.request3_insert:
                if(!isPontic) viewModel.getComponentEnum().openOptionDialog();
                else Utils.getMessageShort("PONTIC설정 모드입니다.");
                break;
            case R.id.request3_nextbtn:
                viewModel.getComponentEnum().save(item, getParentFragmentManager());
                break;
            default:
                if(!longTouch){
                    Integer idx = viewModel.getComponentEnum().getBtnsArray2().get(view);
                    if (idx != null) {
                        if(!isCopy) viewModel.select(idx, isPontic, 0);
                        else viewModel.setCopy(idx);
                    }
                }
        }
        longTouch = false;
    }

    @Override
    public boolean onLongClick(View view) {
        longTouch = true;
        Integer idx = viewModel.getComponentEnum().getBtnsArray2().get(view);
        if (idx != null) showPopupMenu(view, idx);
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getActionMasked();
        switch(action){
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return false;
    }

    public boolean isCopy3() {
        return isCopy;
    }

    public void setCopy3(boolean copy) {
        isCopy = copy;
    }

    public GigongRequestDTO getItem() {
        return item;
    }
}