package com.startxlabs.mvvm.Model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseStatus implements Parcelable {

    public static final Creator<BaseStatus> CREATOR = new Creator<BaseStatus>() {
        @Override
        public BaseStatus createFromParcel(Parcel in) {
            return new BaseStatus(in);
        }

        @Override
        public BaseStatus[] newArray(int size) {
            return new BaseStatus[size];
        }
    };
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    protected BaseStatus(Parcel in) {
        error = in.readString();
        code = in.readInt();
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(error);
        dest.writeInt(code);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
