package defpackage;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22058a;
    public long b;
    public boolean c;

    public final long a(long j) {
        return this.f22058a + Math.max(0L, ((this.b - 529) * 1000000) / j);
    }

    public long b(m mVar) {
        return a(mVar.z);
    }

    public void c() {
        this.f22058a = 0L;
        this.b = 0L;
        this.c = false;
    }

    public long d(m mVar, DecoderInputBuffer decoderInputBuffer) {
        if (this.b == 0) {
            this.f22058a = decoderInputBuffer.e;
        }
        if (this.c) {
            return decoderInputBuffer.e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) vh.e(decoderInputBuffer.c);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & UByte.MAX_VALUE);
        }
        int iM = as3.m(i);
        if (iM != -1) {
            long jA = a(mVar.z);
            this.b += (long) iM;
            return jA;
        }
        this.c = true;
        this.b = 0L;
        this.f22058a = decoderInputBuffer.e;
        y53.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return decoderInputBuffer.e;
    }
}
