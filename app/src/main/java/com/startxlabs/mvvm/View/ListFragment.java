package com.startxlabs.mvvm.View;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.R;
import com.startxlabs.mvvm.ViewModel.CustomListViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public static final String TAG = ListFragment.class.getName();

    private RecyclerView rvList;
    private CustomAdapter mCustomAdapter;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCustomAdapter = new CustomAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvList = view.findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(mCustomAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CustomListViewModel customListViewModel = ViewModelProviders.of(this).get(CustomListViewModel.class);
        observeViewModel(customListViewModel);
    }

    private void observeViewModel(CustomListViewModel viewModel) {

        // Update the list when the data changes

        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {

            @Override

            public void onChanged(@Nullable List<Project> projects) {

                if (projects != null) {

                    //…

                    mCustomAdapter.setProjectList(projects);
                    mCustomAdapter.notifyDataSetChanged();

                }

            }

        });

    }
}
