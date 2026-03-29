package com.opos.mobad.provider.statistic;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StatisticModelIdentify implements IBridgeTargetIdentify {
    public static final Parcelable.Creator<StatisticModelIdentify> CREATOR = new Parcelable.Creator<StatisticModelIdentify>() { // from class: com.opos.mobad.provider.statistic.StatisticModelIdentify.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatisticModelIdentify createFromParcel(Parcel parcel) {
            return new StatisticModelIdentify(parcel.readString(), parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatisticModelIdentify[] newArray(int i) {
            return new StatisticModelIdentify[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9175a;
    public final String b;
    public final String c;

    public StatisticModelIdentify(String str, boolean z, String str2) {
        this.c = str;
        this.f9175a = z;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeInt(this.f9175a ? 1 : 0);
        parcel.writeString(this.b);
    }
}
