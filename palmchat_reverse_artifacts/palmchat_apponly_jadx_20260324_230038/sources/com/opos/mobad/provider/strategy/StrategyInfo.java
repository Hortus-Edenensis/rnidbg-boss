package com.opos.mobad.provider.strategy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StrategyInfo implements Parcelable {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new Parcelable.Creator<StrategyInfo>() { // from class: com.opos.mobad.provider.strategy.StrategyInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyInfo createFromParcel(Parcel parcel) {
            return new StrategyInfo(parcel.readLong(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyInfo[] newArray(int i) {
            return new StrategyInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9178a;
    public final Bundle b;

    public StrategyInfo(long j, Bundle bundle) {
        this.f9178a = j;
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9178a);
        parcel.writeBundle(this.b);
    }
}
