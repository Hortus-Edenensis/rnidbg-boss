package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.i;
import defpackage.d25;
import defpackage.g86;
import defpackage.or1;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import defpackage.w9;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i.b f5956a;
    public final long b;
    public final w9 c;
    public i d;
    public h e;

    @Nullable
    public h.a f;

    @Nullable
    public a g;
    public boolean h;
    public long i = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(i.b bVar, IOException iOException);

        void b(i.b bVar);
    }

    public f(i.b bVar, w9 w9Var, long j) {
        this.f5956a = bVar;
        this.c = w9Var;
        this.b = j;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        return ((h) g86.j(this.e)).a(j, w45Var);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.i;
        if (j3 == -9223372036854775807L || j != this.b) {
            j2 = j;
        } else {
            this.i = -9223372036854775807L;
            j2 = j3;
        }
        return ((h) g86.j(this.e)).b(or1VarArr, zArr, d25VarArr, zArr2, j2);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        h hVar = this.e;
        return hVar != null && hVar.continueLoading(j);
    }

    public void d(i.b bVar) {
        long j = j(this.b);
        h hVarC = ((i) vh.e(this.d)).c(bVar, this.c, j);
        this.e = hVarC;
        if (this.f != null) {
            hVarC.g(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
        ((h) g86.j(this.e)).discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void f(h hVar) {
        ((h.a) g86.j(this.f)).f(this);
        a aVar = this.g;
        if (aVar != null) {
            aVar.b(this.f5956a);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.f = aVar;
        h hVar = this.e;
        if (hVar != null) {
            hVar.g(this, j(this.b));
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return ((h) g86.j(this.e)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return ((h) g86.j(this.e)).getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return ((h) g86.j(this.e)).getTrackGroups();
    }

    public long h() {
        return this.i;
    }

    public long i() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        h hVar = this.e;
        return hVar != null && hVar.isLoading();
    }

    public final long j(long j) {
        long j2 = this.i;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(h hVar) {
        ((h.a) g86.j(this.f)).c(this);
    }

    public void l(long j) {
        this.i = j;
    }

    public void m() {
        if (this.e != null) {
            ((i) vh.e(this.d)).f(this.e);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        try {
            h hVar = this.e;
            if (hVar != null) {
                hVar.maybeThrowPrepareError();
            } else {
                i iVar = this.d;
                if (iVar != null) {
                    iVar.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e) {
            a aVar = this.g;
            if (aVar == null) {
                throw e;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            aVar.a(this.f5956a, e);
        }
    }

    public void n(i iVar) {
        vh.g(this.d == null);
        this.d = iVar;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return ((h) g86.j(this.e)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        ((h) g86.j(this.e)).reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        return ((h) g86.j(this.e)).seekToUs(j);
    }
}
