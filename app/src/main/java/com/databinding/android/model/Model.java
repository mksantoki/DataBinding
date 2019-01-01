package com.databinding.android.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.databinding.android.BR;

/**
 * Created by Developer on 1/1/19.
 */
public class Model extends BaseObservable {

    private String name;
    private String url;

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
