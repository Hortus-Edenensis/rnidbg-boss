package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static com.bytedance.adsdk.lottie.model.u.x b(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.x(u(jsonReader, izVar, wq.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.iz fx(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.iz(dw.u(jsonReader, izVar, com.bytedance.adsdk.lottie.pn.a.u(), d.u, true));
    }

    public static com.bytedance.adsdk.lottie.model.u.jk iz(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.jk(u(jsonReader, com.bytedance.adsdk.lottie.pn.a.u(), izVar, a.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.b nr(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.b(u(jsonReader, izVar, sx.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.n pn(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.n(u(jsonReader, com.bytedance.adsdk.lottie.pn.a.u(), izVar, pb.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.nr u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return u(jsonReader, izVar, true);
    }

    public static com.bytedance.adsdk.lottie.model.u.u x(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.u(u(jsonReader, izVar, x.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.nr u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, boolean z) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.nr(u(jsonReader, z ? com.bytedance.adsdk.lottie.pn.a.u() : 1.0f, izVar, l.u));
    }

    public static com.bytedance.adsdk.lottie.model.u.fx u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, int i) throws IOException {
        return new com.bytedance.adsdk.lottie.model.u.fx(u(jsonReader, izVar, new k(i)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.iz.u<T>> u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar, xw<T> xwVar) throws IOException {
        return dw.u(jsonReader, izVar, 1.0f, xwVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.iz.u<T>> u(JsonReader jsonReader, float f, com.bytedance.adsdk.lottie.iz izVar, xw<T> xwVar) throws IOException {
        return dw.u(jsonReader, izVar, f, xwVar, false);
    }
}
