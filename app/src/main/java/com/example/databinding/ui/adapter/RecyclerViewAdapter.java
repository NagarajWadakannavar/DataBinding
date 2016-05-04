package com.example.databinding.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.databinding.BR;
import com.example.databinding.R;
import com.example.databinding.databinding.RecyclerViewItemBinding;
import com.example.databinding.model.Questions;
import com.example.databinding.ui.RecyclerViewFragment;
import com.example.databinding.utils.Constants;
import com.example.databinding.utils.RecyclerViewHolder;
import com.example.databinding.utils.RecyclerViewOnItemClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NAGARAJ
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Questions.Question> values = new ArrayList<>();
    private Constants.Listener listener;


    public RecyclerViewAdapter(List<Questions.Question> items, Constants.Listener listener) {
        values = items;
        this.listener = listener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_view_item, parent, false);
        return new RecyclerViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Questions.Question question = values.get(position);
        holder.getBinding().setVariable(BR.clickListener, new RecyclerViewOnItemClickHandler<>(question, position, listener));
        holder.getBinding().setVariable(BR.question, values.get(position));
        holder.getBinding().executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
