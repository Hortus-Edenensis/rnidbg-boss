package com.zenmen.palmchat.contacts.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import defpackage.az2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class Amulet implements Parcelable {
    public static final Parcelable.Creator<Amulet> CREATOR = new Parcelable.Creator<Amulet>() { // from class: com.zenmen.palmchat.contacts.bean.Amulet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Amulet createFromParcel(Parcel parcel) {
            return new Amulet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Amulet[] newArray(int i) {
            return new Amulet[i];
        }
    };
    public static final int TYPE_PNG = 1;
    public static final int TYPE_SVGA = 2;
    public String itemId;
    public String ornamentId;
    public int type;
    public String url;

    public Amulet(int i, String str) {
        this.type = i;
        this.url = str;
    }

    public static Amulet buildFromUserExt(String str) {
        ContactExtBean contactExtBean;
        if (TextUtils.isEmpty(str) || (contactExtBean = (ContactExtBean) az2.a(str, ContactExtBean.class)) == null) {
            return null;
        }
        return contactExtBean.getAmulet();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Amulet)) {
            return super.equals(obj);
        }
        Amulet amulet = (Amulet) obj;
        String str = this.url;
        return str != null && str.equals(amulet.url);
    }

    public boolean isOk() {
        int i = this.type;
        return i == 1 || i == 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
        parcel.writeString(this.ornamentId);
        parcel.writeString(this.itemId);
    }

    public Amulet(Parcel parcel) {
        this.type = parcel.readInt();
        this.url = parcel.readString();
        this.ornamentId = parcel.readString();
        this.itemId = parcel.readString();
    }
}
