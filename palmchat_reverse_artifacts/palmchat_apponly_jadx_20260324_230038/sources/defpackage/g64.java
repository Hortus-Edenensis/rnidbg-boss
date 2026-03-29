package defpackage;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class g64 implements os1 {
    public static final ys1 d = new ys1() { // from class: d64
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return g64.e();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qs1 f17671a;
    public dl5 b;
    public boolean c;

    public static /* synthetic */ os1[] e() {
        return new os1[]{new g64()};
    }

    public static gc4 f(gc4 gc4Var) {
        gc4Var.U(0);
        return gc4Var;
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.f17671a = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        vh.i(this.f17671a);
        if (this.b == null) {
            if (!g(ps1Var)) {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
            ps1Var.resetPeekPosition();
        }
        if (!this.c) {
            c06 c06VarTrack = this.f17671a.track(0, 1);
            this.f17671a.endTracks();
            this.b.d(this.f17671a, c06VarTrack);
            this.c = true;
        }
        return this.b.g(ps1Var, vk4Var);
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        try {
            return g(ps1Var);
        } catch (ParserException unused) {
            return false;
        }
    }

    public final boolean g(ps1 ps1Var) throws IOException {
        j64 j64Var = new j64();
        if (j64Var.a(ps1Var, true) && (j64Var.b & 2) == 2) {
            int iMin = Math.min(j64Var.i, 8);
            gc4 gc4Var = new gc4(iMin);
            ps1Var.peekFully(gc4Var.e(), 0, iMin);
            if (nx1.p(f(gc4Var))) {
                this.b = new nx1();
            } else if (vh6.r(f(gc4Var))) {
                this.b = new vh6();
            } else if (n94.o(f(gc4Var))) {
                this.b = new n94();
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        dl5 dl5Var = this.b;
        if (dl5Var != null) {
            dl5Var.m(j, j2);
        }
    }

    @Override // defpackage.os1
    public void release() {
    }
}
