package com.opos.mobad.downloader.a;

import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface c {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8766a;
        public final String b;
        public final int c;
        public final int d;
        public final Intent e;
        public final Intent f;
        public final Intent g;

        public a(String str, String str2, int i, int i2, Intent intent, Intent intent2, Intent intent3) {
            this.f8766a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = intent;
            this.f = intent2;
            this.g = intent3;
        }
    }

    void a();

    void a(int i);

    void a(int i, a aVar);
}
