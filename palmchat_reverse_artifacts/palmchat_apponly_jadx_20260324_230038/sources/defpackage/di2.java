package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.f;
import defpackage.ki2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class di2 implements h, HlsPlaylistTracker.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zh2 f17055a;
    public final HlsPlaylistTracker b;
    public final yh2 c;

    @Nullable
    public final u06 d;
    public final c e;
    public final b.a f;
    public final f g;
    public final j.a h;
    public final w9 i;
    public final gk0 l;
    public final boolean m;
    public final int n;
    public final boolean o;
    public final bk4 p;
    public final long r;

    @Nullable
    public h.a s;
    public int t;
    public vz5 u;
    public int y;
    public q z;
    public final ki2.b q = new b();
    public final IdentityHashMap<d25, Integer> j = new IdentityHashMap<>();
    public final ky5 k = new ky5();
    public ki2[] v = new ki2[0];
    public ki2[] w = new ki2[0];
    public int[][] x = new int[0][];

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ki2.b {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.q.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void c(ki2 ki2Var) {
            di2.this.s.c(di2.this);
        }

        @Override // ki2.b
        public void e(Uri uri) {
            di2.this.b.h(uri);
        }

        @Override // ki2.b
        public void onPrepared() {
            if (di2.e(di2.this) > 0) {
                return;
            }
            int i = 0;
            for (ki2 ki2Var : di2.this.v) {
                i += ki2Var.getTrackGroups().f21565a;
            }
            qz5[] qz5VarArr = new qz5[i];
            int i2 = 0;
            for (ki2 ki2Var2 : di2.this.v) {
                int i3 = ki2Var2.getTrackGroups().f21565a;
                int i4 = 0;
                while (i4 < i3) {
                    qz5VarArr[i2] = ki2Var2.getTrackGroups().b(i4);
                    i4++;
                    i2++;
                }
            }
            di2.this.u = new vz5(qz5VarArr);
            di2.this.s.f(di2.this);
        }
    }

    public di2(zh2 zh2Var, HlsPlaylistTracker hlsPlaylistTracker, yh2 yh2Var, @Nullable u06 u06Var, @Nullable od0 od0Var, c cVar, b.a aVar, f fVar, j.a aVar2, w9 w9Var, gk0 gk0Var, boolean z, int i, boolean z2, bk4 bk4Var, long j) {
        this.f17055a = zh2Var;
        this.b = hlsPlaylistTracker;
        this.c = yh2Var;
        this.d = u06Var;
        this.e = cVar;
        this.f = aVar;
        this.g = fVar;
        this.h = aVar2;
        this.i = w9Var;
        this.l = gk0Var;
        this.m = z;
        this.n = i;
        this.o = z2;
        this.p = bk4Var;
        this.r = j;
        this.z = gk0Var.a(new q[0]);
    }

    public static /* synthetic */ int e(di2 di2Var) {
        int i = di2Var.t - 1;
        di2Var.t = i;
        return i;
    }

    public static m o(m mVar, @Nullable m mVar2, boolean z) {
        String strK;
        Metadata metadata;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        if (mVar2 != null) {
            strK = mVar2.i;
            metadata = mVar2.j;
            i2 = mVar2.y;
            i = mVar2.d;
            i3 = mVar2.e;
            str = mVar2.c;
            str2 = mVar2.b;
        } else {
            strK = g86.K(mVar.i, 1);
            metadata = mVar.j;
            if (z) {
                i2 = mVar.y;
                i = mVar.d;
                i3 = mVar.e;
                str = mVar.c;
                str2 = mVar.b;
            } else {
                i = 0;
                str = null;
                str2 = null;
                i2 = -1;
                i3 = 0;
            }
        }
        return new m.b().U(mVar.f5892a).W(str2).M(mVar.k).g0(fp3.g(strK)).K(strK).Z(metadata).I(z ? mVar.f : -1).b0(z ? mVar.g : -1).J(i2).i0(i).e0(i3).X(str).G();
    }

    public static Map<String, DrmInitData> p(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitDataMerge = list.get(i);
            String str = drmInitDataMerge.schemeType;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData.schemeType, str)) {
                    drmInitDataMerge = drmInitDataMerge.merge(drmInitData);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            map.put(str, drmInitDataMerge);
        }
        return map;
    }

    public static m q(m mVar) {
        String strK = g86.K(mVar.i, 2);
        return new m.b().U(mVar.f5892a).W(mVar.b).M(mVar.k).g0(fp3.g(strK)).K(strK).Z(mVar.j).I(mVar.f).b0(mVar.g).n0(mVar.q).S(mVar.r).R(mVar.s).i0(mVar.d).e0(mVar.e).G();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        for (ki2 ki2Var : this.w) {
            if (ki2Var.E()) {
                return ki2Var.a(j, w45Var);
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    @Override // com.google.android.exoplayer2.source.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        d25[] d25VarArr2 = d25VarArr;
        int[] iArr = new int[or1VarArr.length];
        int[] iArr2 = new int[or1VarArr.length];
        for (int i = 0; i < or1VarArr.length; i++) {
            d25 d25Var = d25VarArr2[i];
            iArr[i] = d25Var == null ? -1 : this.j.get(d25Var).intValue();
            iArr2[i] = -1;
            or1 or1Var = or1VarArr[i];
            if (or1Var != null) {
                qz5 trackGroup = or1Var.getTrackGroup();
                int i2 = 0;
                while (true) {
                    ki2[] ki2VarArr = this.v;
                    if (i2 >= ki2VarArr.length) {
                        break;
                    }
                    if (ki2VarArr[i2].getTrackGroups().c(trackGroup) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.j.clear();
        int length = or1VarArr.length;
        d25[] d25VarArr3 = new d25[length];
        d25[] d25VarArr4 = new d25[or1VarArr.length];
        or1[] or1VarArr2 = new or1[or1VarArr.length];
        ki2[] ki2VarArr2 = new ki2[this.v.length];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (i4 < this.v.length) {
            for (int i5 = 0; i5 < or1VarArr.length; i5++) {
                or1 or1Var2 = null;
                d25VarArr4[i5] = iArr[i5] == i4 ? d25VarArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    or1Var2 = or1VarArr[i5];
                }
                or1VarArr2[i5] = or1Var2;
            }
            ki2 ki2Var = this.v[i4];
            int i6 = i3;
            int i7 = length;
            int i8 = i4;
            or1[] or1VarArr3 = or1VarArr2;
            ki2[] ki2VarArr3 = ki2VarArr2;
            boolean zW = ki2Var.W(or1VarArr2, zArr, d25VarArr4, zArr2, j, z);
            int i9 = 0;
            boolean z2 = false;
            while (true) {
                if (i9 >= or1VarArr.length) {
                    break;
                }
                d25 d25Var2 = d25VarArr4[i9];
                if (iArr2[i9] == i8) {
                    vh.e(d25Var2);
                    d25VarArr3[i9] = d25Var2;
                    this.j.put(d25Var2, Integer.valueOf(i8));
                    z2 = true;
                } else if (iArr[i9] == i8) {
                    vh.g(d25Var2 == null);
                }
                i9++;
            }
            if (z2) {
                ki2VarArr3[i6] = ki2Var;
                i3 = i6 + 1;
                if (i6 == 0) {
                    ki2Var.Z(true);
                    if (!zW) {
                        ki2[] ki2VarArr4 = this.w;
                        if (ki2VarArr4.length == 0 || ki2Var != ki2VarArr4[0]) {
                            this.k.b();
                            z = true;
                        }
                    }
                } else {
                    ki2Var.Z(i8 < this.y);
                }
            } else {
                i3 = i6;
            }
            i4 = i8 + 1;
            d25VarArr2 = d25VarArr;
            ki2VarArr2 = ki2VarArr3;
            length = i7;
            or1VarArr2 = or1VarArr3;
        }
        System.arraycopy(d25VarArr3, 0, d25VarArr2, 0, length);
        ki2[] ki2VarArr5 = (ki2[]) g86.M0(ki2VarArr2, i3);
        this.w = ki2VarArr5;
        this.z = this.l.a(ki2VarArr5);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void c() {
        for (ki2 ki2Var : this.v) {
            ki2Var.O();
        }
        this.s.c(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        if (this.u != null) {
            return this.z.continueLoading(j);
        }
        for (ki2 ki2Var : this.v) {
            ki2Var.o();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean d(Uri uri, f.c cVar, boolean z) {
        boolean zN = true;
        for (ki2 ki2Var : this.v) {
            zN &= ki2Var.N(uri, cVar, z);
        }
        this.s.c(this);
        return zN;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
        for (ki2 ki2Var : this.w) {
            ki2Var.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.s = aVar;
        this.b.i(this);
        m(j);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.z.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.z.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return (vz5) vh.e(this.u);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.z.isLoading();
    }

    public final void k(long j, List<c.a> list, List<ki2> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (g86.c(str, list.get(i2).d)) {
                        c.a aVar = list.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(aVar.f5966a);
                        arrayList2.add(aVar.b);
                        z &= g86.J(aVar.b.i, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                ki2 ki2VarN = n(str2, 1, (Uri[]) arrayList.toArray((Uri[]) g86.k(new Uri[0])), (m[]) arrayList2.toArray(new m[0]), null, Collections.emptyList(), map, j);
                list3.add(ku2.p(arrayList3));
                list2.add(ki2VarN);
                if (this.m && z) {
                    ki2VarN.Q(new qz5[]{new qz5(str2, (m[]) arrayList2.toArray(new m[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j, List<ki2> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z;
        boolean z2;
        int i;
        int size = cVar.e.size();
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < cVar.e.size(); i4++) {
            m mVar = cVar.e.get(i4).b;
            if (mVar.r > 0 || g86.K(mVar.i, 2) != null) {
                iArr[i4] = 2;
                i2++;
            } else if (g86.K(mVar.i, 1) != null) {
                iArr[i4] = 1;
                i3++;
            } else {
                iArr[i4] = -1;
            }
        }
        if (i2 > 0) {
            size = i2;
            z = true;
        } else {
            if (i3 < size) {
                size -= i3;
                z = false;
                z2 = true;
                Uri[] uriArr = new Uri[size];
                m[] mVarArr = new m[size];
                int[] iArr2 = new int[size];
                int i5 = 0;
                for (i = 0; i < cVar.e.size(); i++) {
                    if ((!z || iArr[i] == 2) && (!z2 || iArr[i] != 1)) {
                        c.b bVar = cVar.e.get(i);
                        uriArr[i5] = bVar.f5967a;
                        mVarArr[i5] = bVar.b;
                        iArr2[i5] = i;
                        i5++;
                    }
                }
                String str = mVarArr[0].i;
                int iJ = g86.J(str, 2);
                int iJ2 = g86.J(str, 1);
                boolean z3 = (iJ2 != 1 || (iJ2 == 0 && cVar.g.isEmpty())) && iJ <= 1 && iJ2 + iJ > 0;
                ki2 ki2VarN = n("main", (!z || iJ2 <= 0) ? 0 : 1, uriArr, mVarArr, cVar.j, cVar.k, map, j);
                list.add(ki2VarN);
                list2.add(iArr2);
                if (this.m || !z3) {
                }
                ArrayList arrayList = new ArrayList();
                if (iJ > 0) {
                    m[] mVarArr2 = new m[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        mVarArr2[i6] = q(mVarArr[i6]);
                    }
                    arrayList.add(new qz5("main", mVarArr2));
                    if (iJ2 > 0 && (cVar.j != null || cVar.g.isEmpty())) {
                        arrayList.add(new qz5("main:audio", o(mVarArr[0], cVar.j, false)));
                    }
                    List<m> list3 = cVar.k;
                    if (list3 != null) {
                        for (int i7 = 0; i7 < list3.size(); i7++) {
                            arrayList.add(new qz5("main:cc:" + i7, list3.get(i7)));
                        }
                    }
                } else {
                    m[] mVarArr3 = new m[size];
                    for (int i8 = 0; i8 < size; i8++) {
                        mVarArr3[i8] = o(mVarArr[i8], cVar.j, true);
                    }
                    arrayList.add(new qz5("main", mVarArr3));
                }
                qz5 qz5Var = new qz5("main:id3", new m.b().U("ID3").g0("application/id3").G());
                arrayList.add(qz5Var);
                ki2VarN.Q((qz5[]) arrayList.toArray(new qz5[0]), 0, arrayList.indexOf(qz5Var));
                return;
            }
            z = false;
        }
        z2 = false;
        Uri[] uriArr2 = new Uri[size];
        m[] mVarArr4 = new m[size];
        int[] iArr22 = new int[size];
        int i52 = 0;
        while (i < cVar.e.size()) {
        }
        String str2 = mVarArr4[0].i;
        int iJ3 = g86.J(str2, 2);
        int iJ22 = g86.J(str2, 1);
        if (iJ22 != 1) {
        }
        ki2 ki2VarN2 = n("main", (!z || iJ22 <= 0) ? 0 : 1, uriArr2, mVarArr4, cVar.j, cVar.k, map, j);
        list.add(ki2VarN2);
        list2.add(iArr22);
        if (this.m) {
        }
    }

    public final void m(long j) {
        com.google.android.exoplayer2.source.hls.playlist.c cVar = (com.google.android.exoplayer2.source.hls.playlist.c) vh.e(this.b.g());
        Map<String, DrmInitData> mapP = this.o ? p(cVar.m) : Collections.emptyMap();
        int i = 1;
        boolean z = !cVar.e.isEmpty();
        List<c.a> list = cVar.g;
        List<c.a> list2 = cVar.h;
        char c = 0;
        this.t = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            l(cVar, j, arrayList, arrayList2, mapP);
        }
        k(j, list, arrayList, arrayList2, mapP);
        this.y = arrayList.size();
        int i2 = 0;
        while (i2 < list2.size()) {
            c.a aVar = list2.get(i2);
            String str = "subtitle:" + i2 + ":" + aVar.d;
            Uri[] uriArr = new Uri[i];
            uriArr[c] = aVar.f5966a;
            m[] mVarArr = new m[i];
            mVarArr[c] = aVar.b;
            ArrayList arrayList3 = arrayList2;
            int i3 = i2;
            ki2 ki2VarN = n(str, 3, uriArr, mVarArr, null, Collections.emptyList(), mapP, j);
            arrayList3.add(new int[]{i3});
            arrayList.add(ki2VarN);
            ki2VarN.Q(new qz5[]{new qz5(str, aVar.b)}, 0, new int[0]);
            i2 = i3 + 1;
            arrayList2 = arrayList3;
            i = 1;
            c = 0;
        }
        this.v = (ki2[]) arrayList.toArray(new ki2[0]);
        this.x = (int[][]) arrayList2.toArray(new int[0][]);
        this.t = this.v.length;
        for (int i4 = 0; i4 < this.y; i4++) {
            this.v[i4].Z(true);
        }
        for (ki2 ki2Var : this.v) {
            ki2Var.o();
        }
        this.w = this.v;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        for (ki2 ki2Var : this.v) {
            ki2Var.maybeThrowPrepareError();
        }
    }

    public final ki2 n(String str, int i, Uri[] uriArr, m[] mVarArr, @Nullable m mVar, @Nullable List<m> list, Map<String, DrmInitData> map, long j) {
        return new ki2(str, i, this.q, new xh2(this.f17055a, this.b, uriArr, mVarArr, this.c, this.d, this.k, this.r, list, this.p, null), map, this.i, j, mVar, this.e, this.f, this.g, this.h, this.n);
    }

    public void r() {
        this.b.a(this);
        for (ki2 ki2Var : this.v) {
            ki2Var.S();
        }
        this.s = null;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        this.z.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        ki2[] ki2VarArr = this.w;
        if (ki2VarArr.length > 0) {
            boolean zV = ki2VarArr[0].V(j, false);
            int i = 1;
            while (true) {
                ki2[] ki2VarArr2 = this.w;
                if (i >= ki2VarArr2.length) {
                    break;
                }
                ki2VarArr2[i].V(j, zV);
                i++;
            }
            if (zV) {
                this.k.b();
            }
        }
        return j;
    }
}
