package com.onedaydent.gigongrequest.ui.gigongrequest;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.onedaydent.gigongrequest.data.model.GigongOptionDTO;

public class GigongRequestBridgeController implements View.OnClickListener {

    private static String TAG = GigongRequestBridgeController.class.getSimpleName();

    private GigongRequestPage3ViewModel model = null;
    private Drawable bridgeCircle = null;
    private Drawable bridgeNullCircle = null;

    public GigongRequestBridgeController(GigongRequestPage3ViewModel model, Drawable bridgeCircle, Drawable bridgeNullCircle) {
        super();
        this.model = model;
        this.bridgeCircle = bridgeCircle;
        this.bridgeNullCircle = bridgeNullCircle;
    }

    @Override
    public void onClick(View view) {
        for(GigongOptionDTO item : model.getItems()){
            if(item.getBridge() != null && item.getBridge().getId() == view.getId()){
                if(item.getGo_isBridge() == 1){
                    item.getBridge().setBackgroundDrawable(bridgeNullCircle);
                    item.getLine().setVisibility(View.VISIBLE);
                    item.setGo_isBridge(0);
                }else{
                    item.getBridge().setBackgroundDrawable(bridgeCircle);
                    item.getLine().setVisibility(View.INVISIBLE);
                    item.setGo_isBridge(1);
                }
            }
            if(item.getBridge2() != null && item.getBridge2().getId() == view.getId()){
                if(item.getGo_isBridge2() == 1){
                    item.getBridge2().setBackgroundDrawable(bridgeNullCircle);
                    item.getLine2().setVisibility(View.VISIBLE);
                    item.setGo_isBridge2(0);
                }else{
                    item.getBridge2().setBackgroundDrawable(bridgeCircle);
                    item.getLine2().setVisibility(View.INVISIBLE);
                    item.setGo_isBridge2(1);
                }
            }
        }
    }
}