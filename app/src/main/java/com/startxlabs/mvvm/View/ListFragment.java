package com.startxlabs.mvvm.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.startxlabs.mvvm.Model.ProjectRes;
import com.startxlabs.mvvm.R;
import com.startxlabs.mvvm.Repository.Retrofit.ApiClient;
import com.startxlabs.mvvm.Repository.Room.AppDatabaseClient;
import com.startxlabs.mvvm.ViewModel.CustomListViewModel;
import com.startxlabs.mvvm.ViewModel.CustomListViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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

        CustomListViewModelFactory customListViewModelFactory =
                new CustomListViewModelFactory(AppDatabaseClient.getInstance().getAppDatabase(getActivity())
                        , ApiClient.getInstance()
                        , "Google");
        CustomListViewModel customListViewModel = ViewModelProviders
                .of(this, customListViewModelFactory)
                .get(CustomListViewModel.class);

//        CustomListViewModel customListViewModel = ViewModelProviders.of(this).get(CustomListViewModel.class);
        observeViewModel(customListViewModel);
    }

    private void observeViewModel(CustomListViewModel viewModel) {

        // Update the list when the data changes

        /*viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {

            @Override

            public void onChanged(@Nullable List<Project> projects) {

                if (projects != null) {
                    mCustomAdapter.setProjectList(projects);
                    mCustomAdapter.notifyDataSetChanged();
                }

            }

        });*/

        viewModel.getProjectList2Observable().observe(this, new Observer<ProjectRes>() {

            @Override

            public void onChanged(@Nullable ProjectRes projectRes) {
                if (projectRes.isFine()) {
                    mCustomAdapter.setProjectList(projectRes.getProjectList());
                    mCustomAdapter.notifyDataSetChanged();
                } else {
                    //TODO(Handling Different Errors centrally)
                    if (projectRes.getBaseException() != null)
                        Toast.makeText(getActivity(), "Handle Exception", Toast.LENGTH_SHORT).show();
                    else if (projectRes.getBaseError() != null)
                        Toast.makeText(getActivity(), "Handle Error", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(), "Handle Unknown Issue", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }
}
