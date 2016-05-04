package com.example.databinding.utils;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.databinding.BR;

/**
 * Created by NAGARAJ on 5/4/2016.
 */
public class RecyclerViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T binding;

    public RecyclerViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }

}
