package com.example.databinding.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by NAGARAJ on 5/3/2016.
 */
public class BindingUtils {

    @BindingAdapter(value = {"android:src", "placeHolder"}, requireAll = false)
    public static void bindImage(ImageView view, String url, Drawable placeHolder) {
        RequestCreator requestCreator =
                Picasso.with(view.getContext()).load(url);
        if (placeHolder != null) {
            requestCreator.placeholder(placeHolder);
        }
        requestCreator.into(view);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext()).load(imageUrl).into(view);
    }
}
