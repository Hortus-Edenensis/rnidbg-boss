package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l implements xw<Float> {
    public static final l u = new l();

    private l() {
    }

    @Override // com.bytedance.adsdk.lottie.b.xw
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Float nr(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(bg.nr(jsonReader) * f);
    }
}
