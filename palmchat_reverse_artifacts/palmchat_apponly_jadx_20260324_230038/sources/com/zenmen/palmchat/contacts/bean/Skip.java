package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class Skip implements Parcelable {
    public static final Parcelable.Creator<Skip> CREATOR = new Parcelable.Creator<Skip>() { // from class: com.zenmen.palmchat.contacts.bean.Skip.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Skip createFromParcel(Parcel parcel) {
            return new Skip(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Skip[] newArray(int i) {
            return new Skip[i];
        }
    };
    private boolean enable;
    private String scope;
    private String url;

    public Skip(Parcel parcel) {
        this.enable = parcel.readByte() != 0;
        this.scope = parcel.readString();
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScope() {
        return this.scope;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.enable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.scope);
        parcel.writeString(this.url);
    }
}
