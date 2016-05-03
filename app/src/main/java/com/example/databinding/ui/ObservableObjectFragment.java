package com.example.databinding.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.databinding.R;
import com.example.databinding.databinding.FragmentObservableObjectBinding;
import com.example.databinding.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObservableObjectFragment extends Fragment {
    private FragmentObservableObjectBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_observable_object, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final User user = new User("Nagaraj", "Wadakannavar");
        binding.setUser(user);
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) getView().findViewById(R.id.edit_text);
                user.setFirstName(editText.getText().toString());

            }
        });
    }
}
