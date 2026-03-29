package com.opos.exoplayer.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f8279a = new s(0);
    public final int b;

    public s(int i) {
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && s.class == obj.getClass() && this.b == ((s) obj).b;
    }

    public int hashCode() {
        return this.b;
    }
}
