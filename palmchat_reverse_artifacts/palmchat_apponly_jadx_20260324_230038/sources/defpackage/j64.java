package defpackage;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class j64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18335a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public final int[] j = new int[255];
    public final gc4 k = new gc4(255);

    public boolean a(ps1 ps1Var, boolean z) throws IOException {
        b();
        this.k.Q(27);
        if (!rs1.b(ps1Var, this.k.e(), 0, 27, z) || this.k.J() != 1332176723) {
            return false;
        }
        int iH = this.k.H();
        this.f18335a = iH;
        if (iH != 0) {
            if (z) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.b = this.k.H();
        this.c = this.k.v();
        this.d = this.k.x();
        this.e = this.k.x();
        this.f = this.k.x();
        int iH2 = this.k.H();
        this.g = iH2;
        this.h = iH2 + 27;
        this.k.Q(iH2);
        if (!rs1.b(ps1Var, this.k.e(), 0, this.g, z)) {
            return false;
        }
        for (int i = 0; i < this.g; i++) {
            this.j[i] = this.k.H();
            this.i += this.j[i];
        }
        return true;
    }

    public void b() {
        this.f18335a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean c(ps1 ps1Var) throws IOException {
        return d(ps1Var, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.skip(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(ps1 ps1Var, long j) throws IOException {
        vh.a(ps1Var.getPosition() == ps1Var.getPeekPosition());
        this.k.Q(4);
        while (true) {
            if ((j != -1 && ps1Var.getPosition() + 4 >= j) || !rs1.b(ps1Var, this.k.e(), 0, 4, true)) {
                break;
            }
            this.k.U(0);
            if (this.k.J() == 1332176723) {
                ps1Var.resetPeekPosition();
                return true;
            }
            ps1Var.skipFully(1);
        }
    }
}
