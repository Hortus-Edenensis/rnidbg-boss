package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.n;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f8414a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    private a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f8414a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static a a(p pVar) throws m {
        int i;
        int i2;
        float f;
        try {
            pVar.d(4);
            int iG = (pVar.g() & 3) + 1;
            if (iG == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iG2 = pVar.g() & 31;
            for (int i3 = 0; i3 < iG2; i3++) {
                arrayList.add(b(pVar));
            }
            int iG3 = pVar.g();
            for (int i4 = 0; i4 < iG3; i4++) {
                arrayList.add(b(pVar));
            }
            if (iG2 > 0) {
                n.b bVarA = n.a((byte[]) arrayList.get(0), iG, ((byte[]) arrayList.get(0)).length);
                int i5 = bVarA.b;
                int i6 = bVarA.c;
                f = bVarA.d;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new a(arrayList, iG, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new m("Error parsing AVC config", e);
        }
    }

    private static byte[] b(p pVar) {
        int iH = pVar.h();
        int iD = pVar.d();
        pVar.d(iH);
        return com.opos.exoplayer.core.util.f.a(pVar.f8400a, iD, iH);
    }
}
