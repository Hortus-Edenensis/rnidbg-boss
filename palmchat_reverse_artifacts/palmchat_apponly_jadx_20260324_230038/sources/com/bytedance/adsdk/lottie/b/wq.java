package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class wq implements xw<com.bytedance.adsdk.lottie.iz.b> {
    public static final wq u = new wq();

    private wq() {
    }

    @Override // com.bytedance.adsdk.lottie.b.xw
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.iz.b nr(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.lottie.iz.b((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
