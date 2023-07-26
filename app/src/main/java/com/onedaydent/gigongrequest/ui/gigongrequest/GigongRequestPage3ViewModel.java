package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.WindowManager;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onedaydent.gigongrequest.R;
import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;
import com.onedaydent.gigongrequest.databinding.FragmentGigongrequest3Binding;
import com.onedaydent.gigongrequest.databinding.OptionLayoutBinding;
import com.onedaydent.gigongrequest.utils.COLORENUM;
import com.onedaydent.gigongrequest.utils.COMPONENTENUM;
import com.onedaydent.gigongrequest.utils.OPTIONENUM;
import com.onedaydent.gigongrequest.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GigongRequestPage3ViewModel extends ViewModel implements View.OnClickListener{

    private static String TAG = GigongRequestPage3ViewModel.class.getSimpleName();
    private Context mContext = null;
    private List<GigongOptionDTO> items = new ArrayList<GigongOptionDTO>();
    private MutableLiveData<List<GigongOptionDTO>> temps2 = new MutableLiveData<>();
    private List<GigongOptionDTO> temps = null;

    private Dialog dialog = null;
    private OptionLayoutBinding bindingOption = null;

    // 처음저장
    private boolean isFirstSave = true;
    private COLORENUM colorEnum;
    private OPTIONENUM optionEnum;
    private COMPONENTENUM componentEnum;
    private GigongOptionDTO copyOriginal = null;
    private FragmentGigongrequest3Binding binding = null;
    private GigongRequestFragmentPage3 page3 = null;

    public GigongRequestPage3ViewModel() {}

    public void Init(Context mContext, Activity activity, GigongRequestFragmentPage3 page3, FragmentGigongrequest3Binding binding, View.OnClickListener listener, View.OnLongClickListener longClickListener) {
        this.mContext = mContext;
        this.binding = binding;
        this.page3 = page3;
        this.colorEnum = new COLORENUM(mContext);
        this.optionEnum = new OPTIONENUM(mContext);

        this.bindingOption = OptionLayoutBinding.inflate(LayoutInflater.from(mContext));
        this.componentEnum = new COMPONENTENUM(mContext, binding, listener, longClickListener, bindingOption,this);
        bindingOption.requestOption.setAdapter(optionEnum.getAtemp());
        bindingOption.requestOption1.setAdapter(optionEnum.getAtemp1());
        bindingOption.requestOption2.setAdapter(optionEnum.getAtemp2());
        bindingOption.requestOption3.setAdapter(optionEnum.getAtemp3());
        bindingOption.requestOption4.setAdapter(optionEnum.getAtemp4());
        bindingOption.requestOption5.setAdapter(optionEnum.getAtemp5());
        bindingOption.requestOption6.setAdapter(optionEnum.getAtemp6());
        bindingOption.requestOption3.setSelection(1);
        bindingOption.requestClose.setOnClickListener(this::onClick);
        bindingOption.requestReset.setOnClickListener(this::onClick);
        bindingOption.requestSave.setOnClickListener(this::onClick);
        dialog = new Dialog(mContext);
        dialog.setContentView(bindingOption.getRoot());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(layoutParams);
        componentEnum.setBriges();
    }

    public void select(int i, boolean isPontic, int touch){
        GigongOptionDTO item = items.get(i);
        // 값이 입력 되어 있지 않는 경우
        if(touch == 0){
            if(isPontic) {
                item.setPontic();
                componentEnum.setBriges();
                componentEnum.getSelectedDTO().removeIf(temp -> temp.getGo_ToothNumber() == item.getGo_ToothNumber());
                componentEnum.getSelectedCircle().removeIf(temp -> temp.getId() == item.getCircle().getId());
            }
            else{
                if(item.getGo_Option() == 0){
                    if(!item.isSelected()){
                        item.getCircle().setBackground(componentEnum.getCircleChoice());
                        componentEnum.getSelectedCircle().add(componentEnum.getBtnsArray().get(i));
                        componentEnum.getSelectedDTO().add(item);
                        item.setSelected(true);
                    }else{
                        item.getCircle().setBackground(componentEnum.getCircle());
                        componentEnum.getSelectedCircle().remove(componentEnum.getBtnsArray().get(i));
                        componentEnum.getSelectedDTO().remove(item);
                        item.setSelected(false);
                    }
                    // 값이 입력되어 있는 경우 옵션 데이터 불러와서 내용 보여주기
                }else componentEnum.openSelectedMenu(item);
            }
        }else if(touch == 1){
            item.getCircle().setBackground(componentEnum.getCircleChoice());
            componentEnum.getSelectedCircle().add(componentEnum.getBtnsArray().get(i));
            componentEnum.getSelectedDTO().add(item);
            item.setSelected(true);
        }
    }

    public void setCopy(int i){
        GigongOptionDTO item = items.get(i);
        if(copyOriginal != null){
            item.setCopy(copyOriginal);
            item.getCircle().setBackground(colorEnum.getCOLORENUM().get(copyOriginal.getGo_Option()));
            componentEnum.setBriges();
        }
    }

    public void resetItem(int i){
        GigongOptionDTO item = items.get(i);
        if(item.getGo_Option() == 0) Utils.getMessageShort("입력된 옵션이 없습니다.");
        else {
            item.getCircle().setBackground(colorEnum.getCOLORENUM().get(0));
            item.getCircle().setText(item.getGo_ToothNumber() % 10 + "");
            item.setGo_Option(0);
            item.reset(componentEnum.getBridgeCircle());
            componentEnum.setBriges();
            componentEnum.blockReset();
            isFirstSave = true;
        }
    }

    public void openMenu(int i){
        GigongOptionDTO item = items.get(i);
        if(item.getGo_Option() == 0) {
            Utils.getMessageShort("입력된 옵션이 없습니다.");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) page3.setCopy3(false);
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) page3.setCopy3(true);
            binding.request3Copyshow.setVisibility(View.VISIBLE);
            copyOriginal = item.clone();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.request_close:
                componentEnum.blockReset();
                getDialog().dismiss();
                break;
            case R.id.request_reset:
                componentEnum.blockReset();
                if(!isFirstSave) componentEnum.choiceSpinner(temps.get(0), false);
                componentEnum.setBriges();
                break;
            case R.id.request_save:
                if(bindingOption.requestOption.getSelectedItemPosition() == 0 && isFirstSave) Utils.getMessageShort("의뢰내용을 선택해주세요.");
                else{
                    temps.forEach(item -> item.setGo_Option(bindingOption.requestOption.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option1(bindingOption.requestOption1.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option2(bindingOption.requestOption2.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option3(bindingOption.requestOption3.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option4(bindingOption.requestOption4.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option5(bindingOption.requestOption5.getSelectedItemPosition()));
                    temps.forEach(item -> item.setGo_Option6(bindingOption.requestOption6.getSelectedItemPosition()));
                    for (int i = 0;i < items.size();i++) {
                        for (GigongOptionDTO temp : temps) {
                            if (items.get(i).getGo_ToothNumber() == temp.getGo_ToothNumber()) {
                                items.get(i).getCircle().setBackground(colorEnum.getCOLORENUM().get(bindingOption.requestOption.getSelectedItemPosition()));
                                items.get(i).getCircle().setText(items.get(i).getGo_ToothNumber() % 10 + "");
                                if(bindingOption.requestOption.getSelectedItemPosition() == 0) items.get(i).reset(componentEnum.getBridgeCircle());
                                else if(bindingOption.requestOption.getSelectedItemPosition() == 4) {
                                    items.get(i).getCircle().setText("x");
                                    items.set(i, temp.clone());
                                }
                                else items.set(i, temp.clone());
                                break;
                            }
                        }
                    }
                    componentEnum.setBriges();
                    componentEnum.blockReset();
                    componentEnum.setSelectedCircle(new ArrayList<TextView>());
                    componentEnum.setSelectedDTO(new ArrayList<GigongOptionDTO>());
                    isFirstSave = true;
                    getDialog().dismiss();
                }
                break;
        }
    }

    public COMPONENTENUM getComponentEnum() {
        return componentEnum;
    }
    public Dialog getDialog() {
        return dialog;
    }
    public List<GigongOptionDTO> getItems() {
        return items;
    }
    public List<GigongOptionDTO> getTemps() {
        return temps;
    }
    public void setTemps(List<GigongOptionDTO> temps) {
        this.temps = temps;
    }
    public MutableLiveData<List<GigongOptionDTO>> getTemps2() {
        return temps2;
    }
    public void setFirstSave(boolean firstSave) {
        isFirstSave = firstSave;
    }
    public boolean isFirstSave() {
        return isFirstSave;
    }
    public OPTIONENUM getOptionEnum() {
        return optionEnum;
    }
    public COLORENUM getColorEnum() {
        return colorEnum;
    }
    public GigongOptionDTO getCopyOriginal() {
        return copyOriginal;
    }
    public void setCopyOriginal(GigongOptionDTO copyOriginal) {
        this.copyOriginal = copyOriginal;
    }
}