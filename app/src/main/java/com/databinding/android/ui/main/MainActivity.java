package com.databinding.android.ui.main;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.databinding.android.R;
import com.databinding.android.databinding.ActivityMainBinding;
import com.databinding.android.model.Model;
import com.databinding.android.ui.base.BaseActivity;

/**
 * The type Main activity.
 */
public class MainActivity extends BaseActivity {

    /**
     * The Binding.
     */
    ActivityMainBinding binding;
    /**
     * The Model.
     */
    Model model;

    @Override
    protected boolean setFullScreen() {
        return false;
    }

    @Override
    protected void dataBind() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initControl() {
        model = new Model();
        model.setName("Maulik Santoki");
        model.setUrl("http://placehold.it/120x120&text=image1");
        binding.setModel(model);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setName(binding.etName.getText().toString());
            }
        });
    }

    /**
     * Image url.
     *
     * @param imageView the image view
     * @param url       the url
     */
    @BindingAdapter("app:imageUrl")
    public static void imageUrl(ImageView imageView, String url) {
      Glide.with(imageView).load(url).into(imageView);
    }
}
