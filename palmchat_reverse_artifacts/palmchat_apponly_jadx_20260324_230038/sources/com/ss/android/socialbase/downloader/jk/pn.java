package com.ss.android.socialbase.downloader.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    private int b = 10;
    private int fx;
    private u nr;
    private u u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        u b;
        u fx;
        long nr;
        long u;

        private u() {
        }
    }

    public long nr(long j, long j2) {
        synchronized (this) {
            u uVar = this.u;
            if (uVar == null) {
                return -1L;
            }
            u uVarU = u(j);
            if (uVarU == null) {
                return -1L;
            }
            long j3 = uVar.u - uVarU.u;
            long j4 = j2 - uVarU.nr;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    public boolean u(long j, long j2) {
        synchronized (this) {
            u uVar = this.u;
            if (uVar != null) {
                if (j >= uVar.u && j2 >= uVar.nr) {
                    u uVar2 = uVar.fx;
                    if (uVar2 != null && j2 - uVar2.nr < 1000) {
                        uVar.u = j;
                        uVar.nr = j2;
                        return true;
                    }
                }
                return false;
            }
            u uVarU = u();
            uVarU.u = j;
            uVarU.nr = j2;
            if (uVar != null) {
                uVarU.fx = uVar;
                uVar.b = uVarU;
            }
            this.u = uVarU;
            return true;
        }
    }

    private u u() {
        u uVar;
        int i = this.fx;
        if (i >= this.b && (uVar = this.nr) != null) {
            u uVar2 = uVar.b;
            uVar.b = null;
            this.nr = uVar2;
            if (uVar2 != null) {
                uVar2.fx = null;
            }
            return uVar;
        }
        this.fx = i + 1;
        return new u();
    }

    private u u(long j) {
        u uVar = this.u;
        u uVar2 = null;
        while (uVar != null && uVar.nr > j) {
            uVar2 = uVar;
            uVar = uVar.fx;
        }
        return (uVar == null || uVar2 == null || uVar == uVar2 || j - uVar.nr >= uVar2.nr - j) ? uVar2 : uVar;
    }
}
