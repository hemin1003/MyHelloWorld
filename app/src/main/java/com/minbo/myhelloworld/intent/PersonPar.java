package com.minbo.myhelloworld.intent;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonPar implements Parcelable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //序列化实体类
    public static final Parcelable.Creator<PersonPar> CREATOR = new Creator<PersonPar>() {
        @Override
        public PersonPar createFromParcel(Parcel source) {
            PersonPar person = new PersonPar();
            person.name = source.readString();
            person.age = source.readInt();
            return person;
        }

        @Override
        public PersonPar[] newArray(int size) {
            return new PersonPar[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //将实体类数据写入Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

}
