package com.opos.mobad.provider.openId;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OutOpenIdWrapper extends OpenIdData {
    public static final Parcelable.Creator<OutOpenIdWrapper> CREATOR = new Parcelable.Creator<OutOpenIdWrapper>() { // from class: com.opos.mobad.provider.openId.OutOpenIdWrapper.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OutOpenIdWrapper createFromParcel(Parcel parcel) {
            return new OutOpenIdWrapper(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public OutOpenIdWrapper[] newArray(int i) {
            return new OutOpenIdWrapper[i];
        }
    };
    public int e;
    public String f;
    public String g;
    public String h;

    public OutOpenIdWrapper(int i) {
        super(i);
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    @Override // com.opos.mobad.provider.openId.OpenIdData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.opos.mobad.provider.openId.OpenIdData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TextUtils.isEmpty(this.f9166a) ? "" : this.f9166a);
        parcel.writeString(TextUtils.isEmpty(this.b) ? "" : this.b);
        parcel.writeString(TextUtils.isEmpty(this.c) ? "" : this.c);
        parcel.writeInt(this.e);
    }

    public OutOpenIdWrapper(String str, String str2, String str3, int i) {
        super(str, str2, str3);
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = i;
    }

    public void a(int i) {
        this.e = i;
    }
}
