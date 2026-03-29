package com.zenmen.media.roomchat;

import android.content.Context;
import com.zenmen.media.common.IPInfo;
import com.zenmen.palmchat.R;
import defpackage.it0;
import defpackage.nl0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f11964a;
    public static Context b;
    public static IPInfo g;
    public static IPInfo h;
    public static byte[] j;
    public static a l;
    public static String c = nl0.c();
    public static int d = 0;
    public static int e = 0;
    public static String f = "CN-HD-DX";
    public static boolean i = false;
    public static b k = new b();

    /* JADX INFO: compiled from: SearchBox */
    public enum MY_NAME {
        I_AM_ALICE,
        I_AM_BOB,
        I_AM_CHARLIE,
        I_AM_NONE
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11965a;
        public boolean b = false;
        public long c = 0;

        public long a() {
            return (((long) ((int) (System.currentTimeMillis() % 1215752192))) - this.c) / 1000;
        }

        public long b() {
            if (this.b) {
                return (((long) ((int) (System.currentTimeMillis() % 1215752192))) - this.f11965a) / 1000;
            }
            return -1L;
        }

        public String c() {
            if (this.b) {
                long jB = b();
                long j = jB / 60;
                return String.format("%02d:%02d", Long.valueOf(j), Long.valueOf(jB - (60 * j)));
            }
            if (RTCParameters.c() == null) {
                return null;
            }
            return RTCParameters.c().getResources().getString(R.string.manychats_waiting_accept_call);
        }

        public void d() {
            this.f11965a = 0L;
            this.b = false;
        }

        public void e() {
            this.c = (int) (System.currentTimeMillis() % 1215752192);
        }

        public void f() {
            this.f11965a = (int) (System.currentTimeMillis() % 1215752192);
            this.b = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11966a = 9;
        public boolean b = false;
        public boolean c = false;
        public boolean h = false;

        public b() {
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = true;
            if (RTCParameters.k().equals("dev")) {
                this.d = true;
                this.e = true;
                this.f = true;
                this.g = true;
                this.i = true;
                this.j = true;
                this.l = true;
                return;
            }
            if (RTCParameters.k().equals("debug2")) {
                this.d = true;
                this.e = true;
                this.f = true;
                this.g = true;
                this.i = true;
                this.j = false;
                this.l = false;
                return;
            }
            if (RTCParameters.k().equals("release")) {
                this.d = false;
                this.e = false;
                this.f = false;
                this.g = true;
                this.i = false;
                this.j = false;
                this.l = false;
                if (RTCParameters.m()) {
                    this.k = false;
                }
            }
        }
    }

    public static String a() {
        try {
            return String.valueOf(c().getPackageManager().getPackageInfo(h(), 0).versionCode);
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] b() {
        return j;
    }

    public static Context c() {
        return b;
    }

    public static boolean d() {
        return i;
    }

    public static IPInfo e(IPInfo.IP_Type iP_Type) {
        if (iP_Type == IPInfo.IP_Type.Notify) {
            IPInfo iPInfo = g;
            return iPInfo != null ? iPInfo : com.zenmen.media.common.a.a();
        }
        IPInfo iPInfo2 = h;
        return iPInfo2 != null ? iPInfo2 : com.zenmen.media.common.b.a();
    }

    public static a f() {
        if (l == null) {
            l = new a();
        }
        return l;
    }

    public static String g() {
        try {
            f = it0.k().f();
        } catch (Exception unused) {
        }
        return f;
    }

    public static String h() {
        return m() ? "com.zenmen.im" : "com.zenmen.palmchat";
    }

    public static int i() {
        return d;
    }

    public static int j() {
        return e;
    }

    public static String k() {
        return c;
    }

    public static long l() {
        return f11964a;
    }

    public static boolean m() {
        return nl0.f();
    }

    public static void n(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        j = new byte[bArr.length];
        j = (byte[]) bArr.clone();
    }

    public static void o(Context context) {
        b = context;
    }

    public static void p(boolean z) {
        i = z;
    }

    public static void q(IPInfo.IP_Type iP_Type, String str, int i2) {
        if (iP_Type == IPInfo.IP_Type.Notify) {
            g = new IPInfo(iP_Type, str, i2);
        } else {
            h = new IPInfo(iP_Type, str, i2);
        }
    }

    public static void r(String str) {
        f = str;
    }

    public static void s(int i2) {
        d = i2;
    }

    public static void t(int i2) {
        e = i2;
    }

    public static void u(long j2) {
        f11964a = j2;
    }
}
