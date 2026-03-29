package com.bytedance.adsdk.lottie.model.nr;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.u.u.bq;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx implements fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5000a;
    private final com.bytedance.adsdk.lottie.model.u.u b;
    private final List<com.bytedance.adsdk.lottie.model.u.nr> fx;
    private final com.bytedance.adsdk.lottie.model.u.nr iz;
    private final boolean jk;
    private final nr n;
    private final com.bytedance.adsdk.lottie.model.u.nr nr;
    private final com.bytedance.adsdk.lottie.model.u.b pn;
    private final String u;
    private final u x;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.nr.sx$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nr;
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[nr.values().length];
            nr = iArr;
            try {
                iArr[nr.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                nr[nr.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                nr[nr.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[u.values().length];
            u = iArr2;
            try {
                iArr2[u.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                u[u.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[u.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum nr {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join u() {
            int i = AnonymousClass1.nr[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap u() {
            int i = AnonymousClass1.u[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public sx(String str, com.bytedance.adsdk.lottie.model.u.nr nrVar, List<com.bytedance.adsdk.lottie.model.u.nr> list, com.bytedance.adsdk.lottie.model.u.u uVar, com.bytedance.adsdk.lottie.model.u.b bVar, com.bytedance.adsdk.lottie.model.u.nr nrVar2, u uVar2, nr nrVar3, float f, boolean z) {
        this.u = str;
        this.nr = nrVar;
        this.fx = list;
        this.b = uVar;
        this.pn = bVar;
        this.iz = nrVar2;
        this.x = uVar2;
        this.n = nrVar3;
        this.f5000a = f;
        this.jk = z;
    }

    public float a() {
        return this.f5000a;
    }

    public com.bytedance.adsdk.lottie.model.u.nr b() {
        return this.iz;
    }

    public com.bytedance.adsdk.lottie.model.u.b fx() {
        return this.pn;
    }

    public com.bytedance.adsdk.lottie.model.u.nr iz() {
        return this.nr;
    }

    public boolean jk() {
        return this.jk;
    }

    public nr n() {
        return this.n;
    }

    public com.bytedance.adsdk.lottie.model.u.u nr() {
        return this.b;
    }

    public List<com.bytedance.adsdk.lottie.model.u.nr> pn() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.lottie.model.nr.fx
    public com.bytedance.adsdk.lottie.u.u.fx u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar) {
        return new bq(nVar, fxVar, this);
    }

    public u x() {
        return this.x;
    }

    public String u() {
        return this.u;
    }
}
