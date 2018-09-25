package com.startxlabs.mvvm.View;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomProjectViewHolder> {

    private List<Project> projectList = new ArrayList<>();

    @NonNull
    @Override
    public CustomProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomProjectViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_row_item, viewGroup, false));
    }

    public void setProjectList(final List<Project> projectList) {
        if (this.projectList == null || this.projectList.isEmpty()) {
            this.projectList = projectList;
            notifyItemRangeInserted(0, projectList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return CustomAdapter.this.projectList.size();
                }

                @Override
                public int getNewListSize() {
                    return projectList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return CustomAdapter.this.projectList.get(oldItemPosition).getPid() ==
                            projectList.get(newItemPosition).getPid();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Project project = projectList.get(newItemPosition);
                    Project old = projectList.get(oldItemPosition);
                    return project.getPid() == old.getPid()
                            && Objects.equals(project.getGitUrl(), old.getGitUrl());
                }
            });
            this.projectList = projectList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomProjectViewHolder customProjectViewHolder, int i) {

        customProjectViewHolder.tvTitle.setText(projectList.get(i).getFullName());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class CustomProjectViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public CustomProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
