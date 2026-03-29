package com.bytedance.adsdk.nr.nr.u;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class u {
    private Object[] nr;
    private String u;

    public Object[] nr() {
        return this.nr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.u + "', args=" + Arrays.toString(this.nr) + '}';
    }

    public String u() {
        return this.u;
    }

    public void u(String str) {
        this.u = str;
    }

    public void u(Object[] objArr) {
        this.nr = objArr;
    }
}
