package com.bytedance.adsdk.lottie.model;

import android.graphics.Typeface;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class fx {
    private final float b;
    private final String fx;
    private final String nr;
    private Typeface pn;
    private final String u;

    public fx(String str, String str2, String str3, float f) {
        this.u = str;
        this.nr = str2;
        this.fx = str3;
        this.b = f;
    }

    public Typeface b() {
        return this.pn;
    }

    public String fx() {
        return this.fx;
    }

    public String nr() {
        return this.nr;
    }

    public String u() {
        return this.u;
    }

    public void u(Typeface typeface) {
        this.pn = typeface;
    }
}
