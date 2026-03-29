package defpackage;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import defpackage.j26;
import defpackage.v45;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class i26 implements os1 {
    public static final ys1 t = new ys1() { // from class: e26
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return i26.v();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18091a;
    public final int b;
    public final List<jy5> c;
    public final gc4 d;
    public final SparseIntArray e;
    public final j26.c f;
    public final SparseArray<j26> g;
    public final SparseBooleanArray h;
    public final SparseBooleanArray i;
    public final d26 j;
    public c26 k;
    public qs1 l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Nullable
    public j26 q;
    public int r;
    public int s;

    public i26() {
        this(0);
    }

    public static /* synthetic */ int j(i26 i26Var) {
        int i = i26Var.m;
        i26Var.m = i + 1;
        return i;
    }

    public static /* synthetic */ os1[] v() {
        return new os1[]{new i26()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.l = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        long length = ps1Var.getLength();
        if (this.n) {
            if (((length == -1 || this.f18091a == 2) ? false : true) && !this.j.d()) {
                return this.j.e(ps1Var, vk4Var, this.s);
            }
            w(length);
            if (this.p) {
                this.p = false;
                seek(0L, 0L);
                if (ps1Var.getPosition() != 0) {
                    vk4Var.f21468a = 0L;
                    return 1;
                }
            }
            c26 c26Var = this.k;
            if (c26Var != null && c26Var.d()) {
                return this.k.c(ps1Var, vk4Var);
            }
        }
        if (!t(ps1Var)) {
            return -1;
        }
        int iU = u();
        int iG = this.d.g();
        if (iU > iG) {
            return 0;
        }
        int iQ = this.d.q();
        if ((8388608 & iQ) != 0) {
            this.d.U(iU);
            return 0;
        }
        int i = ((4194304 & iQ) != 0 ? 1 : 0) | 0;
        int i2 = (2096896 & iQ) >> 8;
        boolean z = (iQ & 32) != 0;
        j26 j26Var = (iQ & 16) != 0 ? this.g.get(i2) : null;
        if (j26Var == null) {
            this.d.U(iU);
            return 0;
        }
        if (this.f18091a != 2) {
            int i3 = iQ & 15;
            int i4 = this.e.get(i2, i3 - 1);
            this.e.put(i2, i3);
            if (i4 == i3) {
                this.d.U(iU);
                return 0;
            }
            if (i3 != ((i4 + 1) & 15)) {
                j26Var.seek();
            }
        }
        if (z) {
            int iH = this.d.H();
            i |= (this.d.H() & 64) != 0 ? 2 : 0;
            this.d.V(iH - 1);
        }
        boolean z2 = this.n;
        if (y(i2)) {
            this.d.T(iU);
            j26Var.a(this.d, i);
            this.d.T(iG);
        }
        if (this.f18091a != 2 && !z2 && this.n && length != -1) {
            this.p = true;
        }
        this.d.U(iU);
        return 0;
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        boolean z;
        byte[] bArrE = this.d.e();
        ps1Var.peekFully(bArrE, 0, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                }
                if (bArrE[(i2 * 188) + i] != 71) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                ps1Var.skipFully(i);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        c26 c26Var;
        vh.g(this.f18091a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            jy5 jy5Var = this.c.get(i);
            boolean z = jy5Var.e() == -9223372036854775807L;
            if (!z) {
                long jC = jy5Var.c();
                z = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
            }
            if (z) {
                jy5Var.h(j2);
            }
        }
        if (j2 != 0 && (c26Var = this.k) != null) {
            c26Var.h(j2);
        }
        this.d.Q(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.g.valueAt(i2).seek();
        }
        this.r = 0;
    }

    public final boolean t(ps1 ps1Var) throws IOException {
        byte[] bArrE = this.d.e();
        if (9400 - this.d.f() < 188) {
            int iA = this.d.a();
            if (iA > 0) {
                System.arraycopy(bArrE, this.d.f(), bArrE, 0, iA);
            }
            this.d.S(bArrE, iA);
        }
        while (this.d.a() < 188) {
            int iG = this.d.g();
            int i = ps1Var.read(bArrE, iG, 9400 - iG);
            if (i == -1) {
                return false;
            }
            this.d.T(iG + i);
        }
        return true;
    }

    public final int u() throws ParserException {
        int iF = this.d.f();
        int iG = this.d.g();
        int iA = k26.a(this.d.e(), iF, iG);
        this.d.U(iA);
        int i = iA + 188;
        if (i > iG) {
            int i2 = this.r + (iA - iF);
            this.r = i2;
            if (this.f18091a == 2 && i2 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.r = 0;
        }
        return i;
    }

    public final void w(long j) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.j.b() == -9223372036854775807L) {
            this.l.d(new v45.b(this.j.b()));
            return;
        }
        c26 c26Var = new c26(this.j.c(), this.j.b(), j, this.s, this.b);
        this.k = c26Var;
        this.l.d(c26Var.b());
    }

    public final void x() {
        this.h.clear();
        this.g.clear();
        SparseArray<j26> sparseArrayCreateInitialPayloadReaders = this.f.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i = 0; i < size; i++) {
            this.g.put(sparseArrayCreateInitialPayloadReaders.keyAt(i), sparseArrayCreateInitialPayloadReaders.valueAt(i));
        }
        this.g.put(0, new m45(new a()));
        this.q = null;
    }

    public final boolean y(int i) {
        return this.f18091a == 2 || this.n || !this.i.get(i, false);
    }

    public i26(int i) {
        this(1, i, 112800);
    }

    public i26(int i, int i2, int i3) {
        this(i, new jy5(0L), new ka1(i2), i3);
    }

    public i26(int i, jy5 jy5Var, j26.c cVar) {
        this(i, jy5Var, cVar, 112800);
    }

    public i26(int i, jy5 jy5Var, j26.c cVar, int i2) {
        this.f = (j26.c) vh.e(cVar);
        this.b = i2;
        this.f18091a = i;
        if (i != 1 && i != 2) {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(jy5Var);
        } else {
            this.c = Collections.singletonList(jy5Var);
        }
        this.d = new gc4(new byte[AVMDLDataLoader.KeyIsIgnorePlayInfo], 0);
        this.h = new SparseBooleanArray();
        this.i = new SparseBooleanArray();
        this.g = new SparseArray<>();
        this.e = new SparseIntArray();
        this.j = new d26(i2);
        this.l = qs1.c0;
        this.s = -1;
        x();
    }

    @Override // defpackage.os1
    public void release() {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements l45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fc4 f18092a = new fc4(new byte[4]);

        public a() {
        }

        @Override // defpackage.l45
        public void a(gc4 gc4Var) {
            if (gc4Var.H() == 0 && (gc4Var.H() & 128) != 0) {
                gc4Var.V(6);
                int iA = gc4Var.a() / 4;
                for (int i = 0; i < iA; i++) {
                    gc4Var.k(this.f18092a, 4);
                    int iH = this.f18092a.h(16);
                    this.f18092a.r(3);
                    if (iH == 0) {
                        this.f18092a.r(13);
                    } else {
                        int iH2 = this.f18092a.h(13);
                        if (i26.this.g.get(iH2) == null) {
                            i26.this.g.put(iH2, new m45(i26.this.new b(iH2)));
                            i26.j(i26.this);
                        }
                    }
                }
                if (i26.this.f18091a != 2) {
                    i26.this.g.remove(0);
                }
            }
        }

        @Override // defpackage.l45
        public void b(jy5 jy5Var, qs1 qs1Var, j26.d dVar) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements l45 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fc4 f18093a = new fc4(new byte[5]);
        public final SparseArray<j26> b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        @Override // defpackage.l45
        public void a(gc4 gc4Var) {
            jy5 jy5Var;
            if (gc4Var.H() != 2) {
                return;
            }
            if (i26.this.f18091a == 1 || i26.this.f18091a == 2 || i26.this.m == 1) {
                jy5Var = (jy5) i26.this.c.get(0);
            } else {
                jy5Var = new jy5(((jy5) i26.this.c.get(0)).c());
                i26.this.c.add(jy5Var);
            }
            if ((gc4Var.H() & 128) == 0) {
                return;
            }
            gc4Var.V(1);
            int iN = gc4Var.N();
            int i = 3;
            gc4Var.V(3);
            gc4Var.k(this.f18093a, 2);
            this.f18093a.r(3);
            int i2 = 13;
            i26.this.s = this.f18093a.h(13);
            gc4Var.k(this.f18093a, 2);
            int i3 = 4;
            this.f18093a.r(4);
            gc4Var.V(this.f18093a.h(12));
            if (i26.this.f18091a == 2 && i26.this.q == null) {
                j26.b bVar = new j26.b(21, null, null, g86.f);
                i26 i26Var = i26.this;
                i26Var.q = i26Var.f.a(21, bVar);
                if (i26.this.q != null) {
                    i26.this.q.b(jy5Var, i26.this.l, new j26.d(iN, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int iA = gc4Var.a();
            while (iA > 0) {
                gc4Var.k(this.f18093a, 5);
                int iH = this.f18093a.h(8);
                this.f18093a.r(i);
                int iH2 = this.f18093a.h(i2);
                this.f18093a.r(i3);
                int iH3 = this.f18093a.h(12);
                j26.b bVarC = c(gc4Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.f18314a;
                }
                iA -= iH3 + 5;
                int i4 = i26.this.f18091a == 2 ? iH : iH2;
                if (!i26.this.h.get(i4)) {
                    j26 j26VarA = (i26.this.f18091a == 2 && iH == 21) ? i26.this.q : i26.this.f.a(iH, bVarC);
                    if (i26.this.f18091a != 2 || iH2 < this.c.get(i4, 8192)) {
                        this.c.put(i4, iH2);
                        this.b.put(i4, j26VarA);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.c.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.c.keyAt(i5);
                int iValueAt = this.c.valueAt(i5);
                i26.this.h.put(iKeyAt, true);
                i26.this.i.put(iValueAt, true);
                j26 j26VarValueAt = this.b.valueAt(i5);
                if (j26VarValueAt != null) {
                    if (j26VarValueAt != i26.this.q) {
                        j26VarValueAt.b(jy5Var, i26.this.l, new j26.d(iN, iKeyAt, 8192));
                    }
                    i26.this.g.put(iValueAt, j26VarValueAt);
                }
            }
            if (i26.this.f18091a == 2) {
                if (i26.this.n) {
                    return;
                }
                i26.this.l.endTracks();
                i26.this.m = 0;
                i26.this.n = true;
                return;
            }
            i26.this.g.remove(this.d);
            i26 i26Var2 = i26.this;
            i26Var2.m = i26Var2.f18091a == 1 ? 0 : i26.this.m - 1;
            if (i26.this.m == 0) {
                i26.this.l.endTracks();
                i26.this.n = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final j26.b c(gc4 gc4Var, int i) {
            int iF = gc4Var.f();
            int i2 = i + iF;
            int i3 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (gc4Var.f() < i2) {
                int iH = gc4Var.H();
                int iF2 = gc4Var.f() + gc4Var.H();
                if (iF2 > i2) {
                    break;
                }
                if (iH == 5) {
                    long J = gc4Var.J();
                    if (J == 1094921523) {
                        i3 = 129;
                    } else if (J == 1161904947) {
                        i3 = 135;
                    } else if (J == 1094921524) {
                        i3 = 172;
                    } else if (J == 1212503619) {
                        i3 = 36;
                    }
                } else if (iH != 106) {
                    if (iH != 122) {
                        if (iH == 127) {
                            if (gc4Var.H() == 21) {
                            }
                        } else if (iH == 123) {
                            i3 = 138;
                        } else if (iH == 10) {
                            strTrim = gc4Var.E(3).trim();
                        } else if (iH == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (gc4Var.f() < iF2) {
                                String strTrim2 = gc4Var.E(3).trim();
                                int iH2 = gc4Var.H();
                                byte[] bArr = new byte[4];
                                gc4Var.l(bArr, 0, 4);
                                arrayList2.add(new j26.a(strTrim2, iH2, bArr));
                            }
                            arrayList = arrayList2;
                            i3 = 89;
                        } else if (iH == 111) {
                            i3 = 257;
                        }
                    }
                }
                gc4Var.V(iF2 - gc4Var.f());
            }
            gc4Var.U(i2);
            return new j26.b(i3, strTrim, arrayList, Arrays.copyOfRange(gc4Var.e(), iF, i2));
        }

        @Override // defpackage.l45
        public void b(jy5 jy5Var, qs1 qs1Var, j26.d dVar) {
        }
    }
}
