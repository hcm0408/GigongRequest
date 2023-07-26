package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.db.DatabaseHelper;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.model.MemberDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest5Binding;
import com.onedaydent.gigongrequest.databinding.OptionLayoutBinding;
import com.onedaydent.gigongrequest.utils.COMPONENTENUM;
import com.onedaydent.gigongrequest.utils.OPTIONENUM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GigongRequestPage5ViewModel extends ViewModel implements View.OnClickListener {

    private static String TAG = GigongRequestPage5ViewModel.class.getSimpleName();
    private Context mContext = null;

    private MutableLiveData<GigongRequestDTO> dto = new MutableLiveData<>();
    private MutableLiveData<List<GigongOptionDTO>> items = new MutableLiveData<>();

    private List<MemberDTO> dr = new ArrayList<>();
    private List<MemberDTO> dh = new ArrayList<>();

    private OptionLayoutBinding bindingOption = null;
    private OPTIONENUM optionEnum;
    private COMPONENTENUM componentEnum;
    private Dialog dialog = null;

    private GigongOptionDTO option = null;
    private OptionAdapter adapter1 = null;

    public void Init(Context mContext, FragmentGigongrequest5Binding binding, GigongRequestFragmentPage5 page5) {
        this.mContext = mContext;
        this.bindingOption = OptionLayoutBinding.inflate(LayoutInflater.from(mContext));
        this.optionEnum = new OPTIONENUM(mContext);
        this.componentEnum = new COMPONENTENUM(mContext, bindingOption, optionEnum);
        this.dialog = new Dialog(mContext);
        dialog.setContentView(bindingOption.getRoot());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setCancelable(false);
        dialog.getWindow().setAttributes(layoutParams);

        bindingOption.requestOption.setAdapter(optionEnum.getAtemp());
        bindingOption.requestOption1.setAdapter(optionEnum.getAtemp1());
        bindingOption.requestOption2.setAdapter(optionEnum.getAtemp2());
        bindingOption.requestOption3.setAdapter(optionEnum.getAtemp3());
        bindingOption.requestOption4.setAdapter(optionEnum.getAtemp4());
        bindingOption.requestOption5.setAdapter(optionEnum.getAtemp5());
        bindingOption.requestOption6.setAdapter(optionEnum.getAtemp6());
        bindingOption.requestClose.setOnClickListener(this);
        bindingOption.requestReset.setOnClickListener(this);
        bindingOption.requestSave.setOnClickListener(this);

        dto.setValue(page5.getDto());
        items.setValue(page5.getItems());
        getMember(dto.getValue().getGr_hall());
        binding.grRequestDateTemp.setOnTouchListener(page5);
        binding.grHall.setAdapter(OPTIONENUM.getAdapter(mContext, OPTIONENUM.request5Hall));
        binding.grGender.setAdapter(OPTIONENUM.getAdapter(mContext, OPTIONENUM.request5Gender));
        binding.grType.setAdapter(OPTIONENUM.getAdapter(mContext, OPTIONENUM.request5Type));
        ArrayAdapter<String> dra = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item_request5, dr.stream().map(MemberDTO::getMb_name).collect(Collectors.toList()));
        ArrayAdapter<String> dha = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item_request5, dh.stream().map(MemberDTO::getMb_name).collect(Collectors.toList()));
        binding.grDrMbName.setAdapter(dra);
        binding.grDrMbName.setSelection(dra.getPosition(dto.getValue().getGr_dr_mb_name()));
        binding.grMbName.setAdapter(dha);
        binding.grMbName.setSelection(dha.getPosition(dto.getValue().getGr_mb_name()));
        binding.grShade.setAdapter(OPTIONENUM.getAdapter(mContext, OPTIONENUM.shadeList));
        adapter1 = new OptionAdapter(items.getValue(), this, dialog, bindingOption, componentEnum);
        binding.request5Options1.setAdapter(adapter1);
        binding.request5Options1.setLayoutManager(new LinearLayoutManager(mContext));
    }

    public void setOption(GigongOptionDTO option) {
        this.option = option;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.request_save:
                if(bindingOption.requestOption.getSelectedItemPosition() == 0) items.getValue().removeIf(item -> item == option);
                else{
                    Optional<Spinner> spinner = componentEnum.getSpinners().stream().filter(item -> item.getVisibility() == View.VISIBLE).findFirst();
                    option.setGo_Option(bindingOption.requestOption.getSelectedItemPosition());
                    option.setGo_Option1(bindingOption.requestOption1.getSelectedItemPosition());
                    option.setGo_Option2(bindingOption.requestOption2.getSelectedItemPosition());
                    option.setGo_Option3(bindingOption.requestOption3.getSelectedItemPosition());
                    option.setGo_Option4(bindingOption.requestOption4.getSelectedItemPosition());
                    option.setGo_Option5(bindingOption.requestOption5.getSelectedItemPosition());
                    option.setGo_Option6(bindingOption.requestOption6.getSelectedItemPosition());
                    option.setGo_Option7_p(spinner.get().getSelectedItemPosition());
                    option.setGo_Option7(OPTIONENUM.shadeList.get(spinner.get().getSelectedItemPosition()));
                }
                adapter1.notifyDataSetChanged();
                dialog.dismiss();
                break;
            case R.id.request_reset:
                bindingOption.requestOption.setSelection(0);
                bindingOption.requestOption1.setSelection(0);
                bindingOption.requestOption2.setSelection(0);
                bindingOption.requestOption3.setSelection(1);
                bindingOption.requestOption4.setSelection(0);
                bindingOption.requestOption5.setSelection(0);
                bindingOption.requestOption6.setSelection(0);
                Optional<Spinner> spinner2 = componentEnum.getSpinners().stream().filter(item -> item.getVisibility() == View.VISIBLE).findFirst();
                spinner2.get().setSelection(0);
                break;
            case R.id.request_close:
                dialog.dismiss();
                break;
            default:
                break;
        }
    }

    public void openDatePicker(EditText edit){
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext);
        datePickerDialog.setCancelable(false);
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "확인", datePickerDialog);
        datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "", datePickerDialog);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String monthString = (month + 1) < 10 ? "0" + (month + 1) : String.valueOf(month + 1);
                String dayString = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
                String date = year + "-" + monthString + "-" + dayString;
                edit.requestFocus();
                dto.getValue().setGr_RequestDateTemp(date);
                dto.setValue(dto.getValue());
            }
        });
        datePickerDialog.show();
    }

    public void getMember(int hall){
        if(hall != 0){
            DatabaseHelper instance = DatabaseHelper.getInstance();
            Cursor cursor = null;
            if(hall != 3) cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '원장' AND mb_department != '기공') AND (mb_hall = 1 OR mb_hall = 2)", null, null, null, "mb_department, mb_name ASC");
            else cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '원장' AND mb_department != '기공') AND mb_hall = " + hall, null, null, null, "mb_department, mb_name ASC");
            dr = new LinkedList<MemberDTO>(){{
                MemberDTO temp = new MemberDTO();
                temp.setMb_name("-DR-");
                add(temp);
            }};
            while(cursor.moveToNext()) {
                int mb_no = cursor.getInt(cursor.getColumnIndexOrThrow("mb_no"));
                int mb_hall = cursor.getInt(cursor.getColumnIndexOrThrow("mb_hall"));
                String mb_name = cursor.getString(cursor.getColumnIndexOrThrow("mb_name"));
                String mb_department = cursor.getString(cursor.getColumnIndexOrThrow("mb_department"));
                dr.add(new MemberDTO(mb_no, mb_name, mb_hall, mb_department));
            }
            cursor.close();
            dh = new LinkedList<MemberDTO>(){{
                MemberDTO temp = new MemberDTO();
                temp.setMb_name("-DH-");
                add(temp);
            }};
            instance = DatabaseHelper.getInstance();
            if(hall != 3) cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '진료' AND mb_department != '기공') AND (mb_hall = 1 OR mb_hall = 2)", null, null, null, "mb_department, mb_name ASC");
            else cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '진료' AND mb_department != '기공') AND mb_hall = " + hall, null, null, null, "mb_department, mb_name ASC");
            while(cursor.moveToNext()) {
                int mb_no = cursor.getInt(cursor.getColumnIndexOrThrow("mb_no"));
                int mb_hall = cursor.getInt(cursor.getColumnIndexOrThrow("mb_hall"));
                String mb_name = cursor.getString(cursor.getColumnIndexOrThrow("mb_name"));
                String mb_department = cursor.getString(cursor.getColumnIndexOrThrow("mb_department"));
                dh.add(new MemberDTO(mb_no, mb_name, mb_hall, mb_department));
            }
            cursor.close();
        }
    }

    public MutableLiveData<GigongRequestDTO> getDto() {
        return dto;
    }

    public MutableLiveData<List<GigongOptionDTO>> getItems() {
        return items;
    }

    public List<MemberDTO> getDr() {
        return dr;
    }

    public List<MemberDTO> getDh() {
        return dh;
    }
}