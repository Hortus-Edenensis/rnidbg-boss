package defpackage;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import defpackage.j26;
import defpackage.v45;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c8 implements os1 {
    public static final ys1 m = new ys1() { // from class: z7
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return c8.h();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1913a;
    public final d8 b;
    public final gc4 c;
    public final gc4 d;
    public final fc4 e;
    public qs1 f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public c8() {
        this(0);
    }

    public static int f(int i, long j) {
        return (int) (((((long) i) * 8) * 1000000) / j);
    }

    public static /* synthetic */ os1[] h() {
        return new os1[]{new c8()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.f = qs1Var;
        this.b.b(qs1Var, new j26.d(0, 1));
        qs1Var.endTracks();
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        vh.i(this.f);
        long length = ps1Var.getLength();
        int i = this.f1913a;
        if (((i & 2) == 0 && ((i & 1) == 0 || length == -1)) ? false : true) {
            e(ps1Var);
        }
        int i2 = ps1Var.read(this.c.e(), 0, 2048);
        boolean z = i2 == -1;
        i(length, z);
        if (z) {
            return -1;
        }
        this.c.U(0);
        this.c.T(i2);
        if (!this.k) {
            this.b.packetStarted(this.g, 4);
            this.k = true;
        }
        this.b.a(this.c);
        return 0;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        int iJ = j(ps1Var);
        int i = iJ;
        int i2 = 0;
        int i3 = 0;
        do {
            ps1Var.peekFully(this.d.e(), 0, 2);
            this.d.U(0);
            if (d8.j(this.d.N())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                ps1Var.peekFully(this.d.e(), 0, 4);
                this.e.p(14);
                int iH = this.e.h(13);
                if (iH <= 6) {
                    i++;
                    ps1Var.resetPeekPosition();
                    ps1Var.advancePeekPosition(i);
                } else {
                    ps1Var.advancePeekPosition(iH - 6);
                    i3 += iH;
                }
            } else {
                i++;
                ps1Var.resetPeekPosition();
                ps1Var.advancePeekPosition(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iJ < 8192);
        return false;
    }

    public final void e(ps1 ps1Var) throws IOException {
        int iH;
        if (this.j) {
            return;
        }
        this.i = -1;
        ps1Var.resetPeekPosition();
        long j = 0;
        if (ps1Var.getPosition() == 0) {
            j(ps1Var);
        }
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (!ps1Var.peekFully(this.d.e(), 0, 2, true)) {
                    break;
                }
                this.d.U(0);
                if (!d8.j(this.d.N())) {
                    break;
                }
                if (!ps1Var.peekFully(this.d.e(), 0, 4, true)) {
                    break;
                }
                this.e.p(14);
                iH = this.e.h(13);
                if (iH <= 6) {
                    this.j = true;
                    throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
                }
                j += (long) iH;
                i2++;
                if (i2 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (ps1Var.advancePeekPosition(iH - 6, true));
        i = i2;
        ps1Var.resetPeekPosition();
        if (i > 0) {
            this.i = (int) (j / ((long) i));
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    public final v45 g(long j, boolean z) {
        return new sm0(j, this.h, f(this.i, this.b.h()), this.i, z);
    }

    public final void i(long j, boolean z) {
        if (this.l) {
            return;
        }
        boolean z2 = (this.f1913a & 1) != 0 && this.i > 0;
        if (z2 && this.b.h() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.b.h() == -9223372036854775807L) {
            this.f.d(new v45.b(-9223372036854775807L));
        } else {
            this.f.d(g(j, (this.f1913a & 2) != 0));
        }
        this.l = true;
    }

    public final int j(ps1 ps1Var) throws IOException {
        int i = 0;
        while (true) {
            ps1Var.peekFully(this.d.e(), 0, 10);
            this.d.U(0);
            if (this.d.K() != 4801587) {
                break;
            }
            this.d.V(3);
            int iG = this.d.G();
            i += iG + 10;
            ps1Var.advancePeekPosition(iG);
        }
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.k = false;
        this.b.seek();
        this.g = j2;
    }

    public c8(int i) {
        this.f1913a = (i & 2) != 0 ? i | 1 : i;
        this.b = new d8(true);
        this.c = new gc4(2048);
        this.i = -1;
        this.h = -1L;
        gc4 gc4Var = new gc4(10);
        this.d = gc4Var;
        this.e = new fc4(gc4Var.e());
    }

    @Override // defpackage.os1
    public void release() {
    }
}
