package com.onedaydent.gigongrequest.ui.gigonglist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GigongListViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GigongListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}