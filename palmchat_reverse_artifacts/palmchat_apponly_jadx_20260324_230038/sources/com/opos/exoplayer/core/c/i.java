package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.s;
import com.opos.exoplayer.core.source.p;
import com.opos.exoplayer.core.util.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f8129a;
    public final boolean[] b;
    public final g c;
    public final Object d;
    public final s[] e;

    public i(p pVar, boolean[] zArr, g gVar, Object obj, s[] sVarArr) {
        this.f8129a = pVar;
        this.b = zArr;
        this.c = gVar;
        this.d = obj;
        this.e = sVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null || iVar.c.f8127a != this.c.f8127a) {
            return false;
        }
        for (int i = 0; i < this.c.f8127a; i++) {
            if (!a(iVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i) {
        return iVar != null && this.b[i] == iVar.b[i] && y.a(this.c.a(i), iVar.c.a(i)) && y.a(this.e[i], iVar.e[i]);
    }
}
