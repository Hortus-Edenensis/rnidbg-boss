package defpackage;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.huawei.hms.ads.ld;
import defpackage.v45;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class aa implements os1 {
    public static final int[] r;
    public static final int u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1183a;
    public final int b;
    public boolean c;
    public long d;
    public int e;
    public int f;
    public boolean g;
    public long h;
    public int i;
    public int j;
    public long k;
    public qs1 l;
    public c06 m;
    public v45 n;
    public boolean o;
    public static final ys1 p = new ys1() { // from class: x9
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return aa.l();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };
    public static final int[] q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final byte[] s = g86.o0("#!AMR\n");
    public static final byte[] t = g86.o0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        r = iArr;
        u = iArr[8];
    }

    public aa() {
        this(0);
    }

    public static int f(int i, long j) {
        return (int) (((((long) i) * 8) * 1000000) / j);
    }

    public static /* synthetic */ os1[] l() {
        return new os1[]{new aa()};
    }

    public static boolean o(ps1 ps1Var, byte[] bArr) throws IOException {
        ps1Var.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        ps1Var.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.l = qs1Var;
        this.m = qs1Var.track(0, 1);
        qs1Var.endTracks();
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        e();
        if (ps1Var.getPosition() == 0 && !q(ps1Var)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        m();
        int iR = r(ps1Var);
        n(ps1Var.getLength(), iR);
        return iR;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return q(ps1Var);
    }

    public final void e() {
        vh.i(this.m);
        g86.j(this.l);
    }

    public final v45 g(long j, boolean z) {
        return new sm0(j, this.h, f(this.i, 20000L), this.i, z);
    }

    public final int h(int i) throws ParserException {
        if (j(i)) {
            return this.c ? r[i] : q[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.c ? ld.I : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.createForMalformedContainer(sb.toString(), null);
    }

    public final boolean i(int i) {
        return !this.c && (i < 12 || i > 14);
    }

    public final boolean j(int i) {
        return i >= 0 && i <= 15 && (k(i) || i(i));
    }

    public final boolean k(int i) {
        return this.c && (i < 10 || i > 13);
    }

    public final void m() {
        if (this.o) {
            return;
        }
        this.o = true;
        boolean z = this.c;
        this.m.b(new m.b().g0(z ? "audio/amr-wb" : "audio/3gpp").Y(u).J(1).h0(z ? 16000 : 8000).G());
    }

    public final void n(long j, int i) {
        int i2;
        if (this.g) {
            return;
        }
        int i3 = this.b;
        if ((i3 & 1) == 0 || j == -1 || !((i2 = this.i) == -1 || i2 == this.e)) {
            v45.b bVar = new v45.b(-9223372036854775807L);
            this.n = bVar;
            this.l.d(bVar);
            this.g = true;
            return;
        }
        if (this.j >= 20 || i == -1) {
            v45 v45VarG = g(j, (i3 & 2) != 0);
            this.n = v45VarG;
            this.l.d(v45VarG);
            this.g = true;
        }
    }

    public final int p(ps1 ps1Var) throws IOException {
        ps1Var.resetPeekPosition();
        ps1Var.peekFully(this.f1183a, 0, 1);
        byte b = this.f1183a[0];
        if ((b & 131) <= 0) {
            return h((b >> 3) & 15);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b), null);
    }

    public final boolean q(ps1 ps1Var) throws IOException {
        byte[] bArr = s;
        if (o(ps1Var, bArr)) {
            this.c = false;
            ps1Var.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = t;
        if (!o(ps1Var, bArr2)) {
            return false;
        }
        this.c = true;
        ps1Var.skipFully(bArr2.length);
        return true;
    }

    public final int r(ps1 ps1Var) throws IOException {
        if (this.f == 0) {
            try {
                int iP = p(ps1Var);
                this.e = iP;
                this.f = iP;
                if (this.i == -1) {
                    this.h = ps1Var.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    this.j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iC = this.m.c(ps1Var, this.f, true);
        if (iC == -1) {
            return -1;
        }
        int i = this.f - iC;
        this.f = i;
        if (i > 0) {
            return 0;
        }
        this.m.e(this.k + this.d, 1, this.e, 0, null);
        this.d += 20000;
        return 0;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            v45 v45Var = this.n;
            if (v45Var instanceof sm0) {
                this.k = ((sm0) v45Var).b(j);
                return;
            }
        }
        this.k = 0L;
    }

    public aa(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
        this.f1183a = new byte[1];
        this.i = -1;
    }

    @Override // defpackage.os1
    public void release() {
    }
}
