package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.s;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class pn {
    private static final pn u = new pn();
    private final s<String, com.bytedance.adsdk.lottie.iz> nr = new s<>(20);

    public static pn u() {
        return u;
    }

    public com.bytedance.adsdk.lottie.iz u(String str) {
        if (str == null) {
            return null;
        }
        return this.nr.u(str);
    }

    public void u(String str, com.bytedance.adsdk.lottie.iz izVar) {
        if (str == null) {
            return;
        }
        this.nr.u(str, izVar);
    }

    public void u(int i) {
        this.nr.u(i);
    }
}
