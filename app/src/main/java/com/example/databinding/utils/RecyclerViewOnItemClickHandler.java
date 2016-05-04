package com.example.databinding.utils;

import android.view.View;

import com.example.databinding.ui.RecyclerViewFragment;

/**
 * Created by NAGARAJ on 5/4/2016.
 */
public class RecyclerViewOnItemClickHandler<T> {

    private T item;
    private Constants.Listener listener;
    private int position;

    public RecyclerViewOnItemClickHandler(T item, int position, Constants.Listener listener) {
        this.item = item;
        this.position = position;
        this.listener = listener;
    }

    public void onClick(View view) {
        listener.onItemClick(item, view, position);

    }
}
