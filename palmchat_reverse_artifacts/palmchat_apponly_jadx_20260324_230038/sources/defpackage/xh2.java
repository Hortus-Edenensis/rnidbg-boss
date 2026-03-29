package defpackage;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class xh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zh2 f21960a;
    public final com.google.android.exoplayer2.upstream.a b;
    public final com.google.android.exoplayer2.upstream.a c;
    public final ky5 d;
    public final Uri[] e;
    public final m[] f;
    public final HlsPlaylistTracker g;
    public final qz5 h;

    @Nullable
    public final List<m> i;
    public final bk4 k;
    public final long l;
    public boolean m;

    @Nullable
    public IOException o;

    @Nullable
    public Uri p;
    public boolean q;
    public or1 r;
    public boolean t;
    public final o42 j = new o42(4);
    public byte[] n = g86.f;
    public long s = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends lu0 {
        public byte[] l;

        public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, m mVar, int i, @Nullable Object obj, byte[] bArr) {
            super(aVar, bVar, 3, mVar, i, obj, bArr);
        }

        @Override // defpackage.lu0
        public void e(byte[] bArr, int i) {
            this.l = Arrays.copyOf(bArr, i);
        }

        @Nullable
        public byte[] h() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public x50 f21961a;
        public boolean b;

        @Nullable
        public Uri c;

        public b() {
            a();
        }

        public void a() {
            this.f21961a = null;
            this.b = false;
            this.c = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @VisibleForTesting
    public static final class c extends gr {
        public final List<b.e> e;
        public final long f;
        public final String g;

        public c(String str, long j, List<b.e> list) {
            super(0L, list.size() - 1);
            this.g = str;
            this.f = j;
            this.e = list;
        }

        @Override // defpackage.ue3
        public long getChunkEndTimeUs() {
            a();
            b.e eVar = this.e.get((int) b());
            return this.f + eVar.e + eVar.c;
        }

        @Override // defpackage.ue3
        public long getChunkStartTimeUs() {
            a();
            return this.f + this.e.get((int) b()).e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends as {
        public int h;

        public d(qz5 qz5Var, int[] iArr) {
            super(qz5Var, iArr);
            this.h = c(qz5Var.c(iArr[0]));
        }

        @Override // defpackage.or1
        public void b(long j, long j2, long j3, List<? extends te3> list, ue3[] ue3VarArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (isTrackExcluded(this.h, jElapsedRealtime)) {
                for (int i = this.b - 1; i >= 0; i--) {
                    if (!isTrackExcluded(i, jElapsedRealtime)) {
                        this.h = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // defpackage.or1
        public int getSelectedIndex() {
            return this.h;
        }

        @Override // defpackage.or1
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // defpackage.or1
        public int getSelectionReason() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.e f21962a;
        public final long b;
        public final int c;
        public final boolean d;

        public e(b.e eVar, long j, int i) {
            this.f21962a = eVar;
            this.b = j;
            this.c = i;
            this.d = (eVar instanceof b.C0357b) && ((b.C0357b) eVar).m;
        }
    }

    public xh2(zh2 zh2Var, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, m[] mVarArr, yh2 yh2Var, @Nullable u06 u06Var, ky5 ky5Var, long j, @Nullable List<m> list, bk4 bk4Var, @Nullable od0 od0Var) {
        this.f21960a = zh2Var;
        this.g = hlsPlaylistTracker;
        this.e = uriArr;
        this.f = mVarArr;
        this.d = ky5Var;
        this.l = j;
        this.i = list;
        this.k = bk4Var;
        com.google.android.exoplayer2.upstream.a aVarA = yh2Var.a(1);
        this.b = aVarA;
        if (u06Var != null) {
            aVarA.b(u06Var);
        }
        this.c = yh2Var.a(3);
        this.h = new qz5(mVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((mVarArr[i].e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.r = new d(this.h, ku2.p(arrayList));
    }

    @Nullable
    public static Uri d(com.google.android.exoplayer2.source.hls.playlist.b bVar, @Nullable b.e eVar) {
        String str;
        if (eVar == null || (str = eVar.g) == null) {
            return null;
        }
        return v56.e(bVar.f17306a, str);
    }

    @Nullable
    public static e g(com.google.android.exoplayer2.source.hls.playlist.b bVar, long j, int i) {
        int i2 = (int) (j - bVar.k);
        if (i2 == bVar.r.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < bVar.s.size()) {
                return new e(bVar.s.get(i), j, i);
            }
            return null;
        }
        b.d dVar = bVar.r.get(i2);
        if (i == -1) {
            return new e(dVar, j, -1);
        }
        if (i < dVar.m.size()) {
            return new e(dVar.m.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < bVar.r.size()) {
            return new e(bVar.r.get(i3), j + 1, -1);
        }
        if (bVar.s.isEmpty()) {
            return null;
        }
        return new e(bVar.s.get(0), j + 1, 0);
    }

    @VisibleForTesting
    public static List<b.e> i(com.google.android.exoplayer2.source.hls.playlist.b bVar, long j, int i) {
        int i2 = (int) (j - bVar.k);
        if (i2 < 0 || bVar.r.size() < i2) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i2 < bVar.r.size()) {
            if (i != -1) {
                b.d dVar = bVar.r.get(i2);
                if (i == 0) {
                    arrayList.add(dVar);
                } else if (i < dVar.m.size()) {
                    List<b.C0357b> list = dVar.m;
                    arrayList.addAll(list.subList(i, list.size()));
                }
                i2++;
            }
            List<b.d> list2 = bVar.r;
            arrayList.addAll(list2.subList(i2, list2.size()));
            i = 0;
        }
        if (bVar.n != -9223372036854775807L) {
            int i3 = i != -1 ? i : 0;
            if (i3 < bVar.s.size()) {
                List<b.C0357b> list3 = bVar.s;
                arrayList.addAll(list3.subList(i3, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public ue3[] a(@Nullable bi2 bi2Var, long j) {
        int i;
        int iD = bi2Var == null ? -1 : this.h.d(bi2Var.d);
        int length = this.r.length();
        ue3[] ue3VarArr = new ue3[length];
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            int indexInTrackGroup = this.r.getIndexInTrackGroup(i2);
            Uri uri = this.e[indexInTrackGroup];
            if (this.g.k(uri)) {
                com.google.android.exoplayer2.source.hls.playlist.b bVarO = this.g.o(uri, z);
                vh.e(bVarO);
                long jB = bVarO.h - this.g.b();
                i = i2;
                Pair<Long, Integer> pairF = f(bi2Var, indexInTrackGroup != iD, bVarO, jB, j);
                ue3VarArr[i] = new c(bVarO.f17306a, jB, i(bVarO, ((Long) pairF.first).longValue(), ((Integer) pairF.second).intValue()));
            } else {
                ue3VarArr[i2] = ue3.f21199a;
                i = i2;
            }
            i2 = i + 1;
            z = false;
        }
        return ue3VarArr;
    }

    public long b(long j, w45 w45Var) {
        int selectedIndex = this.r.getSelectedIndex();
        Uri[] uriArr = this.e;
        com.google.android.exoplayer2.source.hls.playlist.b bVarO = (selectedIndex >= uriArr.length || selectedIndex == -1) ? null : this.g.o(uriArr[this.r.getSelectedIndexInTrackGroup()], true);
        if (bVarO == null || bVarO.r.isEmpty() || !bVarO.c) {
            return j;
        }
        long jB = bVarO.h - this.g.b();
        long j2 = j - jB;
        int iG = g86.g(bVarO.r, Long.valueOf(j2), true, true);
        long j3 = bVarO.r.get(iG).e;
        return w45Var.a(j2, j3, iG != bVarO.r.size() - 1 ? bVarO.r.get(iG + 1).e : j3) + jB;
    }

    public int c(bi2 bi2Var) {
        if (bi2Var.o == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.b bVar = (com.google.android.exoplayer2.source.hls.playlist.b) vh.e(this.g.o(this.e[this.h.d(bi2Var.d)], false));
        int i = (int) (bi2Var.j - bVar.k);
        if (i < 0) {
            return 1;
        }
        List<b.C0357b> list = i < bVar.r.size() ? bVar.r.get(i).m : bVar.s;
        if (bi2Var.o >= list.size()) {
            return 2;
        }
        b.C0357b c0357b = list.get(bi2Var.o);
        if (c0357b.m) {
            return 0;
        }
        return g86.c(Uri.parse(v56.d(bVar.f17306a, c0357b.f5964a)), bi2Var.b.f6011a) ? 1 : 2;
    }

    public void e(long j, long j2, List<bi2> list, boolean z, b bVar) {
        com.google.android.exoplayer2.source.hls.playlist.b bVar2;
        long jB;
        Uri uri;
        int i;
        bi2 bi2Var = list.isEmpty() ? null : (bi2) bv2.g(list);
        int iD = bi2Var == null ? -1 : this.h.d(bi2Var.d);
        long jMax = j2 - j;
        long jS = s(j);
        if (bi2Var != null && !this.q) {
            long jB2 = bi2Var.b();
            jMax = Math.max(0L, jMax - jB2);
            if (jS != -9223372036854775807L) {
                jS = Math.max(0L, jS - jB2);
            }
        }
        this.r.b(j, jMax, jS, list, a(bi2Var, j2));
        int selectedIndexInTrackGroup = this.r.getSelectedIndexInTrackGroup();
        boolean z2 = iD != selectedIndexInTrackGroup;
        Uri uri2 = this.e[selectedIndexInTrackGroup];
        if (!this.g.k(uri2)) {
            bVar.c = uri2;
            this.t &= uri2.equals(this.p);
            this.p = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b bVarO = this.g.o(uri2, true);
        vh.e(bVarO);
        this.q = bVarO.c;
        w(bVarO);
        long jB3 = bVarO.h - this.g.b();
        Pair<Long, Integer> pairF = f(bi2Var, z2, bVarO, jB3, j2);
        long jLongValue = ((Long) pairF.first).longValue();
        int iIntValue = ((Integer) pairF.second).intValue();
        if (jLongValue >= bVarO.k || bi2Var == null || !z2) {
            bVar2 = bVarO;
            jB = jB3;
            uri = uri2;
            i = selectedIndexInTrackGroup;
        } else {
            Uri uri3 = this.e[iD];
            com.google.android.exoplayer2.source.hls.playlist.b bVarO2 = this.g.o(uri3, true);
            vh.e(bVarO2);
            jB = bVarO2.h - this.g.b();
            Pair<Long, Integer> pairF2 = f(bi2Var, false, bVarO2, jB, j2);
            jLongValue = ((Long) pairF2.first).longValue();
            iIntValue = ((Integer) pairF2.second).intValue();
            i = iD;
            uri = uri3;
            bVar2 = bVarO2;
        }
        if (jLongValue < bVar2.k) {
            this.o = new BehindLiveWindowException();
            return;
        }
        e eVarG = g(bVar2, jLongValue, iIntValue);
        if (eVarG == null) {
            if (!bVar2.o) {
                bVar.c = uri;
                this.t &= uri.equals(this.p);
                this.p = uri;
                return;
            } else {
                if (z || bVar2.r.isEmpty()) {
                    bVar.b = true;
                    return;
                }
                eVarG = new e((b.e) bv2.g(bVar2.r), (bVar2.k + ((long) bVar2.r.size())) - 1, -1);
            }
        }
        this.t = false;
        this.p = null;
        Uri uriD = d(bVar2, eVarG.f21962a.b);
        x50 x50VarL = l(uriD, i, true, null);
        bVar.f21961a = x50VarL;
        if (x50VarL != null) {
            return;
        }
        Uri uriD2 = d(bVar2, eVarG.f21962a);
        x50 x50VarL2 = l(uriD2, i, false, null);
        bVar.f21961a = x50VarL2;
        if (x50VarL2 != null) {
            return;
        }
        boolean zU = bi2.u(bi2Var, uri, bVar2, eVarG, jB);
        if (zU && eVarG.d) {
            return;
        }
        bVar.f21961a = bi2.h(this.f21960a, this.b, this.f[i], jB, bVar2, eVarG, uri, this.i, this.r.getSelectionReason(), this.r.getSelectionData(), this.m, this.d, this.l, bi2Var, this.j.a(uriD2), this.j.a(uriD), zU, this.k, null);
    }

    public final Pair<Long, Integer> f(@Nullable bi2 bi2Var, boolean z, com.google.android.exoplayer2.source.hls.playlist.b bVar, long j, long j2) {
        if (bi2Var != null && !z) {
            if (!bi2Var.f()) {
                return new Pair<>(Long.valueOf(bi2Var.j), Integer.valueOf(bi2Var.o));
            }
            Long lValueOf = Long.valueOf(bi2Var.o == -1 ? bi2Var.e() : bi2Var.j);
            int i = bi2Var.o;
            return new Pair<>(lValueOf, Integer.valueOf(i != -1 ? i + 1 : -1));
        }
        long j3 = bVar.u + j;
        if (bi2Var != null && !this.q) {
            j2 = bi2Var.g;
        }
        if (!bVar.o && j2 >= j3) {
            return new Pair<>(Long.valueOf(bVar.k + ((long) bVar.r.size())), -1);
        }
        long j4 = j2 - j;
        int i2 = 0;
        int iG = g86.g(bVar.r, Long.valueOf(j4), true, !this.g.l() || bi2Var == null);
        long j5 = ((long) iG) + bVar.k;
        if (iG >= 0) {
            b.d dVar = bVar.r.get(iG);
            List<b.C0357b> list = j4 < dVar.e + dVar.c ? dVar.m : bVar.s;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                b.C0357b c0357b = list.get(i2);
                if (j4 >= c0357b.e + c0357b.c) {
                    i2++;
                } else if (c0357b.l) {
                    j5 += list == bVar.s ? 1L : 0L;
                    i = i2;
                }
            }
        }
        return new Pair<>(Long.valueOf(j5), Integer.valueOf(i));
    }

    public int h(long j, List<? extends te3> list) {
        return (this.o != null || this.r.length() < 2) ? list.size() : this.r.evaluateQueueSize(j, list);
    }

    public qz5 j() {
        return this.h;
    }

    public or1 k() {
        return this.r;
    }

    @Nullable
    public final x50 l(@Nullable Uri uri, int i, boolean z, @Nullable qd0 qd0Var) {
        if (uri == null) {
            return null;
        }
        byte[] bArrC = this.j.c(uri);
        if (bArrC != null) {
            this.j.b(uri, bArrC);
            return null;
        }
        ImmutableMap<String, String> immutableMapOf = ImmutableMap.of();
        if (qd0Var != null) {
            if (z) {
                qd0Var.d("i");
            }
            immutableMapOf = qd0Var.a();
        }
        return new a(this.c, new b.C0361b().i(uri).b(1).e(immutableMapOf).a(), this.f[i], this.r.getSelectionReason(), this.r.getSelectionData(), this.n);
    }

    public boolean m(x50 x50Var, long j) {
        or1 or1Var = this.r;
        return or1Var.excludeTrack(or1Var.indexOf(this.h.d(x50Var.d)), j);
    }

    public void n() throws IOException {
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.p;
        if (uri == null || !this.t) {
            return;
        }
        this.g.d(uri);
    }

    public boolean o(Uri uri) {
        return g86.s(this.e, uri);
    }

    public void p(x50 x50Var) {
        if (x50Var instanceof a) {
            a aVar = (a) x50Var;
            this.n = aVar.f();
            this.j.b(aVar.b.f6011a, (byte[]) vh.e(aVar.h()));
        }
    }

    public boolean q(Uri uri, long j) {
        int iIndexOf;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (iIndexOf = this.r.indexOf(i)) == -1) {
            return true;
        }
        this.t |= uri.equals(this.p);
        return j == -9223372036854775807L || (this.r.excludeTrack(iIndexOf, j) && this.g.m(uri, j));
    }

    public void r() {
        this.o = null;
    }

    public final long s(long j) {
        long j2 = this.s;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(or1 or1Var) {
        this.r = or1Var;
    }

    public boolean v(long j, x50 x50Var, List<? extends te3> list) {
        if (this.o != null) {
            return false;
        }
        return this.r.a(j, x50Var, list);
    }

    public final void w(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.s = bVar.o ? -9223372036854775807L : bVar.d() - this.g.b();
    }
}
