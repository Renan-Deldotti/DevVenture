package com.teste.marsweather.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.teste.marsweather.R;

public class ImageUtil {

    private static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(10f);
        progressDrawable.setCenterRadius(50f);
        progressDrawable.start();
        return progressDrawable;
    }

    public static void setImageView(ImageView imageView, String photoUrl) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(getProgressDrawable(imageView.getContext()))
                .fitCenter()
                .error(R.drawable.mars_placeholder);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(photoUrl)
                .into(imageView);
    }

    @BindingAdapter("image_url")
    public static void bindingImageSource(View view, String imageUrl) {
        setImageView((ImageView) view, imageUrl);
    }
}
