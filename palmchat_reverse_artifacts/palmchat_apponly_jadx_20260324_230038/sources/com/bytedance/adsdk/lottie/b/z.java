package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class z {
    public static com.bytedance.adsdk.lottie.u.nr.a u(JsonReader jsonReader, com.bytedance.adsdk.lottie.iz izVar) throws IOException {
        return new com.bytedance.adsdk.lottie.u.nr.a(izVar, bq.u(jsonReader, izVar, com.bytedance.adsdk.lottie.pn.a.u(), gi.u, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
