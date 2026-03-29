package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f4006a = Executors.newSingleThreadExecutor();
    private static int b = -1;
    private static int c = -1;
    private int d;
    private int e;
    private Context f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4007a;

        public a(String str) {
            this.f4007a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.b = c.this.f.getSharedPreferences("ad_auth", 0).getInt(this.f4007a, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4008a;

        public b(String str) {
            this.f4008a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.c = c.this.f.getSharedPreferences("ad_auth", 0).getInt(this.f4008a, 0);
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.util.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0090c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4009a;
        final /* synthetic */ int b;

        public RunnableC0090c(String str, int i) {
            this.f4009a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f4009a, this.b).apply();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4010a;
        final /* synthetic */ int b;

        public d(String str, int i) {
            this.f4010a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f4010a, this.b).apply();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f4011a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public void c(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        this.d = i;
        a("ad_key", i);
    }

    public void d(int i) {
        if (i == -1 && (i = b("ad_key_user")) == -101) {
            return;
        }
        this.e = i;
        b("ad_key_user", i);
    }

    public boolean e() {
        int i = this.d;
        return i >= 0 && (i & 65536) == 65536;
    }

    public boolean f() {
        int i = this.d;
        return i >= 0 && (i & 1073741824) == 1073741824;
    }

    public boolean g() {
        int i = this.d;
        return i >= 0 && (i & 1) == 1;
    }

    public boolean h() {
        int i = this.e;
        return i >= 0 && (i & 268435456) == 268435456;
    }

    public boolean i() {
        int i = this.d;
        return i >= 0 && (i & 1024) == 1024;
    }

    private c() {
    }

    private int b(String str) {
        if (this.f == null) {
            return -101;
        }
        if (c == -1) {
            f4006a.execute(new b(str));
        }
        return c;
    }

    public static c a() {
        return e.f4011a;
    }

    public void a(Context context) {
        this.f = context;
    }

    public boolean c() {
        int i = this.d;
        return i >= 0 && (i & 67108864) == 67108864;
    }

    public boolean d() {
        int i = this.d;
        return i >= 0 && (i & 134217728) == 134217728;
    }

    private int a(String str) {
        if (this.f == null) {
            return -101;
        }
        if (b == -1) {
            f4006a.execute(new a(str));
        }
        return b;
    }

    private void b(String str, int i) {
        if (this.f == null) {
            return;
        }
        c = i;
        f4006a.execute(new d(str, i));
    }

    private void a(String str, int i) {
        if (this.f == null) {
            return;
        }
        b = i;
        f4006a.execute(new RunnableC0090c(str, i));
    }

    public boolean b() {
        int i = this.d;
        return i >= 0 && (i & 33554432) == 33554432;
    }
}
