package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.bytedance.adsdk.lottie.model.layer.n> f4981a;
    private Map<String, a> b;
    private fx bg;
    private u bq;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.n>> fx;
    private List<com.bytedance.adsdk.lottie.model.iz> iz;
    private Rect jk;
    private float l;
    private float mv;
    private b my;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.n> n;
    private Map<String, com.bytedance.adsdk.lottie.model.fx> pn;
    private boolean s;
    private nr sx;
    private float t;
    private SparseArray<com.bytedance.adsdk.lottie.model.b> x;
    private final sx u = new sx();
    private final HashSet<String> nr = new HashSet<>();
    private int k = 0;
    private String o = "";

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4982a;
        public String b;
        public String fx;
        public String iz;
        public String[] jk;
        public int n;
        public String nr;
        public int[] pn;
        public int u;
        public JSONArray x;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx {
        public JSONArray fx;
        public int[][] nr;
        public String u;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        public int b;
        public Map<String, Object> fx;
        public String iz;
        public Map<String, Object> nr;
        public int pn;
        public int u;
        public JSONArray x;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public String b;
        public String fx;
        public String nr;
        public String u;
        public float pn = -1.0f;
        public float iz = -1.0f;
        public float x = -1.0f;
        public float n = -1.0f;

        public String toString() {
            return "area[" + this.u + "," + this.nr + "," + this.fx + "," + this.b + "]->[" + this.pn + "," + this.iz + "," + this.x + "," + this.n + "]";
        }
    }

    public String a() {
        return this.o;
    }

    public Rect b() {
        return this.jk;
    }

    public sx fx() {
        return this.u;
    }

    public float iz() {
        return this.t;
    }

    public u jk() {
        return this.bq;
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.b> k() {
        return this.x;
    }

    public nr l() {
        return this.sx;
    }

    public float mv() {
        return this.mv;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.fx> my() {
        return this.pn;
    }

    public b n() {
        return this.my;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int nr() {
        return this.k;
    }

    public Map<String, a> o() {
        return this.b;
    }

    public float pn() {
        return (long) ((sx() / this.mv) * 1000.0f);
    }

    public List<com.bytedance.adsdk.lottie.model.layer.n> s() {
        return this.f4981a;
    }

    public float sx() {
        return this.l - this.t;
    }

    public fx t() {
        return this.bg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.n> it = this.f4981a.iterator();
        while (it.hasNext()) {
            sb.append(it.next().u("\t"));
        }
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.model.layer.n> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.n> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.n>> map, Map<String, a> map2, SparseArray<com.bytedance.adsdk.lottie.model.b> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.fx> map3, List<com.bytedance.adsdk.lottie.model.iz> list2, b bVar, String str, nr nrVar, fx fxVar, u uVar) {
        this.jk = rect;
        this.t = f;
        this.l = f2;
        this.mv = f3;
        this.f4981a = list;
        this.n = longSparseArray;
        this.fx = map;
        this.b = map2;
        this.x = sparseArray;
        this.pn = map3;
        this.iz = list2;
        this.my = bVar;
        this.o = str;
        this.sx = nrVar;
        this.bg = fxVar;
        this.bq = uVar;
    }

    public float x() {
        return this.l;
    }

    public com.bytedance.adsdk.lottie.model.iz fx(String str) {
        int size = this.iz.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.model.iz izVar = this.iz.get(i);
            if (izVar.u(str)) {
                return izVar;
            }
        }
        return null;
    }

    public void nr(boolean z) {
        this.u.u(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.bytedance.adsdk.lottie.model.layer.n> nr(String str) {
        return this.fx.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(String str) {
        com.bytedance.adsdk.lottie.pn.pn.nr(str);
        this.nr.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(boolean z) {
        this.s = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(int i) {
        this.k += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean u() {
        return this.s;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.bytedance.adsdk.lottie.model.layer.n u(long j) {
        return this.n.get(j);
    }

    public float u(float f) {
        return com.bytedance.adsdk.lottie.pn.n.u(this.t, this.l, f);
    }
}
