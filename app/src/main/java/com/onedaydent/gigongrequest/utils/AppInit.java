package com.onedaydent.gigongrequest.utils;

import android.app.Application;
import android.content.ContentValues;
import android.util.Log;

import com.onedaydent.gigongrequest.data.db.DatabaseHelper;
import com.onedaydent.gigongrequest.data.model.MemberDTO;
import com.onedaydent.gigongrequest.data.retrofit.GigongAPI;
import com.onedaydent.gigongrequest.data.retrofit.GigongClient;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppInit extends Application {

    private static String TAG = AppInit.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        // Toast알람 메소드 등록
        Utils.setContext(this);
        // DatabaseHelper 등록
        DatabaseHelper instance = DatabaseHelper.getInstance(this);
        // 초기 사용자 정보 받아오기
        if (GigongClient.getInstance() != null){
            GigongClient.getRetrofit().create(GigongAPI.class).getMemberData().enqueue(new Callback<LinkedList<MemberDTO>>() {
                @Override
                public void onResponse(Call<LinkedList<MemberDTO>> call, Response<LinkedList<MemberDTO>> response) {
                    if(response.code() == 200){
                        if(response.body().size() != 0){
                            for(MemberDTO item : response.body()){
                                ContentValues values = new ContentValues();
                                values.put("mb_no", item.getMb_no());
                                values.put("mb_name", item.getMb_name());
                                values.put("mb_hall", item.getMb_hall());
                                values.put("mb_department", item.getMb_department());
                                instance.getDb().insert("TB_MEMBER", null, values);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<LinkedList<MemberDTO>> call, Throwable t) {
                    Utils.getMessageShort("초기화 실패, 관리자에게 문의하세요.");
                }
            });
        }
    }
}