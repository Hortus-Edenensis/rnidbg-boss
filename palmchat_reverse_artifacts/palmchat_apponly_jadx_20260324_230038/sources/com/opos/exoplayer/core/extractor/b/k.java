package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.b.b;
import com.opos.exoplayer.core.extractor.b.i;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class k extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8174a;
    private int b;
    private boolean c;
    private b.d d;
    private b.C0689b e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.d f8175a;
        public final byte[] b;
        public final b.c[] c;
        public final int d;

        public a(b.d dVar, b.C0689b c0689b, byte[] bArr, b.c[] cVarArr, int i) {
            this.f8175a = dVar;
            this.b = bArr;
            this.c = cVarArr;
            this.d = i;
        }
    }

    public static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public long b(p pVar) {
        byte b = pVar.f8400a[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        int iA = a(b, this.f8174a);
        long j = this.c ? (this.b + iA) / 4 : 0;
        a(pVar, j);
        this.c = true;
        this.b = iA;
        return j;
    }

    public a c(p pVar) throws m {
        if (this.d == null) {
            this.d = b.a(pVar);
            return null;
        }
        if (this.e == null) {
            this.e = b.b(pVar);
            return null;
        }
        byte[] bArr = new byte[pVar.c()];
        System.arraycopy(pVar.f8400a, 0, bArr, 0, pVar.c());
        return new a(this.d, this.e, bArr, b.a(pVar, this.d.b), b.a(r5.length - 1));
    }

    private static int a(byte b, a aVar) {
        return !aVar.c[a(b, aVar.d, 1)].f8162a ? aVar.f8175a.g : aVar.f8175a.h;
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public void c(long j) {
        super.c(j);
        this.c = j != 0;
        b.d dVar = this.d;
        this.b = dVar != null ? dVar.g : 0;
    }

    public static void a(p pVar, long j) {
        pVar.b(pVar.c() + 4);
        pVar.f8400a[pVar.c() - 4] = (byte) (j & 255);
        pVar.f8400a[pVar.c() - 3] = (byte) ((j >>> 8) & 255);
        pVar.f8400a[pVar.c() - 2] = (byte) ((j >>> 16) & 255);
        pVar.f8400a[pVar.c() - 1] = (byte) ((j >>> 24) & 255);
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f8174a = null;
            this.d = null;
            this.e = null;
        }
        this.b = 0;
        this.c = false;
    }

    public static boolean a(p pVar) {
        try {
            return b.a(1, pVar, true);
        } catch (m unused) {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public boolean a(p pVar, long j, i.b bVar) throws m {
        if (this.f8174a != null) {
            return false;
        }
        a aVarC = c(pVar);
        this.f8174a = aVarC;
        if (aVarC == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f8174a.f8175a.j);
        arrayList.add(this.f8174a.b);
        b.d dVar = this.f8174a.f8175a;
        bVar.f8172a = Format.a(null, "audio/vorbis", null, dVar.e, -1, dVar.b, (int) dVar.c, arrayList, null, 0, null);
        return true;
    }
}
