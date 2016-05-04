package com.example.databinding.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.databinding.R;
import com.example.databinding.databinding.FragmentObservableFieldBinding;
import com.example.databinding.model.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObservableFieldFragment extends Fragment {


    private FragmentObservableFieldBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_observable_field, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Person person = new Person("Nagaraj", "Wadakannavar", 26);
        binding.setPerson(person);
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) getView().findViewById(R.id.edit_text);
                person.lastName.set(editText.getText().toString());

            }
        });
    }
}
