package com.google.android.exoplayer2;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import defpackage.bk4;
import defpackage.d25;
import defpackage.f12;
import defpackage.mv4;
import defpackage.qv4;
import defpackage.tv4;
import defpackage.vh;
import defpackage.xe3;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class e implements z, a0 {
    public final int b;

    @Nullable
    public tv4 d;
    public int e;
    public bk4 f;
    public int g;

    @Nullable
    public d25 h;

    @Nullable
    public m[] i;
    public long j;
    public long k;
    public boolean m;
    public boolean n;

    @Nullable
    @GuardedBy("lock")
    public a0.a o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5868a = new Object();
    public final f12 c = new f12();
    public long l = Long.MIN_VALUE;

    public e(int i) {
        this.b = i;
    }

    @Override // com.google.android.exoplayer2.z
    public final void c(m[] mVarArr, d25 d25Var, long j, long j2) throws ExoPlaybackException {
        vh.g(!this.m);
        this.h = d25Var;
        if (this.l == Long.MIN_VALUE) {
            this.l = j;
        }
        this.i = mVarArr;
        this.j = j2;
        w(mVarArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.a0
    public final void clearListener() {
        synchronized (this.f5868a) {
            this.o = null;
        }
    }

    @Override // com.google.android.exoplayer2.z
    public final void d(int i, bk4 bk4Var) {
        this.e = i;
        this.f = bk4Var;
    }

    @Override // com.google.android.exoplayer2.z
    public final void disable() {
        vh.g(this.g == 1);
        this.c.a();
        this.g = 0;
        this.h = null;
        this.i = null;
        this.m = false;
        o();
    }

    @Override // com.google.android.exoplayer2.a0
    public final void e(a0.a aVar) {
        synchronized (this.f5868a) {
            this.o = aVar;
        }
    }

    @Override // com.google.android.exoplayer2.z
    public final void f(tv4 tv4Var, m[] mVarArr, d25 d25Var, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException {
        vh.g(this.g == 0);
        this.d = tv4Var;
        this.g = 1;
        p(z, z2);
        c(mVarArr, d25Var, j2, j3);
        y(j, z);
    }

    public final ExoPlaybackException g(Throwable th, @Nullable m mVar, int i) {
        return h(th, mVar, false, i);
    }

    @Override // com.google.android.exoplayer2.z
    @Nullable
    public xe3 getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.z
    public final long getReadingPositionUs() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.z
    public final int getState() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.z
    @Nullable
    public final d25 getStream() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public final int getTrackType() {
        return this.b;
    }

    public final ExoPlaybackException h(Throwable th, @Nullable m mVar, boolean z, int i) {
        int i2;
        if (mVar == null || this.n) {
            i2 = 4;
        } else {
            this.n = true;
            try {
                int iF = qv4.f(a(mVar));
                this.n = false;
                i2 = iF;
            } catch (ExoPlaybackException unused) {
                this.n = false;
                i2 = 4;
            } catch (Throwable th2) {
                this.n = false;
                throw th2;
            }
        }
        return ExoPlaybackException.createForRenderer(th, getName(), k(), mVar, i2, z, i);
    }

    @Override // com.google.android.exoplayer2.z
    public final boolean hasReadStreamToEnd() {
        return this.l == Long.MIN_VALUE;
    }

    public final tv4 i() {
        return (tv4) vh.e(this.d);
    }

    @Override // com.google.android.exoplayer2.z
    public final boolean isCurrentStreamFinal() {
        return this.m;
    }

    public final f12 j() {
        this.c.a();
        return this.c;
    }

    public final int k() {
        return this.e;
    }

    public final bk4 l() {
        return (bk4) vh.e(this.f);
    }

    public final m[] m() {
        return (m[]) vh.e(this.i);
    }

    @Override // com.google.android.exoplayer2.z
    public final void maybeThrowStreamError() throws IOException {
        ((d25) vh.e(this.h)).maybeThrowError();
    }

    public final boolean n() {
        return hasReadStreamToEnd() ? this.m : ((d25) vh.e(this.h)).isReady();
    }

    public abstract void o();

    public abstract void q(long j, boolean z) throws ExoPlaybackException;

    @Override // com.google.android.exoplayer2.z
    public final void release() {
        vh.g(this.g == 0);
        r();
    }

    @Override // com.google.android.exoplayer2.z
    public final void reset() {
        vh.g(this.g == 0);
        this.c.a();
        t();
    }

    @Override // com.google.android.exoplayer2.z
    public final void resetPosition(long j) throws ExoPlaybackException {
        y(j, false);
    }

    public final void s() {
        a0.a aVar;
        synchronized (this.f5868a) {
            aVar = this.o;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.google.android.exoplayer2.z
    public final void setCurrentStreamFinal() {
        this.m = true;
    }

    @Override // com.google.android.exoplayer2.z
    public /* synthetic */ void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        mv4.a(this, f, f2);
    }

    @Override // com.google.android.exoplayer2.z
    public final void start() throws ExoPlaybackException {
        vh.g(this.g == 1);
        this.g = 2;
        u();
    }

    @Override // com.google.android.exoplayer2.z
    public final void stop() {
        vh.g(this.g == 2);
        this.g = 1;
        v();
    }

    @Override // com.google.android.exoplayer2.a0
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public abstract void w(m[] mVarArr, long j, long j2) throws ExoPlaybackException;

    public final int x(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int iC = ((d25) vh.e(this.h)).c(f12Var, decoderInputBuffer, i);
        if (iC == -4) {
            if (decoderInputBuffer.g()) {
                this.l = Long.MIN_VALUE;
                return this.m ? -4 : -3;
            }
            long j = decoderInputBuffer.e + this.j;
            decoderInputBuffer.e = j;
            this.l = Math.max(this.l, j);
        } else if (iC == -5) {
            m mVar = (m) vh.e(f12Var.b);
            if (mVar.p != Long.MAX_VALUE) {
                f12Var.b = mVar.b().k0(mVar.p + this.j).G();
            }
        }
        return iC;
    }

    public final void y(long j, boolean z) throws ExoPlaybackException {
        this.m = false;
        this.k = j;
        this.l = j;
        q(j, z);
    }

    public int z(long j) {
        return ((d25) vh.e(this.h)).skipData(j - this.j);
    }

    @Override // com.google.android.exoplayer2.z
    public final a0 getCapabilities() {
        return this;
    }

    public void r() {
    }

    public void t() {
    }

    public void u() throws ExoPlaybackException {
    }

    public void v() {
    }

    @Override // com.google.android.exoplayer2.w.b
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    public void p(boolean z, boolean z2) throws ExoPlaybackException {
    }
}
