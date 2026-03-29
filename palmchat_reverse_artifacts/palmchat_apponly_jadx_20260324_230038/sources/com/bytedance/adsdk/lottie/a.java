package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<fx> f4979a;
    private final String b;
    private final String fx;
    private final String iz;
    private final String jk;
    private Bitmap k;
    private final JSONArray l;
    private final u mv;
    private final String n;
    private final int nr;
    private final String pn;
    private final nr s;
    private final int[][] t;
    private final int u;
    private final String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4980a;
        public String b;
        public String fx;
        public int iz;
        public String jk;
        public u l;
        public int mv;
        public int n;
        public int nr;
        public String pn;
        public int s;
        public u t;
        public int u;
        public String x;

        /* JADX INFO: compiled from: SearchBox */
        public static class u {
            public String nr;
            public int u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public int fx;
        public int nr;
        public int u;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public boolean nr;
        public C0163u u = null;

        /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.a$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0163u {
            public float u = 5.0f;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public a(int i, int i2, String str, String str2, String str3, String str4, List<fx> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, u uVar, nr nrVar) {
        this.u = i;
        this.nr = i2;
        this.fx = str;
        this.b = str2;
        this.pn = str3;
        this.iz = str4;
        this.x = str6;
        this.n = str7;
        this.f4979a = list;
        this.jk = str5;
        this.t = iArr;
        this.l = jSONArray;
        this.mv = uVar;
        this.s = nrVar;
    }

    public JSONArray a() {
        return this.l;
    }

    public String b() {
        return this.iz;
    }

    public List<fx> fx() {
        return this.f4979a;
    }

    public String iz() {
        return this.n;
    }

    public u jk() {
        return this.mv;
    }

    public Bitmap k() {
        return this.k;
    }

    public String l() {
        return this.fx;
    }

    public String mv() {
        return this.b;
    }

    public int[][] n() {
        return this.t;
    }

    public int nr() {
        return this.nr;
    }

    public String pn() {
        return this.x;
    }

    public String s() {
        return this.pn;
    }

    public nr t() {
        return this.s;
    }

    public int u() {
        return this.u;
    }

    public String x() {
        return this.jk;
    }

    public void u(Bitmap bitmap) {
        this.k = bitmap;
    }
}
