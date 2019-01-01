package com.databinding.android.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * <p>
 * BaseActivity contains some modifications to the native AppCompatActivity.
 * Mainly, it use ButterKnife for view binding and it automatically check if
 * toolbar exists.
 * </p>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        dataBind();
        initControl();
        initView();
        setListener();
    }

    /**
     * Sets full screen.
     *
     * @return the full screen
     */
    protected abstract boolean setFullScreen();

    /**
     * Data bind.
     */
    protected abstract void dataBind();

    /**
     * Init control.
     */
    protected abstract void initControl();

    /**
     * Init view.
     */
    protected abstract void initView();

    /**
     * Sets listener.
     */
    protected abstract void setListener();

}