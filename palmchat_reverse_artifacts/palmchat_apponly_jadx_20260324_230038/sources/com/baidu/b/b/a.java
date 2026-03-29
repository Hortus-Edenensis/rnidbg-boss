package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.cdo.oaps.ad.OapsKey;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Comparator f3303a = new com.baidu.b.b.b();
    protected C0058a b;
    protected a.C0060a c;
    private final String d;
    private long e;

    /* JADX INFO: renamed from: com.baidu.b.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0058a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f3304a;
        public com.baidu.b.e.a b;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a.C0060a f3305a;
        private String b;
        private String c;
        private boolean d = true;

        public b(a.C0060a c0060a, String str) {
            this.f3305a = c0060a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject) throws JSONException;

        public void a(boolean z) {
            this.d = z;
        }

        public abstract void b(JSONObject jSONObject) throws JSONException;

        public boolean b() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f3305a.a(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean a() {
            String strA = this.f3305a.a(this.c, true);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    a(new JSONObject(strA));
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3306a;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h.a f3307a;
        public int b;
        public Exception c;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.f3307a = aVar;
            this.c = exc;
        }

        public static e a() {
            return new e(-1, null, null);
        }

        public boolean b() {
            return this.b == 0;
        }

        public static e a(int i) {
            return new e(i, null, null);
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }
    }

    public a(String str, long j) {
        this.d = str;
        this.e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.d;
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }

    public final void a(C0058a c0058a) {
        this.b = c0058a;
        this.c = c0058a.b.b().a(OapsKey.KEY_CHECKSUM);
    }
}
