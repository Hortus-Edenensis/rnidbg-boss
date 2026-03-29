package com.opos.cmn.func.dl.base.exception;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DlException extends Exception implements Parcelable {
    public static final Parcelable.Creator<DlException> CREATOR = new Parcelable.Creator<DlException>() { // from class: com.opos.cmn.func.dl.base.exception.DlException.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DlException createFromParcel(Parcel parcel) {
            return new DlException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DlException[] newArray(int i) {
            return new DlException[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7990a;
    private String b;
    private int c;

    public DlException() {
        this.c = -1;
        this.f7990a = 1000;
        this.b = a.a(1000);
    }

    public final int a() {
        return this.f7990a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "DlException{code=" + this.f7990a + ", msg='" + this.b + "', httpCode=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7990a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }

    public DlException(int i) {
        this.c = -1;
        this.f7990a = i;
        this.b = a.a(i);
    }

    public DlException(int i, int i2) {
        this.f7990a = i;
        this.c = i2;
        this.b = a.a(i);
    }

    public DlException(int i, int i2, String str) {
        this.f7990a = i;
        this.c = i2;
        this.b = TextUtils.isEmpty(str) ? a.a(i) : str;
    }

    public DlException(int i, Throwable th) {
        super(th);
        this.c = -1;
        this.f7990a = i;
        this.b = th.getMessage();
    }

    public DlException(int i, Object... objArr) {
        this.c = -1;
        this.f7990a = i;
        this.b = String.format(a.a(i), objArr);
    }

    private DlException(Parcel parcel) {
        this.c = -1;
        this.f7990a = parcel.readInt();
        this.b = parcel.readString();
    }
}
