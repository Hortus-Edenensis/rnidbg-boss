package com.bytedance.adsdk.lottie.u.nr;

import android.view.animation.Interpolator;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u<K, A> {
    protected com.bytedance.adsdk.lottie.iz.fx<A> fx;
    private final fx<K> pn;
    final List<InterfaceC0166u> u = new ArrayList(1);
    private boolean b = false;
    protected float nr = 0.0f;
    private A iz = null;
    private float x = -1.0f;
    private float n = -1.0f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<T> implements fx<T> {
        private final List<? extends com.bytedance.adsdk.lottie.iz.u<T>> u;
        private com.bytedance.adsdk.lottie.iz.u<T> fx = null;
        private float b = -1.0f;
        private com.bytedance.adsdk.lottie.iz.u<T> nr = fx(0.0f);

        public b(List<? extends com.bytedance.adsdk.lottie.iz.u<T>> list) {
            this.u = list;
        }

        private com.bytedance.adsdk.lottie.iz.u<T> fx(float f) {
            com.bytedance.adsdk.lottie.iz.u<T> uVar = this.u.get(r0.size() - 1);
            if (f >= uVar.fx()) {
                return uVar;
            }
            for (int size = this.u.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.iz.u<T> uVar2 = this.u.get(size);
                if (this.nr != uVar2 && uVar2.u(f)) {
                    return uVar2;
                }
            }
            return this.u.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float b() {
            return this.u.get(r0.size() - 1).b();
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public com.bytedance.adsdk.lottie.iz.u<T> nr() {
            return this.nr;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean nr(float f) {
            com.bytedance.adsdk.lottie.iz.u<T> uVar = this.fx;
            com.bytedance.adsdk.lottie.iz.u<T> uVar2 = this.nr;
            if (uVar == uVar2 && this.b == f) {
                return true;
            }
            this.fx = uVar2;
            this.b = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u(float f) {
            if (this.nr.u(f)) {
                return !this.nr.pn();
            }
            this.nr = fx(f);
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float fx() {
            return this.u.get(0).fx();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface fx<T> {
        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        float b();

        @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
        float fx();

        com.bytedance.adsdk.lottie.iz.u<T> nr();

        boolean nr(float f);

        boolean u();

        boolean u(float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr<T> implements fx<T> {
        private nr() {
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float b() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float fx() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public com.bytedance.adsdk.lottie.iz.u<T> nr() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean nr(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u(float f) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class pn<T> implements fx<T> {
        private float nr = -1.0f;
        private final com.bytedance.adsdk.lottie.iz.u<T> u;

        public pn(List<? extends com.bytedance.adsdk.lottie.iz.u<T>> list) {
            this.u = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float b() {
            return this.u.b();
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public float fx() {
            return this.u.fx();
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public com.bytedance.adsdk.lottie.iz.u<T> nr() {
            return this.u;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean nr(float f) {
            if (this.nr == f) {
                return true;
            }
            this.nr = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.u.nr.u.fx
        public boolean u(float f) {
            return !this.u.pn();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.u.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0166u {
        void u();
    }

    public u(List<? extends com.bytedance.adsdk.lottie.iz.u<K>> list) {
        this.pn = u(list);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float a() {
        if (this.x == -1.0f) {
            this.x = this.pn.fx();
        }
        return this.x;
    }

    public float b() {
        if (this.b) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.iz.u<K> uVarFx = fx();
        if (uVarFx.pn()) {
            return 0.0f;
        }
        return (this.nr - uVarFx.fx()) / (uVarFx.b() - uVarFx.fx());
    }

    public com.bytedance.adsdk.lottie.iz.u<K> fx() {
        com.bytedance.adsdk.lottie.pn.u("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.iz.u<K> uVarNr = this.pn.nr();
        com.bytedance.adsdk.lottie.pn.nr("BaseKeyframeAnimation#getCurrentKeyframe");
        return uVarNr;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float iz() {
        if (this.n == -1.0f) {
            this.n = this.pn.b();
        }
        return this.n;
    }

    public float n() {
        return this.nr;
    }

    public void nr() {
        for (int i = 0; i < this.u.size(); i++) {
            this.u.get(i).u();
        }
    }

    public float pn() {
        com.bytedance.adsdk.lottie.iz.u<K> uVarFx = fx();
        if (uVarFx == null || uVarFx.pn()) {
            return 0.0f;
        }
        return uVarFx.fx.getInterpolation(b());
    }

    public abstract A u(com.bytedance.adsdk.lottie.iz.u<K> uVar, float f);

    public void u() {
        this.b = true;
    }

    public A x() {
        float fB = b();
        if (this.fx == null && this.pn.nr(fB)) {
            return this.iz;
        }
        com.bytedance.adsdk.lottie.iz.u<K> uVarFx = fx();
        Interpolator interpolator = uVarFx.b;
        A aU = (interpolator == null || uVarFx.pn == null) ? u(uVarFx, pn()) : u(uVarFx, fB, interpolator.getInterpolation(fB), uVarFx.pn.getInterpolation(fB));
        this.iz = aU;
        return aU;
    }

    public void u(InterfaceC0166u interfaceC0166u) {
        this.u.add(interfaceC0166u);
    }

    public void u(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        if (this.pn.u()) {
            return;
        }
        if (f < a()) {
            f = a();
        } else if (f > iz()) {
            f = iz();
        }
        if (f == this.nr) {
            return;
        }
        this.nr = f;
        if (this.pn.u(f)) {
            nr();
        }
    }

    public A u(com.bytedance.adsdk.lottie.iz.u<K> uVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> fx<T> u(List<? extends com.bytedance.adsdk.lottie.iz.u<T>> list) {
        if (list.isEmpty()) {
            return new nr();
        }
        if (list.size() == 1) {
            return new pn(list);
        }
        return new b(list);
    }
}
