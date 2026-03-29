package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.b.i;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8170a = y.f("Opus");
    private static final byte[] b = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean c;

    private long a(byte[] bArr) {
        int i;
        int i2 = bArr[0] & UByte.MAX_VALUE;
        int i3 = i2 & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        return i * (i4 >= 16 ? 2500 << r1 : i4 >= 12 ? 10000 << (r1 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r1);
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public long b(p pVar) {
        return b(a(pVar.f8400a));
    }

    private void a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.c = false;
        }
    }

    public static boolean a(p pVar) {
        int iB = pVar.b();
        byte[] bArr = b;
        if (iB < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        pVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public boolean a(p pVar, long j, i.b bVar) {
        if (this.c) {
            boolean z = pVar.o() == f8170a;
            pVar.c(0);
            return z;
        }
        byte[] bArrCopyOf = Arrays.copyOf(pVar.f8400a, pVar.c());
        int i = bArrCopyOf[9] & UByte.MAX_VALUE;
        int i2 = ((bArrCopyOf[11] & UByte.MAX_VALUE) << 8) | (bArrCopyOf[10] & UByte.MAX_VALUE);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArrCopyOf);
        a(arrayList, i2);
        a(arrayList, 3840);
        bVar.f8172a = Format.a(null, "audio/opus", null, -1, -1, i, 48000, arrayList, null, 0, null);
        this.c = true;
        return true;
    }
}
