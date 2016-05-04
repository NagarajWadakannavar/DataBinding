package com.example.databinding.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.databinding.R;
import com.example.databinding.api.StackOverflowAPI;
import com.example.databinding.databinding.FragmentRecyclerViewBinding;
import com.example.databinding.model.Questions;
import com.example.databinding.ui.adapter.RecyclerViewAdapter;
import com.example.databinding.utils.Constants;
import com.example.databinding.utils.ServiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p>
 */
public class RecyclerViewFragment extends Fragment implements Constants.Listener<Questions.Question> {


    private StackOverflowAPI api;
    private Call<Questions> call;
    private List<Questions.Question> questionList = new ArrayList<>();

    private FragmentRecyclerViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycler_view, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        api = ServiceGenerator.createService(StackOverflowAPI.class);
        downloadQuestions(api.downloadQuestions());
        binding.recyclerView.setAdapter(new RecyclerViewAdapter(questionList, this));
    }

    private void downloadQuestions(Call<Questions> questionsCall) {
        binding.progressBar.setVisibility(View.VISIBLE);
        questionsCall.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                if (getActivity() == null)
                    return;
                if (response.isSuccessful()) {
                    questionList.addAll(response.body().items);
                    (binding.recyclerView.getAdapter()).notifyDataSetChanged();
                } else {
                    // error response, no access to resource?
                }
                binding.progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {
                if (getActivity() == null)
                    return;
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onItemClick(Questions.Question item, View v, int position) {
        Toast.makeText(getActivity().getApplicationContext(), "Clicked item position is " + position, Toast.LENGTH_SHORT).show();

    }

}
