package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdData extends a implements Parcelable {
    public static final Parcelable.Creator<AdData> CREATOR = new Parcelable.Creator<AdData>() { // from class: com.opos.mobad.model.data.AdData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdData adData = new AdData();
            adData.b(parcel.readInt());
            adData.a(parcel.readString());
            adData.a(parcel.createTypedArrayList(AdItemData.CREATOR));
            adData.a(parcel.readLong());
            adData.c(parcel.readInt());
            adData.e(parcel.readInt());
            adData.e = parcel.readInt();
            adData.d(parcel.readInt());
            adData.a(parcel.readInt() == 1);
            return adData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdData[] newArray(int i) {
            return new AdData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9074a;
    private String b;
    private List<AdItemData> c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public AdData() {
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 1;
    }

    public int a() {
        return this.j;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.f9074a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.b;
    }

    public List<AdItemData> f() {
        return this.c;
    }

    public int g() {
        return this.f;
    }

    public long h() {
        return this.d;
    }

    public String toString() {
        return "AdData{code=" + this.f9074a + ", msg='" + this.b + "', adItemDataList=" + this.c + ", expTime=" + this.d + ", requestInterval=" + this.f + ", dispatchMode=" + this.g + ", gameBoxType=" + this.h + ", customSkip=" + this.i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f9074a);
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.e);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i ? 1 : 0);
    }

    public AdData(int i, String str) {
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = 1;
        this.f9074a = i;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        this.g = i;
    }

    public void a(int i) {
        this.j = i;
    }

    public void b(int i) {
        this.f9074a = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public AdData(int i, String str, int i2, int i3) {
        this.h = 0;
        this.i = false;
        this.j = 1;
        this.f9074a = i;
        this.b = str;
        this.f = i2;
        this.g = i3;
    }

    public void a(long j) {
        this.d = j;
    }

    public boolean b() {
        return this.i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<AdItemData> list) {
        this.c = list;
    }

    public void a(boolean z) {
        this.i = z;
    }
}
