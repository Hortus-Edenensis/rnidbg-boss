package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class hv5 extends e implements Handler.Callback {

    @Nullable
    public jn5 A;

    @Nullable
    public jn5 B;
    public int C;
    public long E;
    public long F;
    public long G;

    @Nullable
    public final Handler p;
    public final gv5 q;
    public final fn5 r;
    public final f12 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;

    @Nullable
    public m x;

    @Nullable
    public en5 y;

    @Nullable
    public in5 z;

    public hv5(gv5 gv5Var, @Nullable Looper looper) {
        this(gv5Var, looper, fn5.f17566a);
    }

    public final void A() {
        L(new xr0(ImmutableList.of(), D(this.G)));
    }

    public final long B(long j) {
        int nextEventTimeIndex = this.A.getNextEventTimeIndex(j);
        if (nextEventTimeIndex == 0 || this.A.getEventTimeCount() == 0) {
            return this.A.b;
        }
        if (nextEventTimeIndex != -1) {
            return this.A.getEventTime(nextEventTimeIndex - 1);
        }
        return this.A.getEventTime(r2.getEventTimeCount() - 1);
    }

    public final long C() {
        if (this.C == -1) {
            return Long.MAX_VALUE;
        }
        vh.e(this.A);
        if (this.C >= this.A.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.A.getEventTime(this.C);
    }

    public final long D(long j) {
        vh.g(j != -9223372036854775807L);
        vh.g(this.F != -9223372036854775807L);
        return j - this.F;
    }

    public final void E(SubtitleDecoderException subtitleDecoderException) {
        y53.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.x, subtitleDecoderException);
        A();
        J();
    }

    public final void F() {
        this.v = true;
        this.y = this.r.b((m) vh.e(this.x));
    }

    public final void G(xr0 xr0Var) {
        this.q.onCues(xr0Var.f22036a);
        this.q.d(xr0Var);
    }

    public final void H() {
        this.z = null;
        this.C = -1;
        jn5 jn5Var = this.A;
        if (jn5Var != null) {
            jn5Var.l();
            this.A = null;
        }
        jn5 jn5Var2 = this.B;
        if (jn5Var2 != null) {
            jn5Var2.l();
            this.B = null;
        }
    }

    public final void I() {
        H();
        ((en5) vh.e(this.y)).release();
        this.y = null;
        this.w = 0;
    }

    public final void J() {
        I();
        F();
    }

    public void K(long j) {
        vh.g(isCurrentStreamFinal());
        this.E = j;
    }

    public final void L(xr0 xr0Var) {
        Handler handler = this.p;
        if (handler != null) {
            handler.obtainMessage(0, xr0Var).sendToTarget();
        } else {
            G(xr0Var);
        }
    }

    @Override // com.google.android.exoplayer2.a0
    public int a(m mVar) {
        if (this.r.a(mVar)) {
            return qv4.a(mVar.H == 0 ? 4 : 2);
        }
        return fp3.r(mVar.l) ? qv4.a(1) : qv4.a(0);
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        G((xr0) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isEnded() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e
    public void o() {
        this.x = null;
        this.E = -9223372036854775807L;
        A();
        this.F = -9223372036854775807L;
        this.G = -9223372036854775807L;
        I();
    }

    @Override // com.google.android.exoplayer2.e
    public void q(long j, boolean z) {
        this.G = j;
        A();
        this.t = false;
        this.u = false;
        this.E = -9223372036854775807L;
        if (this.w != 0) {
            J();
        } else {
            H();
            ((en5) vh.e(this.y)).flush();
        }
    }

    @Override // com.google.android.exoplayer2.z
    public void render(long j, long j2) throws DecoderException {
        boolean z;
        this.G = j;
        if (isCurrentStreamFinal()) {
            long j3 = this.E;
            if (j3 != -9223372036854775807L && j >= j3) {
                H();
                this.u = true;
            }
        }
        if (this.u) {
            return;
        }
        if (this.B == null) {
            ((en5) vh.e(this.y)).setPositionUs(j);
            try {
                this.B = ((en5) vh.e(this.y)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                E(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.A != null) {
            long jC = C();
            z = false;
            while (jC <= j) {
                this.C++;
                jC = C();
                z = true;
            }
        } else {
            z = false;
        }
        jn5 jn5Var = this.B;
        if (jn5Var != null) {
            if (jn5Var.g()) {
                if (!z && C() == Long.MAX_VALUE) {
                    if (this.w == 2) {
                        J();
                    } else {
                        H();
                        this.u = true;
                    }
                }
            } else if (jn5Var.b <= j) {
                jn5 jn5Var2 = this.A;
                if (jn5Var2 != null) {
                    jn5Var2.l();
                }
                this.C = jn5Var.getNextEventTimeIndex(j);
                this.A = jn5Var;
                this.B = null;
                z = true;
            }
        }
        if (z) {
            vh.e(this.A);
            L(new xr0(this.A.getCues(j), D(B(j))));
        }
        if (this.w == 2) {
            return;
        }
        while (!this.t) {
            try {
                in5 in5VarDequeueInputBuffer = this.z;
                if (in5VarDequeueInputBuffer == null) {
                    in5VarDequeueInputBuffer = ((en5) vh.e(this.y)).dequeueInputBuffer();
                    if (in5VarDequeueInputBuffer == null) {
                        return;
                    } else {
                        this.z = in5VarDequeueInputBuffer;
                    }
                }
                if (this.w == 1) {
                    in5VarDequeueInputBuffer.k(4);
                    ((en5) vh.e(this.y)).queueInputBuffer(in5VarDequeueInputBuffer);
                    this.z = null;
                    this.w = 2;
                    return;
                }
                int iX = x(this.s, in5VarDequeueInputBuffer, 0);
                if (iX == -4) {
                    if (in5VarDequeueInputBuffer.g()) {
                        this.t = true;
                        this.v = false;
                    } else {
                        m mVar = this.s.b;
                        if (mVar == null) {
                            return;
                        }
                        in5VarDequeueInputBuffer.i = mVar.p;
                        in5VarDequeueInputBuffer.n();
                        this.v &= !in5VarDequeueInputBuffer.i();
                    }
                    if (!this.v) {
                        ((en5) vh.e(this.y)).queueInputBuffer(in5VarDequeueInputBuffer);
                        this.z = null;
                    }
                } else if (iX == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                E(e2);
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e
    public void w(m[] mVarArr, long j, long j2) {
        this.F = j2;
        this.x = mVarArr[0];
        if (this.y != null) {
            this.w = 1;
        } else {
            F();
        }
    }

    public hv5(gv5 gv5Var, @Nullable Looper looper, fn5 fn5Var) {
        super(3);
        this.q = (gv5) vh.e(gv5Var);
        this.p = looper == null ? null : g86.v(looper, this);
        this.r = fn5Var;
        this.s = new f12();
        this.E = -9223372036854775807L;
        this.F = -9223372036854775807L;
        this.G = -9223372036854775807L;
    }
}
