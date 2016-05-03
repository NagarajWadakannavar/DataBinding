package com.example.databinding.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding.R;
import com.example.databinding.databinding.FragmentSimpleBinding;
import com.example.databinding.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {
private FragmentSimpleBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_simple, container, false);
//        User user = new User("Nagaraj", "Wadakannavar");
//        binding.setUser(user);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        User user = new User("Nagaraj", "Wadakannavar");
        binding.setUser(user);

    }
}
