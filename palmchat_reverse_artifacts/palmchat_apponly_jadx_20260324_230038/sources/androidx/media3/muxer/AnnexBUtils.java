package androidx.media3.muxer;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class AnnexBUtils {
    private static final int THREE_BYTE_NAL_START_CODE_SIZE = 3;

    private AnnexBUtils() {
    }

    public static boolean doesSampleContainAnnexBNalUnits(Format format) {
        String str = format.sampleMimeType;
        Assertions.checkNotNull(str);
        return str.equals("video/dolby-vision") ? ((Integer) ((Pair) Assertions.checkNotNull(Boxes.getDolbyVisionProfileAndLevel(format))).first).intValue() != 10 : str.equals("video/avc") || str.equals("video/hevc");
    }

    private static int findNalEndIndex(ByteBuffer byteBuffer, int i) {
        while (i <= byteBuffer.limit() - 4) {
            int i2 = byteBuffer.getInt(i);
            int i3 = i2 & InputDeviceCompat.SOURCE_ANY;
            if (i3 == 0 || i3 == 256) {
                return i;
            }
            int i4 = 16777215 & i2;
            if (i4 == 0 || i4 == 1) {
                return i + 1;
            }
            i = (65535 & i2) == 0 ? i + 2 : (i2 & 255) == 0 ? i + 3 : i + 4;
        }
        if (i == byteBuffer.limit() - 3) {
            short s = byteBuffer.getShort(i);
            byte b = byteBuffer.get(i + 2);
            if (s == 0 && (b == 0 || b == 1)) {
                return i;
            }
        }
        return byteBuffer.limit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        r0 = skipLeadingZerosAndFindNalStartCodeIndex(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r0 == r6.limit()) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImmutableList<ByteBuffer> findNalUnits(ByteBuffer byteBuffer) {
        int iSkipLeadingZerosAndFindNalStartCodeIndex;
        if (byteBuffer.remaining() == 0) {
            return ImmutableList.of();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byteBufferAsReadOnlyBuffer.order(ByteOrder.BIG_ENDIAN);
        int iSkipLeadingZerosAndFindNalStartCodeIndex2 = skipLeadingZerosAndFindNalStartCodeIndex(byteBufferAsReadOnlyBuffer, byteBufferAsReadOnlyBuffer.position()) + 3;
        ImmutableList.a aVar = new ImmutableList.a();
        int i = iSkipLeadingZerosAndFindNalStartCodeIndex2;
        loop0: while (true) {
            boolean z = true;
            while (true) {
                if (iSkipLeadingZerosAndFindNalStartCodeIndex2 < byteBufferAsReadOnlyBuffer.limit()) {
                    if (!z) {
                        break;
                    }
                    iSkipLeadingZerosAndFindNalStartCodeIndex2 = findNalEndIndex(byteBufferAsReadOnlyBuffer, iSkipLeadingZerosAndFindNalStartCodeIndex2);
                    aVar.a(getBytes(byteBufferAsReadOnlyBuffer, i, iSkipLeadingZerosAndFindNalStartCodeIndex2 - i));
                    z = false;
                } else {
                    break loop0;
                }
            }
            i = iSkipLeadingZerosAndFindNalStartCodeIndex + 3;
            iSkipLeadingZerosAndFindNalStartCodeIndex2 = i;
        }
        return aVar.e();
    }

    private static ByteBuffer getBytes(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.limit(i + i2);
        return byteBufferDuplicate.slice();
    }

    private static int skipLeadingZerosAndFindNalStartCodeIndex(ByteBuffer byteBuffer, int i) {
        while (true) {
            if (i > byteBuffer.limit() - 4) {
                if (i <= byteBuffer.limit() - 3) {
                    Assertions.checkState(byteBuffer.getShort(i) == 0, "Invalid NAL units");
                    byte b = byteBuffer.get(i + 2);
                    if (b == 1) {
                        return i;
                    }
                    Assertions.checkState(b == 0, "Invalid NAL units");
                } else {
                    while (i < byteBuffer.limit()) {
                        Assertions.checkState(byteBuffer.get(i) == 0, "Invalid NAL units");
                        i++;
                    }
                }
                return byteBuffer.limit();
            }
            int i2 = byteBuffer.getInt(i);
            int i3 = i2 & InputDeviceCompat.SOURCE_ANY;
            if (i3 == 256) {
                return i;
            }
            Assertions.checkState(i3 == 0, "Invalid Nal units");
            int i4 = i2 & 255;
            if (i4 == 1) {
                return i + 1;
            }
            if (i4 == 0) {
                z = true;
            }
            Assertions.checkState(z, "Invalid Nal units");
            i++;
        }
    }

    public static ByteBuffer stripEmulationPrevention(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit());
        int i = 0;
        for (int i2 = 0; i2 < byteBuffer.limit(); i2++) {
            if (!(byteBuffer.get(i2) == 3 && i >= 2)) {
                byteBufferAllocate.put(byteBuffer.get(i2));
            }
            i = byteBuffer.get(i2) == 0 ? i + 1 : 0;
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
