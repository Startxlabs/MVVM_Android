package com.startxlabs.mvvm.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.startxlabs.mvvm.Model.ProjectRes;
import com.startxlabs.mvvm.R;
import com.startxlabs.mvvm.Repository.Retrofit.ApiClient;
import com.startxlabs.mvvm.Repository.Room.AppDatabaseClient;
import com.startxlabs.mvvm.Utility.Utility;
import com.startxlabs.mvvm.ViewModel.CustomListViewModel;
import com.startxlabs.mvvm.ViewModel.CustomListViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public static final String TAG = ListFragment.class.getName();

    private RecyclerView rvList;
    private CustomAdapter mCustomAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private CustomListViewModelFactory customListViewModelFactory;
    private CustomListViewModel customListViewModel;

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
        swipeRefreshLayout = view.findViewById(R.id.srl);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(mCustomAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setViewModel(true);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setViewModel(false);

    }

    private void setViewModel(boolean refresh) {
        customListViewModelFactory = new CustomListViewModelFactory(AppDatabaseClient.getInstance().getAppDatabase(getActivity())
                , ApiClient.getInstance()
                , "Google");

        customListViewModel = ViewModelProviders
                .of(this, customListViewModelFactory)
                .get(CustomListViewModel.class);

        if (refresh)
            customListViewModel.clearObservableLiveData();
        else {
            if (customListViewModel.getProjectList2Observable().getValue() != null && !customListViewModel.getProjectList2Observable().getValue().isFine())
                customListViewModel.clearObservableLiveData();
        }

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
                swipeRefreshLayout.setRefreshing(false);
                if (projectRes != null)
                    if (projectRes.isFine()) {
                        mCustomAdapter.setProjectList(projectRes.getProjectList());
                        mCustomAdapter.notifyDataSetChanged();
                    } else {
                        //TODO(Handling Different Errors centrally)
                        if (projectRes.getBaseException() != null) {
                            showErrorSnackbar("Exception Occurred");
                        } else if (projectRes.getBaseError() != null)
                            showErrorSnackbar("Error Occurred");
                        else
                            showErrorSnackbar("Unknown Error Occurred");
                    }

            }

        });


    }


    private void showErrorSnackbar(String string) {
        Utility.makeSnackbar(getView(), string)
                .setAction(string, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setViewModel(false);
                    }
                }).show();
    }
}
