package com.example.databinding.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by NAGARAJ on 5/4/2016.
 */
public class Person {

    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();

    public Person(String firstName,String lastName,int age){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.age.set(age);
    }
}
