package com.example.databinding.utils;

import android.view.View;

/**
 * Created by NAGARAJ on 5/4/2016.
 */
public class Constants {
    /**
     * Callback interface for delivering item clicks.
     */
    public interface Listener<T> {
        /**
         * Called when a item is clicked.
         */
        public void onItemClick(T item, View v, int position);
    }
}
