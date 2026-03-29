package com.bytedance.adsdk.lottie.fx;

import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public enum fx {
    JSON(".json"),
    ZIP(".zip");

    public final String fx;

    fx(String str) {
        this.fx = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.fx;
    }

    public String u() {
        return ".temp" + this.fx;
    }
}
