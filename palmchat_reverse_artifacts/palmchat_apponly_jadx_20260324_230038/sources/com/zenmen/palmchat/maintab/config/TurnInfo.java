package com.zenmen.palmchat.maintab.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TurnInfo implements Parcelable {
    public static final Parcelable.Creator<TurnInfo> CREATOR = new a();
    public static final String TYPE_DEEP_LINK = "deeplink";
    public static final String TYPE_NATIVE = "native";
    public boolean showMenu;
    public String type;
    public String url;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<TurnInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TurnInfo createFromParcel(Parcel parcel) {
            return new TurnInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TurnInfo[] newArray(int i) {
            return new TurnInfo[i];
        }
    }

    public TurnInfo() {
        this(TYPE_NATIVE, null, false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeString(this.url);
        parcel.writeInt(this.showMenu ? 1 : 0);
    }

    public TurnInfo(String str, String str2) {
        this(str, str2, false);
    }

    public TurnInfo(String str, String str2, boolean z) {
        this.type = str;
        this.url = str2;
        this.showMenu = z;
    }

    public TurnInfo(Parcel parcel) {
        this.type = parcel.readString();
        this.url = parcel.readString();
        this.showMenu = parcel.readInt() == 1;
    }
}
