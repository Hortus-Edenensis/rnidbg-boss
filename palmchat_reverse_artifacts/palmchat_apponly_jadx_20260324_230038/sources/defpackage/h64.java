package defpackage;

import androidx.annotation.Nullable;
import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class h64 {
    public static final byte[] d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, ByteCompanionObject.MIN_VALUE, -69, 0, 0, 0, 0, 0};
    public static final byte[] e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 11, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f17878a = AudioProcessor.f5817a;
    public int c = 0;
    public int b = 2;

    public void a(DecoderInputBuffer decoderInputBuffer, List<byte[]> list) {
        vh.e(decoderInputBuffer.c);
        if (decoderInputBuffer.c.limit() - decoderInputBuffer.c.position() == 0) {
            return;
        }
        this.f17878a = b(decoderInputBuffer.c, (this.b == 2 && (list.size() == 1 || list.size() == 3)) ? list.get(0) : null);
        decoderInputBuffer.b();
        decoderInputBuffer.m(this.f17878a.remaining());
        decoderInputBuffer.c.put(this.f17878a);
        decoderInputBuffer.n();
    }

    public final ByteBuffer b(ByteBuffer byteBuffer, @Nullable byte[] bArr) {
        int i;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = (i2 + 255) / 255;
        int length = i3 + 27 + i2;
        if (this.b == 2) {
            int length2 = bArr != null ? bArr.length + 28 : d.length;
            length += e.length + length2;
            i = length2;
        } else {
            i = 0;
        }
        ByteBuffer byteBufferC = c(length);
        if (this.b == 2) {
            if (bArr != null) {
                e(byteBufferC, bArr);
            } else {
                byteBufferC.put(d);
            }
            byteBufferC.put(e);
        }
        int i4 = this.c + o94.i(byteBuffer);
        this.c = i4;
        f(byteBufferC, i4, this.b, i3, false);
        for (int i5 = 0; i5 < i3; i5++) {
            if (i2 >= 255) {
                byteBufferC.put((byte) -1);
                i2 += UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
            } else {
                byteBufferC.put((byte) i2);
                i2 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBufferC.put(byteBuffer.get(iPosition));
            iPosition++;
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferC.flip();
        if (this.b == 2) {
            byte[] bArrArray = byteBufferC.array();
            int iArrayOffset = byteBufferC.arrayOffset() + i;
            byte[] bArr2 = e;
            byteBufferC.putInt(i + bArr2.length + 22, g86.t(bArrArray, iArrayOffset + bArr2.length, byteBufferC.limit() - byteBufferC.position(), 0));
        } else {
            byteBufferC.putInt(22, g86.t(byteBufferC.array(), byteBufferC.arrayOffset(), byteBufferC.limit() - byteBufferC.position(), 0));
        }
        this.b++;
        return byteBufferC;
    }

    public final ByteBuffer c(int i) {
        if (this.f17878a.capacity() < i) {
            this.f17878a = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f17878a.clear();
        }
        return this.f17878a;
    }

    public void d() {
        this.f17878a = AudioProcessor.f5817a;
        this.c = 0;
        this.b = 2;
    }

    public final void e(ByteBuffer byteBuffer, byte[] bArr) {
        f(byteBuffer, 0L, 0, 1, true);
        byteBuffer.put(v46.a(bArr.length));
        byteBuffer.put(bArr);
        byteBuffer.putInt(22, g86.t(byteBuffer.array(), byteBuffer.arrayOffset(), bArr.length + 28, 0));
        byteBuffer.position(bArr.length + 28);
    }

    public final void f(ByteBuffer byteBuffer, long j, int i, int i2, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(z ? (byte) 2 : (byte) 0);
        byteBuffer.putLong(j);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i);
        byteBuffer.putInt(0);
        byteBuffer.put(v46.a(i2));
    }
}
