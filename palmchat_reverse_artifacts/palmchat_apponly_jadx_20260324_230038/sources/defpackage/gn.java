package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import defpackage.v45;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gn implements os1 {
    public int c;
    public hn e;
    public long h;

    @Nullable
    public c60 i;
    public int m;
    public boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f17753a = new gc4(12);
    public final c b = new c();
    public qs1 d = new oi1();
    public c60[] g = new c60[0];
    public long k = -1;
    public long l = -1;
    public int j = -1;
    public long f = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements v45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17754a;

        public b(long j) {
            this.f17754a = j;
        }

        @Override // defpackage.v45
        public long getDurationUs() {
            return this.f17754a;
        }

        @Override // defpackage.v45
        public v45.a getSeekPoints(long j) {
            v45.a aVarI = gn.this.g[0].i(j);
            for (int i = 1; i < gn.this.g.length; i++) {
                v45.a aVarI2 = gn.this.g[i].i(j);
                if (aVarI2.f21356a.b < aVarI.f21356a.b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // defpackage.v45
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17755a;
        public int b;
        public int c;

        public c() {
        }

        public void a(gc4 gc4Var) {
            this.f17755a = gc4Var.u();
            this.b = gc4Var.u();
            this.c = 0;
        }

        public void b(gc4 gc4Var) throws ParserException {
            a(gc4Var);
            if (this.f17755a == 1414744396) {
                this.c = gc4Var.u();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.f17755a, null);
        }
    }

    public static void e(ps1 ps1Var) throws IOException {
        if ((ps1Var.getPosition() & 1) == 1) {
            ps1Var.skipFully(1);
        }
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.c = 0;
        this.d = qs1Var;
        this.h = -1L;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        if (l(ps1Var, vk4Var)) {
            return 1;
        }
        switch (this.c) {
            case 0:
                if (!d(ps1Var)) {
                    throw ParserException.createForMalformedContainer("AVI Header List not found", null);
                }
                ps1Var.skipFully(12);
                this.c = 1;
                return 0;
            case 1:
                ps1Var.readFully(this.f17753a.e(), 0, 12);
                this.f17753a.U(0);
                this.b.b(this.f17753a);
                c cVar = this.b;
                if (cVar.c == 1819436136) {
                    this.j = cVar.b;
                    this.c = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.b.c, null);
            case 2:
                int i = this.j - 4;
                gc4 gc4Var = new gc4(i);
                ps1Var.readFully(gc4Var.e(), 0, i);
                g(gc4Var);
                this.c = 3;
                return 0;
            case 3:
                if (this.k != -1) {
                    long position = ps1Var.getPosition();
                    long j = this.k;
                    if (position != j) {
                        this.h = j;
                        return 0;
                    }
                }
                ps1Var.peekFully(this.f17753a.e(), 0, 12);
                ps1Var.resetPeekPosition();
                this.f17753a.U(0);
                this.b.a(this.f17753a);
                int iU = this.f17753a.u();
                int i2 = this.b.f17755a;
                if (i2 == 1179011410) {
                    ps1Var.skipFully(12);
                    return 0;
                }
                if (i2 != 1414744396 || iU != 1769369453) {
                    this.h = ps1Var.getPosition() + ((long) this.b.b) + 8;
                    return 0;
                }
                long position2 = ps1Var.getPosition();
                this.k = position2;
                this.l = position2 + ((long) this.b.b) + 8;
                if (!this.n) {
                    if (((hn) vh.e(this.e)).a()) {
                        this.c = 4;
                        this.h = this.l;
                        return 0;
                    }
                    this.d.d(new v45.b(this.f));
                    this.n = true;
                }
                this.h = ps1Var.getPosition() + 12;
                this.c = 6;
                return 0;
            case 4:
                ps1Var.readFully(this.f17753a.e(), 0, 8);
                this.f17753a.U(0);
                int iU2 = this.f17753a.u();
                int iU3 = this.f17753a.u();
                if (iU2 == 829973609) {
                    this.c = 5;
                    this.m = iU3;
                } else {
                    this.h = ps1Var.getPosition() + ((long) iU3);
                }
                return 0;
            case 5:
                gc4 gc4Var2 = new gc4(this.m);
                ps1Var.readFully(gc4Var2.e(), 0, this.m);
                h(gc4Var2);
                this.c = 6;
                this.h = this.k;
                return 0;
            case 6:
                return k(ps1Var);
            default:
                throw new AssertionError();
        }
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        ps1Var.peekFully(this.f17753a.e(), 0, 12);
        this.f17753a.U(0);
        if (this.f17753a.u() != 1179011410) {
            return false;
        }
        this.f17753a.V(4);
        return this.f17753a.u() == 541677121;
    }

    @Nullable
    public final c60 f(int i) {
        for (c60 c60Var : this.g) {
            if (c60Var.j(i)) {
                return c60Var;
            }
        }
        return null;
    }

    public final void g(gc4 gc4Var) throws IOException {
        l33 l33VarC = l33.c(AviExtractor.FOURCC_hdrl, gc4Var);
        if (l33VarC.getType() != 1819436136) {
            throw ParserException.createForMalformedContainer("Unexpected header list type " + l33VarC.getType(), null);
        }
        hn hnVar = (hn) l33VarC.b(hn.class);
        if (hnVar == null) {
            throw ParserException.createForMalformedContainer("AviHeader not found", null);
        }
        this.e = hnVar;
        this.f = ((long) hnVar.c) * ((long) hnVar.f17997a);
        ArrayList arrayList = new ArrayList();
        o46<fn> it = l33VarC.f18897a.iterator();
        int i = 0;
        while (it.hasNext()) {
            fn next = it.next();
            if (next.getType() == 1819440243) {
                int i2 = i + 1;
                c60 c60VarJ = j((l33) next, i);
                if (c60VarJ != null) {
                    arrayList.add(c60VarJ);
                }
                i = i2;
            }
        }
        this.g = (c60[]) arrayList.toArray(new c60[0]);
        this.d.endTracks();
    }

    public final void h(gc4 gc4Var) {
        long jI = i(gc4Var);
        while (gc4Var.a() >= 16) {
            int iU = gc4Var.u();
            int iU2 = gc4Var.u();
            long jU = ((long) gc4Var.u()) + jI;
            gc4Var.u();
            c60 c60VarF = f(iU);
            if (c60VarF != null) {
                if ((iU2 & 16) == 16) {
                    c60VarF.b(jU);
                }
                c60VarF.k();
            }
        }
        for (c60 c60Var : this.g) {
            c60Var.c();
        }
        this.n = true;
        this.d.d(new b(this.f));
    }

    public final long i(gc4 gc4Var) {
        if (gc4Var.a() < 16) {
            return 0L;
        }
        int iF = gc4Var.f();
        gc4Var.V(8);
        long jU = gc4Var.u();
        long j = this.k;
        long j2 = jU <= j ? j + 8 : 0L;
        gc4Var.U(iF);
        return j2;
    }

    @Nullable
    public final c60 j(l33 l33Var, int i) {
        in inVar = (in) l33Var.b(in.class);
        bl5 bl5Var = (bl5) l33Var.b(bl5.class);
        if (inVar == null) {
            y53.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (bl5Var == null) {
            y53.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = inVar.a();
        m mVar = bl5Var.f1748a;
        m.b bVarB = mVar.b();
        bVarB.T(i);
        int i2 = inVar.f;
        if (i2 != 0) {
            bVarB.Y(i2);
        }
        cl5 cl5Var = (cl5) l33Var.b(cl5.class);
        if (cl5Var != null) {
            bVarB.W(cl5Var.f2010a);
        }
        int iK = fp3.k(mVar.l);
        if (iK != 1 && iK != 2) {
            return null;
        }
        c06 c06VarTrack = this.d.track(i, iK);
        c06VarTrack.b(bVarB.G());
        c60 c60Var = new c60(i, iK, jA, inVar.e, c06VarTrack);
        this.f = jA;
        return c60Var;
    }

    public final int k(ps1 ps1Var) throws IOException {
        if (ps1Var.getPosition() >= this.l) {
            return -1;
        }
        c60 c60Var = this.i;
        if (c60Var == null) {
            e(ps1Var);
            ps1Var.peekFully(this.f17753a.e(), 0, 12);
            this.f17753a.U(0);
            int iU = this.f17753a.u();
            if (iU == 1414744396) {
                this.f17753a.U(8);
                ps1Var.skipFully(this.f17753a.u() != 1769369453 ? 8 : 12);
                ps1Var.resetPeekPosition();
                return 0;
            }
            int iU2 = this.f17753a.u();
            if (iU == 1263424842) {
                this.h = ps1Var.getPosition() + ((long) iU2) + 8;
                return 0;
            }
            ps1Var.skipFully(8);
            ps1Var.resetPeekPosition();
            c60 c60VarF = f(iU);
            if (c60VarF == null) {
                this.h = ps1Var.getPosition() + ((long) iU2);
                return 0;
            }
            c60VarF.n(iU2);
            this.i = c60VarF;
        } else if (c60Var.m(ps1Var)) {
            this.i = null;
        }
        return 0;
    }

    public final boolean l(ps1 ps1Var, vk4 vk4Var) throws IOException {
        boolean z;
        if (this.h != -1) {
            long position = ps1Var.getPosition();
            long j = this.h;
            if (j < position || j > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + position) {
                vk4Var.f21468a = j;
                z = true;
            } else {
                ps1Var.skipFully((int) (j - position));
                z = false;
            }
        } else {
            z = false;
        }
        this.h = -1L;
        return z;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.h = -1L;
        this.i = null;
        for (c60 c60Var : this.g) {
            c60Var.o(j);
        }
        if (j != 0) {
            this.c = 6;
        } else if (this.g.length == 0) {
            this.c = 0;
        } else {
            this.c = 3;
        }
    }

    @Override // defpackage.os1
    public void release() {
    }
}
