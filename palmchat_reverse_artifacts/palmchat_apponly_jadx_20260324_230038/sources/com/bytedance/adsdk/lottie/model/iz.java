package com.bytedance.adsdk.lottie.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {
    private final String fx;
    public final float nr;
    public final float u;

    public iz(String str, float f, float f2) {
        this.fx = str;
        this.nr = f2;
        this.u = f;
    }

    public boolean u(String str) {
        if (this.fx.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.fx.endsWith("\r")) {
            String str2 = this.fx;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
