package com.startxlabs.mvvm.Model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseModel<T> implements Parcelable {

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };
    private BaseStatus status;
    private BaseError baseError;
    private BaseException baseException;
    private boolean isFine;
    @SerializedName("data")
    @Expose
    private T data;

    protected BaseModel(Parcel in) {
        status = in.readParcelable(BaseStatus.class.getClassLoader());
        baseError = in.readParcelable(BaseError.class.getClassLoader());
        baseException = in.readParcelable(BaseException.class.getClassLoader());
        isFine = in.readByte() != 0;
    }

    public BaseModel() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(status, flags);
        dest.writeParcelable(baseError, flags);
        dest.writeParcelable(baseException, flags);
        dest.writeByte((byte) (isFine ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isFine() {
        return isFine;
    }

    public void setFine(boolean fine) {
        isFine = fine;
    }

    public BaseStatus getStatus() {
        return status;
    }

    public void setStatus(BaseStatus status) {
        this.status = status;
    }

    public BaseError getBaseError() {
        return baseError;
    }

    public void setBaseError(BaseError baseError) {
        this.baseError = baseError;
    }

    public BaseException getBaseException() {
        return baseException;
    }

    public void setBaseException(BaseException baseException) {
        this.baseException = baseException;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
