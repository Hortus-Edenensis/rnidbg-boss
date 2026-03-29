package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.h;
import defpackage.d25;
import defpackage.f12;
import defpackage.gk0;
import defpackage.or1;
import defpackage.qz5;
import defpackage.te3;
import defpackage.ue3;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import defpackage.x50;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class k implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h[] f5970a;
    public final gk0 c;

    @Nullable
    public h.a f;

    @Nullable
    public vz5 g;
    public q i;
    public final ArrayList<h> d = new ArrayList<>();
    public final HashMap<qz5, qz5> e = new HashMap<>();
    public final IdentityHashMap<d25, Integer> b = new IdentityHashMap<>();
    public h[] h = new h[0];

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements or1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final or1 f5971a;
        public final qz5 b;

        public a(or1 or1Var, qz5 qz5Var) {
            this.f5971a = or1Var;
            this.b = qz5Var;
        }

        @Override // defpackage.or1
        public boolean a(long j, x50 x50Var, List<? extends te3> list) {
            return this.f5971a.a(j, x50Var, list);
        }

        @Override // defpackage.or1
        public void b(long j, long j2, long j3, List<? extends te3> list, ue3[] ue3VarArr) {
            this.f5971a.b(j, j2, j3, list, ue3VarArr);
        }

        @Override // defpackage.e06
        public int c(com.google.android.exoplayer2.m mVar) {
            return this.f5971a.c(mVar);
        }

        @Override // defpackage.or1
        public void disable() {
            this.f5971a.disable();
        }

        @Override // defpackage.or1
        public void enable() {
            this.f5971a.enable();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5971a.equals(aVar.f5971a) && this.b.equals(aVar.b);
        }

        @Override // defpackage.or1
        public int evaluateQueueSize(long j, List<? extends te3> list) {
            return this.f5971a.evaluateQueueSize(j, list);
        }

        @Override // defpackage.or1
        public boolean excludeTrack(int i, long j) {
            return this.f5971a.excludeTrack(i, j);
        }

        @Override // defpackage.e06
        public com.google.android.exoplayer2.m getFormat(int i) {
            return this.f5971a.getFormat(i);
        }

        @Override // defpackage.e06
        public int getIndexInTrackGroup(int i) {
            return this.f5971a.getIndexInTrackGroup(i);
        }

        @Override // defpackage.or1
        public com.google.android.exoplayer2.m getSelectedFormat() {
            return this.f5971a.getSelectedFormat();
        }

        @Override // defpackage.or1
        public int getSelectedIndex() {
            return this.f5971a.getSelectedIndex();
        }

        @Override // defpackage.or1
        public int getSelectedIndexInTrackGroup() {
            return this.f5971a.getSelectedIndexInTrackGroup();
        }

        @Override // defpackage.or1
        @Nullable
        public Object getSelectionData() {
            return this.f5971a.getSelectionData();
        }

        @Override // defpackage.or1
        public int getSelectionReason() {
            return this.f5971a.getSelectionReason();
        }

        @Override // defpackage.e06
        public qz5 getTrackGroup() {
            return this.b;
        }

        public int hashCode() {
            return ((527 + this.b.hashCode()) * 31) + this.f5971a.hashCode();
        }

        @Override // defpackage.e06
        public int indexOf(int i) {
            return this.f5971a.indexOf(i);
        }

        @Override // defpackage.or1
        public boolean isTrackExcluded(int i, long j) {
            return this.f5971a.isTrackExcluded(i, j);
        }

        @Override // defpackage.e06
        public int length() {
            return this.f5971a.length();
        }

        @Override // defpackage.or1
        public void onDiscontinuity() {
            this.f5971a.onDiscontinuity();
        }

        @Override // defpackage.or1
        public void onPlayWhenReadyChanged(boolean z) {
            this.f5971a.onPlayWhenReadyChanged(z);
        }

        @Override // defpackage.or1
        public void onPlaybackSpeed(float f) {
            this.f5971a.onPlaybackSpeed(f);
        }

        @Override // defpackage.or1
        public void onRebuffer() {
            this.f5971a.onRebuffer();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements h, h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f5972a;
        public final long b;
        public h.a c;

        public b(h hVar, long j) {
            this.f5972a = hVar;
            this.b = j;
        }

        @Override // com.google.android.exoplayer2.source.h
        public long a(long j, w45 w45Var) {
            return this.f5972a.a(j - this.b, w45Var) + this.b;
        }

        @Override // com.google.android.exoplayer2.source.h
        public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
            d25[] d25VarArr2 = new d25[d25VarArr.length];
            int i = 0;
            while (true) {
                d25 d25VarA = null;
                if (i >= d25VarArr.length) {
                    break;
                }
                c cVar = (c) d25VarArr[i];
                if (cVar != null) {
                    d25VarA = cVar.a();
                }
                d25VarArr2[i] = d25VarA;
                i++;
            }
            long jB = this.f5972a.b(or1VarArr, zArr, d25VarArr2, zArr2, j - this.b);
            for (int i2 = 0; i2 < d25VarArr.length; i2++) {
                d25 d25Var = d25VarArr2[i2];
                if (d25Var == null) {
                    d25VarArr[i2] = null;
                } else {
                    d25 d25Var2 = d25VarArr[i2];
                    if (d25Var2 == null || ((c) d25Var2).a() != d25Var) {
                        d25VarArr[i2] = new c(d25Var, this.b);
                    }
                }
            }
            return jB + this.b;
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public boolean continueLoading(long j) {
            return this.f5972a.continueLoading(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.h
        public void discardBuffer(long j, boolean z) {
            this.f5972a.discardBuffer(j - this.b, z);
        }

        @Override // com.google.android.exoplayer2.source.h.a
        public void f(h hVar) {
            ((h.a) vh.e(this.c)).f(this);
        }

        @Override // com.google.android.exoplayer2.source.h
        public void g(h.a aVar, long j) {
            this.c = aVar;
            this.f5972a.g(this, j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.f5972a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.f5972a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.h
        public vz5 getTrackGroups() {
            return this.f5972a.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.q.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void c(h hVar) {
            ((h.a) vh.e(this.c)).c(this);
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public boolean isLoading() {
            return this.f5972a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.h
        public void maybeThrowPrepareError() throws IOException {
            this.f5972a.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.h
        public long readDiscontinuity() {
            long discontinuity = this.f5972a.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.b + discontinuity;
        }

        @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
        public void reevaluateBuffer(long j) {
            this.f5972a.reevaluateBuffer(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.h
        public long seekToUs(long j) {
            return this.f5972a.seekToUs(j - this.b) + this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements d25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d25 f5973a;
        public final long b;

        public c(d25 d25Var, long j) {
            this.f5973a = d25Var;
            this.b = j;
        }

        public d25 a() {
            return this.f5973a;
        }

        @Override // defpackage.d25
        public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
            int iC = this.f5973a.c(f12Var, decoderInputBuffer, i);
            if (iC == -4) {
                decoderInputBuffer.e = Math.max(0L, decoderInputBuffer.e + this.b);
            }
            return iC;
        }

        @Override // defpackage.d25
        public boolean isReady() {
            return this.f5973a.isReady();
        }

        @Override // defpackage.d25
        public void maybeThrowError() throws IOException {
            this.f5973a.maybeThrowError();
        }

        @Override // defpackage.d25
        public int skipData(long j) {
            return this.f5973a.skipData(j - this.b);
        }
    }

    public k(gk0 gk0Var, long[] jArr, h... hVarArr) {
        this.c = gk0Var;
        this.f5970a = hVarArr;
        this.i = gk0Var.a(new q[0]);
        for (int i = 0; i < hVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.f5970a[i] = new b(hVarArr[i], j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        h[] hVarArr = this.h;
        return (hVarArr.length > 0 ? hVarArr[0] : this.f5970a[0]).a(j, w45Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.h
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        Integer num;
        int[] iArr = new int[or1VarArr.length];
        int[] iArr2 = new int[or1VarArr.length];
        int i = 0;
        while (true) {
            if (i >= or1VarArr.length) {
                break;
            }
            d25 d25Var = d25VarArr[i];
            num = d25Var != null ? this.b.get(d25Var) : null;
            iArr[i] = num == null ? -1 : num.intValue();
            or1 or1Var = or1VarArr[i];
            if (or1Var != null) {
                String str = or1Var.getTrackGroup().b;
                iArr2[i] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i] = -1;
            }
            i++;
        }
        this.b.clear();
        int length = or1VarArr.length;
        d25[] d25VarArr2 = new d25[length];
        d25[] d25VarArr3 = new d25[or1VarArr.length];
        Object[] objArr = new or1[or1VarArr.length];
        ArrayList arrayList = new ArrayList(this.f5970a.length);
        long j2 = j;
        int i2 = 0;
        while (i2 < this.f5970a.length) {
            for (int i3 = 0; i3 < or1VarArr.length; i3++) {
                d25VarArr3[i3] = iArr[i3] == i2 ? d25VarArr[i3] : num;
                if (iArr2[i3] == i2) {
                    or1 or1Var2 = (or1) vh.e(or1VarArr[i3]);
                    objArr[i3] = new a(or1Var2, (qz5) vh.e(this.e.get(or1Var2.getTrackGroup())));
                } else {
                    objArr[i3] = num;
                }
            }
            int i4 = i2;
            ArrayList arrayList2 = arrayList;
            Object[] objArr2 = objArr;
            long jB = this.f5970a[i2].b(objArr, zArr, d25VarArr3, zArr2, j2);
            if (i4 == 0) {
                j2 = jB;
            } else if (jB != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i5 = 0; i5 < or1VarArr.length; i5++) {
                if (iArr2[i5] == i4) {
                    d25 d25Var2 = (d25) vh.e(d25VarArr3[i5]);
                    d25VarArr2[i5] = d25VarArr3[i5];
                    this.b.put(d25Var2, Integer.valueOf(i4));
                    z = true;
                } else if (iArr[i5] == i4) {
                    vh.g(d25VarArr3[i5] == 0);
                }
            }
            if (z) {
                arrayList2.add(this.f5970a[i4]);
            }
            i2 = i4 + 1;
            arrayList = arrayList2;
            objArr = objArr2;
            num = null;
        }
        System.arraycopy(d25VarArr2, 0, d25VarArr, 0, length);
        h[] hVarArr = (h[]) arrayList.toArray(new h[0]);
        this.h = hVarArr;
        this.i = this.c.a(hVarArr);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        if (this.d.isEmpty()) {
            return this.i.continueLoading(j);
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.get(i).continueLoading(j);
        }
        return false;
    }

    public h d(int i) {
        h hVar = this.f5970a[i];
        return hVar instanceof b ? ((b) hVar).f5972a : hVar;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
        for (h hVar : this.h) {
            hVar.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void f(h hVar) {
        this.d.remove(hVar);
        if (!this.d.isEmpty()) {
            return;
        }
        int i = 0;
        for (h hVar2 : this.f5970a) {
            i += hVar2.getTrackGroups().f21565a;
        }
        qz5[] qz5VarArr = new qz5[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            h[] hVarArr = this.f5970a;
            if (i2 >= hVarArr.length) {
                this.g = new vz5(qz5VarArr);
                ((h.a) vh.e(this.f)).f(this);
                return;
            }
            vz5 trackGroups = hVarArr[i2].getTrackGroups();
            int i4 = trackGroups.f21565a;
            int i5 = 0;
            while (i5 < i4) {
                qz5 qz5VarB = trackGroups.b(i5);
                qz5 qz5VarB2 = qz5VarB.b(i2 + ":" + qz5VarB.b);
                this.e.put(qz5VarB2, qz5VarB);
                qz5VarArr[i3] = qz5VarB2;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.f = aVar;
        Collections.addAll(this.d, this.f5970a);
        for (h hVar : this.f5970a) {
            hVar.g(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.i.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return this.i.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return (vz5) vh.e(this.g);
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(h hVar) {
        ((h.a) vh.e(this.f)).c(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        for (h hVar : this.f5970a) {
            hVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        long j = -9223372036854775807L;
        for (h hVar : this.h) {
            long discontinuity = hVar.readDiscontinuity();
            if (discontinuity == -9223372036854775807L) {
                if (j != -9223372036854775807L && hVar.seekToUs(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (h hVar2 : this.h) {
                    if (hVar2 == hVar) {
                        break;
                    }
                    if (hVar2.seekToUs(discontinuity) != discontinuity) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = discontinuity;
            } else if (discontinuity != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        this.i.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        long jSeekToUs = this.h[0].seekToUs(j);
        int i = 1;
        while (true) {
            h[] hVarArr = this.h;
            if (i >= hVarArr.length) {
                return jSeekToUs;
            }
            if (hVarArr[i].seekToUs(jSeekToUs) != jSeekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }
}
