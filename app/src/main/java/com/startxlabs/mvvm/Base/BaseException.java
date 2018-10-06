package com.startxlabs.mvvm.Base;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseException implements Parcelable {

    private Exception exception;

    private String message;

    private String code;

    protected BaseException(Parcel in) {
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

    public static final Creator<BaseException> CREATOR = new Creator<BaseException>() {
        @Override
        public BaseException createFromParcel(Parcel in) {
            return new BaseException(in);
        }

        @Override
        public BaseException[] newArray(int size) {
            return new BaseException[size];
        }
    };

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
