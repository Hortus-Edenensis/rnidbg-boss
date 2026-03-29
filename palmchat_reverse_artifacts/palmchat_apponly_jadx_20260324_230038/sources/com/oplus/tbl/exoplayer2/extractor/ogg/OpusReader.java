package com.oplus.tbl.exoplayer2.extractor.ogg;

import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.audio.OpusUtil;
import com.oplus.tbl.exoplayer2.extractor.ogg.StreamReader;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class OpusReader extends StreamReader {
    private static final int OPUS_CODE = 1332770163;
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean headerRead;

    private long getPacketDurationUs(byte[] bArr) {
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
        int i5 = i4 & 3;
        return ((long) i) * ((long) (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i5 & 1) : i5 == 3 ? 60000 : 10000 << i5));
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int iBytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (iBytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.getData()));
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) {
        if (this.headerRead) {
            Assertions.checkNotNull(setupData.format);
            boolean z = parsableByteArray.readInt() == 1332770163;
            parsableByteArray.setPosition(0);
            return z;
        }
        byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
        setupData.format = new Format.Builder().setSampleMimeType("audio/opus").setChannelCount(OpusUtil.getChannelCount(bArrCopyOf)).setSampleRate(48000).setInitializationData(OpusUtil.buildInitializationData(bArrCopyOf)).build();
        this.headerRead = true;
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.headerRead = false;
        }
    }
}
