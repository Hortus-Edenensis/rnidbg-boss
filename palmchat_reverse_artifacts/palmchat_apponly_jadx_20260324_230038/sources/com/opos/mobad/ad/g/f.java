package com.opos.mobad.ad.g;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8535a;
    public final String b;
    public final String c;
    public final boolean d;
    public final d e;
    public final boolean f;
    public final e g;
    public final boolean h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f8536a;
        private String b;
        private String c;
        private boolean d;
        private d e;
        private boolean f;
        private Context g;
        private boolean h;
        private boolean i;
        private e j;

        private a() {
            this.f8536a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }

        public a(Context context) {
            this.f8536a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
            if (context != null) {
                this.g = context.getApplicationContext();
            }
        }

        public a a(long j) {
            if (j >= 3000 && j <= 5000) {
                this.f8536a = j;
            }
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }

        public a a(d dVar) {
            if (dVar != null) {
                this.e = dVar;
            }
            return this;
        }

        public a a(e eVar) {
            this.j = eVar;
            return this;
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
            }
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public f a() throws NullPointerException {
            this.g.getClass();
            return new f(this);
        }
    }

    public f(a aVar) {
        this.f8535a = aVar.f8536a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.h = aVar.h;
        this.g = aVar.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashAdParams{fetchTimeout=");
        sb.append(this.f8535a);
        sb.append(", title='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", showPreLoadPage=");
        sb.append(this.d);
        sb.append(", bottomArea=");
        Object obj = this.e;
        if (obj == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        sb.append(", isUseSurfaceView='");
        sb.append(this.f);
        sb.append('\'');
        sb.append(", isVertical=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }
}
