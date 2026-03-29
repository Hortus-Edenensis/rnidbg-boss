package com.heytap.msp.ipc.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6375a;
    private String b;
    private Bundle c;
    private String d;
    private Parcelable e;
    private int f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f6376a;
        private String b;
        private Bundle c;
        private String d;
        private Parcelable e;
        private int f;

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(Context context) {
            this.f6376a = context;
            return this;
        }

        public a a(Bundle bundle) {
            this.c = bundle;
            return this;
        }

        public a a(Parcelable parcelable) {
            this.e = parcelable;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public c a() {
            return new c(this.f6376a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public c(Context context, String str, Bundle bundle, String str2, Parcelable parcelable, int i) {
        this.f6375a = context;
        this.b = str;
        this.c = bundle;
        this.d = str2;
        this.e = parcelable;
        this.f = i;
    }

    public Context a() {
        return this.f6375a;
    }

    public String b() {
        return this.d;
    }

    public Parcelable c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }
}
