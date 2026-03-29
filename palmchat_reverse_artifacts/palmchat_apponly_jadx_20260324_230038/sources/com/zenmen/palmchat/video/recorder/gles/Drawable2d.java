package com.zenmen.palmchat.video.recorder.gles;

import defpackage.gc2;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class Drawable2d {
    public static final float[] h;
    public static final float[] i;
    public static final FloatBuffer j;
    public static final FloatBuffer k;
    public static final float[] l;
    public static final float[] m;
    public static final FloatBuffer n;
    public static final FloatBuffer o;
    public static final float[] p;
    public static final float[] q;
    public static final FloatBuffer r;
    public static final FloatBuffer s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FloatBuffer f15809a;
    public FloatBuffer b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Prefab g;

    /* JADX INFO: compiled from: SearchBox */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15810a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f15810a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15810a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15810a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        h = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        i = fArr2;
        j = gc2.c(fArr);
        k = gc2.c(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        m = fArr4;
        n = gc2.c(fArr3);
        o = gc2.c(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr5;
        float[] fArr6 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        q = fArr6;
        r = gc2.c(fArr5);
        s = gc2.c(fArr6);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f15810a[prefab.ordinal()];
        if (i2 == 1) {
            this.f15809a = j;
            this.b = k;
            this.d = 2;
            this.e = 2 * 4;
            this.c = h.length / 2;
        } else if (i2 == 2) {
            this.f15809a = n;
            this.b = o;
            this.d = 2;
            this.e = 2 * 4;
            this.c = l.length / 2;
        } else {
            if (i2 != 3) {
                throw new RuntimeException("Unknown shape " + prefab);
            }
            this.f15809a = r;
            this.b = s;
            this.d = 2;
            this.e = 2 * 4;
            this.c = p.length / 2;
        }
        this.f = 8;
        this.g = prefab;
    }

    public int a() {
        return this.d;
    }

    public FloatBuffer b() {
        return this.b;
    }

    public int c() {
        return this.f;
    }

    public FloatBuffer d() {
        return this.f15809a;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public String toString() {
        if (this.g == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.g + "]";
    }
}
