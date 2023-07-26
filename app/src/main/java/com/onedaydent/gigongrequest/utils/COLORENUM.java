package com.onedaydent.gigongrequest.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.onedaydent.gigongrequest.R;

import java.util.ArrayList;
import java.util.List;

public class COLORENUM extends Application {
    private static String TAG = COLORENUM.class.getSimpleName();
    private Context mContext = null;
    private List<Drawable> COLORENUM = new ArrayList<Drawable>();
    public COLORENUM(Context context){
        this.mContext = context;
        COLORENUM = new ArrayList<Drawable>(){{
            add(ContextCompat.getDrawable(mContext, R.drawable.circle));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option1));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option2));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option3));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option4));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option5));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option6));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option7));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option8));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option9));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option10));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option11));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option12));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option13));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option14));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option15));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option16));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option17));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option18));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option19));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option20));
            add(ContextCompat.getDrawable(mContext, R.drawable.circle_option21));
        }};
    }

    public List<Drawable> getCOLORENUM() {
        return COLORENUM;
    }
}
