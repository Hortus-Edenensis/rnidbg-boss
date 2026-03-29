package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.model.nr.my;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class b {
    private final double b;
    private final double fx;
    private final String iz;
    private final char nr;
    private final String pn;
    private final List<my> u;

    public b(List<my> list, char c, double d, double d2, String str, String str2) {
        this.u = list;
        this.nr = c;
        this.fx = d;
        this.b = d2;
        this.pn = str;
        this.iz = str2;
    }

    public static int u(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public int hashCode() {
        return u(this.nr, this.iz, this.pn);
    }

    public double nr() {
        return this.b;
    }

    public List<my> u() {
        return this.u;
    }
}
