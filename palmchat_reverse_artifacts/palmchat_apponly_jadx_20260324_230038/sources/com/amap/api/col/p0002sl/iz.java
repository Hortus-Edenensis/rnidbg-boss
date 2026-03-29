package com.amap.api.col.p0002sl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class iz {
    iz c;

    public iz() {
    }

    public void a(boolean z) {
        iz izVar = this.c;
        if (izVar != null) {
            izVar.a(z);
        }
    }

    public abstract boolean a();

    public int b() {
        iz izVar = this.c;
        return Math.min(Integer.MAX_VALUE, izVar != null ? izVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        iz izVar = this.c;
        if (izVar != null ? izVar.c() : true) {
            return a();
        }
        return false;
    }

    public iz(iz izVar) {
        this.c = izVar;
    }

    public void a(int i) {
        iz izVar = this.c;
        if (izVar != null) {
            izVar.a(i);
        }
    }
}
