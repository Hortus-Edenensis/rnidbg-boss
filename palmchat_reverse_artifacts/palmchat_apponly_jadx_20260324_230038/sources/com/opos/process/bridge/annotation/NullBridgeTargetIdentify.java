package com.opos.process.bridge.annotation;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NullBridgeTargetIdentify {
    public static final Parcelable.Creator<NullBridgeTargetIdentify> CREATOR = new Parcelable.Creator<NullBridgeTargetIdentify>() { // from class: com.opos.process.bridge.annotation.NullBridgeTargetIdentify.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NullBridgeTargetIdentify createFromParcel(Parcel parcel) {
            return new NullBridgeTargetIdentify(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NullBridgeTargetIdentify[] newArray(int i) {
            return new NullBridgeTargetIdentify[i];
        }
    };

    public NullBridgeTargetIdentify(Parcel parcel) {
    }

    public int a() {
        return 0;
    }

    public void a(Parcel parcel, int i) {
    }
}
