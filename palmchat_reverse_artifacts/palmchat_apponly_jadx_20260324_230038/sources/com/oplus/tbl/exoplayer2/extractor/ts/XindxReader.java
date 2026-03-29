package com.oplus.tbl.exoplayer2.extractor.ts;

import android.util.Log;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ts.TsPayloadReader;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tbl.exoplayer2.util.Util;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class XindxReader {
    private static final boolean DEBUG = false;
    private static final String INDEX_INFO_FLAG_BEGIN = "XINDXB";
    private static final String INDEX_INFO_FLAG_END = "XINDXE";
    private static final int INDEX_INFO_FLAG_SIZE = 6;
    private static final int INDEX_INFO_HEADER_RESERVED_SIZE = 5;
    private static final int INDEX_INFO_HEADER_SIZE = 10;
    private static final int INDEX_INFO_ITEM_SIZE = 5;
    private static final String TAG = "XindxReader";
    private boolean isXindxInfoRead = false;
    private long durationUs = -9223372036854775807L;
    private long[] keyFrameTimesUs = new long[0];
    private long[] keyFrameTagPositions = new long[0];

    /* JADX INFO: compiled from: SearchBox */
    public static final class IndexInfoHeader {
        private long durationMs;
        private byte[] reserved = new byte[5];
        private int version;

        public IndexInfoHeader(int i, long j) {
            this.version = i;
            this.durationMs = j;
        }

        public String toString() {
            return "IndexInfoHeader{version=" + this.version + ", durationMs=" + this.durationMs + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class IndexInfoItem {
        private final long offsetPosition;
        private final long timestampMs;

        public IndexInfoItem(long j, long j2) {
            this.timestampMs = j;
            this.offsetPosition = j2;
        }

        public String toString() {
            return "IndexInfoItem{timestampMs=" + this.timestampMs + ", offsetPosition=" + this.offsetPosition + '}';
        }
    }

    private static int findMemoryIndex(byte[] bArr, String str) {
        int length = bArr.length - str.length();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            if (memcmp(bArr, i, bytes)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean hasXindxIndexInfo(byte[] bArr) {
        return findMemoryIndex(bArr, INDEX_INFO_FLAG_BEGIN) != -1;
    }

    private static boolean memcmp(byte[] bArr, int i, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private void parseXindxIndexInfo(ParsableByteArray parsableByteArray) {
        int iFindMemoryIndex = findMemoryIndex(parsableByteArray.getData(), INDEX_INFO_FLAG_BEGIN);
        int iFindMemoryIndex2 = findMemoryIndex(parsableByteArray.getData(), INDEX_INFO_FLAG_END);
        if (iFindMemoryIndex == -1 || iFindMemoryIndex2 == -1) {
            Log.w(TAG, "The xindx flag is not found.");
            return;
        }
        parsableByteArray.setPosition(iFindMemoryIndex + 6);
        parsableByteArray.setLimit(iFindMemoryIndex2);
        IndexInfoHeader indexInfoHeader = new IndexInfoHeader(parsableByteArray.readUnsignedByte(), parsableByteArray.readLittleEndianInt());
        parsableByteArray.skipBytes(5);
        int iBytesLeft = parsableByteArray.bytesLeft();
        if (iBytesLeft % 5 != 0) {
            Log.w(TAG, "Data cannot be aligned, size is " + iBytesLeft);
        }
        int i = iBytesLeft / 5;
        Log.d(TAG, "Index items size: " + iBytesLeft + ", count: " + i);
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        long unsignedByte = 0;
        long littleEndianUnsignedInt = 0L;
        for (int i2 = 0; i2 < i; i2++) {
            unsignedByte += ((long) parsableByteArray.readUnsignedByte()) * 1000;
            littleEndianUnsignedInt += parsableByteArray.readLittleEndianUnsignedInt();
            jArr[i2] = littleEndianUnsignedInt;
            jArr2[i2] = Util.msToUs(unsignedByte);
        }
        this.durationUs = Util.msToUs(indexInfoHeader.durationMs);
        this.keyFrameTimesUs = jArr2;
        this.keyFrameTagPositions = jArr;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        parseXindxIndexInfo(parsableByteArray);
        this.isXindxInfoRead = true;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public long[] getKeyFrameTagPositions() {
        return this.keyFrameTagPositions;
    }

    public long[] getKeyFrameTimesUs() {
        return this.keyFrameTimesUs;
    }

    public void init(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.isXindxInfoRead = false;
    }

    public boolean isXindxInfoReadFinished() {
        return this.isXindxInfoRead;
    }
}
