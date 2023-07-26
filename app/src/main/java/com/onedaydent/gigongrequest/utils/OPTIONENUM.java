package com.onedaydent.gigongrequest.utils;

import android.app.Application;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.onedaydent.gigongrequest.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OPTIONENUM extends Application {
    private static String TAG = OPTIONENUM.class.getSimpleName();
    private Context mContext = null;
    private ArrayAdapter<String> atemp = null;
    private ArrayAdapter<String> atemp1 = null;
    private ArrayAdapter<String> atemp2 = null;
    private ArrayAdapter<String> atemp3 = null;
    private ArrayAdapter<String> atemp4 = null;
    private ArrayAdapter<String> atemp5 = null;
    private ArrayAdapter<String> atemp6 = null;
    private ArrayAdapter<String> adapter = null;

    public OPTIONENUM(){
    }

    public OPTIONENUM(Context context){
        this.mContext = context;
        atemp = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.optionStr.stream().map(s -> s).collect(Collectors.toList()));
        atemp1 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option1Str.stream().map(s -> s).collect(Collectors.toList()));
        atemp2 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option2Str.stream().map(s -> s).collect(Collectors.toList()));
        atemp3 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option3Str.stream().map(s -> s).collect(Collectors.toList()));
        atemp4 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option4Str.stream().map(s -> s).collect(Collectors.toList()));
        atemp5 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option5Str.stream().map(s -> s).collect(Collectors.toList()));
        atemp6 = new ArrayAdapter<>(mContext, R.layout.custom_spinner_item2, OPTIONENUM.option6Str.stream().map(s -> s).collect(Collectors.toList()));
        adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, OPTIONENUM.healings.stream().map(s -> s).collect(Collectors.toList()));
    }
    public static List<String> healings = Arrays.asList(
        "",
        "4.0x3",
        "4.0x4.5",
        "4.0x6",
        "4.0x7",
        "4.5x3",
        "4.5x4",
        "4.5x5",
        "4.5x6",
        "4.5x7",
        "4.5x9",
        "5.5x3",
        "5.5x4",
        "5.5x5",
        "5.5x6",
        "5.5x7",
        "5.5x9",
        "6.5x3",
        "6.5x4",
        "6.5x5",
        "6.5x6",
        "Bit(M)",
        "Bit(R)"
    );
    public static List<String> optionStr = Arrays.asList(
        "",
        "Zirconia Implant",
        "PFM Implant",
        "PMMA Implant",
        "Pontic",
        "Zirconia Crown",
        "PFM Crown",
        "PMMA Crown",
        "Gold Crown",
        "Ceramic Inlay",
        "Gold Inlay",
        "Indi Tray / Jig Bite",
        "Full Denture",
        "Temp Denture",
        "Temp Shell",
        "Temp",
        "Flipper",
        "Metal Frame",
        "Wax Rim",
        "Recoding Base",
        "도치배열",
        "스터디모델",
        "진단왁스업",
        "서지컬가이드",
        "Laminate"
    );
    public static List<String> option1Str = Arrays.asList(
        "",
        "Oneday Biotech",
        "Osstem",
        "Dentis",
        "Dentium",
        "Astra"
    );
    public static List<String> option2Str = Arrays.asList(
        "",
        "Oneday Biotech",
        "Sur",
        "Sur(신)",
        "Der",
        "Der(신)",
        "Dentis",
        "Dentium",
        "Astra"
    );
    public static List<String> option3Str = Arrays.asList(
        "",
        "○",
        "△"
    );
    public static List<String> option4Str = Arrays.asList(
        "",
        "Imp",
        "Trios",
        "RAYOS"
    );
    public static List<String> option5Str = Arrays.asList(
        "",
        "Cement Type",
        "Scrp Type",
        "Screw Type"
    );
    public static List<String> option6Str = Arrays.asList(
        "",
        "Cap",
        "Set",
        "F/Imp"
    );

    public static List<String> shadeList = Arrays.asList(
            "",
            "A1",
            "A2",
            "A3",
            "A3.5",
            "A4",
            "B1",
            "B2",
            "B3",
            "B4",
            "C1",
            "C2",
            "C3",
            "C4",
            "D2",
            "D3",
            "D4",
            "1M1",
            "1M2",
            "2L1.5",
            "2L2",
            "2M1",
            "2M1.5",
            "2M2",
            "2R1.5",
            "2R2",
            "3L1.5",
            "3L2",
            "3M1",
            "3M1.5",
            "3M2",
            "3R1.5",
            "3R2",
            "4L1.5",
            "4L2",
            "4M1",
            "4M1.5",
            "4M2",
            "4R1.5",
            "4R2",
            "5M1",
            "5M2.5",
            "5M2"
    );
    public static List<String> request5Hall = Arrays.asList(
            "1관",
            "2관",
            "3관"
    );
    public static List<String> request5Type = Arrays.asList(
            "X",
            "당일",
            "1박 2일"
    );
    public static List<String> request5Gender = Arrays.asList(
            "남",
            "여"
    );

    public ArrayAdapter<String> getAtemp() {
        return atemp;
    }

    public ArrayAdapter<String> getAtemp1() {
        return atemp1;
    }

    public ArrayAdapter<String> getAtemp2() {
        return atemp2;
    }

    public ArrayAdapter<String> getAtemp3() {
        return atemp3;
    }

    public ArrayAdapter<String> getAtemp4() {
        return atemp4;
    }

    public ArrayAdapter<String> getAtemp5() {
        return atemp5;
    }

    public ArrayAdapter<String> getAtemp6() {
        return atemp6;
    }

    public ArrayAdapter<String> getAdapter() {
        return adapter;
    }

    public List<String> getShadeList() {
        return shadeList;
    }

    public static ArrayAdapter<String> getAdapter(Context context, List<String> items) {
        return new ArrayAdapter<>(context, R.layout.custom_spinner_item_request5, items.stream().map(s -> s).collect(Collectors.toList()));
    }
}
