package com.opos.exoplayer.core.source;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class MergingMediaSource extends b<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h[] f8282a;
    private final ArrayList<h> b;
    private final c c;
    private h.a d;
    private w e;
    private Object f;
    private int g;
    private IllegalMergeException h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class IllegalMergeException extends com.opos.exoplayer.core.util.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8283a;

        /* JADX INFO: compiled from: SearchBox */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.f8283a = i;
        }

        @Override // com.opos.exoplayer.core.util.c
        public String a() {
            return "IllegalMergeException";
        }
    }

    private IllegalMergeException a(w wVar) {
        int i = this.g;
        int iC = wVar.c();
        if (i == -1) {
            this.g = iC;
            return null;
        }
        if (iC != this.g) {
            return new IllegalMergeException(0);
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void b() {
        super.b();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = null;
        this.b.clear();
        Collections.addAll(this.b, this.f8282a);
    }

    @Override // com.opos.exoplayer.core.source.h
    public g a(h.b bVar, com.opos.exoplayer.core.upstream.b bVar2) {
        int length = this.f8282a.length;
        g[] gVarArr = new g[length];
        for (int i = 0; i < length; i++) {
            gVarArr[i] = this.f8282a[i].a(bVar, bVar2);
        }
        return new s(this.c, gVarArr);
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void a() throws IllegalMergeException {
        IllegalMergeException illegalMergeException = this.h;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.a();
    }

    @Override // com.opos.exoplayer.core.source.b, com.opos.exoplayer.core.source.h
    public void a(com.opos.exoplayer.core.g gVar, boolean z, h.a aVar) {
        super.a(gVar, z, aVar);
        this.d = aVar;
        for (int i = 0; i < this.f8282a.length; i++) {
            a(Integer.valueOf(i), this.f8282a[i]);
        }
    }

    @Override // com.opos.exoplayer.core.source.h
    public void a(g gVar) {
        s sVar = (s) gVar;
        int i = 0;
        while (true) {
            h[] hVarArr = this.f8282a;
            if (i >= hVarArr.length) {
                return;
            }
            hVarArr[i].a(sVar.f8312a[i]);
            i++;
        }
    }

    @Override // com.opos.exoplayer.core.source.b
    public void a(Integer num, h hVar, w wVar, @Nullable Object obj) {
        if (this.h == null) {
            this.h = a(wVar);
        }
        if (this.h != null) {
            return;
        }
        this.b.remove(hVar);
        if (hVar == this.f8282a[0]) {
            this.e = wVar;
            this.f = obj;
        }
        if (this.b.isEmpty()) {
            this.d.a(this, this.e, this.f);
        }
    }
}
