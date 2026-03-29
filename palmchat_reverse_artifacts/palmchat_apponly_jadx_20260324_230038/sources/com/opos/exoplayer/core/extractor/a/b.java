package com.opos.exoplayer.core.extractor.a;

import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final n f8157a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends m {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.exoplayer.core.m, com.opos.exoplayer.core.util.c
        public String a() {
            return "UnsupportedFormatException";
        }
    }

    public b(n nVar) {
        this.f8157a = nVar;
    }

    public final void a(p pVar, long j) {
        if (a(pVar)) {
            b(pVar, j);
        }
    }

    public abstract boolean a(p pVar);

    public abstract void b(p pVar, long j);
}
