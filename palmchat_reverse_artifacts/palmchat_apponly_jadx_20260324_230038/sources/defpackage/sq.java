package defpackage;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class sq<K, A> {
    public final d<K> c;

    @Nullable
    public i93<A> e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f20803a = new ArrayList(1);
    public boolean b = false;
    public float d = 0.0f;

    @Nullable
    public A f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void e();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // sq.d
        public h03<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // sq.d
        public float b() {
            return 0.0f;
        }

        @Override // sq.d
        public boolean c(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // sq.d
        public boolean d(float f) {
            return false;
        }

        @Override // sq.d
        public float e() {
            return 1.0f;
        }

        @Override // sq.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d<T> {
        h03<T> a();

        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        float b();

        boolean c(float f);

        boolean d(float f);

        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        float e();

        boolean isEmpty();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends h03<T>> f20804a;
        public h03<T> c = null;
        public float d = -1.0f;

        @NonNull
        public h03<T> b = f(0.0f);

        public e(List<? extends h03<T>> list) {
            this.f20804a = list;
        }

        @Override // sq.d
        @NonNull
        public h03<T> a() {
            return this.b;
        }

        @Override // sq.d
        public float b() {
            return this.f20804a.get(0).e();
        }

        @Override // sq.d
        public boolean c(float f) {
            h03<T> h03Var = this.c;
            h03<T> h03Var2 = this.b;
            if (h03Var == h03Var2 && this.d == f) {
                return true;
            }
            this.c = h03Var2;
            this.d = f;
            return false;
        }

        @Override // sq.d
        public boolean d(float f) {
            if (this.b.a(f)) {
                return !this.b.h();
            }
            this.b = f(f);
            return true;
        }

        @Override // sq.d
        public float e() {
            return this.f20804a.get(r0.size() - 1).b();
        }

        public final h03<T> f(float f) {
            List<? extends h03<T>> list = this.f20804a;
            h03<T> h03Var = list.get(list.size() - 1);
            if (f >= h03Var.e()) {
                return h03Var;
            }
            for (int size = this.f20804a.size() - 2; size >= 1; size--) {
                h03<T> h03Var2 = this.f20804a.get(size);
                if (this.b != h03Var2 && h03Var2.a(f)) {
                    return h03Var2;
                }
            }
            return this.f20804a.get(0);
        }

        @Override // sq.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final h03<T> f20805a;
        public float b = -1.0f;

        public f(List<? extends h03<T>> list) {
            this.f20805a = list.get(0);
        }

        @Override // sq.d
        public h03<T> a() {
            return this.f20805a;
        }

        @Override // sq.d
        public float b() {
            return this.f20805a.e();
        }

        @Override // sq.d
        public boolean c(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // sq.d
        public boolean d(float f) {
            return !this.f20805a.h();
        }

        @Override // sq.d
        public float e() {
            return this.f20805a.b();
        }

        @Override // sq.d
        public boolean isEmpty() {
            return false;
        }
    }

    public sq(List<? extends h03<K>> list) {
        this.c = o(list);
    }

    public static <T> d<T> o(List<? extends h03<T>> list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f20803a.add(bVar);
    }

    public h03<K> b() {
        m03.a("BaseKeyframeAnimation#getCurrentKeyframe");
        h03<K> h03VarA = this.c.a();
        m03.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return h03VarA;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float c() {
        if (this.h == -1.0f) {
            this.h = this.c.e();
        }
        return this.h;
    }

    public float d() {
        h03<K> h03VarB = b();
        if (h03VarB == null || h03VarB.h()) {
            return 0.0f;
        }
        return h03VarB.d.getInterpolation(e());
    }

    public float e() {
        if (this.b) {
            return 0.0f;
        }
        h03<K> h03VarB = b();
        if (h03VarB.h()) {
            return 0.0f;
        }
        return (this.d - h03VarB.e()) / (h03VarB.b() - h03VarB.e());
    }

    public float f() {
        return this.d;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public final float g() {
        if (this.g == -1.0f) {
            this.g = this.c.b();
        }
        return this.g;
    }

    public A h() {
        float fE = e();
        if (this.e == null && this.c.c(fE)) {
            return this.f;
        }
        h03<K> h03VarB = b();
        Interpolator interpolator = h03VarB.e;
        A aI = (interpolator == null || h03VarB.f == null) ? i(h03VarB, d()) : j(h03VarB, fE, interpolator.getInterpolation(fE), h03VarB.f.getInterpolation(fE));
        this.f = aI;
        return aI;
    }

    public abstract A i(h03<K> h03Var, float f2);

    public A j(h03<K> h03Var, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i = 0; i < this.f20803a.size(); i++) {
            this.f20803a.get(i).e();
        }
    }

    public void l() {
        this.b = true;
    }

    public void m(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f2) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.d) {
            return;
        }
        this.d = f2;
        if (this.c.d(f2)) {
            k();
        }
    }

    public void n(@Nullable i93<A> i93Var) {
        i93<A> i93Var2 = this.e;
        if (i93Var2 != null) {
            i93Var2.c(null);
        }
        this.e = i93Var;
        if (i93Var != null) {
            i93Var.c(this);
        }
    }
}
