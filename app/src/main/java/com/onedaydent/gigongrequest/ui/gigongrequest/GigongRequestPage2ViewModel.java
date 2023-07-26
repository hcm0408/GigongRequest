package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.db.DatabaseHelper;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.model.MemberDTO;
import com.onedaydent.gigongrequest.data.model.PatientDTO;
import com.onedaydent.gigongrequest.data.retrofit.GigongAPI;
import com.onedaydent.gigongrequest.data.retrofit.GigongClient;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest2Binding;
import com.onedaydent.gigongrequest.utils.Utils;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GigongRequestPage2ViewModel extends ViewModel {

    private static String TAG = GigongRequestPage2ViewModel.class.getSimpleName();
    // 원장
    private MutableLiveData<List<MemberDTO>> dr = new MutableLiveData<>();
    // 치과위생사
    private MutableLiveData<List<MemberDTO>> dh = new MutableLiveData<>();
    // 접수일
    private static MutableLiveData<GigongRequestDTO> gigong = new MutableLiveData<>();

    private LinkedList<PatientDTO> patients = new LinkedList<PatientDTO>();
    private Context mContext = null;

    public MutableLiveData<List<MemberDTO>> getDr() {
        return dr;
    }

    public MutableLiveData<List<MemberDTO>> getDh() {
        return dh;
    }

    public static MutableLiveData<GigongRequestDTO> getGigong(){
        return gigong;
    }

    public GigongRequestPage2ViewModel() {}

    public void Init(Context mContext, int hall, EditText date) {
        this.mContext = mContext;
        gigong.setValue(new GigongRequestDTO());
        Calendar cal = Calendar.getInstance();
        String monthString = (cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : String.valueOf(cal.get(Calendar.MONTH) + 1);
        String dayString = cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : String.valueOf(cal.get(Calendar.DATE));
        date.setText(cal.get(Calendar.YEAR) + "-" + monthString + "-" + dayString);
        gigong.getValue().setGr_RequestDateTemp(date.getText().toString());
        if(hall != 0){
            gigong.getValue().setGr_hall(hall);
            gigong.getValue().setGr_Gender(3);
            DatabaseHelper instance = DatabaseHelper.getInstance();
            Cursor cursor = null;
            if(hall != 3) cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '원장' AND mb_department != '기공') AND (mb_hall = 1 OR mb_hall = 2)", null, null, null, "mb_department, mb_name ASC");
            else cursor = instance.getDb().query("TB_MEMBER", new String[]{"mb_no", "mb_name", "mb_hall", "mb_department"}, "(mb_department = '원장' AND mb_department != '기공') AND mb_hall = " + hall, null, null, null, "mb_department, mb_name ASC");
            LinkedList<MemberDTO> items = new LinkedList<MemberDTO>(){{
                MemberDTO temp = new MemberDTO();
                temp.setMb_name("-DR-");
                add(temp);
            }};
            while(cursor.moveToNext()) {
                int mb_no = cursor.getInt(cursor.getColumnIndexOrThrow("mb_no"));
                int mb_hall = cursor.getInt(cursor.getColumnIndexOrThrow("mb_hall"));
                String mb_name = cursor.getString(cursor.getColumnIndexOrThrow("mb_name"));
                String mb_department = cursor.getString(cursor.getColumnIndexOrThrow("mb_department"));
                items.add(new MemberDTO(mb_no, mb_name, mb_hall, mb_department));
            }
            cursor.close();
            dr.setValue(items.size() != 0 ? items : null);

            items = new LinkedList<MemberDTO>(){{
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
                items.add(new MemberDTO(mb_no, mb_name, mb_hall, mb_department));
            }
            cursor.close();
            dh.setValue(items.size() != 0 ? items : null);
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
                gigong.getValue().setGr_RequestDateTemp(date);
                gigong.setValue(gigong.getValue());
            }
        });
        datePickerDialog.show();
    }

    public void getPatientData(String chartID){
        if (GigongClient.getInstance() != null){
            GigongClient.getRetrofit().create(GigongAPI.class).getPatientData(chartID).enqueue(new Callback<LinkedList<PatientDTO>>() {
                @Override
                public void onResponse(Call<LinkedList<PatientDTO>> call, Response<LinkedList<PatientDTO>> response) {
                    if(response.code() == 200){
                        if(response.body().size() != 0) showModalDialog(response.body());
                        else Utils.getMessageShort("환자정보가 없습니다.");
                    }
                }

                @Override
                public void onFailure(Call<LinkedList<PatientDTO>> call, Throwable t) {
                    Utils.getMessageShort("환자정보 받아오기 실패.\n관리자에게 문의하세요.");
                }
            });
        }
    }

    public void showModalDialog(LinkedList<PatientDTO> list) {
        // 다이얼로그 생성
        Dialog dialog = new Dialog(mContext);

        // 다이얼로그 뷰 설정
        dialog.setContentView(R.layout.dialog_layout);

        // 리스트뷰 참조
        ListView listView = dialog.findViewById(R.id.dialog_list_view);

        patients = list;
        List<String> nameList = patients.stream().map(PatientDTO::getName).collect(Collectors.toList());

        // 리스트뷰 어댑터 설정
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);

        // 다이얼로그 크기 설정
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PatientDTO item = patients.get(i);
                gigong.getValue().setGr_Gender(item.getGender().equals("M") ? 0 : 1);
                gigong.getValue().setGr_Name(item.getName());
                gigong.getValue().setGr_ChartID(item.getChartID());
                gigong.setValue(gigong.getValue());
                dialog.dismiss();
            }
        });

        // 다이얼로그 표시
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    public void clickSpinnerItem(int type, int i){
        if(type == 0){
            gigong.getValue().setGr_dr_mb_name(dr.getValue().get(i).getMb_name());
            gigong.getValue().setGr_dr_mb_no(dr.getValue().get(i).getMb_no());
        }else{
            gigong.getValue().setGr_mb_name(dh.getValue().get(i).getMb_name());
            gigong.getValue().setGr_mb_no(dh.getValue().get(i).getMb_no());
        }
        gigong.setValue(gigong.getValue());
    }

    public void setGender(int gender){
        gigong.getValue().setGr_Gender(gender);
        gigong.setValue(gigong.getValue());
    }

    public void setType(int type){
        if(type == 0) {
            if(gigong.getValue().getGr_Type() == 1) gigong.getValue().setGr_Type(0);
            else gigong.getValue().setGr_Type(1);
        }
        else {
            if(gigong.getValue().getGr_Type() == 2) gigong.getValue().setGr_Type(0);
            else gigong.getValue().setGr_Type(2);
        }
        gigong.setValue(gigong.getValue());
    }

    public void getNextStep(FragmentManager manager, FragmentGigongrequest2Binding binding){
        GigongRequestDTO dto = GigongRequestPage2ViewModel.getGigong().getValue();
        boolean bool = true;
        if(dto.getGr_RequestDateTemp().equals("")){
            Utils.getMessageShort("접수일을 입력해주세요.");
            binding.request2Txt1.requestFocus();
            bool = false;
        }
        Log.d(TAG, "getNextStep: " + bool);
        if(bool && (dto.getGr_ChartID() == null || dto.getGr_ChartID().isEmpty())){
            Utils.getMessageShort("차트번호를 입력해주세요.");
            binding.request2Txt2.requestFocus();
            bool = false;
        }
        if(bool && (dto.getGr_Name() == null || dto.getGr_Name().isEmpty())){
            Utils.getMessageShort("이름을 입력해주세요.");
            binding.request2Txt3.requestFocus();
            bool = false;
        }
        if(bool && (dto.getGr_Gender() != 0 && dto.getGr_Gender() != 1)){
            Utils.getMessageShort("성별을 선택해주세요.");
            binding.request2Txt3.requestFocus();
            bool = false;
        }
        if(bool && dto.getGr_dr_mb_no() == 0){
            Utils.getMessageShort("DR을 선택해주세요.");
            binding.request2Dr.performClick();
            bool = false;
        }
        if(bool && dto.getGr_mb_no() == 0){
            Utils.getMessageShort("DH을 선택해주세요.");
            binding.request2Dh.performClick();
            bool = false;
        }
        if(bool){
            if (GigongClient.getInstance() != null){
                GigongClient.getRetrofit().create(GigongAPI.class).setGigongRequest(dto).enqueue(new Callback<GigongRequestDTO>() {
                    @Override
                    public void onResponse(Call<GigongRequestDTO> call, Response<GigongRequestDTO> response) {
                        if(response.code() == 200){
                            dto.setGr_IDX(response.body().getGr_IDX());
                            FragmentTransaction transaction = manager.beginTransaction();
                            GigongRequestFragmentPage3 frag = new GigongRequestFragmentPage3(dto);
                            transaction = manager.beginTransaction();
                            transaction.replace(R.id.nav_host_fragment_activity_main, frag);
                            transaction.addToBackStack("2");
                            transaction.commit();
                        }
                    }

                    @Override
                    public void onFailure(Call<GigongRequestDTO> call, Throwable t) {
                        Utils.getMessageShort("기본정보 저장 실패.\n관리자에게 문의하세요.");
                    }
                });
            }
        }
    }
}