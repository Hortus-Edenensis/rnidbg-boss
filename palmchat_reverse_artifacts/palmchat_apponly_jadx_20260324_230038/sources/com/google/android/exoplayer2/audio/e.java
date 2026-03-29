package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.muxer.MuxerUtil;
import defpackage.em;
import defpackage.g86;
import defpackage.vh;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class e {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public long G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5839a;
    public final long[] b;

    @Nullable
    public AudioTrack c;
    public int d;
    public int e;

    @Nullable
    public em f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;

    @Nullable
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public int w;
    public int x;
    public long y;
    public long z;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onInvalidLatency(long j);

        void onPositionAdvancing(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    public e(a aVar) {
        this.f5839a = (a) vh.e(aVar);
        if (g86.f17680a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public static boolean n(int i) {
        return g86.f17680a < 23 && (i == 5 || i == 6);
    }

    public final boolean a() {
        return this.h && ((AudioTrack) vh.e(this.c)).getPlayState() == 2 && d() == 0;
    }

    public int b(long j) {
        return this.e - ((int) (j - (d() * ((long) this.d))));
    }

    public long c(boolean z) {
        long jE;
        if (((AudioTrack) vh.e(this.c)).getPlayState() == 3) {
            l();
        }
        long jNanoTime = System.nanoTime() / 1000;
        em emVar = (em) vh.e(this.f);
        boolean zD = emVar.d();
        if (zD) {
            jE = g86.T0(emVar.b(), this.g) + g86.b0(jNanoTime - emVar.c(), this.j);
        } else {
            jE = this.x == 0 ? e() : g86.b0(this.l + jNanoTime, this.j);
            if (!z) {
                jE = Math.max(0L, jE - this.o);
            }
        }
        if (this.E != zD) {
            this.G = this.D;
            this.F = this.C;
        }
        long j = jNanoTime - this.G;
        if (j < 1000000) {
            long jB0 = this.F + g86.b0(j, this.j);
            long j2 = (j * 1000) / 1000000;
            jE = ((jE * j2) + ((1000 - j2) * jB0)) / 1000;
        }
        if (!this.k) {
            long j3 = this.C;
            if (jE > j3) {
                this.k = true;
                this.f5839a.onPositionAdvancing(System.currentTimeMillis() - g86.m1(g86.g0(g86.m1(jE - j3), this.j)));
            }
        }
        this.D = jNanoTime;
        this.C = jE;
        this.E = zD;
        return jE;
    }

    public final long d() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.y;
        if (j != -9223372036854775807L) {
            return Math.min(this.B, this.A + g86.B(g86.b0((jElapsedRealtime * 1000) - j, this.j), this.g));
        }
        if (jElapsedRealtime - this.s >= 5) {
            u(jElapsedRealtime);
            this.s = jElapsedRealtime;
        }
        return this.t + (this.u << 32);
    }

    public final long e() {
        return g86.T0(d(), this.g);
    }

    public void f(long j) {
        this.A = d();
        this.y = SystemClock.elapsedRealtime() * 1000;
        this.B = j;
    }

    public boolean g(long j) {
        return j > g86.B(c(false), this.g) || a();
    }

    public boolean h() {
        return ((AudioTrack) vh.e(this.c)).getPlayState() == 3;
    }

    public boolean i(long j) {
        return this.z != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.z >= 200;
    }

    public boolean j(long j) {
        int playState = ((AudioTrack) vh.e(this.c)).getPlayState();
        if (this.h) {
            if (playState == 2) {
                this.p = false;
                return false;
            }
            if (playState == 1 && d() == 0) {
                return false;
            }
        }
        boolean z = this.p;
        boolean zG = g(j);
        this.p = zG;
        if (z && !zG && playState != 1) {
            this.f5839a.onUnderrun(this.e, g86.m1(this.i));
        }
        return true;
    }

    public final void k(long j) {
        em emVar = (em) vh.e(this.f);
        if (emVar.e(j)) {
            long jC = emVar.c();
            long jB = emVar.b();
            long jE = e();
            if (Math.abs(jC - j) > 5000000) {
                this.f5839a.onSystemTimeUsMismatch(jB, jC, j, jE);
                emVar.f();
            } else if (Math.abs(g86.T0(jB, this.g) - jE) <= 5000000) {
                emVar.a();
            } else {
                this.f5839a.onPositionFramesMismatch(jB, jC, j, jE);
                emVar.f();
            }
        }
    }

    public final void l() {
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.m >= 30000) {
            long jE = e();
            if (jE != 0) {
                this.b[this.w] = g86.g0(jE, this.j) - jNanoTime;
                this.w = (this.w + 1) % 10;
                int i = this.x;
                if (i < 10) {
                    this.x = i + 1;
                }
                this.m = jNanoTime;
                this.l = 0L;
                int i2 = 0;
                while (true) {
                    int i3 = this.x;
                    if (i2 >= i3) {
                        break;
                    }
                    this.l += this.b[i2] / ((long) i3);
                    i2++;
                }
            } else {
                return;
            }
        }
        if (this.h) {
            return;
        }
        k(jNanoTime);
        m(jNanoTime);
    }

    public final void m(long j) {
        Method method;
        if (!this.q || (method = this.n) == null || j - this.r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) g86.j((Integer) method.invoke(vh.e(this.c), new Object[0]))).intValue()) * 1000) - this.i;
            this.o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.o = jMax;
            if (jMax > 5000000) {
                this.f5839a.onInvalidLatency(jMax);
                this.o = 0L;
            }
        } catch (Exception unused) {
            this.n = null;
        }
        this.r = j;
    }

    public boolean o() {
        q();
        if (this.y != -9223372036854775807L) {
            return false;
        }
        ((em) vh.e(this.f)).g();
        return true;
    }

    public void p() {
        q();
        this.c = null;
        this.f = null;
    }

    public final void q() {
        this.l = 0L;
        this.x = 0;
        this.w = 0;
        this.m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.k = false;
    }

    public void r(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new em(audioTrack);
        this.g = audioTrack.getSampleRate();
        this.h = z && n(i);
        boolean zZ0 = g86.z0(i);
        this.q = zZ0;
        this.i = zZ0 ? g86.T0(i3 / i2, this.g) : -9223372036854775807L;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.p = false;
        this.y = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }

    public void s(float f) {
        this.j = f;
        em emVar = this.f;
        if (emVar != null) {
            emVar.g();
        }
        q();
    }

    public void t() {
        ((em) vh.e(this.f)).g();
    }

    public final void u(long j) {
        AudioTrack audioTrack = (AudioTrack) vh.e(this.c);
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.v = this.t;
            }
            playbackHeadPosition += this.v;
        }
        if (g86.f17680a <= 29) {
            if (playbackHeadPosition == 0 && this.t > 0 && playState == 3) {
                if (this.z == -9223372036854775807L) {
                    this.z = j;
                    return;
                }
                return;
            }
            this.z = -9223372036854775807L;
        }
        if (this.t > playbackHeadPosition) {
            this.u++;
        }
        this.t = playbackHeadPosition;
    }
}
