package defpackage;

import android.net.Uri;
import defpackage.j26;
import defpackage.v45;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f2 implements os1 {
    public static final ys1 d = new ys1() { // from class: c2
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return f2.e();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2 f17413a = new g2();
    public final gc4 b = new gc4(2786);
    public boolean c;

    public static /* synthetic */ os1[] e() {
        return new os1[]{new f2()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.f17413a.b(qs1Var, new j26.d(0, 1));
        qs1Var.endTracks();
        qs1Var.d(new v45.b(-9223372036854775807L));
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int i = ps1Var.read(this.b.e(), 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.b.U(0);
        this.b.T(i);
        if (!this.c) {
            this.f17413a.packetStarted(0L, 4);
            this.c = true;
        }
        this.f17413a.a(this.b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0037, code lost:
    
        r8.resetPeekPosition();
        r4 = r4 + 1;
     */
    @Override // defpackage.os1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(ps1 ps1Var) throws IOException {
        gc4 gc4Var = new gc4(10);
        int i = 0;
        while (true) {
            ps1Var.peekFully(gc4Var.e(), 0, 10);
            gc4Var.U(0);
            if (gc4Var.K() != 4801587) {
                break;
            }
            gc4Var.V(3);
            int iG = gc4Var.G();
            i += iG + 10;
            ps1Var.advancePeekPosition(iG);
        }
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition(i);
        int i2 = i;
        while (true) {
            int i3 = 0;
            while (true) {
                ps1Var.peekFully(gc4Var.e(), 0, 6);
                gc4Var.U(0);
                if (gc4Var.N() != 2935) {
                    break;
                }
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                int iG2 = h2.g(gc4Var.e());
                if (iG2 == -1) {
                    return false;
                }
                ps1Var.advancePeekPosition(iG2 - 6);
            }
            ps1Var.advancePeekPosition(i2);
        }
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.c = false;
        this.f17413a.seek();
    }

    @Override // defpackage.os1
    public void release() {
    }
}
