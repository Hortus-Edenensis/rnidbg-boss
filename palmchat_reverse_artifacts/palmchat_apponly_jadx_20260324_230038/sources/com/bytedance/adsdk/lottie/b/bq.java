package com.bytedance.adsdk.lottie.b;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class bq {
    private static SparseArray<WeakReference<Interpolator>> nr;
    private static final Interpolator u = new LinearInterpolator();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> com.bytedance.adsdk.lottie.iz.u<T> nr(com.bytedance.adsdk.lottie.iz izVar, JsonReader jsonReader, float f, xw<T> xwVar) throws IOException {
        Interpolator interpolatorU;
        Interpolator interpolatorU2;
        T t;
        Interpolator interpolatorU3;
        PointF pointF;
        com.bytedance.adsdk.lottie.iz.u<T> uVar;
        float f2;
        PointF pointF2;
        PointF pointF3;
        T t2;
        String str;
        String str2;
        T t3;
        jsonReader.beginObject();
        PointF pointFNr = null;
        boolean z = false;
        PointF pointFNr2 = null;
        PointF pointFNr3 = null;
        PointF pointF4 = null;
        T tNr = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float fNextDouble = 0.0f;
        PointF pointFNr4 = null;
        T tNr2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 101:
                    if (strNextName.equals("e")) {
                        b = 0;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 1;
                    }
                    break;
                case 105:
                    if (strNextName.equals("i")) {
                        b = 2;
                    }
                    break;
                case 111:
                    if (strNextName.equals("o")) {
                        b = 3;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 4;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 5;
                    }
                    break;
                case 3701:
                    if (strNextName.equals("ti")) {
                        b = 6;
                    }
                    break;
                case 3707:
                    if (strNextName.equals(RemoteMessageConst.TO)) {
                        b = 7;
                    }
                    break;
            }
            String str3 = "y";
            String str4 = "x";
            switch (b) {
                case 0:
                    f2 = fNextDouble;
                    tNr2 = xwVar.nr(jsonReader, f);
                    fNextDouble = f2;
                    break;
                case 1:
                    pointF2 = pointFNr;
                    f2 = fNextDouble;
                    pointF3 = pointFNr4;
                    t2 = tNr;
                    z = jsonReader.nextInt() == 1;
                    tNr = t2;
                    pointFNr4 = pointF3;
                    pointFNr = pointF2;
                    fNextDouble = f2;
                    break;
                case 2:
                    pointF2 = pointFNr;
                    f2 = fNextDouble;
                    pointF3 = pointFNr4;
                    t2 = tNr;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(str4)) {
                                str = str3;
                                str2 = str4;
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (!strNextName2.equals(str3)) {
                                jsonReader.skipValue();
                            } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                str = str3;
                                str2 = str4;
                                fNextDouble5 = (float) jsonReader.nextDouble();
                                fNextDouble3 = fNextDouble5;
                            } else {
                                str = str3;
                                str2 = str4;
                                jsonReader.beginArray();
                                fNextDouble3 = (float) jsonReader.nextDouble();
                                fNextDouble5 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble3;
                                jsonReader.endArray();
                            }
                            str3 = str;
                            str4 = str2;
                        }
                        PointF pointF8 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF9 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF7 = pointF9;
                        pointF6 = pointF8;
                    } else {
                        pointFNr3 = bg.nr(jsonReader, f);
                    }
                    tNr = t2;
                    pointFNr4 = pointF3;
                    pointFNr = pointF2;
                    fNextDouble = f2;
                    break;
                case 3:
                    pointF3 = pointFNr4;
                    pointF2 = pointFNr;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            float f3 = fNextDouble;
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("x")) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    t3 = tNr;
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                } else {
                                    t3 = tNr;
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                }
                                tNr = t3;
                            } else if (!strNextName3.equals("y")) {
                                jsonReader.skipValue();
                            } else if (jsonReader.peek() == JsonToken.NUMBER) {
                                fNextDouble9 = (float) jsonReader.nextDouble();
                                fNextDouble7 = fNextDouble9;
                            } else {
                                jsonReader.beginArray();
                                fNextDouble7 = (float) jsonReader.nextDouble();
                                fNextDouble9 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble7;
                                jsonReader.endArray();
                            }
                            fNextDouble = f3;
                        }
                        f2 = fNextDouble;
                        PointF pointF10 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF11 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF5 = pointF11;
                        pointF4 = pointF10;
                    } else {
                        f2 = fNextDouble;
                        pointFNr2 = bg.nr(jsonReader, f);
                    }
                    pointFNr4 = pointF3;
                    pointFNr = pointF2;
                    fNextDouble = f2;
                    break;
                case 4:
                    tNr = xwVar.nr(jsonReader, f);
                    break;
                case 5:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    pointFNr = bg.nr(jsonReader, f);
                    break;
                case 7:
                    pointFNr4 = bg.nr(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF12 = pointFNr;
        float f4 = fNextDouble;
        PointF pointF13 = pointFNr4;
        T t4 = tNr;
        jsonReader.endObject();
        if (z) {
            tNr2 = t4;
        } else {
            if (pointFNr2 != null && pointFNr3 != null) {
                interpolatorU3 = u(pointFNr2, pointFNr3);
                t = tNr2;
                interpolatorU = null;
                interpolatorU2 = null;
                if (interpolatorU == null) {
                    pointF = pointF13;
                    uVar = new com.bytedance.adsdk.lottie.iz.u<>(izVar, t4, t, interpolatorU3, f4, null);
                }
                uVar.n = pointF;
                uVar.f4983a = pointF12;
                return uVar;
            }
            if (pointF4 != null && pointF5 != null && pointF6 != null && pointF7 != null) {
                interpolatorU = u(pointF4, pointF6);
                interpolatorU2 = u(pointF5, pointF7);
                t = tNr2;
                interpolatorU3 = null;
                if (interpolatorU == null || interpolatorU2 == null) {
                    pointF = pointF13;
                    uVar = new com.bytedance.adsdk.lottie.iz.u<>(izVar, t4, t, interpolatorU3, f4, null);
                } else {
                    pointF = pointF13;
                    uVar = new com.bytedance.adsdk.lottie.iz.u<>(izVar, t4, t, interpolatorU, interpolatorU2, f4, null);
                }
                uVar.n = pointF;
                uVar.f4983a = pointF12;
                return uVar;
            }
        }
        interpolatorU3 = u;
        t = tNr2;
        interpolatorU = null;
        interpolatorU2 = null;
        if (interpolatorU == null) {
        }
        uVar.n = pointF;
        uVar.f4983a = pointF12;
        return uVar;
    }

    private static SparseArray<WeakReference<Interpolator>> u() {
        if (nr == null) {
            nr = new SparseArray<>();
        }
        return nr;
    }

    private static WeakReference<Interpolator> u(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (bq.class) {
            weakReference = u().get(i);
        }
        return weakReference;
    }

    private static void u(int i, WeakReference<Interpolator> weakReference) {
        synchronized (bq.class) {
            nr.put(i, weakReference);
        }
    }

    public static <T> com.bytedance.adsdk.lottie.iz.u<T> u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, float f, xw<T> xwVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return nr(izVar, jsonReader, f, xwVar);
        }
        if (z) {
            return u(izVar, jsonReader, f, xwVar);
        }
        return u(jsonReader, f, xwVar);
    }

    private static <T> com.bytedance.adsdk.lottie.iz.u<T> u(com.bytedance.adsdk.lottie.iz izVar, JsonReader jsonReader, float f, xw<T> xwVar) throws IOException {
        Interpolator interpolatorU;
        jsonReader.beginObject();
        PointF pointFNr = null;
        PointF pointFNr2 = null;
        T tNr = null;
        T tNr2 = null;
        PointF pointFNr3 = null;
        PointF pointFNr4 = null;
        boolean z = false;
        float fNextDouble = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tNr = xwVar.nr(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFNr2 = bg.nr(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFNr = bg.nr(jsonReader, 1.0f);
                    break;
                case "s":
                    tNr2 = xwVar.nr(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFNr4 = bg.nr(jsonReader, f);
                    break;
                case "to":
                    pointFNr3 = bg.nr(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFNr != null && pointFNr2 != null) {
                interpolatorU = u(pointFNr, pointFNr2);
            }
            com.bytedance.adsdk.lottie.iz.u<T> uVar = new com.bytedance.adsdk.lottie.iz.u<>(izVar, tNr2, tNr, interpolatorU, fNextDouble, null);
            uVar.n = pointFNr3;
            uVar.f4983a = pointFNr4;
            return uVar;
        }
        tNr = tNr2;
        interpolatorU = u;
        com.bytedance.adsdk.lottie.iz.u<T> uVar2 = new com.bytedance.adsdk.lottie.iz.u<>(izVar, tNr2, tNr, interpolatorU, fNextDouble, null);
        uVar2.n = pointFNr3;
        uVar2.f4983a = pointFNr4;
        return uVar2;
    }

    private static Interpolator u(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.pn.n.nr(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.pn.n.nr(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.pn.n.nr(pointF2.x, -1.0f, 1.0f);
        float fNr = com.bytedance.adsdk.lottie.pn.n.nr(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fNr;
        int iU = com.bytedance.adsdk.lottie.pn.a.u(pointF.x, pointF.y, pointF2.x, fNr);
        WeakReference<Interpolator> weakReferenceU = com.bytedance.adsdk.lottie.pn.u() ? null : u(iU);
        Interpolator interpolator = weakReferenceU != null ? weakReferenceU.get() : null;
        if (weakReferenceU == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.lottie.o.u(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.lottie.o.u(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.lottie.pn.u()) {
                try {
                    u(iU, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.iz.u<T> u(JsonReader jsonReader, float f, xw<T> xwVar) throws IOException {
        return new com.bytedance.adsdk.lottie.iz.u<>(xwVar.nr(jsonReader, f));
    }
}
