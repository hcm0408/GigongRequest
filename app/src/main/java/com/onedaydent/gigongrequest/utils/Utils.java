package com.onedaydent.gigongrequest.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.onedaydent.gigongrequest.R;

public class Utils {

    private static Context mContext = null;
    public static void setContext(Context context) {
        mContext = context;
    }
    public static void getMessageShort(String str){
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }
    public static void getMessageLong(String str){
        Toast.makeText(mContext, str, Toast.LENGTH_LONG).show();
    }
    public static void changeButtonBackground(AppCompatButton btn, boolean on){
        if(on) {
            btn.setTextColor(Color.WHITE);
            btn.setBackgroundDrawable(mContext.getDrawable(R.drawable.border2));
        }
        else{
            btn.setTextColor(Color.BLACK);
            btn.setBackgroundDrawable(mContext.getDrawable(R.drawable.border1));
        }
    }
}
