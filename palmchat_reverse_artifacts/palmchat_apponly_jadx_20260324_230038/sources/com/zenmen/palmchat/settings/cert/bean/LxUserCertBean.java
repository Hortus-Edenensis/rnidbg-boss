package com.zenmen.palmchat.settings.cert.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class LxUserCertBean implements Parcelable {
    public static final Parcelable.Creator<LxUserCertBean> CREATOR = new a();
    public int certCode;
    public boolean continueFlag;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<LxUserCertBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LxUserCertBean createFromParcel(Parcel parcel) {
            return new LxUserCertBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LxUserCertBean[] newArray(int i) {
            return new LxUserCertBean[i];
        }
    }

    public LxUserCertBean() {
        this.certCode = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.certCode);
        parcel.writeByte(this.continueFlag ? (byte) 1 : (byte) 0);
    }

    public LxUserCertBean(Parcel parcel) {
        this.certCode = -1;
        this.certCode = parcel.readInt();
        this.continueFlag = parcel.readByte() != 0;
    }
}
