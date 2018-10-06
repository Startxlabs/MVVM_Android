package com.startxlabs.mvvm.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseModel implements Parcelable {

    private BaseStatus status;

    private BaseError baseError;

    private BaseException baseException;


    protected BaseModel(Parcel in) {
        status = in.readParcelable(BaseStatus.class.getClassLoader());
        baseError = in.readParcelable(BaseError.class.getClassLoader());
        baseException = in.readParcelable(BaseException.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(status, flags);
        dest.writeParcelable(baseError, flags);
        dest.writeParcelable(baseException, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

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
}
