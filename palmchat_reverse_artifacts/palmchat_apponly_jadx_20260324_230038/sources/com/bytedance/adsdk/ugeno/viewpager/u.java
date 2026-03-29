package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u implements Parcelable {
    private final Parcelable nr;
    public static final u u = new u() { // from class: com.bytedance.adsdk.ugeno.viewpager.u.1
    };
    public static final Parcelable.Creator<u> CREATOR = new Parcelable.ClassLoaderCreator<u>() { // from class: com.bytedance.adsdk.ugeno.viewpager.u.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public u createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return u.u;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public u[] newArray(int i) {
            return new u[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable u() {
        return this.nr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.nr, i);
    }

    private u() {
        this.nr = null;
    }

    public u(Parcelable parcelable) {
        if (parcelable != null) {
            this.nr = parcelable == u ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public u(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.nr = parcelable == null ? u : parcelable;
    }
}
