package defpackage;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class u73 {
    public Map<String, List<Layer>> c;
    public Map<String, x83> d;
    public Map<String, q02> e;
    public List<dd3> f;
    public SparseArrayCompat<t02> g;
    public LongSparseArray<Layer> h;
    public List<Layer> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lg4 f21155a = new lg4();
    public final HashSet<String> b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        m63.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.j;
    }

    public SparseArrayCompat<t02> c() {
        return this.g;
    }

    public float d() {
        return (long) ((e() / this.m) * 1000.0f);
    }

    public float e() {
        return this.l - this.k;
    }

    public float f() {
        return this.l;
    }

    public Map<String, q02> g() {
        return this.e;
    }

    public float h(float f) {
        return sp3.i(this.k, this.l, f);
    }

    public float i() {
        return this.m;
    }

    public Map<String, x83> j() {
        return this.d;
    }

    public List<Layer> k() {
        return this.i;
    }

    @Nullable
    public dd3 l(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            dd3 dd3Var = this.f.get(i);
            if (dd3Var.a(str)) {
                return dd3Var;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int m() {
        return this.o;
    }

    public lg4 n() {
        return this.f21155a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> o(String str) {
        return this.c.get(str);
    }

    public float p() {
        return this.k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean q() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(int i) {
        this.o += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void s(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, x83> map2, SparseArrayCompat<t02> sparseArrayCompat, Map<String, q02> map3, List<dd3> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = longSparseArray;
        this.c = map;
        this.d = map2;
        this.g = sparseArrayCompat;
        this.e = map3;
        this.f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer t(long j) {
        return this.h.get(j);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().y("\t"));
        }
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(boolean z) {
        this.n = z;
    }

    public void v(boolean z) {
        this.f21155a.b(z);
    }
}
