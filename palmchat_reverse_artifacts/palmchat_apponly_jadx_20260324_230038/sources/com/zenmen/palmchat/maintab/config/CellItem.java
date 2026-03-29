package com.zenmen.palmchat.maintab.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import defpackage.k86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CellItem implements Parcelable {
    public static final Parcelable.Creator<CellItem> CREATOR = new a();
    public String appId;
    public String desc;
    public String descEn;
    public String exp;
    public String icon;
    public String inChannel;
    public String invisibleModel;
    public String kitCode;
    public String name;
    public String nameEn;
    public String notInChannel;
    public int noticeGapMinutes;
    public String noticeType;
    public String strikeType;
    public String tag;
    public TurnInfo turnInfo;
    public int versionCode;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<CellItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CellItem createFromParcel(Parcel parcel) {
            return new CellItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CellItem[] newArray(int i) {
            return new CellItem[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String[] f14619a = {"badge", "reddot", "new", "icon", "label", "bubble"};

        public static Boolean[] a(String str) {
            Boolean[] boolArr = new Boolean[f14619a.length];
            int i = 0;
            while (true) {
                String[] strArr = f14619a;
                if (i >= strArr.length) {
                    return boolArr;
                }
                boolArr[i] = Boolean.valueOf(str != null && str.contains(strArr[i]));
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String[] f14620a = {"badge", "icon", "reddot"};

        public static boolean a(String str) {
            return str != null && str.contains("badge");
        }

        public static boolean b(String str) {
            return str != null && str.contains("bubble");
        }

        public static boolean c(String str) {
            return str != null && str.contains("icon");
        }

        public static boolean d(String str) {
            return str != null && str.contains("reddot");
        }
    }

    public CellItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, TurnInfo turnInfo) {
        this.name = str;
        this.nameEn = str2;
        this.icon = str3;
        this.tag = str4;
        this.desc = str5;
        this.descEn = str6;
        this.kitCode = str7;
        this.noticeType = str8;
        this.turnInfo = turnInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescForShow() {
        return k86.G() ? this.desc : this.descEn;
    }

    public String getNameForShow() {
        return k86.G() ? this.name : this.nameEn;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.nameEn);
        parcel.writeString(this.icon);
        parcel.writeString(this.tag);
        parcel.writeString(this.desc);
        parcel.writeString(this.descEn);
        parcel.writeString(this.kitCode);
        parcel.writeString(this.noticeType);
        parcel.writeString(this.strikeType);
        parcel.writeString(this.invisibleModel);
        parcel.writeString(this.appId);
        parcel.writeParcelable(this.turnInfo, i);
    }

    public CellItem(Parcel parcel) {
        this.name = parcel.readString();
        this.nameEn = parcel.readString();
        this.icon = parcel.readString();
        this.tag = parcel.readString();
        this.desc = parcel.readString();
        this.descEn = parcel.readString();
        this.kitCode = parcel.readString();
        this.noticeType = parcel.readString();
        this.strikeType = parcel.readString();
        this.invisibleModel = parcel.readString();
        this.appId = parcel.readString();
        this.turnInfo = (TurnInfo) parcel.readParcelable(TurnInfo.class.getClassLoader());
    }
}
