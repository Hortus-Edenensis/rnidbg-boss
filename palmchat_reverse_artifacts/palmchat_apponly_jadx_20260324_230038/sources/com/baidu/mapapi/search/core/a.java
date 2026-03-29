package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0072a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3771a;
    private int b;

    /* JADX INFO: renamed from: com.baidu.mapapi.search.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0072a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    public a() {
        this.f3771a = -1;
        this.b = -1;
    }

    public int a() {
        return this.f3771a;
    }

    public int b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3771a);
        parcel.writeInt(this.b);
    }

    public void a(int i) {
        this.f3771a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public a(Parcel parcel) {
        this.f3771a = -1;
        this.b = -1;
        this.f3771a = parcel.readInt();
        this.b = parcel.readInt();
    }
}
