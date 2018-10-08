package com.startxlabs.mvvm.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.startxlabs.mvvm.Model.Base.BaseModel;

import java.util.List;

public class ProjectRes extends BaseModel<ProjectRes> implements Parcelable {

    public static final Creator<ProjectRes> CREATOR = new Creator<ProjectRes>() {
        @Override
        public ProjectRes createFromParcel(Parcel in) {
            return new ProjectRes(in);
        }

        @Override
        public ProjectRes[] newArray(int size) {
            return new ProjectRes[size];
        }
    };
    @SerializedName("data")
    @Expose
    private List<Project> projectList;

    public ProjectRes() {
    }

    protected ProjectRes(Parcel in) {
        super(in);
        projectList = in.createTypedArrayList(Project.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(projectList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
