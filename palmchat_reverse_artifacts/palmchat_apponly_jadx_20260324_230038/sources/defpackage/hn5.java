package defpackage;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class hn5 implements os1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final en5 f18001a;
    public final m d;
    public qs1 g;
    public c06 h;
    public int i;
    public final sr0 b = new sr0();
    public final gc4 c = new gc4();
    public final List<Long> e = new ArrayList();
    public final List<gc4> f = new ArrayList();
    public int j = 0;
    public long k = -9223372036854775807L;

    public hn5(en5 en5Var, m mVar) {
        this.f18001a = en5Var;
        this.d = mVar.b().g0("text/x-exoplayer-cues").K(mVar.l).G();
    }

    public final void a() throws IOException, DecoderException {
        try {
            in5 in5VarDequeueInputBuffer = this.f18001a.dequeueInputBuffer();
            while (in5VarDequeueInputBuffer == null) {
                Thread.sleep(5L);
                in5VarDequeueInputBuffer = this.f18001a.dequeueInputBuffer();
            }
            in5VarDequeueInputBuffer.m(this.i);
            in5VarDequeueInputBuffer.c.put(this.c.e(), 0, this.i);
            in5VarDequeueInputBuffer.c.limit(this.i);
            this.f18001a.queueInputBuffer(in5VarDequeueInputBuffer);
            jn5 jn5VarDequeueOutputBuffer = this.f18001a.dequeueOutputBuffer();
            while (jn5VarDequeueOutputBuffer == null) {
                Thread.sleep(5L);
                jn5VarDequeueOutputBuffer = this.f18001a.dequeueOutputBuffer();
            }
            for (int i = 0; i < jn5VarDequeueOutputBuffer.getEventTimeCount(); i++) {
                byte[] bArrA = this.b.a(jn5VarDequeueOutputBuffer.getCues(jn5VarDequeueOutputBuffer.getEventTime(i)));
                this.e.add(Long.valueOf(jn5VarDequeueOutputBuffer.getEventTime(i)));
                this.f.add(new gc4(bArrA));
            }
            jn5VarDequeueOutputBuffer.l();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        vh.g(this.j == 0);
        this.g = qs1Var;
        this.h = qs1Var.track(0, 3);
        this.g.endTracks();
        this.g.d(new ns2(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.h.b(this.d);
        this.j = 1;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException, DecoderException {
        int i = this.j;
        vh.g((i == 0 || i == 5) ? false : true);
        if (this.j == 1) {
            this.c.Q(ps1Var.getLength() != -1 ? ku2.e(ps1Var.getLength()) : 1024);
            this.i = 0;
            this.j = 2;
        }
        if (this.j == 2 && e(ps1Var)) {
            a();
            g();
            this.j = 4;
        }
        if (this.j == 3 && f(ps1Var)) {
            g();
            this.j = 4;
        }
        return this.j == 4 ? -1 : 0;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return true;
    }

    public final boolean e(ps1 ps1Var) throws IOException {
        int iB = this.c.b();
        int i = this.i;
        if (iB == i) {
            this.c.c(i + 1024);
        }
        int i2 = ps1Var.read(this.c.e(), this.i, this.c.b() - this.i);
        if (i2 != -1) {
            this.i += i2;
        }
        long length = ps1Var.getLength();
        return (length != -1 && ((long) this.i) == length) || i2 == -1;
    }

    public final boolean f(ps1 ps1Var) throws IOException {
        return ps1Var.skip((ps1Var.getLength() > (-1L) ? 1 : (ps1Var.getLength() == (-1L) ? 0 : -1)) != 0 ? ku2.e(ps1Var.getLength()) : 1024) == -1;
    }

    public final void g() {
        vh.i(this.h);
        vh.g(this.e.size() == this.f.size());
        long j = this.k;
        for (int iG = j == -9223372036854775807L ? 0 : g86.g(this.e, Long.valueOf(j), true, true); iG < this.f.size(); iG++) {
            gc4 gc4Var = this.f.get(iG);
            gc4Var.U(0);
            int length = gc4Var.e().length;
            this.h.d(gc4Var, length);
            this.h.e(this.e.get(iG).longValue(), 1, length, 0, null);
        }
    }

    @Override // defpackage.os1
    public void release() {
        if (this.j == 5) {
            return;
        }
        this.f18001a.release();
        this.j = 5;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        int i = this.j;
        vh.g((i == 0 || i == 5) ? false : true);
        this.k = j2;
        if (this.j == 2) {
            this.j = 1;
        }
        if (this.j == 4) {
            this.j = 3;
        }
    }
}
