package com.onedaydent.gigongrequest.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.data.model.GigongRequestDTO;
import com.onedaydent.gigongrequest.data.retrofit.GigongAPI;
import com.onedaydent.gigongrequest.data.retrofit.GigongClient;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest3Binding;
import com.onedaydent.gigongrequest.databinding.OptionLayoutBinding;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestBridgeController;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestFragmentPage3;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestFragmentPage4;
import com.onedaydent.gigongrequest.ui.gigongrequest.GigongRequestPage3ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class COMPONENTENUM extends Application {
    private static String TAG = COMPONENTENUM.class.getSimpleName();

    private boolean btns1b = true, btns2b = true, btns3b = true, btns4b = true;
    private List<Boolean> btnsBArray = new ArrayList<Boolean>(){{
        add(btns1b);
        add(btns2b);
        add(btns3b);
        add(btns4b);
    }};
    private LinkedList<TextView> btns1 = new LinkedList<TextView>();
    private LinkedList<TextView> btns2 = new LinkedList<TextView>();
    private LinkedList<TextView> btns3 = new LinkedList<TextView>();
    private LinkedList<TextView> btns4 = new LinkedList<TextView>();
    private LinkedList<View> lines = new LinkedList<View>();
    private LinkedList<ImageButton> bridges = new LinkedList<ImageButton>();
    private Map<Integer, TextView> btnsArray = new HashMap<Integer, TextView>(){};
    private Map<TextView, Integer> btnsArray2 = new HashMap<TextView, Integer>(){};
    private List<TextView> selectedCircle = new ArrayList<TextView>();
    private List<GigongOptionDTO> selectedDTO = new ArrayList<GigongOptionDTO>();
    private List<Spinner> spinners = null;
    private Context mContext = null;
    private OptionLayoutBinding bindingOption = null;
    private GigongRequestPage3ViewModel model = null;

    private Drawable circleChoice = null;
    private Drawable circle = null;
    private Drawable bridgeCircle = null;
    private Drawable bridgeNullCircle = null;
    private GigongRequestFragmentPage3 page3 = null;


    public COMPONENTENUM (Context context,  FragmentGigongrequest3Binding binding, View.OnClickListener listener, View.OnLongClickListener longClickListener, OptionLayoutBinding bindingOption, GigongRequestPage3ViewModel model){
        this.mContext = context;
        this.bindingOption = bindingOption;
        this.model = model;
        circleChoice = mContext.getDrawable(R.drawable.circle_choice);
        circle = mContext.getDrawable(R.drawable.circle);
        bridgeCircle = mContext.getDrawable(R.drawable.circle_bridge);
        bridgeNullCircle = mContext.getDrawable(R.drawable.circle_bridgenull);

        GigongRequestBridgeController bridgeController = new GigongRequestBridgeController(model, bridgeCircle, bridgeNullCircle);

        btns1.add(binding.request3Circle11);
        btns1.add(binding.request3Circle12);
        btns1.add(binding.request3Circle13);
        btns1.add(binding.request3Circle14);
        btns1.add(binding.request3Circle15);
        btns1.add(binding.request3Circle16);
        btns1.add(binding.request3Circle17);
        btns1.add(binding.request3Circle18);

        btns2.add(binding.request3Circle21);
        btns2.add(binding.request3Circle22);
        btns2.add(binding.request3Circle23);
        btns2.add(binding.request3Circle24);
        btns2.add(binding.request3Circle25);
        btns2.add(binding.request3Circle26);
        btns2.add(binding.request3Circle27);
        btns2.add(binding.request3Circle28);

        btns3.add(binding.request3Circle31);
        btns3.add(binding.request3Circle32);
        btns3.add(binding.request3Circle33);
        btns3.add(binding.request3Circle34);
        btns3.add(binding.request3Circle35);
        btns3.add(binding.request3Circle36);
        btns3.add(binding.request3Circle37);
        btns3.add(binding.request3Circle38);

        btns4.add(binding.request3Circle41);
        btns4.add(binding.request3Circle42);
        btns4.add(binding.request3Circle43);
        btns4.add(binding.request3Circle44);
        btns4.add(binding.request3Circle45);
        btns4.add(binding.request3Circle46);
        btns4.add(binding.request3Circle47);
        btns4.add(binding.request3Circle48);

        lines.add(binding.request3Line10);
        lines.add(binding.request3Line11);
        lines.add(binding.request3Line12);
        lines.add(binding.request3Line13);
        lines.add(binding.request3Line14);
        lines.add(binding.request3Line15);
        lines.add(binding.request3Line16);
        lines.add(binding.request3Line17);
        lines.add(binding.request3Line21);
        lines.add(binding.request3Line22);
        lines.add(binding.request3Line23);
        lines.add(binding.request3Line24);
        lines.add(binding.request3Line25);
        lines.add(binding.request3Line26);
        lines.add(binding.request3Line27);
        lines.add(binding.request3Line30);
        lines.add(binding.request3Line31);
        lines.add(binding.request3Line32);
        lines.add(binding.request3Line33);
        lines.add(binding.request3Line34);
        lines.add(binding.request3Line35);
        lines.add(binding.request3Line36);
        lines.add(binding.request3Line37);
        lines.add(binding.request3Line41);
        lines.add(binding.request3Line42);
        lines.add(binding.request3Line43);
        lines.add(binding.request3Line44);
        lines.add(binding.request3Line45);
        lines.add(binding.request3Line46);
        lines.add(binding.request3Line47);

        bridges.add(binding.request3Bridge10);
        bridges.add(binding.request3Bridge11);
        bridges.add(binding.request3Bridge12);
        bridges.add(binding.request3Bridge13);
        bridges.add(binding.request3Bridge14);
        bridges.add(binding.request3Bridge15);
        bridges.add(binding.request3Bridge16);
        bridges.add(binding.request3Bridge17);
        bridges.add(binding.request3Bridge21);
        bridges.add(binding.request3Bridge22);
        bridges.add(binding.request3Bridge23);
        bridges.add(binding.request3Bridge24);
        bridges.add(binding.request3Bridge25);
        bridges.add(binding.request3Bridge26);
        bridges.add(binding.request3Bridge27);
        bridges.add(binding.request3Bridge30);
        bridges.add(binding.request3Bridge31);
        bridges.add(binding.request3Bridge32);
        bridges.add(binding.request3Bridge33);
        bridges.add(binding.request3Bridge34);
        bridges.add(binding.request3Bridge35);
        bridges.add(binding.request3Bridge36);
        bridges.add(binding.request3Bridge37);
        bridges.add(binding.request3Bridge41);
        bridges.add(binding.request3Bridge42);
        bridges.add(binding.request3Bridge43);
        bridges.add(binding.request3Bridge44);
        bridges.add(binding.request3Bridge45);
        bridges.add(binding.request3Bridge46);
        bridges.add(binding.request3Bridge47);

        binding.request3All1.setOnClickListener(listener);
        binding.request3All2.setOnClickListener(listener);
        binding.request3All3.setOnClickListener(listener);
        binding.request3All4.setOnClickListener(listener);
        binding.request3Reset.setOnClickListener(listener);
        binding.request3Insert.setOnClickListener(listener);
        binding.request3Nextbtn.setOnClickListener(listener);
        binding.request3Pontic.setOnClickListener(listener);
        binding.request3Copyshow.setOnClickListener(listener);

        Stream.of(btns1, btns2, btns3, btns4).flatMap(Collection::stream).forEach(item -> {
            item.setOnClickListener(listener);
            item.setOnLongClickListener(longClickListener);
        });
        AtomicInteger startValue = new AtomicInteger(0);
        Stream.of(btns1, btns2, btns3, btns4)
                .flatMap(Collection::stream)
                .forEach(item -> btnsArray.put(startValue.getAndIncrement(), item));
        btnsArray.forEach((key, item) -> btnsArray2.put(item, key));

        Stream.of(bridges, lines)
                .flatMap(Collection::stream)
                .forEach(item -> item.setVisibility(View.INVISIBLE));
        spinners = Arrays.asList(
                bindingOption.requestSpinner11,
                bindingOption.requestSpinner12,
                bindingOption.requestSpinner13,
                bindingOption.requestSpinner14,
                bindingOption.requestSpinner15,
                bindingOption.requestSpinner16,
                bindingOption.requestSpinner17,
                bindingOption.requestSpinner18,
                bindingOption.requestSpinner21,
                bindingOption.requestSpinner22,
                bindingOption.requestSpinner23,
                bindingOption.requestSpinner24,
                bindingOption.requestSpinner25,
                bindingOption.requestSpinner26,
                bindingOption.requestSpinner27,
                bindingOption.requestSpinner28,
                bindingOption.requestSpinner31,
                bindingOption.requestSpinner32,
                bindingOption.requestSpinner33,
                bindingOption.requestSpinner34,
                bindingOption.requestSpinner35,
                bindingOption.requestSpinner36,
                bindingOption.requestSpinner37,
                bindingOption.requestSpinner38,
                bindingOption.requestSpinner41,
                bindingOption.requestSpinner42,
                bindingOption.requestSpinner43,
                bindingOption.requestSpinner44,
                bindingOption.requestSpinner45,
                bindingOption.requestSpinner46,
                bindingOption.requestSpinner47,
                bindingOption.requestSpinner48
        );

        IntStream.range(1, 5).forEach(group -> {
            AtomicInteger startValue2 = new AtomicInteger(group * 10 + 1);
            List<TextView> btns = getBtnsByGroup(group);
            btns.forEach(item -> model.getItems().add(new GigongOptionDTO(item, startValue2.getAndIncrement())));
            model.getTemps2().setValue(model.getItems());
        });

        for (int i = 0; i < model.getItems().size(); i++) {
            int temp = model.getItems().get(i).getGo_ToothNumber();
            if(temp == 11){
                model.getItems().get(i).setBridge2(getBridges().get(0));
                model.getItems().get(i).setLine2(getLines().get(0));
            }else if(temp == 31){
                model.getItems().get(i).setBridge2(getBridges().get(15));
                model.getItems().get(i).setLine2(getLines().get(15));
            }
            if(temp >= 10 && temp < 18) {
                model.getItems().get(i).setBridge(getBridges().get(i + 1));
                model.getItems().get(i).setLine(getLines().get(i + 1));
            }
            else if(temp >= 20 && temp < 28) {
                model.getItems().get(i).setBridge(getBridges().get(i));
                model.getItems().get(i).setLine(getLines().get(i));
            }
            else if(temp >= 30 && temp < 38) {
                model.getItems().get(i).setBridge(getBridges().get(i));
                model.getItems().get(i).setLine(getLines().get(i));
            }
            else if(temp >= 40 && temp < 48) {
                model.getItems().get(i).setBridge(getBridges().get(i - 1));
                model.getItems().get(i).setLine(getLines().get(i - 1));
            }
        }
        getBridges().forEach(item -> {
            item.setOnClickListener(bridgeController);
            item.setBackgroundDrawable(bridgeCircle);
        });

        getSpinners().forEach(item -> {
            item.setAdapter(model.getOptionEnum().getAdapter());
            item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String str = (String) adapterView.getItemAtPosition(i);
                    if (!str.equals("")) {
                        Optional<GigongOptionDTO> optional = null;
                        switch (adapterView.getId()) {
                            case R.id.request_spinner11:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 11).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner12:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 12).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner13:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 13).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner14:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 14).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner15:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 15).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner16:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 16).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner17:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 17).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner18:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 18).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner21:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 21).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner22:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 22).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner23:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 23).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner24:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 24).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner25:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 25).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner26:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 26).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner27:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 27).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner28:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 28).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner31:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 31).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner32:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 32).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner33:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 33).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner34:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 34).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner35:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 35).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner36:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 36).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner37:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 37).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner38:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 38).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner41:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 41).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner42:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 42).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner43:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 43).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner44:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 44).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner45:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 45).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner46:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 46).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner47:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 47).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            case R.id.request_spinner48:
                                optional = model.getTemps().stream().filter(item -> item.getGo_ToothNumber() == 48).findFirst();
                                if (optional.isPresent()) {
                                    optional.get().setGo_Option7(str);
                                    optional.get().setGo_Option7_p(i);
                                }
                                break;
                            default:
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        });
    }

    public COMPONENTENUM(Context context, OptionLayoutBinding bindingOption, OPTIONENUM optionenum){
        this.mContext = context;
        spinners = Arrays.asList(
                bindingOption.requestSpinner11,
                bindingOption.requestSpinner12,
                bindingOption.requestSpinner13,
                bindingOption.requestSpinner14,
                bindingOption.requestSpinner15,
                bindingOption.requestSpinner16,
                bindingOption.requestSpinner17,
                bindingOption.requestSpinner18,
                bindingOption.requestSpinner21,
                bindingOption.requestSpinner22,
                bindingOption.requestSpinner23,
                bindingOption.requestSpinner24,
                bindingOption.requestSpinner25,
                bindingOption.requestSpinner26,
                bindingOption.requestSpinner27,
                bindingOption.requestSpinner28,
                bindingOption.requestSpinner31,
                bindingOption.requestSpinner32,
                bindingOption.requestSpinner33,
                bindingOption.requestSpinner34,
                bindingOption.requestSpinner35,
                bindingOption.requestSpinner36,
                bindingOption.requestSpinner37,
                bindingOption.requestSpinner38,
                bindingOption.requestSpinner41,
                bindingOption.requestSpinner42,
                bindingOption.requestSpinner43,
                bindingOption.requestSpinner44,
                bindingOption.requestSpinner45,
                bindingOption.requestSpinner46,
                bindingOption.requestSpinner47,
                bindingOption.requestSpinner48
        );
        spinners.forEach(item -> {
            item.setAdapter(optionenum.getAdapter());
        });
    }

    public void openOptionDialog(){
        if(getSelectedCircle().size() == 0) Utils.getMessageShort("선택된 치식이 없습니다.");
        else {
            blockReset();
            model.setTemps(new ArrayList<GigongOptionDTO>());
            getSelectedDTO().forEach(item -> model.getTemps().add((GigongOptionDTO)item.clone()));
            for(GigongOptionDTO item : getSelectedDTO()) {
                choiceSpinner(item, false);
            }
            model.getDialog().show();
        }
    }

    public void save(GigongRequestDTO dto, FragmentManager manager){
        model.getItems().forEach(item -> {
            if(item.getGo_Option() != 0){
                if(item.getGo_Option() == 4) item.reset();
            }
            item.setGo_gr_IDX(dto.getGr_IDX());
            item.setCircle(null);
            item.setBridge(null);
            item.setBridge2(null);
            item.setLine(null);
            item.setLine2(null);
        });
        if(model.getItems().size() == 0) Utils.getMessageShort("기공물을 입력해주세요.");
        if (GigongClient.getInstance() != null){
            GigongClient.getRetrofit().create(GigongAPI.class).setGigongOption(model.getItems()).enqueue(new Callback<LinkedList<GigongOptionDTO>>() {

                @Override
                public void onResponse(Call<LinkedList<GigongOptionDTO>> call, Response<LinkedList<GigongOptionDTO>> response) {
                    if(response.code() == 200){
                        model.getItems().forEach(item ->{
                            response.body().stream().forEach(item2 ->{
                                if(item.getGo_ToothNumber() == item2.getGo_ToothNumber()) {
                                    item.setGo_IDX(item2.getGo_IDX());
                                }
                            });
                        });
                        FragmentTransaction transaction = manager.beginTransaction();
                        GigongRequestFragmentPage4 frag = new GigongRequestFragmentPage4(dto, model.getItems());
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.nav_host_fragment_activity_main, frag);
                        transaction.addToBackStack("3");
                        transaction.commit();
                    }
                }

                @Override
                public void onFailure(Call<LinkedList<GigongOptionDTO>> call, Throwable t) {
                    Utils.getMessageShort("기공물정보 저장 실패.\n관리자에게 문의하세요.");
                }
            });
        }
    }

    private List<TextView> getBtnsByGroup(int group) {
        switch (group) {
            case 1:
                return getBtns1();
            case 2:
                return getBtns2();
            case 3:
                return getBtns3();
            case 4:
                return getBtns4();
            default:
                throw new IllegalArgumentException("Invalid group number");
        }
    }

    public void clickAll(int group){
        int start = group * 8;
        int end = start + 6;
        for (int i = start; i <= end; i++) {
            if (getBtnsBArray().get(group)) {
                if(model.getItems().get(i).getGo_Option() == 0){
                    getBtnsArray().get(i).setBackground(circleChoice);
                    GigongOptionDTO item = model.getItems().get(i);
                    selectedCircle.add(getBtnsArray().get(i));
                    selectedDTO.add(item);
                    item.setSelected(getBtnsBArray().get(group));
                }
            }
            else {
                if(model.getItems().get(i).getGo_Option() == 0){
                    getBtnsArray().get(i).setBackground(circle);
                    GigongOptionDTO item = model.getItems().get(i);
                    selectedCircle.remove(getBtnsArray().get(i));
                    selectedDTO.remove(item);
                    item.setSelected(getBtnsBArray().get(group));
                }
            }
        }
        getBtnsBArray().set(group, !getBtnsBArray().get(group));
    }

    // 완전 초기화
    public void reset(){
        getBtnsArray().forEach((key, item) -> item.setBackground(circle));
        model.getItems().forEach(item -> {
            if(item.getGo_Option() == 4) item.getCircle().setText(item.getGo_ToothNumber() % 10 + "");
        });
        model.getItems().replaceAll(item -> new GigongOptionDTO(item.getCircle(), item.getGo_ToothNumber(), item.getBridge(), item.getLine(), item.getBridge2() != null ? item.getBridge2() : null, item.getLine2() != null ? item.getLine2() : null, bridgeCircle));
        Collections.fill(getBtnsBArray(), true);
        selectedCircle = new ArrayList<TextView>();
        selectedDTO = new ArrayList<GigongOptionDTO>();
        Stream.of(getBridges(), getLines())
                .flatMap(Collection::stream)
                .forEach(item -> item.setVisibility(View.INVISIBLE));
        getSpinners().forEach(item -> item.setVisibility(View.INVISIBLE));
        model.setFirstSave(true);
        blockReset();
    }

    // 요청서 항목 초기화
    public void blockReset(){
        getSpinners().forEach(item -> {
            item.setVisibility(View.INVISIBLE);
            item.setSelection(0);
        });
        bindingOption.requestOption.setSelection(0);
        bindingOption.requestOption1.setSelection(0);
        bindingOption.requestOption2.setSelection(0);
        bindingOption.requestOption3.setSelection(1);
        bindingOption.requestOption4.setSelection(0);
        bindingOption.requestOption5.setSelection(0);
        bindingOption.requestOption6.setSelection(0);
    }

    public void setBriges(){
        for(GigongOptionDTO item : model.getItems()){
            if(item.getBridge() != null){
                item.getBridge().setVisibility(View.INVISIBLE);
                item.getBridge().setBackground(bridgeCircle);
                item.getLine().setVisibility(View.INVISIBLE);
            }
            if(item.getBridge2() != null){
                item.getBridge2().setVisibility(View.INVISIBLE);
                item.getBridge2().setBackground(bridgeCircle);
                item.getLine2().setVisibility(View.INVISIBLE);
            }
        }
        for(GigongOptionDTO item : model.getItems()){
            if(item.getGo_Option() != 0) {
                String temp = item.getGo_ToothNumber() + "";
                int first1 = Integer.parseInt(temp.substring(0, 1));
                int second1 = Integer.parseInt(temp.substring(1, 2));
                for(GigongOptionDTO item2 : model.getItems()){
                    if(item2.getGo_Option() != 0) {
                        item.getCircle().setBackground(model.getColorEnum().getCOLORENUM().get(item.getGo_Option()));
                        String temp2 = item2.getGo_ToothNumber() + "";
                        int first2 = Integer.parseInt(temp2.substring(0, 1));
                        int second2 = Integer.parseInt(temp2.substring(1, 2));
                        if (!temp.equals(temp2)) {
                            if((first1 == 1 && second1 == 1 && first2 == 2 && second2 == 1) || (first1 == 3 && second1 == 1 && first2 == 4 && second2 == 1)){
                                if(item.getBridge2() != null){
                                    if(item.getGo_isBridge2() == 1) {
                                        item.getBridge2().setVisibility(View.VISIBLE);
                                        item.getLine2().setVisibility(View.INVISIBLE);
                                    }else{
                                        item.getBridge2().setVisibility(View.VISIBLE);
                                        item.getBridge2().setBackground(bridgeNullCircle);
                                        item.getLine2().setVisibility(View.VISIBLE);
                                    }
                                }
                            }else if (first1 == first2 && (second1 + 1) == second2) {
                                if(item.getBridge() != null){
                                    if(item.getGo_isBridge() == 1) {
                                        item.getBridge().setVisibility(View.VISIBLE);
                                        item.getBridge().setBackground(bridgeCircle);
                                        item.getLine().setVisibility(View.INVISIBLE);
                                    }else{
                                        item.getBridge().setVisibility(View.VISIBLE);
                                        item.getBridge().setBackground(bridgeNullCircle);
                                        item.getLine().setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void openSelectedMenu(GigongOptionDTO item){
        blockReset();
        choiceSpinner(item, true);
        model.setTemps(new ArrayList<GigongOptionDTO>());
        model.getTemps().add(item);
        model.setFirstSave(false);
        bindingOption.requestOption.setSelection(item.getGo_Option());
        bindingOption.requestOption1.setSelection(item.getGo_Option1());
        bindingOption.requestOption2.setSelection(item.getGo_Option2());
        bindingOption.requestOption3.setSelection(item.getGo_Option3());
        bindingOption.requestOption4.setSelection(item.getGo_Option4());
        bindingOption.requestOption5.setSelection(item.getGo_Option5());
        bindingOption.requestOption6.setSelection(item.getGo_Option6());
        model.getDialog().show();
    }

    public void choiceSpinner(GigongOptionDTO item, boolean bool){
        switch(item.getGo_ToothNumber()){
            case 11 :
                getSpinners().get(0).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(0).setSelection(item.getGo_Option7_p());
                break;
            case 12 :
                getSpinners().get(1).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(1).setSelection(item.getGo_Option7_p());
                break;
            case 13 :
                getSpinners().get(2).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(2).setSelection(item.getGo_Option7_p());
                break;
            case 14 :
                getSpinners().get(3).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(3).setSelection(item.getGo_Option7_p());
                break;
            case 15 :
                getSpinners().get(4).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(4).setSelection(item.getGo_Option7_p());
                break;
            case 16 :
                getSpinners().get(5).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(5).setSelection(item.getGo_Option7_p());
                break;
            case 17 :
                getSpinners().get(6).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(6).setSelection(item.getGo_Option7_p());
                break;
            case 18 :
                getSpinners().get(7).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(7).setSelection(item.getGo_Option7_p());
                break;
            case 21 :
                getSpinners().get(8).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(8).setSelection(item.getGo_Option7_p());
                break;
            case 22 :
                getSpinners().get(9).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(9).setSelection(item.getGo_Option7_p());
                break;
            case 23 :
                getSpinners().get(10).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(10).setSelection(item.getGo_Option7_p());
                break;
            case 24 :
                getSpinners().get(11).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(11).setSelection(item.getGo_Option7_p());
                break;
            case 25 :
                getSpinners().get(12).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(12).setSelection(item.getGo_Option7_p());
                break;
            case 26 :
                getSpinners().get(13).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(13).setSelection(item.getGo_Option7_p());
                break;
            case 27 :
                getSpinners().get(14).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(14).setSelection(item.getGo_Option7_p());
                break;
            case 28 :
                getSpinners().get(15).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(15).setSelection(item.getGo_Option7_p());
                break;
            case 31 :
                getSpinners().get(16).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(16).setSelection(item.getGo_Option7_p());
                break;
            case 32 :
                getSpinners().get(17).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(17).setSelection(item.getGo_Option7_p());
                break;
            case 33 :
                getSpinners().get(18).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(18).setSelection(item.getGo_Option7_p());
                break;
            case 34 :
                getSpinners().get(19).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(19).setSelection(item.getGo_Option7_p());
                break;
            case 35 :
                getSpinners().get(20).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(20).setSelection(item.getGo_Option7_p());
                break;
            case 36 :
                getSpinners().get(21).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(21).setSelection(item.getGo_Option7_p());
                break;
            case 37 :
                getSpinners().get(22).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(22).setSelection(item.getGo_Option7_p());
                break;
            case 38 :
                getSpinners().get(23).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(23).setSelection(item.getGo_Option7_p());
                break;
            case 41 :
                getSpinners().get(24).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(24).setSelection(item.getGo_Option7_p());
                break;
            case 42 :
                getSpinners().get(25).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(25).setSelection(item.getGo_Option7_p());
                break;
            case 43 :
                getSpinners().get(26).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(26).setSelection(item.getGo_Option7_p());
                break;
            case 44 :
                getSpinners().get(27).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(27).setSelection(item.getGo_Option7_p());
                break;
            case 45 :
                getSpinners().get(28).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(28).setSelection(item.getGo_Option7_p());
                break;
            case 46 :
                getSpinners().get(29).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(29).setSelection(item.getGo_Option7_p());
                break;
            case 47 :
                getSpinners().get(30).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(30).setSelection(item.getGo_Option7_p());
                break;
            case 48 :
                getSpinners().get(31).setVisibility(View.VISIBLE);
                if(bool) getSpinners().get(31).setSelection(item.getGo_Option7_p());
                break;
        }
    }

    public LinkedList<TextView> getBtns1() {
        return btns1;
    }

    public LinkedList<TextView> getBtns2() {
        return btns2;
    }

    public LinkedList<TextView> getBtns3() {
        return btns3;
    }

    public LinkedList<TextView> getBtns4() {
        return btns4;
    }

    public LinkedList<View> getLines() {
        return lines;
    }

    public LinkedList<ImageButton> getBridges() {
        return bridges;
    }

    public Map<Integer, TextView> getBtnsArray() {
        return btnsArray;
    }

    public Map<TextView, Integer> getBtnsArray2() {
        return btnsArray2;
    }

    public List<Spinner> getSpinners() {
        return spinners;
    }

    public boolean isBtns1b() {
        return btns1b;
    }

    public boolean isBtns2b() {
        return btns2b;
    }

    public boolean isBtns3b() {
        return btns3b;
    }

    public boolean isBtns4b() {
        return btns4b;
    }

    public List<Boolean> getBtnsBArray() {
        return btnsBArray;
    }

    public List<TextView> getSelectedCircle() {
        return selectedCircle;
    }

    public void setSelectedCircle(List<TextView> selectedCircle) {
        this.selectedCircle = selectedCircle;
    }

    public List<GigongOptionDTO> getSelectedDTO() {
        return selectedDTO;
    }

    public void setSelectedDTO(List<GigongOptionDTO> selectedDTO) {
        this.selectedDTO = selectedDTO;
    }

    public Drawable getCircleChoice() {
        return circleChoice;
    }

    public Drawable getCircle() {
        return circle;
    }

    public Drawable getBridgeCircle() {
        return bridgeCircle;
    }

    public Drawable getBridgeNullCircle() {
        return bridgeNullCircle;
    }
}
