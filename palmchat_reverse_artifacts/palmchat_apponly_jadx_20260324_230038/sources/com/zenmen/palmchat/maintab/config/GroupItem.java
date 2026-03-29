package com.zenmen.palmchat.maintab.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import defpackage.k86;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GroupItem implements Parcelable {
    public static final Parcelable.Creator<GroupItem> CREATOR = new a();
    public static final String TAG_RECENT_USE = "recent_used";
    public static final String TAG_VIP = "vip_group";
    public static final int TYPE_NORMAL = 2;
    public static final int TYPE_TOP = 0;
    public static final int TYPE_TOP2 = 1;
    public static final int TYPE_TOP3 = 3;
    public static final int TYPE_TOP4 = 4;
    public static final int TYPE_TOP5 = 5;
    public static final int TYPE_TOP_GRID_GROUP = 8;
    public String KitCode;
    public boolean ignorePadding = false;
    public List<CellItem> items;
    public String name;
    public String nameEn;
    public int styleType;
    public String tag;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GroupItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupItem createFromParcel(Parcel parcel) {
            return new GroupItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupItem[] newArray(int i) {
            return new GroupItem[i];
        }
    }

    public GroupItem(int i, String str, String str2, String str3, List<CellItem> list) {
        this.styleType = i;
        this.name = str;
        this.nameEn = str2;
        this.KitCode = str3;
        this.items = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNameForShow() {
        return k86.G() ? this.name : this.nameEn;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.styleType);
        parcel.writeString(this.name);
        parcel.writeString(this.nameEn);
        parcel.writeString(this.KitCode);
        parcel.writeString(this.tag);
        parcel.writeTypedList(this.items);
    }

    public GroupItem(Parcel parcel) {
        this.styleType = parcel.readInt();
        this.name = parcel.readString();
        this.nameEn = parcel.readString();
        this.KitCode = parcel.readString();
        this.tag = parcel.readString();
        this.items = parcel.createTypedArrayList(CellItem.CREATOR);
    }
}
