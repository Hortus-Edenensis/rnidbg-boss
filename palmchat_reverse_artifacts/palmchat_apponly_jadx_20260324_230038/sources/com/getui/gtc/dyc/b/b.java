package com.getui.gtc.dyc.b;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.getui.gtc.dyc.b.b.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final b[] newArray(int i) {
            return new b[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5752a = "sdkconfig";
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private long i;
    private c j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5753a;
        private String b;
        private String c;
        private String e;
        private String f;
        private c h;
        private String d = b.f5752a;
        private long g = com.heytap.mcssdk.constant.a.g;

        public a a(String str) {
            this.f5753a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a e(String str) {
            this.d = str;
            return this;
        }

        public a f(String str) {
            this.f = str;
            return this;
        }

        public a g(long j) {
            this.g = j;
            return this;
        }

        public a h(c cVar) {
            this.h = cVar;
            return this;
        }

        public b i() {
            return new b(this);
        }
    }

    public b(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.h = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.e = parcel.readString();
        this.i = parcel.readLong();
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public long h() {
        return this.i;
    }

    public c i() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.h);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.e);
        parcel.writeLong(this.i);
    }

    private b(a aVar) {
        this.b = aVar.f5753a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.h = aVar.f;
        this.i = aVar.g;
        this.j = aVar.h;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.g = str;
    }

    public void g(String str) {
        this.h = str;
    }

    public void h(long j) {
        this.i = j;
    }

    public void i(c cVar) {
        this.j = cVar;
    }
}
