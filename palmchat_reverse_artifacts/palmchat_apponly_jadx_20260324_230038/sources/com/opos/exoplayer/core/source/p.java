package com.opos.exoplayer.core.source;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f8304a = new p(new o[0]);
    public final int b;
    private final o[] c;
    private int d;

    public p(o... oVarArr) {
        this.c = oVarArr;
        this.b = oVarArr.length;
    }

    public int a(o oVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] == oVar) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.b == pVar.b && Arrays.equals(this.c, pVar.c);
    }

    public int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.c);
        }
        return this.d;
    }

    public o a(int i) {
        return this.c[i];
    }
}
