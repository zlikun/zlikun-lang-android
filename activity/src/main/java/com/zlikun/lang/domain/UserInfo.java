package com.zlikun.lang.domain;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;

import java.util.Date;

/**
 * 创建一个值对象，用于Activity间对象类型参数传递
 * Created by zlikun on 2017/6/13.
 */

public class UserInfo implements Parcelable {

    private String name ;
    private String mobile ;
    private Date birthday ;

    public UserInfo(String name, String mobile, Date birthday) {
        this.name = name;
        this.mobile = mobile;
        this.birthday = birthday;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        // 方法 I ，需要按属性声明顺序写入
//        dest.writeString(getName());
//        dest.writeString(getMobile());
//        dest.writeSerializable(getBirthday());
        // 方法 II
        Bundle bundle = new Bundle() ;
        bundle.putString("name" ,getName());
        bundle.putString("mobile" ,getMobile());
        bundle.putSerializable("birthday" ,getBirthday());
        dest.writeBundle(bundle);
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            // 方法 I ，需要按写入顺序读取
//            return new UserInfo(in.readString() ,in.readString() , (Date) in.readSerializable());
            // 方法 II
            Bundle bundle = in.readBundle() ;
            return new UserInfo(bundle.getString("name") ,bundle.getString("mobile") ,(Date) bundle.getSerializable("birthday")) ;
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    @Override
    public String toString() {
        return String.format("userInfo : name = %s ,mobile = %s ,birthday = %s"
                ,name ,mobile , DateFormat.format("yyyy/MM/dd HH:mm:ss" ,birthday)) ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
