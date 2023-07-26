package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest4Binding;
import com.onedaydent.gigongrequest.ui.DrawCanvas;
import com.onedaydent.gigongrequest.utils.OPTIONENUM;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GigongRequestPage4ViewModel extends ViewModel implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private static String TAG = GigongRequestPage4ViewModel.class.getSimpleName();
    private Context mContext = null;
    private ArrayAdapter<String> shade = null;
    private DrawCanvas drawCanvas;
    private FloatingActionButton fbPen;                 // 펜 모드 버튼
    private FloatingActionButton fbReset;               // 리셋 버튼
    private FloatingActionButton fbEraser;              // 지우개 모드 버튼
    private FloatingActionButton fbPaint;               // 색변경 모드 버튼
    private ConstraintLayout canvasContainer;           // 캔버스 root view

    private List<AppCompatCheckBox> checks = new ArrayList<>();
    private AppCompatCheckBox grCheck1;
    private AppCompatCheckBox grCheck2;
    private AppCompatCheckBox grCheck3;
    private AppCompatCheckBox grCheck4;
    private AppCompatCheckBox grCheck5;
    private AppCompatCheckBox grCheck6;
    private AppCompatCheckBox grCheck7;
    private AppCompatCheckBox grCheck8;
    private AppCompatCheckBox grCheck9;

    private FragmentGigongrequest4Binding binding = null;
    private Dialog dialog = null;
    private GigongRequestDTO dto;
    private List<GigongOptionDTO> items = new ArrayList<GigongOptionDTO>();
    private GigongRequestFragmentPage4 page4;

    public void Init(Context mContext, FragmentGigongrequest4Binding binding, GigongRequestFragmentPage4 page4) {
        this.mContext = mContext;
        this.binding = binding;
        this.dto = page4.getDto();
        OPTIONENUM optionenum = new OPTIONENUM();
        shade = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item3, optionenum.getShadeList().stream().map(s -> s).collect(Collectors.toList()));
        binding.grShade.setAdapter(shade);
        binding.grShade.setOnItemSelectedListener(this);
        canvasContainer = binding.request4Draw;
        fbPen = binding.fbPen;
        fbEraser = binding.fbEraser;
        fbReset = binding.fbReset;
        fbPaint = binding.fbPaint;
        drawCanvas = new DrawCanvas(mContext);
        canvasContainer.addView(drawCanvas);
        setOnClickListener();

        checks = new ArrayList<AppCompatCheckBox>(){{
            add(binding.grCheck1);
            add(binding.grCheck2);
            add(binding.grCheck3);
            add(binding.grCheck4);
            add(binding.grCheck5);
            add(binding.grCheck6);
            add(binding.grCheck7);
            add(binding.grCheck8);
            add(binding.grCheck9);
        }};
        checks.forEach(item -> {
            item.setOnCheckedChangeListener(this);
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        dto.setGr_Shade(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    /**
     * jhChoi - 201124
     * OnClickListener Setting
     */
    private void setOnClickListener() {
        fbPen.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) drawCanvas.changeTool(DrawCanvas.MODE_PEN);
            return true;
        });
        fbReset.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("메모를 초기화 하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                drawCanvas.resetDraw();
                            }
                        }).setNegativeButton("취소", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            return true;
        });
        fbEraser.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) drawCanvas.changeTool(DrawCanvas.MODE_ERASER);
            return true;
        });
        fbPaint.setOnTouchListener((v, motionEvent) -> {
            if(motionEvent.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS && motionEvent.getAction() == MotionEvent.ACTION_UP) {
                PopupMenu popupMenu = new PopupMenu(mContext, v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.color_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                drawCanvas.changeColor(Color.BLACK, 3);
                                break;
                            case R.id.menu2:
                                drawCanvas.changeColor(Color.BLUE, 3);
                                break;
                            case R.id.menu3:
                                drawCanvas.changeColor(Color.RED, 3);
                                break;
                            case R.id.menu4:
                                drawCanvas.changeColor(Color.GREEN, 3);
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });
            }
            return true;
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch(compoundButton.getId()){
            case R.id.gr_check1:
                if(b) dto.setGr_Check1(1);
                else dto.setGr_Check1(0);
                break;
            case R.id.gr_check2:
                if(b) dto.setGr_Check2(1);
                else dto.setGr_Check2(0);
                break;
            case R.id.gr_check3:
                if(b) dto.setGr_Check3(1);
                else dto.setGr_Check3(0);
                break;
            case R.id.gr_check4:
                if(b) dto.setGr_Check4(1);
                else dto.setGr_Check4(0);
                break;
            case R.id.gr_check5:
                if(b) dto.setGr_Check5(1);
                else dto.setGr_Check5(0);
                break;
            case R.id.gr_check6:
                if(b) dto.setGr_Check6(1);
                else dto.setGr_Check6(0);
                break;
            case R.id.gr_check7:
                if(b) dto.setGr_Check7(1);
                else dto.setGr_Check7(0);
                break;
            case R.id.gr_check8:
                if(b) dto.setGr_Check8(1);
                else dto.setGr_Check8(0);
                break;
            case R.id.gr_check9:
                if(b) dto.setGr_Check9(1);
                else dto.setGr_Check9(0);
                break;
            default:
                break;
        }
    }
    public DrawCanvas getDrawCanvas() {
        return drawCanvas;
    }
}