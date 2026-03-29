package com.bytedance.adsdk.lottie.b;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class sx implements xw<Integer> {
    public static final sx u = new sx();

    private sx() {
    }

    @Override // com.bytedance.adsdk.lottie.b.xw
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Integer nr(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(bg.nr(jsonReader) * f));
    }
}
