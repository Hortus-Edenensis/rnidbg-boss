package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class IdModelIdentify implements IBridgeTargetIdentify {
    public static final Parcelable.Creator<IdModelIdentify> CREATOR = new Parcelable.Creator<IdModelIdentify>() { // from class: com.opos.mobad.provider.openId.IdModelIdentify.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IdModelIdentify createFromParcel(Parcel parcel) {
            return new IdModelIdentify(parcel.readInt() == 1, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IdModelIdentify[] newArray(int i) {
            return new IdModelIdentify[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9165a;
    public final String b;

    public IdModelIdentify(boolean z, String str) {
        this.f9165a = z;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9165a ? 1 : 0);
        parcel.writeString(this.b);
    }
}
