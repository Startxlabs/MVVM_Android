package com.startxlabs.mvvm.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseError implements Parcelable {

    private String message;

    private String code;

    protected BaseError(Parcel in) {
        message = in.readString();
        code = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(code);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseError> CREATOR = new Creator<BaseError>() {
        @Override
        public BaseError createFromParcel(Parcel in) {
            return new BaseError(in);
        }

        @Override
        public BaseError[] newArray(int size) {
            return new BaseError[size];
        }
    };
}
