package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class j03 {
    public static SparseArrayCompat<WeakReference<Interpolator>> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f18298a = new LinearInterpolator();
    public static JsonReader.a c = JsonReader.a.a("t", "s", "e", "o", "i", "h", RemoteMessageConst.TO, "ti");
    public static JsonReader.a d = JsonReader.a.a("x", "y");

    @Nullable
    public static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (j03.class) {
            weakReference = g().get(i);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = sp3.b(pointF.x, -1.0f, 1.0f);
        pointF.y = sp3.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = sp3.b(pointF2.x, -1.0f, 1.0f);
        float fB = sp3.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        int i = r86.i(pointF.x, pointF.y, pointF2.x, fB);
        WeakReference<Interpolator> weakReferenceA = a(i);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                interpolatorCreate = "The Path cannot loop back on itself.".equals(e.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorCreate;
            try {
                h(i, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> h03<T> c(JsonReader jsonReader, u73 u73Var, float f, i96<T> i96Var, boolean z, boolean z2) throws IOException {
        return (z && z2) ? e(u73Var, jsonReader, f, i96Var) : z ? d(u73Var, jsonReader, f, i96Var) : f(jsonReader, f, i96Var);
    }

    public static <T> h03<T> d(u73 u73Var, JsonReader jsonReader, float f, i96<T> i96Var) throws IOException {
        Interpolator interpolatorB;
        T t;
        jsonReader.d();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        boolean z = false;
        float fI = 0.0f;
        while (jsonReader.g()) {
            switch (jsonReader.r(c)) {
                case 0:
                    fI = (float) jsonReader.i();
                    break;
                case 1:
                    tA2 = i96Var.a(jsonReader, f);
                    break;
                case 2:
                    tA = i96Var.a(jsonReader, f);
                    break;
                case 3:
                    pointFE = bz2.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFE2 = bz2.e(jsonReader, 1.0f);
                    break;
                case 5:
                    z = jsonReader.j() == 1;
                    break;
                case 6:
                    pointFE3 = bz2.e(jsonReader, f);
                    break;
                case 7:
                    pointFE4 = bz2.e(jsonReader, f);
                    break;
                default:
                    jsonReader.x();
                    break;
            }
        }
        jsonReader.f();
        if (z) {
            interpolatorB = f18298a;
            t = tA2;
        } else {
            interpolatorB = (pointFE == null || pointFE2 == null) ? f18298a : b(pointFE, pointFE2);
            t = tA;
        }
        h03<T> h03Var = new h03<>(u73Var, tA2, t, interpolatorB, fI, null);
        h03Var.o = pointFE3;
        h03Var.p = pointFE4;
        return h03Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> h03<T> e(u73 u73Var, JsonReader jsonReader, float f, i96<T> i96Var) throws IOException {
        Interpolator interpolatorB;
        Interpolator interpolatorB2;
        Interpolator interpolatorB3;
        T t;
        PointF pointF;
        h03<T> h03Var;
        PointF pointF2;
        float f2;
        PointF pointF3;
        jsonReader.d();
        PointF pointFE = null;
        boolean z = false;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        PointF pointF4 = null;
        T tA = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float fI = 0.0f;
        PointF pointFE4 = null;
        T tA2 = null;
        while (jsonReader.g()) {
            switch (jsonReader.r(c)) {
                case 0:
                    pointF2 = pointFE;
                    fI = (float) jsonReader.i();
                    pointFE = pointF2;
                    break;
                case 1:
                    pointF2 = pointFE;
                    tA = i96Var.a(jsonReader, f);
                    pointFE = pointF2;
                    break;
                case 2:
                    pointF2 = pointFE;
                    tA2 = i96Var.a(jsonReader, f);
                    pointFE = pointF2;
                    break;
                case 3:
                    pointF2 = pointFE;
                    f2 = fI;
                    PointF pointF8 = pointFE4;
                    if (jsonReader.p() != JsonReader.Token.BEGIN_OBJECT) {
                        pointFE2 = bz2.e(jsonReader, f);
                        fI = f2;
                        pointFE4 = pointF8;
                        pointFE = pointF2;
                    } else {
                        jsonReader.d();
                        float fI2 = 0.0f;
                        float fI3 = 0.0f;
                        float fI4 = 0.0f;
                        float fI5 = 0.0f;
                        while (jsonReader.g()) {
                            int iR = jsonReader.r(d);
                            if (iR == 0) {
                                JsonReader.Token tokenP = jsonReader.p();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (tokenP == token) {
                                    fI4 = (float) jsonReader.i();
                                    fI2 = fI4;
                                } else {
                                    jsonReader.c();
                                    fI2 = (float) jsonReader.i();
                                    fI4 = jsonReader.p() == token ? (float) jsonReader.i() : fI2;
                                    jsonReader.e();
                                }
                            } else if (iR != 1) {
                                jsonReader.x();
                            } else {
                                JsonReader.Token tokenP2 = jsonReader.p();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (tokenP2 == token2) {
                                    fI5 = (float) jsonReader.i();
                                    fI3 = fI5;
                                } else {
                                    jsonReader.c();
                                    fI3 = (float) jsonReader.i();
                                    fI5 = jsonReader.p() == token2 ? (float) jsonReader.i() : fI3;
                                    jsonReader.e();
                                }
                            }
                        }
                        PointF pointF9 = new PointF(fI2, fI3);
                        PointF pointF10 = new PointF(fI4, fI5);
                        jsonReader.f();
                        pointF5 = pointF10;
                        pointF4 = pointF9;
                        pointFE4 = pointF8;
                        fI = f2;
                        pointFE = pointF2;
                    }
                    break;
                case 4:
                    if (jsonReader.p() != JsonReader.Token.BEGIN_OBJECT) {
                        pointF2 = pointFE;
                        pointFE3 = bz2.e(jsonReader, f);
                        pointFE = pointF2;
                    } else {
                        jsonReader.d();
                        float fI6 = 0.0f;
                        float f3 = 0.0f;
                        float fI7 = 0.0f;
                        float fI8 = 0.0f;
                        while (jsonReader.g()) {
                            PointF pointF11 = pointFE4;
                            int iR2 = jsonReader.r(d);
                            if (iR2 != 0) {
                                pointF3 = pointFE;
                                if (iR2 != 1) {
                                    jsonReader.x();
                                } else {
                                    JsonReader.Token tokenP3 = jsonReader.p();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (tokenP3 == token3) {
                                        fI8 = (float) jsonReader.i();
                                        fI = fI;
                                        f3 = fI8;
                                    } else {
                                        float f4 = fI;
                                        jsonReader.c();
                                        float fI9 = (float) jsonReader.i();
                                        float fI10 = jsonReader.p() == token3 ? (float) jsonReader.i() : fI9;
                                        jsonReader.e();
                                        fI = f4;
                                        pointFE4 = pointF11;
                                        pointFE = pointF3;
                                        fI8 = fI10;
                                        f3 = fI9;
                                    }
                                }
                            } else {
                                pointF3 = pointFE;
                                float f5 = fI;
                                JsonReader.Token tokenP4 = jsonReader.p();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (tokenP4 == token4) {
                                    fI7 = (float) jsonReader.i();
                                    fI = f5;
                                    fI6 = fI7;
                                } else {
                                    jsonReader.c();
                                    fI6 = (float) jsonReader.i();
                                    fI7 = jsonReader.p() == token4 ? (float) jsonReader.i() : fI6;
                                    jsonReader.e();
                                    fI = f5;
                                }
                            }
                            pointFE4 = pointF11;
                            pointFE = pointF3;
                        }
                        pointF2 = pointFE;
                        f2 = fI;
                        PointF pointF12 = new PointF(fI6, f3);
                        PointF pointF13 = new PointF(fI7, fI8);
                        jsonReader.f();
                        pointF7 = pointF13;
                        pointF6 = pointF12;
                        fI = f2;
                        pointFE = pointF2;
                    }
                    break;
                case 5:
                    z = jsonReader.j() == 1;
                    break;
                case 6:
                    pointFE4 = bz2.e(jsonReader, f);
                    break;
                case 7:
                    pointFE = bz2.e(jsonReader, f);
                    break;
                default:
                    pointF2 = pointFE;
                    jsonReader.x();
                    pointFE = pointF2;
                    break;
            }
        }
        PointF pointF14 = pointFE;
        float f6 = fI;
        PointF pointF15 = pointFE4;
        jsonReader.f();
        if (z) {
            interpolatorB = f18298a;
            t = tA;
        } else {
            if (pointFE2 == null || pointFE3 == null) {
                if (pointF4 != null && pointF5 != null && pointF6 != null && pointF7 != null) {
                    interpolatorB2 = b(pointF4, pointF6);
                    interpolatorB3 = b(pointF5, pointF7);
                    t = tA2;
                    interpolatorB = null;
                    if (interpolatorB2 != null || interpolatorB3 == null) {
                        pointF = pointF15;
                        h03Var = new h03<>(u73Var, tA, t, interpolatorB, f6, null);
                    } else {
                        pointF = pointF15;
                        h03Var = new h03<>(u73Var, tA, t, interpolatorB2, interpolatorB3, f6, null);
                    }
                    h03Var.o = pointF;
                    h03Var.p = pointF14;
                    return h03Var;
                }
                interpolatorB = f18298a;
            } else {
                interpolatorB = b(pointFE2, pointFE3);
            }
            t = tA2;
        }
        interpolatorB2 = null;
        interpolatorB3 = null;
        if (interpolatorB2 != null) {
            pointF = pointF15;
            h03Var = new h03<>(u73Var, tA, t, interpolatorB, f6, null);
        }
        h03Var.o = pointF;
        h03Var.p = pointF14;
        return h03Var;
    }

    public static <T> h03<T> f(JsonReader jsonReader, float f, i96<T> i96Var) throws IOException {
        return new h03<>(i96Var.a(jsonReader, f));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (b == null) {
            b = new SparseArrayCompat<>();
        }
        return b;
    }

    public static void h(int i, WeakReference<Interpolator> weakReference) {
        synchronized (j03.class) {
            b.put(i, weakReference);
        }
    }
}
