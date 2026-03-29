package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class Car implements Parcelable {
    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() { // from class: com.zenmen.palmchat.contacts.bean.Car.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Car createFromParcel(Parcel parcel) {
            return new Car(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Car[] newArray(int i) {
            return new Car[i];
        }
    };
    public int car;

    public Car(Parcel parcel) {
        this.car = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.car);
    }
}
