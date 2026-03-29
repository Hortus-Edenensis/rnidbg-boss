package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import defpackage.ed0;
import defpackage.gk5;
import defpackage.vh;
import defpackage.xe3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class h implements xe3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gk5 f5877a;
    public final a b;

    @Nullable
    public z c;

    @Nullable
    public xe3 d;
    public boolean e = true;
    public boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void g(u uVar);
    }

    public h(a aVar, ed0 ed0Var) {
        this.b = aVar;
        this.f5877a = new gk5(ed0Var);
    }

    public void a(z zVar) {
        if (zVar == this.c) {
            this.d = null;
            this.c = null;
            this.e = true;
        }
    }

    @Override // defpackage.xe3
    public void b(u uVar) {
        xe3 xe3Var = this.d;
        if (xe3Var != null) {
            xe3Var.b(uVar);
            uVar = this.d.getPlaybackParameters();
        }
        this.f5877a.b(uVar);
    }

    public void c(z zVar) throws ExoPlaybackException {
        xe3 xe3Var;
        xe3 mediaClock = zVar.getMediaClock();
        if (mediaClock == null || mediaClock == (xe3Var = this.d)) {
            return;
        }
        if (xe3Var != null) {
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = mediaClock;
        this.c = zVar;
        mediaClock.b(this.f5877a.getPlaybackParameters());
    }

    public void d(long j) {
        this.f5877a.a(j);
    }

    public final boolean e(boolean z) {
        z zVar = this.c;
        return zVar == null || zVar.isEnded() || (!this.c.isReady() && (z || this.c.hasReadStreamToEnd()));
    }

    public void f() {
        this.f = true;
        this.f5877a.c();
    }

    public void g() {
        this.f = false;
        this.f5877a.d();
    }

    @Override // defpackage.xe3
    public u getPlaybackParameters() {
        xe3 xe3Var = this.d;
        return xe3Var != null ? xe3Var.getPlaybackParameters() : this.f5877a.getPlaybackParameters();
    }

    @Override // defpackage.xe3
    public long getPositionUs() {
        return this.e ? this.f5877a.getPositionUs() : ((xe3) vh.e(this.d)).getPositionUs();
    }

    public long h(boolean z) {
        i(z);
        return getPositionUs();
    }

    public final void i(boolean z) {
        if (e(z)) {
            this.e = true;
            if (this.f) {
                this.f5877a.c();
                return;
            }
            return;
        }
        xe3 xe3Var = (xe3) vh.e(this.d);
        long positionUs = xe3Var.getPositionUs();
        if (this.e) {
            if (positionUs < this.f5877a.getPositionUs()) {
                this.f5877a.d();
                return;
            } else {
                this.e = false;
                if (this.f) {
                    this.f5877a.c();
                }
            }
        }
        this.f5877a.a(positionUs);
        u playbackParameters = xe3Var.getPlaybackParameters();
        if (playbackParameters.equals(this.f5877a.getPlaybackParameters())) {
            return;
        }
        this.f5877a.b(playbackParameters);
        this.b.g(playbackParameters);
    }
}
