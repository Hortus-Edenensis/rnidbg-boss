package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import defpackage.as3;
import defpackage.dq2;
import defpackage.y45;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class or3 implements os1 {
    public static final ys1 u = new ys1() { // from class: ir3
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return or3.n();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };
    public static final dq2.a v = new dq2.a() { // from class: lr3
        @Override // dq2.a
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return or3.o(i, i2, i3, i4, i5);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19818a;
    public final long b;
    public final gc4 c;
    public final as3.a d;
    public final m52 e;
    public final eq2 f;
    public final c06 g;
    public qs1 h;
    public c06 i;
    public c06 j;
    public int k;

    @Nullable
    public Metadata l;
    public long m;
    public long n;
    public long o;
    public int p;
    public y45 q;
    public boolean r;
    public boolean s;
    public long t;

    public or3() {
        this(0);
    }

    public static long k(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return g86.H0(Long.parseLong(textInformationFrame.values.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static int l(gc4 gc4Var, int i) {
        if (gc4Var.g() >= i + 4) {
            gc4Var.U(i);
            int iQ = gc4Var.q();
            if (iQ == 1483304551 || iQ == 1231971951) {
                return iQ;
            }
        }
        if (gc4Var.g() < 40) {
            return 0;
        }
        gc4Var.U(36);
        return gc4Var.q() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean m(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public static /* synthetic */ os1[] n() {
        return new os1[]{new or3()};
    }

    public static /* synthetic */ boolean o(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    @Nullable
    public static wp3 p(@Nullable Metadata metadata, long j) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof MlltFrame) {
                return wp3.a(j, (MlltFrame) entry, k(metadata));
            }
        }
        return null;
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.h = qs1Var;
        c06 c06VarTrack = qs1Var.track(0, 1);
        this.i = c06VarTrack;
        this.j = c06VarTrack;
        this.h.endTracks();
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        f();
        int iS = s(ps1Var);
        if (iS == -1 && (this.q instanceof os2)) {
            long jH = h(this.n);
            if (this.q.getDurationUs() != jH) {
                ((os2) this.q).c(jH);
                this.h.d(this.q);
            }
        }
        return iS;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return u(ps1Var, true);
    }

    public final void f() {
        vh.i(this.i);
        g86.j(this.h);
    }

    public final y45 g(ps1 ps1Var) throws IOException {
        long jK;
        long dataEndPosition;
        y45 y45VarQ = q(ps1Var);
        wp3 wp3VarP = p(this.l, ps1Var.getPosition());
        if (this.r) {
            return new y45.a();
        }
        if ((this.f19818a & 4) != 0) {
            if (wp3VarP != null) {
                jK = wp3VarP.getDurationUs();
                dataEndPosition = wp3VarP.getDataEndPosition();
            } else if (y45VarQ != null) {
                jK = y45VarQ.getDurationUs();
                dataEndPosition = y45VarQ.getDataEndPosition();
            } else {
                jK = k(this.l);
                dataEndPosition = -1;
            }
            y45VarQ = new os2(jK, ps1Var.getPosition(), dataEndPosition);
        } else if (wp3VarP != null) {
            y45VarQ = wp3VarP;
        } else if (y45VarQ == null) {
            y45VarQ = null;
        }
        if (y45VarQ == null || !(y45VarQ.isSeekable() || (this.f19818a & 1) == 0)) {
            return j(ps1Var, (this.f19818a & 2) != 0);
        }
        return y45VarQ;
    }

    public final long h(long j) {
        return this.m + ((j * 1000000) / ((long) this.d.d));
    }

    public void i() {
        this.r = true;
    }

    public final y45 j(ps1 ps1Var, boolean z) throws IOException {
        ps1Var.peekFully(this.c.e(), 0, 4);
        this.c.U(0);
        this.d.a(this.c.q());
        return new tm0(ps1Var.getLength(), ps1Var.getPosition(), this.d, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final y45 q(ps1 ps1Var) throws IOException {
        int i;
        gc4 gc4Var = new gc4(this.d.c);
        ps1Var.peekFully(gc4Var.e(), 0, this.d.c);
        as3.a aVar = this.d;
        if ((aVar.f1565a & 1) != 0) {
            i = aVar.e != 1 ? 36 : 21;
        } else if (aVar.e == 1) {
            i = 13;
        }
        int iL = l(gc4Var, i);
        if (iL != 1483304551 && iL != 1231971951) {
            if (iL != 1447187017) {
                ps1Var.resetPeekPosition();
                return null;
            }
            k96 k96VarA = k96.a(ps1Var.getLength(), ps1Var.getPosition(), this.d, gc4Var);
            ps1Var.skipFully(this.d.c);
            return k96VarA;
        }
        bp6 bp6VarA = bp6.a(ps1Var.getLength(), ps1Var.getPosition(), this.d, gc4Var);
        if (bp6VarA != null && !this.e.a()) {
            ps1Var.resetPeekPosition();
            ps1Var.advancePeekPosition(i + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID);
            ps1Var.peekFully(this.c.e(), 0, 3);
            this.c.U(0);
            this.e.d(this.c.K());
        }
        ps1Var.skipFully(this.d.c);
        return (bp6VarA == null || bp6VarA.isSeekable() || iL != 1231971951) ? bp6VarA : j(ps1Var, false);
    }

    public final boolean r(ps1 ps1Var) throws IOException {
        y45 y45Var = this.q;
        if (y45Var != null) {
            long dataEndPosition = y45Var.getDataEndPosition();
            if (dataEndPosition != -1 && ps1Var.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !ps1Var.peekFully(this.c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final int s(ps1 ps1Var) throws IOException {
        if (this.k == 0) {
            try {
                u(ps1Var, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.q == null) {
            y45 y45VarG = g(ps1Var);
            this.q = y45VarG;
            this.h.d(y45VarG);
            this.j.b(new m.b().g0(this.d.b).Y(4096).J(this.d.e).h0(this.d.d).P(this.e.f19139a).Q(this.e.b).Z((this.f19818a & 8) != 0 ? null : this.l).G());
            this.o = ps1Var.getPosition();
        } else if (this.o != 0) {
            long position = ps1Var.getPosition();
            long j = this.o;
            if (position < j) {
                ps1Var.skipFully((int) (j - position));
            }
        }
        return t(ps1Var);
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        y45 y45Var = this.q;
        if (!(y45Var instanceof os2) || ((os2) y45Var).a(j2)) {
            return;
        }
        this.s = true;
        this.j = this.g;
    }

    public final int t(ps1 ps1Var) throws IOException {
        if (this.p == 0) {
            ps1Var.resetPeekPosition();
            if (r(ps1Var)) {
                return -1;
            }
            this.c.U(0);
            int iQ = this.c.q();
            if (!m(iQ, this.k) || as3.j(iQ) == -1) {
                ps1Var.skipFully(1);
                this.k = 0;
                return 0;
            }
            this.d.a(iQ);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.getTimeUs(ps1Var.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.getTimeUs(0L);
                }
            }
            as3.a aVar = this.d;
            this.p = aVar.c;
            y45 y45Var = this.q;
            if (y45Var instanceof os2) {
                os2 os2Var = (os2) y45Var;
                os2Var.b(h(this.n + ((long) aVar.g)), ps1Var.getPosition() + ((long) this.d.c));
                if (this.s && os2Var.a(this.t)) {
                    this.s = false;
                    this.j = this.i;
                }
            }
        }
        int iC = this.j.c(ps1Var, this.p, true);
        if (iC == -1) {
            return -1;
        }
        int i = this.p - iC;
        this.p = i;
        if (i > 0) {
            return 0;
        }
        this.j.e(h(this.n), 1, this.d.c, 0, null);
        this.n += (long) this.d.g;
        this.p = 0;
        return 0;
    }

    public final boolean u(ps1 ps1Var, boolean z) throws IOException {
        int i;
        int peekPosition;
        int iJ;
        int i2 = z ? 32768 : 131072;
        ps1Var.resetPeekPosition();
        if (ps1Var.getPosition() == 0) {
            Metadata metadataA = this.f.a(ps1Var, (this.f19818a & 8) == 0 ? null : v);
            this.l = metadataA;
            if (metadataA != null) {
                this.e.c(metadataA);
            }
            peekPosition = (int) ps1Var.getPeekPosition();
            if (!z) {
                ps1Var.skipFully(peekPosition);
            }
            i = 0;
        } else {
            i = 0;
            peekPosition = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!r(ps1Var)) {
                this.c.U(0);
                int iQ = this.c.q();
                if ((i == 0 || m(iQ, i)) && (iJ = as3.j(iQ)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(iQ);
                        i = iQ;
                    }
                    ps1Var.advancePeekPosition(iJ - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z) {
                            return false;
                        }
                        throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                    }
                    if (z) {
                        ps1Var.resetPeekPosition();
                        ps1Var.advancePeekPosition(peekPosition + i5);
                    } else {
                        ps1Var.skipFully(1);
                    }
                    i4 = i5;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ps1Var.skipFully(peekPosition + i4);
        } else {
            ps1Var.resetPeekPosition();
        }
        this.k = i;
        return true;
    }

    public or3(int i) {
        this(i, -9223372036854775807L);
    }

    public or3(int i, long j) {
        this.f19818a = (i & 2) != 0 ? i | 1 : i;
        this.b = j;
        this.c = new gc4(10);
        this.d = new as3.a();
        this.e = new m52();
        this.m = -9223372036854775807L;
        this.f = new eq2();
        pi1 pi1Var = new pi1();
        this.g = pi1Var;
        this.j = pi1Var;
    }

    @Override // defpackage.os1
    public void release() {
    }
}
