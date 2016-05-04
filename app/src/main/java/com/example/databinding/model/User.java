package com.example.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.databinding.BR;


/**
 * Created by NAGARAJ on 5/3/2016.
 */
public class User extends BaseObservable {

    private String firstName;
    private String lastName;
    public String imageUrl;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        imageUrl = "http://fillmurray.com/400/400";
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
